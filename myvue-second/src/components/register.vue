<template>
  <div id="login">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >

      <el-form-item label="用户名" prop="name">
        <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item prop="account" label="账户/邮箱">
        <el-input type="text" v-model="ruleForm.account" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
const axios = require('axios');

export default {
  name:"register",
  data() {
    var validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('用户名不能为空，请输入用户名！'));
      } else {
        if (value.length>10) {
          callback(new Error('用户名长度最大为10，请另取名字！'))
        }
        callback();
      }
    };
    var validateAccount = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入账号'));
      } else {
        if (!this.testAccount(value)) {
          callback(new Error("请输入有效的邮箱地址！"));
        }
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('密码不能为空'));
      } else {
        if (value.length<6) {
          callback(new Error("密码长度不得少于6位，请重新输入！"))
        }
        callback();
      }
    };
    return {
      ruleForm: {
        account:'',
        name:'',
        password:'',
        picture:''
      },
      rules: {
        name:[
          { validator: validateName, trigger: 'blur' }
        ],
        account: [
          { validator: validateAccount, trigger: 'blur' }
        ],
        password: [
          { validator: validatePass, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //通过前面格式的检验
          //测试账号是否重复
          var temp={account:this.ruleForm.account}
          axios.post("http://119.91.199.135:8081/user/adduser",this.ruleForm)
          .then(res=>{
            //注册成功
            console.log("??????????????")
            console.log("mess:",res.data)
            if(res.data.errCode>0){
              alert(res.data.errMsg)
              this.resetForm("ruleForm");
              this.$router.push("truelogin");
            }
            else{//注册失败
              alert(res.data.errMsg);
            }
          })
        } else {
          console.log('注册失败，请重新输入!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    testAccount(email){
      var pattern= /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
      var flag=pattern.test(email)
      if(flag){
        return true;
      }
      else{
        return false;
      }
    }
  }
}
</script>

<style scoped>

</style>
