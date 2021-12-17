<template>
  <div style="height:500px">
    <ul class="infinite-list" v-infinite-scroll="load" >
      <li  v-for="order in orders" class="infinite-list-item" style="display: inline-block;overflow:auto">
        <orders v-bind:order="order" v-bind:account="account" v-bind:deal="deal"></orders>
      </li>
    </ul>
  </div>
</template>

<script>
//导入组件
import orders from "./orders";
import good from "./good";
const axios = require('axios');

export default {
  name: "showorder",
  props:["orders","account","deal"], //嵌套组件传值
  components: {orders},
  data(){
    //如果没有传递参数过来
    if(this.account===undefined){
      axios.get("http://119.91.199.135:8081/order/getallorders").then(res=>{
        this.orders=res.data.data
        this.deal=false
        console.log("得到的orders:",this.orders)
    })
    }
    return{
      count:10,
      deal:true,
      account:"",
    }
  }
}
</script>

<style scoped>
.good-header{
  background-color: rgba(222,184,135,0.1);
  height:50px;
  position: fixed;
  top:500px;
}
</style>
