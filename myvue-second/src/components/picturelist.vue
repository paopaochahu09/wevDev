<template>
  <div class="block" >
    <div class="aside">
      <img :src="left" class="left">
    </div>
    <el-carousel class="lunbo_kuang" height="300px" >
      <el-carousel-item style="background-color: white" v-for="item in lunbo" :key="item">
        <img class="lunbo" :src="item" width="100%">
      </el-carousel-item>
    </el-carousel>
    <div class="aside">
      <img class="right" :src="right">
    </div>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "picturelist",
  data(){
    return {
      lunbo: [require("@/assets/image/1.png"),
        require("@/assets/image/2.png"),
        require("@/assets/image/3.png"),
        require("@/assets/image/4.png")],
      left:require("@/assets/image/8.png"),
      right:require("@/assets/image/9.png"),
    }
  }
}
</script>

<style scoped>
.lunbo{
  width:400px;
  height:300px;
  border-left: 2px solid #B3C0D1;
  border-right: 2px solid #B3C0D1;
}
.lunbo_kuang{
  width:600px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
.block{
  background-color: whitesmoke;
  display: flex;
  justify-content: center;
  align-items: center;
}
.aside{
  width:227px;
}

.left{
  margin-top:90px;
  margin-right:60px;
  width:220px;
  height:300px;
  border:2px solid blue;
}
.right{
  margin-top:90px;
  margin-left: 50px;
  width:220px;
  height:300px;
  border:2px solid blue;
}
</style>
