<template>
  <div id="app">
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>

      <el-container class="main_container">
        <el-main>
          <!--          <transition :name="transitionName">-->
          <!-- 用来渲染通过路由映射过来的组件 -->
          <router-view class="router"></router-view>
          <!--          </transition>-->
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
    data() {
      return {
        // 初始过度动画方向
        transitionName: "slide-right"
      }
    },
    // watch: {
    //   $route(to, from) {
    // 监听路由变化时的状态为前进还是后退
    // let isBack = this.$router.isBack;
    // if (isBack) {
    //   this.transitionName = "slider-right";
    //
    // } else {
    //   this.transitionName = "slider-left";
    //
    // }
    // this.$router.isBack = false;
    // }
    // // 切换动画
    // }
    // created() {
    //   // live2d动画
    //   setTimeout(() => {
    //     window.L2Dwidget.init({
    //       pluginRootPath: 'blogger/static/live2dw/',
    //       pluginJsPath: 'lib/',
    //       pluginModelPath: 'live2d-widget-model-hijiki/assets/',
    //       tagMode: false,
    //       debug: false,
    //       model: {jsonPath: '../blogger/static/live2dw/live2d-widget-model-hijiki/assets/hijiki.model.json'},
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
    /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
    font-family: 微軟正黑體;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    /*font-size: 18px;*/
    color: #2c3e50;
  }

  .main_container {
    /*  !* 外边距属性 *!*/
    /*  margin: 0 auto;*/
    /*  padding: 0 20px;*/
    /*  max-width: 1280px;*/
    overflow: hidden;
  }


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


  /*.router {*/
  /*  !*position: absolute;*!*/
  /*  !*width: 100%;*!*/
  /*  transition: all .8s ease;*/
  /*  !*top: 40px;*!*/
  /*}*/


  /*.slide-left-enter, .slide-right-leave-to {*/
  /*  opacity: 0;*/
  /*  transform: translateX(100%)*/
  /*}*/

  /*.slide-left-leave-to, .slide-right-enter {*/
  /*  opacity: 0;*/
  /*  transform: translateX(-100%)*/
  /*}*/

  /*.slide-left-enter-active, .slide-left-leave-active, .slide-right-enter-active, .slide-right-leave-active {*/
  /*  transition: 2s;*/
  /*  position: absolute;*/
  /*  top: 0;*/
  /*}*/
</style>
