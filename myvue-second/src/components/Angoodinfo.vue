<template>
  <div style="margin-left: 10px;margin-right: 10px">
    <el-descriptions class="margin-top" title="请输入商品信息" :column="2" :size="size" border style="width:700px" >
      <template slot="extra">
        <el-button class="el-icon-thumb" type="primary" size="small" @click="addGood">提交/submit</el-button>
      </template>
      <template slot="extra">
        <el-button class="el-icon-aim" type="info" size="small" @click="resetGood">重置/reset</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-postcard"></i>
          商品ID
        </template>
        <input disabled="true" type="text" value="提交后自动生成"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-chat-line-square"></i>
          商品名字
        </template>
        <input  type="text" v-model="good.name"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-wallet"></i>
          商品价格
        </template>
        <input  type="number" v-model="good.price"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-box"></i>
          库存数量
        </template>
        <input type="number" v-model="good.number" style="width: 25px"></input>件
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-chat-line-square"></i>
          商品描述
        </template>
        <input  type="text" v-model="good.introduction"></input>
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
        <!--<input type="text" disabled="true" v-model="good.picture"></input>-->

        <div class="up">
        <el-dropdown @command="uploadPic">
        <span  class="el-dropdown-link">
          选择图片<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu   slot="dropdown">
            <el-dropdown-item command="1">模型1</el-dropdown-item>
            <el-dropdown-item command="2">模型2</el-dropdown-item>
            <el-dropdown-item command="3">模型3</el-dropdown-item>
            <el-dropdown-item command="4" >模型4</el-dropdown-item>
            <el-dropdown-item command="5" >模型5</el-dropdown-item>
            <el-dropdown-item command="6">模型6</el-dropdown-item>
            <el-dropdown-item command="7">模型7</el-dropdown-item>
            <el-dropdown-item command="8">模型8</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        </div>
       <!-- <el-button id="upLoad" class="el-icon-upload">修改商品图片</el-button>-->
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "Angoodinfo",
  data () {
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"],
      good: {
        name: "",
        price: 0,
        picture: "请上传图片资源",
        introduction: "",
        goodID: "",
        number: 0
      },
      pic_path: ["@/asssets/image/1.png",
        "@/asssets/image/2.png",
        "@/asssets/image/3.png",
        "@/asssets/image/4.png",
        "@/asssets/image/5.png",
        "@/asssets/image/6.png",
        "@/asssets/image/7.png",
        "@/asssets/image/8.png"],

      pic: [require("@/assets/image/1.png"),
        require("@/assets/image/2.png"),
        require("@/assets/image/3.png"),
        require("@/assets/image/4.png"),
        require("@/assets/image/5.png"),
        require("@/assets/image/6.png"),
        require("@/assets/image/7.png"),
        require("@/assets/image/8.png")],
    }
  },
  methods:{
    addGood:function(){
      //检验值是否完整
      if(this.good.name===""||this.good.picture===""||this.good.introduction==="") {
        alert("请进一步完善商品信息！")
      }else if(this.good.number<0){
        alert("商品数量不能小于0！")
      }else if(this.good.price<0){
        alert("商品价格不能小于0！")
      }else{//将新增加的商品信息上传
        if(this.good.picture==="请上传图片资源"){
          this.good.picture="暂无图片资源"
        }
        console.log("要增加的新的商品信息:",this.good)
        axios.post("http://119.91.199.135:8081/good/addgood",this.good).then(res=>{
          alert("成功增加新商品！")
          //清空输入数据
          this.resetGood()
        })
      }
    },
    uploadPic(command){
      let num=parseInt(command)
      this.good.picture=this.pic_path[num]
      //修改展示的图片
      this.squareUrl=this.pic[num]
    },
    resetGood(){
      this.good.picture="请上传图片资源"
      this.good.name=this.good.introduction=""
      this.good.price=this.good.number=0
      this.squareUrl="https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png"
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
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.up{
  width:80px;
  border:2px solid whitesmoke;
  margin-left:20%;
  margin-right: 10px;
  display: inline-block;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>
