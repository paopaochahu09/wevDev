<template>
  <div>
      <ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto">
       <div class="addgood" >
          <el-collapse accordion >
            <el-collapse-item style="background-color: green">
              <template slot="title">
                <pre>  新增加商品信息 </pre><i class="header-icon el-icon-circle-plus-outline"></i>
              </template>
              <div >
                <Angoodinfo></Angoodinfo>
              </div>
            </el-collapse-item>
          </el-collapse>
        </div>
        <li  v-for="good in goods" class="infinite-list-item">
          <goodinfo v-bind:good="good"></goodinfo>
        </li>
      </ul>
  </div>
</template>

<script>
//导入组件
import goodinfo from "./goodinfo";
import Angoodinfo from "./Angoodinfo";
const axios = require('axios');

export default {
  name: "showgood",
  components: {Angoodinfo, goodinfo},
  data(){
    //获取全部商品信息
    var goods=[]
    axios.get("http://119.91.199.135:8081/good/getallgoods").then(res=>{
      goods=res.data.data
      console.log("获取全部的商品信息",goods)
      this.goods=goods
      console.log("获取到的商品信息:",this.goods)
    })
    return{
      count:10,
      goods: goods
    }
  }
}
</script>

<style scoped>

.addgood{
  position: fixed;
  top:140px;
  background-color: green;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
}
.infinite-list-item{
  margin-top:10px;
}
</style>
