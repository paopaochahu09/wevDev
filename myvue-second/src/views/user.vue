<template>
  <div >
  <el-descriptions class="margin-top" title="用户信息" :column="2" :size="size" border style="display: inline-block;margin-top: 100px" >
    <template slot="extra">
      <el-button class="el-icon-edit" type="primary" size="small" v-on:click="changeEditable">编辑/edit</el-button>
    </template>
    <template slot="extra">
      <el-button class="el-icon-check" type="success" size="small" v-on:click="storeUser">保存/store</el-button>
    </template>
    <template slot="extra">
      <el-button type="info"  icon="el-icon-s-home" v-on:click="goHome" size="small">返回主页面/Home</el-button>
    </template>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-user"></i>
        用户名
      </template>
      <input v-bind:disabled=editable type="text" v-model="user.name"></input>
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-mobile-phone"></i>
        账号/e-mail
      </template>
      <input disabled="true" type="text" v-bind:value="user.account"></input>
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-mouse"></i>
        密码
      </template>
      <input v-bind:disabled="editable" type="text" v-model="user.password"></input>
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-tickets"></i>
        备注
      </template>
      <el-tag size="small">学生</el-tag>
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-office-building"></i>
        联系地址
      </template>
      <input v-bind:disabled="editable" type="text" v-model="user.address"></input>
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
      <i class="el-icon-upload" id="upLoad">上传头像</i>
      <input v-bind:disabled="editable" type="text" v-model="user.picture"></input>
    </el-descriptions-item>
  </el-descriptions>
  </div>
</template>



<script>
const axios = require('axios');

export default {
  name: "user",
  data () {
    //地址传值
    //通过account获取用户信息
    axios.get("http://119.91.199.135:8081/user/getuser",{params:{account: this.$route.params["account"]}}).then(res=>{
      this.user=res.data.data
      console.log("user:",this.user)
    })
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
    },
    changeEditable:function(){
      this.editable=false
    },
    storeUser:function(){
      this.editable=true
      //将信息传递给updateuser
      console.log("befor user:",this.user)
      axios.post("http://119.91.199.135:8081/user/updateuser",this.user).then(res=>{
        console.log("err:",res)
        console.log("after user:",this.user)
        alert("保存信息成功！")
      })
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
