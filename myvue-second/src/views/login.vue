<template>
  <div id="enter">
    <el-container>
      <el-aside width="250px" class="aside">
        <el-main class="aside-up">
        <el-button type="success"  icon="el-icon-user" v-on:click="goLogin">Login/登录</el-button>
        </el-main>
        <el-main class="aside-down">
        <el-button type="info"  icon="el-icon-user-solid" v-on:click="goRegister">Register/注册</el-button>
        </el-main>
      </el-aside>
      <el-container class="body">
        <el-header>Header</el-header>
        <el-main>
          <router-view name="loginbody"></router-view>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "login",
  methods:{
    goLogin:function(){
      this.$router.push("/truelogin")
    },
    goRegister:function (){
      this.$router.push("/register")
    }
  }
}
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
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
  .aside-up{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    background-color:cadetblue;
  }
  .aside-down{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    background-color:gray;
  }

  /*
  #enter{
    background:url("~@/assets/image/background1.png");
    width:100%;			//大小设置为100%
    height:100%;			//大小设置为100%
    position:fixed;
    background-size:100% 100%;}
   */
  #enter{
    display: inline-block;
    width:800px;
  }
</style>
