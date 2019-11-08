<template>
  <div id="app">
    <el-row :gutter="10">
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <el-container>
          <!-- header组件 -->
          <el-header style="background-color: antiquewhite;">
            <HeaderMoudle></HeaderMoudle>
          </el-header>
          <el-container>
            <!-- Navigation组件 -->
            <el-aside style="width:auto; ">
              <NavigationMoudle></NavigationMoudle>
            </el-aside>
            <!-- main组件 -->
            <el-main>
              <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
                <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                <el-breadcrumb-item>活动详情</el-breadcrumb-item>
              </el-breadcrumb>
              <router-view></router-view>
            </el-main>
          </el-container>
        </el-container>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "App"
  };
</script>

<style>
  #app {
    /* 字体样式 */
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    font-size: 15px;
  }
</style>
