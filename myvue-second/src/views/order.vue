<template>
  <div id="enter">
    <el-container>
      <el-aside>
        <el-main >
          <el-button type="info"  icon="el-icon-shopping-cart-full" v-on:click="getUnDealed" round="true">未处理订单</el-button>
        </el-main>
        <el-main >
          <el-button type="success"  icon="el-icon-s-order" v-on:click="getDealed" round="true">已处理订单</el-button>
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
          <el-button type="info"  icon="el-icon-s-home" v-on:click="goHome" >返回主页面/Home</el-button>
        </el-header>

        <el-main style="background-color: Transparent"><!--显示商品组件-->
          <!--将orders和account绑定在showorder上-->
          <showorder v-bind:orders="orders" v-bind:account="account" v-bind:deal="deal"></showorder>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import showorder from "../components/showorder";
const axios = require('axios');

export default {
  name: "order",
  components:{showorder},
  data() {
    //跳转传值
    this.account=this.$route.params["account"]
    if(this.account===undefined){
      this.account="none"
    }
    //通过传递的account,获取用户的订单信息

    axios.get("http://119.91.199.135:8081/order/getuserorder",{params:{account: this.account}}).then(res=>{
      this.orders=res.data.data
      for(let i=0;i<this.orders.length;i++){
        if(this.orders[i].isDeal===0){
          this.UnsolvedOrders.push(this.orders[i])
        }
        else{
          this.SolvedOrders.push(this.orders[i])
        }
      }
      console.log("获取到的用户订单信息：",this.orders)
      console.log("account:",this.account)
      console.log("已经处理的订单信息:",this.SolvedOrders)
      console.log("尚未处理的订单信息：",this.UnsolvedOrders)
    })
    return {
      value1: true,
      value2: true,
      orders: [{
        name:"等待刷新",
        price: 0,
        picture: "等待图片资源刷新",
        orderTime: 0,
        account: "等待刷新",
        orderID: "none",
        isDeal: 0
      }],
      deal: true, //让处理按钮的disabled处于true状态，即不能工作的状态
      SolvedOrders: [],
      UnsolvedOrders: []
    }
  },
  methods:{
    getUnDealed:function(){
      this.orders=this.UnsolvedOrders
    },
    getDealed:function(){
      this.orders=this.SolvedOrders
    },
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
</style>
