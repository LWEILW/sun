<template>
  <div class="AbouMe-container">
    <el-tabs :tab-position="tabPosition" style="height: 200px;">
      <el-tab-pane label="用户管理">用户管理</el-tab-pane>
      <el-tab-pane label="配置管理">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
    </el-tabs>



    <!--  背景图片或走马灯吸引人亮点  -->
    <div class="home-demo">
      <span>背景图片或走马灯吸引人亮点</span>
    </div>
    <!--关于我 基本信息，教育背景，工作经验，专业技能-->
    <!--  tab页  -->
    <div></div>
    <!--  参与项目  -->
    <!--  卡片  -->
    <div></div>

    <!-- foot 联系我吧   -->


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
