<template>
  <div class="BloggerMoudle">
    <!-- 路由 -->
    <!-- <div class="blogger-route">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>活动管理</el-breadcrumb-item>
        <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        <el-breadcrumb-item>活动详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>-->
    <br>

    <div>
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="标题名" prop="title">
          <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>

        <el-form-item label="内容" prop="content">
          <el-input type="textarea" v-model="ruleForm.content"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
          <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item label="创建时间" required>
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="ruleForm.date1"
                style="width: 100%;"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="date2">
              <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <br>
  </div>
</template>

<script>
import api from "@/api/blogger";

export default {
  name: "BloggerMoudle",
  data() {
    return {
      // 表单默认值
      ruleForm: {
        title: "",
        content: "",
        author: "",
        date1: "",
        date2: ""
      },
      rules: {
        title: [
          { required: true, message: "请输入标题名", trigger: "blur" },
          { min: 3, max: 8, message: "长度在 3 到 8 个字符", trigger: "blur" }
        ],

        content: [{ required: true, message: "请输入内容", trigger: "blur" }],

        author: [{ required: true, message: "请输入作者名", trigger: "blur" }],

        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          api.createBlogger({ blogger: this.ruleForm }).then(res => {
            this.$message.success("创建成功");
            this.$router.push({ path: "/bloggerListPage" });
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>


<style scoped>
</style>
