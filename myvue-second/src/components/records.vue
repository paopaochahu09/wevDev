<template>
  <div>
  <el-table
    :data="tableData"
    height="500"
    border
    style="width: 100%">
    <el-table-column
      prop="naviTime"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="account"
      label="用户账号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="浏览-商品名">
    </el-table-column>
    <el-table-column
      prop="goodID"
      label="浏览-商品ID">
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
const axios = require('axios');

export default {
  name:"records",
  data() {
    //获取数据库全部的浏览记录信息
    var records=[]
    axios.get("http://119.91.199.135:8081//record/getallrecords").then(res=>{
      console.log("获取到的records：",res.data.data)
      records=res.data.data;
      for(let i=0;i<records.length;i++){
        records[i].naviTime=new Date(records[i].naviTime).toLocaleString();
      }
      console.log("this.records:",records)
      this.tableData=records
    })

    return {
      tableDataTemp: [{
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }, {
        date: '2016-05-03',
        username: '王小虎',
        goodname: 'figma/四谷裕美'
      }],
      tableData: []
    }
  }
}
</script>
