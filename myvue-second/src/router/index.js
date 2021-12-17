import Vue from 'vue'
import VueRouter from "vue-router";
import login from "@/views/login";
import mainbody from "@/views/mainbody";
import truelogin from "../components/truelogin"
import register from "../components/register";
import shop from "../views/shop";
import order from "../views/order";
import user from "../views/user";
import manager from "../views/manager";
import good from "../components/good";
import orders from "../components/orders";
import showgood from "../components/showgood";
import goodinfo from "../components/goodinfo";
import Angoodinfo from "../components/Angoodinfo";
import records from "../components/records";
import showgoodmain from "../components/showgoodmain";
import showorder from "../components/showorder";
import inshop from "../components/inshop"
import datastat from "../components/datastat";
import help from "../views/help";
Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {//主页
      name: "login",
      path:"/",
      component:login,
      children: [
        {
          name: "truelogin",
          path: "/truelogin",
          components: {
            loginbody: truelogin
          }
        },
        {
          name: "register",
          path: "/register",
          components:{
            loginbody: register
          }
        }
      ]
    },/*
    { //登录页面
      name: "login",
      path: "/login",
      component: login,
      children: [
        {
          name: "truelogin",
          path: "/truelogin",
          components: {
            loginbody: truelogin
          }
        },
        {
          name: "register",
          path: "/register",
          components:{
            loginbody: register
          }
        }
      ]
    },*/
    {//商城页面
      name: "mainbody",
      path: "/mainbody",
      component: mainbody,
      children:[
        {//测试页面
          name:"showgoodmain",
          path:"/showgoodmain",
          components:{
            good:showgoodmain
          }
        },
      ]
    },
    {//购物车页面
      name:"shop",
      path:"/shop",
      component: shop
    },
    {//订单页面
      name: "order",
      path: "/order",
      component: order
    },
    {//用户个人信息页面
      name: "user",
      path: "/user",
      component: user
    },
    {//帮助页面
      name: "help",
      path: "/help",
      component: help
    },
    {//管理员界面
      name: "manager",
      path: "/manager",
      component: manager,
      children:[
        {//测试页面
          name:"showgood",
          path:"/showgood",
          components:{
            managerbody:showgood
          }
        },
        {
          name:"showorder",
          path:"/showorder",
          components:{
            managerbody:showorder
          }
        },
        {
          name:"records",
          path:"/records",
          components:{
            managerbody:records
          }
        },
        {
          name:"datastat",
          path:"/datastat",
          components:{
            managerbody:datastat
          }
        }
      ]
    },
    {//测试页面
      name:"orders",
      path:"/orders",
      component:orders
    },
    {//goodinfo
      name:"goodinfo",
      path:"/goodinfo",
      component:goodinfo
    },
    {//Angoodinfo
      name:"Angoodinfo",
      path:"/angoodinfo",
      component:Angoodinfo
    },
    {//测试页面
      name:"records",
      path:"/records",
      component:records
    },
    {//测试页面
      name:"good",
      path:"/good",
      component:good
    },
    {//测试页面
      name:"test",
      path:"/test",
      component:showgoodmain
    },
    {//测试页面
      name:"inshop",
      path:"/inshop",
      component:inshop
    }
  ]
})
