<template>
  <div id="enter" style="display: inline-block;width:1000px">
    <el-container>
      <!--
      <el-aside>
        <el-main >
          <el-button type="info"  icon="el-icon-shopping-cart-full" v-on:click="getUnpay" round="true">未支付订单</el-button>
        </el-main>
        <el-main >
          <el-button type="success"  icon="el-icon-s-order" v-on:click="getPay" round="true">已支付订单</el-button>
        </el-main>
      </el-aside>
      -->

      <el-container class="body">
        <el-header>
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1"><router-link to="/showgood">商品管理</router-link></el-menu-item>
            <el-menu-item index="2"><router-link to="/datastat">销售记录/报表</router-link></el-menu-item>
            <el-menu-item index="3"><router-link to="/showorder">订单管理</router-link></el-menu-item>
            <el-menu-item index="4"><router-link to="/records">客户浏览记录</router-link></el-menu-item>
            <el-button type="info"  icon="el-icon-s-home" v-on:click="goHome" >返回主页面/Home</el-button>
          </el-menu>

        </el-header>

        <el-main style="background-color: whitesmoke;height:500px">
          <router-view name="managerbody"></router-view>
        </el-main>

        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
//导入响应的组件
import showgood from "../components/showgood";
const axios = require('axios');

export default {
  name: "manager",
  data() {
    //获取全部的订单信息
    this.account=this.$route.params["account"]
    console.log("管理员页面的account:",this.account)
    var orders=[]
    axios.get("http://119.91.199.135:8081/order/getallorders").then(res=>{
      orders=res.data
      console.log("获取到的全部订单信息：",orders)
    })

    return {
      value1: true,
      value2: true,
      count: 10,
      deal: false, //让处理按钮的disabled处于false状态，即可以工作的状态,
      orders: orders,
    }
  },
  components:{
    showgood
  },
  methods:{
    goHome:function(){
      console.log("manager-->home:account:",this.account)
      this.$router.push({name:"mainbody",params:{account:this.account}})
    },
    load () {
     // this.count += 2
    }
  }
}
</script>

<style scoped>
.el-header{
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
.show{
}
</style>
