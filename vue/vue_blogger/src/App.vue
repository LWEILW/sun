<template>
  <div id="app">
<!--    <el-row :gutter="10">-->
<!--      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">-->
        <el-container>
          <el-header>
            <Header></Header>
          </el-header>

          <el-container>
            <el-main>
              <!-- 用来渲染通过路由映射过来的组件 -->
              <router-view></router-view>
            </el-main>

            <el-aside width="263px" class="asideNone">
              <Aside></Aside>
            </el-aside>
          </el-container>

          <el-footer>
            <Footer></Footer>
          </el-footer>
        </el-container>

<!--      </el-col>-->
<!--    </el-row>-->
  </div>
</template>

<script>
  export default {
    name: "app"
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

  .el-header {
    padding: 0;
    height: 100px;
  }

  /**
    @media 可以针对不同的屏幕尺寸设置不同的样式，
    特别是如果你需要设置设计响应式的页面，@media是非常有用的。
  */
  @media (max-width: 1280px) {
    .asideNone {
      display: none;
    }
  }

  @media (max-width: 500px) {
    .el-main {
      padding: 0;
    }
  }
</style>
