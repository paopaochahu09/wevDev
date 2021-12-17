<template>
  <div id="enter">
    <el-container>
      <el-aside >
      <el-main >
        <el-button type="primary"  icon="el-icon-shopping-cart-full" v-on:click="goShop" round="true">购物车/Cart</el-button>
      </el-main>
      <el-main >
        <el-button type="success"  icon="el-icon-s-order" v-on:click="goOrder" round="true">订单信息/Order</el-button>
      </el-main>
      <el-main >
        <el-button type="info"  icon="el-icon-setting" v-on:click="showManaPass" round="true">管理员入口/Enter</el-button>
      </el-main>
        <el-main style="background-color: antiquewhite;height:500px;">
        <div class="inputPassword" v-if="showpass">
          <el-collapse accordion >
            <el-collapse-item style="background-color: antiquewhite">
              <template slot="title">
                <pre>  管理员身份验证 </pre><i class="header-icon el-icon-circle-plus-outline"></i>
              </template>
              <div >
                  Password<input type="text" v-model="manaPass" ></input>
                  <el-button class="el-icon-check" type="success" size="small" v-on:click="goManager">提交/submit</el-button>
              </div>
            </el-collapse-item>
          </el-collapse>
        </div>
        </el-main>
      </el-aside>

      <el-container class="body">

        <el-header>
          <div style="display: inline-block;float: left;border-radius: 30px;background-color: white;width:100px;">
          <el-switch
            style="display: inline-block"
            v-model="value2"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-icon-class="el-icon-sunny"
            inactive-icon-class="el-icon-moon"
            inactive-text="按年付费">
          </el-switch>
          </div>
          <!--用户头像 <el-avatar :size="30" :src="circleUrl"></el-avatar>-->
          <el-button type="info"  icon="el-icon-s-custom" v-on:click="goLogin" round="true">注销/logout</el-button>
          <el-button type="success"  icon="el-icon-s-custom" v-on:click="goUser" round="true">用户信息/Info</el-button>
        </el-header>

        <el-main style="background-color: white"><!--显示轮播图组件-->
          <picturelist></picturelist>
        </el-main>

        <el-main>
          <showgoodmain v-bind:goods="goods" v-bind:account="account"></showgoodmain>
        </el-main>
        <el-footer> <el-link type="success" v-on:click="goHelp">关于我们/help</el-link></el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import picturelist from "../components/picturelist";
import showgoodmain from "../components/showgoodmain";
const axios = require('axios');

export default {
  name: "mainbody",
  data() {
    this.account=this.$route.params["account"]
    console.log("正在获取商品信息......")
    axios.get("http://119.91.199.135:8081/good/getallgoods")
      .then(res=>{
        console.log("before:goods",this.goods)
        this.goods=res.data.data;
      })
    console.log("account:",this.account)
    console.log("goods:",this.goods)
    return {
      value1: true,
      value2: true,
      //account: account,
      goods:[{
        name: "爱丽丝机甲",
        price: 625,
        goodID: "123456fff",
        number: 1000,
        introduction: "正版figma/可动成品/爱丽丝机甲IP",
        picture: "http://none",
      }],
      showpass: false,
      manaPass: ""
    }
  },
  components:{
    picturelist,
    showgoodmain
  },
  created(){
    //获得上个页面传过来的account值

  },
  methods:{
    goShop:function(){//跳到购物车页面
      //传递用户的account过去
      this.$router.push({name:"shop",params:{
        account: this.account
        }})
    },
    showManaPass:function (){
      this.showpass=!this.showpass
    },
    goManager:function(){//跳到管理员入口页面，需要弹出密码验证
      if(this.manaPass==="1433223") {
        this.$router.push({name: "manager", params: {account: this.account}})
      }else{
        alert("密码错误，请重新输入！")
      }
    },
    goOrder:function(){//跳到订单信息页面
      //传递用户的account
      this.$router.push({name:"order",params:{
        account: this.account
        }})
    },
    goUser:function(){//传递account参数
      this.$router.push({name:"user",params:{
        account:this.account
      }})
    },
    goLogin:function (){
      this.$router.push("/")
    },
    goHelp:function(){
      this.$router.push("/help")
    }
  }
}
</script>

<style scoped>
.el-header {
  background-color: whitesmoke;
  color: #333;
  text-align: right;
  line-height: 60px;
  margin-bottom: 10px;
}
.el-footer{
  background-color: whitesmoke;
  color: #333;
  text-align: right;
  line-height: 60px;
  margin-top:10px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.aside{
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background-color: Transparent;
}
.body{
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
}

/*
#enter{
  background:url("~@/assets/image/background1.png");
  width:100%;			//大小设置为100%
  height:100%;			//大小设置为100%
  position:fixed;
  background-size:100% 100%;}
 */
</style>
