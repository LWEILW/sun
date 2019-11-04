<template>
  <div id="app">
    <el-row :gutter="10">
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <el-container>
          <!-- Navigation组件 -->
          <el-aside style="width:auto; ">
            <NavigationMoudle></NavigationMoudle>
          </el-aside>
          <el-container>
            <!-- header组件 -->
            <el-header style="background-color: antiquewhite;">
              <HeaderMoudle></HeaderMoudle>
            </el-header>
            <!-- main组件 -->
            <el-main>
              <!--<router-view></router-view>是用来渲染通过路由映射过来的组件,当路由更改时,<router-view>的内容也会发生更改.-->
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
