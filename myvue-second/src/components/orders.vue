<template>
  <div style="background-color: lightgray;margin-top:10px">

    <div style="background-color: whitesmoke;width:200px;height:183.2px;float: left">
      <img :src="pic" class="picture">
    </div>

   <div style="float: left">
     <el-descriptions class="margin-top"  :column="2" :size="size" border style="width:700px" >
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-postcard"></i>
           订单信息
         </template>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-postcard"></i>
           处理订单/发货
         </template>
         <el-button v-bind:disabled="deal" class="el-icon-edit" type="primary" size="small" @click="dealOrder">处理/deal</el-button>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-postcard"></i>
           订单ID
         </template>
         <input disabled="true" type="text" v-bind:value="order.orderID"></input>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-chat-line-square"></i>
           商品名字
         </template>
         <input disabled="true" type="text" v-bind:value="order.name"></input>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-wallet"></i>
           订单金额
         </template>
         <input disabled="true" type="number" v-bind:value="order.price"></input>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-timer"></i>
           下单时间
         </template>
         <input disabled="true" type="text" v-bind:value="orderTime" ></input>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-user-solid"></i>
           下单人账号
         </template>
         <input disabled="true" type="text" v-bind:value="order.account"></input>
       </el-descriptions-item>
       <el-descriptions-item>
         <template slot="label">
           <i class="el-icon-user-solid"></i>
           处理状态
         </template>
         <input disabled="true" type="text" v-bind:value="isDeal"></input>
       </el-descriptions-item>
     </el-descriptions>
   </div>

  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "orders",
  props:["order","account","deal"], //嵌套组件传值
  data () {
    this.pic=require("@/assets/image/"+this.order.picture)
    var isDeal="";
    var order=this.order
    if(order.isDeal===0){
      isDeal="商家尚未发货|未处理该订单"
    }else{
      isDeal="商家已发货|已处理该订单"
    }
    var orderTime=new Date(order.orderTime).toLocaleString()
    console.log("处理状态：",isDeal)
    console.log("下单时间：",orderTime)
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"],
      isDeal: isDeal,
      orderTime: orderTime
    }
  },
  methods:{
    dealOrder:function(){//处理订单，将isdeal字段改成1
      axios.post("http://119.91.199.135:8081/order/dealorder",this.order).then(res=>{
        alert("已处理订单！")
        //发送订单邮件信息
        var email={}
        email.address=this.order.account
        email.title="订单处理信息"
        email.body="尊敬的 "+this.order.account+" 用户，您在"+this.orderTime+"购买的"+this.order.name+"已经发货，请记得关注物流信息！祝您购物愉快！"
        //调用后端函数发送邮件
        axios.post("http://119.91.199.135:8081/mail/sendemail",email).then(res=>{
          console.log("发送邮件信息：",res)
        })
        alert("成功将邮件信息发送给用户！")
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
