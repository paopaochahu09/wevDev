<template>
  <div style="height:500px">
    <ul class="infinite-list" v-infinite-scroll="load" >
      <li  v-for="item in goods" class="infinite-list-item" style="display: inline-block;overflow:auto">
        <good v-bind:good="item" v-bind:account="account"></good>
      </li>
    </ul>
  </div>
</template>

<script>
import good from "./good";
const axios = require('axios');

export default {
  name: "showgoodmain",
  props:["goods","account"],
  components: {good},
  data() {
    console.log("showgoodmain:")
    console.log(this.goods)
    console.log((this.account))
    return {
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
