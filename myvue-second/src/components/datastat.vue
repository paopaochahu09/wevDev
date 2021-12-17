<template>
  <div>
    <el-table
      :data="tableData"
      height="500"
      border
      style="width: 100%">
      <el-table-column
        type="index"
        label="序号">
      </el-table-column>
      <el-table-column
        prop="name"
        label="商品名">
      </el-table-column>
      <el-table-column
        prop="price"
        label="销售总价格">
      </el-table-column>
      <el-table-column
        prop="scaleString"
        sortable
        label="销售占比">
      </el-table-column>
      <el-table-column
        prop="scale"
        label="图">

        <template slot-scope="scope">
          {{scope.row.scale}}
          <el-progress  :percentage="scope.row.scale" status="success"></el-progress>
        </template>

      </el-table-column>
    </el-table>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  name:"datastat",
  data() {
    //获取数据库全部的浏览记录信息
    axios.get("http://119.91.199.135:8081//order/getstat").then(res=>{
      console.log("获取到的datastat：",res.data.data)
      var tableData=res.data.data
      var sum=0
      for(let i=0;i<tableData.length;i++){
        sum+=tableData[i].price
      }
      for(let i=0;i<tableData.length;i++){
        tableData[i].scale=parseInt(tableData[i].price*100/sum)
        tableData[i].scaleString=tableData[i].scale+"%"
      }
      this.tableData=tableData
      console.log("tableData:",this.tableData)
      console.log("sum:",sum)
    })
    return {
      tableDataTemp: [{
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }, {
        name:"四谷裕美",
        price:240
      }],
      tableData: []
    }
  }
}
</script>

