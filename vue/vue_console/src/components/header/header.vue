<template>
  <div class="header">
    <el-row>
      <el-col :span="16" class="BreadBox">
        <!--        &lt;!&ndash; 面包屑组件 &ndash;&gt;-->
        <!--        <BreadBox></BreadBox>-->
        11
      </el-col>
      <el-col :span="4">
        <span>账户:{{account}}</span>
        <span>角色:{{password}}</span>
      </el-col>
      <el-col :span="4">
        <!-- 用户头像 -->
        <el-image styl="width: 100px; height: 40pxe" :src="url"></el-image>
        <!--        &lt;!&ndash; 用户名下拉菜单 &ndash;&gt;-->
        <!--        <el-dropdown trigger="click" @command="handleCommand">-->
        <!--          <span>{{username}} <i class="el-icon-caret-bottom"></i></span>-->
        <!--          <el-dropdown-menu slot="dropdown">-->
        <!--            <el-dropdown-item command="info">个人资料</el-dropdown-item>-->
        <!--            <el-dropdown-item command="loginout" divided>退出登录</el-dropdown-item>-->
        <!--          </el-dropdown-menu>-->
        <!--        </el-dropdown>-->
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "header",
    // 存储数据
    data() {
      return {
        account: 123456,
        password: 1234522,
        username: "username",
        url: ''
      };
    },
    // 初始化加载
    created() {
    },
    // 方法
    methods: {}
  };
</script>


<style scoped>
  .header {
    line-height: 40px;
    /*color: #000000;*/
  }
</style>
