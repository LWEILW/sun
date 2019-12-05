<template>
  <div class="headerModular" style="text-align: right;background: #fff4e4; -webkit-box-shadow: 0 5px 10px #000000;">
    <!--    <el-row>-->
    <!--      <el-col :span="3" :offset="18">-->
    <span>账户:{{account}}</span>
    <span>角色:{{password}}</span>
    <!--      </el-col>-->
    <!--      <el-col :span="3">-->
    <!-- 用户头像 -->
    <el-image styl="width: 100px; height: 40pxe" :src="url"></el-image>
    <!-- 用户名下拉菜单 -->
    <el-dropdown trigger="click">
      <span style="margin-bottom: 10px">{{username}} <i class="el-icon-caret-bottom"></i></span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="info">个人资料</el-dropdown-item>
        <el-dropdown-item command="loginout" divided>退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    <!--      </el-col>-->
    <!--    </el-row>-->
  </div>
</template>

<script>
  export default {
    name: "headerModular",
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
  .headerModular {
    line-height: 40px;
    /*color: #000000;*/
  }
</style>
