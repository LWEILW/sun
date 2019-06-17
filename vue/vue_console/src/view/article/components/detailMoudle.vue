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
    </div> -->
    <br>

    <div>
      <el-form :model="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="标题名" prop="title">
          <el-input v-model="ruleForm.title" disabled></el-input>
        </el-form-item>

        <el-form-item label="内容" prop="content">
          <el-input type="textarea" v-model="ruleForm.content" disabled></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
          <el-input v-model="ruleForm.author" disabled></el-input>
        </el-form-item>

        <el-form-item label="创建时间" required>
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="ruleForm.date1"
                style="width: 100%;"
                disabled
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="date2">
              <el-time-picker
                placeholder="选择时间"
                v-model="ruleForm.date2"
                style="width: 100%;"
                disabled
              ></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import api from "@/api/blogger";

export default {
  name: "BloggerMoudle",
  data() {
    return {
      ruleForm: {
        title: "",
        content: "",
        author: "",
        date1: "",
        date2: ""
      }
    };
  },
  created() {
    var that = this;
    that.getBlogger();
  },
  methods: {
    getBlogger(id) {
      api.getBlogger(this.$route.params.id).then(res => {
        var that = this;
        that.ruleForm = res.data;
        console.log(that.ruleForm);
      });
    }
  }
};
</script>


<style scoped>
</style>
