<template>
  <div class="loginPage">
    <el-form
      :model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="账号" prop="account">
        <el-input v-model="ruleForm.account"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import api from "@/api/login";

export default {
  data() {
    var checkAccount = (rule, value, callback) => {
      if (!value) {
        return callback();
      }
      if (value) {
        setTimeout(() => {
          var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
          if (!reg.test(value)) {
            callback(new Error("请输入有效的电子邮箱！"));
          } else {
            callback();
          }
        }, 500);
      }
    };

    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        account: "",
        pass: "",
        checkPass: ""
      },
      rules: {
        account: [{ validator: checkAccount, trigger: "blur" }],
        pass: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }]
      }
    };
  },
  methods: {
    // 登录方法
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          api
            .ajaxLogin({
              username: this.ruleForm.account,
              password: this.ruleForm.pass
            })
            .then(res => {
              if (res.data.status == 200) {
                this.$router.push({ path: "/UserListPage" }); //登录成功之后重定向到首页
              } else {
                this.$message.success(res.data.message);
              }

              // if (res.data.flag) {
              //   this.$router.push({ path: "/HomePage" }); //登录成功之后重定向到首页
              // } else {
              //   this.$message.success(res.data.msg);
              // }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    // 重置
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style scoped>
.loginPage {
  margin: 15%;
}
</style>