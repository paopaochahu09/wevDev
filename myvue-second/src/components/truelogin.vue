<template>
  <div id="login">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="账号" prop="account">
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
  name:"truelogin",
  data() {
    var validateAccount = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('账号不能为空！'));
      } else {
        if(!this.testAccount(value)){
          callback(new Error("请输入正确有效的邮箱地址"))
        }
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('密码不能为空，请输入密码'));
      } else if (value.length<6) {
        callback(new Error('密码长度至少为6位，请重新输入!'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        account:'',
        password: '',
      },
      rules: {
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
          //通过了前期验证
          const that=this;
          axios.post("http://119.91.199.135:8081/user/concllogin",that.ruleForm)
          .then(res=>{
            if(res.data.errCode===0){
              alert(res.data.errMsg);
              console.log("登录信息：",res.data)
            }
            else{
              alert(res.data.errMsg);
              //账号密码正确，跳转到主页面,传递用户的account
              //this.resetForm("ruleForm")
              that.$router.push({
                name:"mainbody",
                params:{
                  account:this.ruleForm.account
                }
              })
              console.log("登录信息：",res.data)
            }
          })
        } else {
          console.log('error submit!!');
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
