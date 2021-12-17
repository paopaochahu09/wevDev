<template>
  <div >
    <el-descriptions class="margin-top" title="商品信息" :column="2" :size="size" border style="width:700px" >
      <template slot="extra">
        <el-button class="el-icon-edit" type="primary" size="small" >编辑/edit</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          商品ID
        </template>
        <input disabled="true" type="text" value="15sd48s15dsa"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          商品名字
        </template>
        <input disabled="true" type="text" value="figma爱丽丝机甲/四谷裕美"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mouse"></i>
          商品价格
        </template>
        <input disabled="true" type="text" value="650"></input>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          库存数量
        </template>
        <input disabled="true" type="text" value="150" style="width: 25px"></input>件
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          商品描述
        </template>
        <input disabled="true" type="text" value="品牌：figma / ip:爱丽丝机甲手游 / 类型:可动成品"></input>
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
        <i class="el-icon-upload" id="upLoad">修改商品图片</i>
        <input disabled="true" type="text" value="http://paopaochahu.png"></input>
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name: "orderinfo",
  data () {
    return {
      size: '',
      show3:true,
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"]
    }
  },
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
