<template>
  <div id="app">
    <div v-if="$route.meta.keepAlive" class="app-keepAlive">
      <el-container>
        <el-aside>
          <!-- 导航栏 -->
          <Navigation></Navigation>
        </el-aside>
        <el-container>
          <el-header>
            <!-- 页首 -->
            <Header></Header>
            <!-- 面包屑组件 -->
            <!-- <BreadBox></BreadBox>-->
          </el-header>
          <!-- 多重标签页组件 -->
          <Tags></Tags>
          <el-main>
            <router-view/>
            <!--    <wavePlay></wavePlay>-->
          </el-main>
          <el-footer>
            <!-- 页尾 -->
            Footer
          </el-footer>
        </el-container>

      </el-container>
    </div>

    <div v-if="$route.meta.keepAlive" class="app-keepAlive">
      <el-container>
        <el-header>
          <!-- 页首 -->
          <Header></Header>
          <!-- 面包屑组件 -->
          <!-- <BreadBox></BreadBox>-->
        </el-header>

        <el-container>
          <el-aside>
            <!-- 导航栏 -->
            <Navigation></Navigation>
          </el-aside>
          <el-container>
            <!-- 多重标签页组件 -->
            <Tags></Tags>
            <el-main>
              <router-view/>
              <!--    <wavePlay></wavePlay>-->
            </el-main>
            <el-footer>
              <!-- 页尾 -->
              Footer
            </el-footer>
          </el-container>

        </el-container>
      </el-container>
    </div>

    <router-view v-if="!$route.meta.keepAlive"></router-view>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    /*text-align: center;*/
    color: #2c3e50;
    /*border: 1px solid #eee;*/
  }


</style>
