<template>
  <div style="background-color: lightgray;margin-top:10px;display: block">
    <div style="background-color: whitesmoke;width:200px;height:183.2px;float: left">
      <img :src="pic" class="picture">
    </div>


    <div style="float: left; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
      <el-descriptions class="margin-top"  :column="2" :size="size" border style="width:700px" >
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-postcard"></i>
            商品信息:
          </template>
        </el-descriptions-item>
        <el-descriptions-item>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-postcard"></i>
            商品ID
          </template>
          <input disabled="true" type="text" v-bind:value="good.goodID"></input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-postcard"></i>
            商品名字
          </template>
          <input disabled="true" type="text" v-bind:value="good.name"></input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-wallet"></i>
            商品价格
          </template>
          <input disabled="true" type="number" v-bind:value="good.price"></input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-box"></i>
            购买数量
          </template>
          <input disabled="true" type="number" value="1" style="width: 25px"></input>件
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-chat-line-square"></i>
            商品描述
          </template>
          <input disabled="true" type="text" v-bind:value="good.introduction"></input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-chat-line-square"></i>
            处理
          </template>
          <el-button type="success"  icon="el-icon-shopping-cart-1" round="true" @click="doPay">支付/Pay</el-button>
          <el-button type="info"  icon="el-icon-shopping-cart-1" round="true" @click="doRemove">移除/Remove</el-button>
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "inshop",
  props:["good","account"], //这是嵌套组件传值
  data () {
    this.pic=require("@/assets/image/"+this.good.picture)
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"]
    }
  },
  methods:{
    doPay:function(){
      //生成订单信息，并传递给addOrder
      //生成下单时间
      var orderTime=new Date().getTime()
      var order={
        account: this.account,
        name: this.good.name,
        price: this.good.price,
        picture: this.good.picture,
        isDeal: 0,
        orderTime: orderTime,
        orderID: "",
      }
      axios.post("http://119.91.199.135:8081/order/addorder",order).then(res=>{
        alert("支付成功！")
      })
    },
    doRemove:function(){
      //将account和goodID传入deleteshop
      var shop={
        account: this.account,
        goodID: this.good.goodID
      }
      console.log("删除的购物车信息：",shop)
      axios.post("http://119.91.199.135:8081/shop/deleteshop",shop).then(res=>{
        alert("删除订单信息成功！")
        this.data()
      })
    }
  }
}
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}

.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.margin-top{
  box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.1);
}
.picture{
  width: 180px;
  height:160px;
  margin-top: 10px;
  border:2px solid blue;
  display: inline-block;
}
</style>


