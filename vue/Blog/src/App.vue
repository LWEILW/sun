<template>
  <div id="app">
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>

      <el-container class="main_container">
        <el-main>
          <!-- 用来渲染通过路由映射过来的组件 -->
          <router-view></router-view>
        </el-main>

        <div v-if="$route.meta.keepAlive" class="app-keepAlive">
          <el-aside class="asideNone">
            <Aside></Aside>
          </el-aside>
        </div>
      </el-container>
      <el-footer>
        <Footer></Footer>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'App',
    // created() {
    //   // live2d动画
    //   setTimeout(() => {
    //     window.L2Dwidget.init({
    //       pluginRootPath: 'static/live2dw/',
    //       pluginJsPath: 'lib/',
    //       pluginModelPath: 'live2d-widget-model-hijiki/assets/',
    //       tagMode: false,
    //       debug: false,
    //       model: {jsonPath: '../static/live2dw/live2d-widget-model-hijiki/assets/hijiki.model.json'},
    //       display: {position: 'right', width: 300, height: 500},
    //       mobile: {show: true},
    //       log: false
    //     })
    //   }, 1000)
    // }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 14px;
    line-height: 2;
    color: #555;

  }

  /*.main_container {*/
  /*  !* 外边距属性 *!*/
  /*  margin: 0 auto;*/
  /*  padding: 0 20px;*/
  /*  max-width: 1280px;*/
  /*}*/

  .asideNone {
    width: 30%;
  }

  /**
  @media 可以针对不同的屏幕尺寸设置不同的样式，
  特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
  */
  @media (max-width: 986px) {
    /*.navNone {*/
    /*  display: inline;*/
    /*}*/
    .asideNone {
      display: none;
    }
  }
</style>
