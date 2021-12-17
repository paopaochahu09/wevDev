<template>
  <div id="enter" >
    <el-container style="height:500px;background-color: Transparent">
      <el-aside>
        <div id="aside">
        <i class="el-icon-shopping-cart-1"></i>
        <span>购物车</span>
        </div>
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
          <el-button type="info"  icon="el-icon-s-home" v-on:click="goHome" >返回主页面/Home</el-button>
        </el-header>

        <el-main style="background-color: Transparent"><!--显示商品组件-->
          <div style="height:500px">
            <ul class="infinite-list" v-infinite-scroll="load" >
              <li  v-for="item in goods" class="infinite-list-item" style="display: inline-block;overflow:auto">
                <inshop v-bind:good="item" v-bind:account="account"></inshop>
              </li>
            </ul>
          </div>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import inshop from "../components/inshop";
import Inshop from "../components/inshop";
const axios = require('axios');

export default {
  name: "shop",
  components: {Inshop},
  data() {
    //这是跳转传值
    console.log("获取到的account:",this.$route.params["account"])
    axios.get("http://119.91.199.135:8081/shop/getshop",{params:{account: this.$route.params["account"]}}).then(res=>{
      console.log("返回的数据:",res.data.data)
      this.goods=res.data.data;
      console.log("获取到购物车数据：",this.goods)
    })
    return {
      value1: true,
      value2: true,
      count:10,
      account: this.$route.params["account"],
      goods:[
        {
          name: "等待刷新",
          goodID: "等待刷新",
          price: 0,
          number: 0,
          introduction: "等待刷新",
          picture: "等待刷新"
        }
      ]
    }
  },
  methods:{
    goHome:function(){
      this.$router.push({name:"mainbody",params:{account:this.account}})
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

#aside{
  position: absolute;
  top:200px;
  width:300px;
  background-color: whitesmoke;
}

</style>
