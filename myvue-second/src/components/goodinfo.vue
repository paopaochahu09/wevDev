<template>
  <div >
    <el-descriptions class="margin-top" title="商品信息" :column="2" :size="size" border style="width:700px" >
      <template slot="extra">
        <el-button class="el-icon-edit" type="primary" size="small" @click="changeEditable">编辑/edit</el-button>
      </template>
      <template slot="extra">
        <el-button class="el-icon-edit" type="success" size="small" @click="updateGood">保存/restore</el-button>
      </template>
      <template slot="extra">
          <el-button class="el-icon-delete" type="primary" size="small" @click="deleteGood">删除/delete</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-postcard"></i>
          商品ID
        </template>
        <input disabled="true" type="text" v-bind:value="good.goodID"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-chat-line-square"></i>
          商品名字
        </template>
        <input v-bind:disabled="editable" type="text" v-model="good.name" ></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-wallet"></i>
          商品价格
        </template>
        <input v-bind:disabled="editable" type="number" v-model="good.price"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-box"></i>
          库存数量
        </template>
        <input v-bind:disabled="editable" type="number" v-model="good.number" style="width: 25px"></input>件
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-chat-line-square"></i>
          商品描述
        </template>
        <input v-bind:disabled="editable" type="text" v-model="good.introduction"></input>
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
        <i class="el-icon-upload" id="upLoad"></i>
        <!--<input  type="text" v-model="good.picture"></input>-->
        <div class="up">
          <el-dropdown @command="uploadPic" v-bind:disbaled="editable">
        <span  class="el-dropdown-link">
          选择图片<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
            <el-dropdown-menu    slot="dropdown">
              <el-dropdown-item command="1" v-bind:disabled="editable">模型1</el-dropdown-item>
              <el-dropdown-item command="2" v-bind:disabled="editable">模型2</el-dropdown-item>
              <el-dropdown-item command="3" v-bind:disabled="editable">模型3</el-dropdown-item>
              <el-dropdown-item command="4" v-bind:disabled="editable">模型4</el-dropdown-item>
              <el-dropdown-item command="5" v-bind:disabled="editable">模型5</el-dropdown-item>
              <el-dropdown-item command="6" v-bind:disabled="editable">模型6</el-dropdown-item>
              <el-dropdown-item command="7" v-bind:disabled="editable">模型7</el-dropdown-item>
              <el-dropdown-item command="8" v-bind:disabled="editable">模型8</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "goodinfo",
  props:["good"], //嵌套组件传值
  data () {
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: require("@/assets/image/"+this.good.picture),
      sizeList: ["large", "medium", "small"],
      editable: true,
      pic_path: ["1.png",
        "2.png",
        "3.png",
        "4.png",
        "5.png",
        "6.png",
        "7.png",
        "8.png"],

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
    deleteGood:function(){ //删除指定的商品信息
      axios.post("http://119.91.199.135:8081/good/deletegood",this.good).then(res=>{
        alert("删除成功")
      })
    },
    updateGood:function(){//将修改后的商品信息更新到数据库
      console.log("更新前的good:",this.good)
      if(this.good.name===""||this.good.picture===""||this.introduction==="") {
        alert("请进一步完善商品信息！")
      }else if(this.good.number<0){
        alert("商品数量不能小于0！")
      }else if(this.good.price<0){
        alert("商品价格不能小于0！")
      }else {
        this.editable=true
        axios.post("http://119.91.199.135:8081/good/updategood", this.good).then(res => {
          alert("成功修改商品信息！")
        })
      }
    },
    changeEditable:function(){//让该商品的信息可以被修改
      this.editable=false
    },
    uploadPic(command){
      let num=parseInt(command)
      this.good.picture=this.pic_path[num]
      //修改展示的图片
      this.squareUrl=this.pic[num]
    },
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
.up{
  width:80px;
  border:2px solid whitesmoke;
  margin-right: 10px;
  display: inline-block;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>
