<template>
  <div id="app">
    <el-container style="height:100%;">
      <el-aside style="width: auto; background-color: #3e4a61;">
        <!-- Navigation组件 -->
        <Navigation></Navigation>
      </el-aside>

      <el-container>
        <el-header style="height: 135px; padding: 0;">
          <!-- header组件 -->
          <Header></Header>
          <!-- 多重标签页组件 -->
          <Tags></Tags>
          <!-- 面包屑组件 -->
          <BreadBox></BreadBox>
        </el-header>

        <el-main>
          <!-- 增加keep-alive缓存机制 -->
          <keep-alive :include="tagsList">
            <!--  main主页内容 -->
            <router-view></router-view>
          </keep-alive>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

  export default {
    name: "App",
    data() {
      return {
        tagsList: [],
      }
    }
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
