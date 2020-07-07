<template>
  <div class="AbouMe-container">
    <el-tabs :tab-position="tabPosition" style="height: 200px;">
      <el-tab-pane label="用户管理">用户管理</el-tab-pane>
      <el-tab-pane label="配置管理">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "aboutMePage",
  data() {
    return {
      tabPosition: 'top'
    };
  }
};
</script>

<style scoped>
  .AbouMe-container{
    /* 外边距属性 */
    margin: 0 auto;
    padding: 0 20px;
    max-width: 1280px;
  }
</style>
