<template>
  <div >
    <el-descriptions class="margin-top" title="用户信息" :column="2" :size="size" border style="display: inline-block;margin-top: 100px" >
      <template slot="extra">
        <el-button type="info"  icon="el-icon-s-home" v-on:click="goHome" size="small">返回主页面/Home</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          作者
        </template>
        YYg
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          联系地址
        </template>
        华南理工大学大学校区生活区c12
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mouse"></i>
          QQ
        </template>
        1324603194
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          身份
        </template>
        <el-tag size="small">学生</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          邮箱地址
        </template>
        1324603194@qq.com
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
        </template>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <div class="demo-basic--circle">
            <div class="picture"><el-avatar shape="square" :size="100" :src="squareUrl"></el-avatar></div>
          </div>
        </template>
        一只迷茫的小菜鸟
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>



<script>
const axios = require('axios');

export default {
  name: "help",
  data () {
    //地址传值
    //通过account获取用户信息
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      //squareUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
      sizeList: ["large", "medium", "small"],
      account: this.$route.params["account"],
      editable: true,
      user: {//设置默认值
        name: "账号暂时走丢了...",
        account: this.$route.params["account"],
        password: "xxxxxx",
        picture: "http://xxxxx",
        address: "xxxxxx"
      }
    }
  },
  methods:{
    goHome:function (){
      this.$router.push({name:"mainbody",params:{account:this.account}})
    }
  }
}
</script>

<style scoped>
.margin-top{
  box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.1);
}
.picture{
  display:inline;
}
#upLoad{
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-right: 20px;
}
</style>
