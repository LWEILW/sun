<template>
  <div id="app">
<!--    <el-row :gutter="10">-->
<!--      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">-->
<!--        <div class="homePage">-->
<!--          <el-container>-->
<!--            &lt;!&ndash; Navigation组件 &ndash;&gt;-->
<!--            <el-aside style="width:auto; ">-->
<!--              <NavigationMoudle></NavigationMoudle>-->
<!--            </el-aside>-->
<!--            <el-container>-->
<!--              &lt;!&ndash; header组件 &ndash;&gt;-->
<!--              <el-header style="background-color: antiquewhite;">-->
<!--                <HeaderMoudle></HeaderMoudle>-->
<!--              </el-header>-->
<!--              &lt;!&ndash; main组件 &ndash;&gt;-->
<!--              <el-main>-->
                <!--<router-view></router-view>是用来渲染通过路由映射过来的组件,当路由更改时,<router-view>的内容也会发生更改.-->
                <router-view></router-view>
<!--              </el-main>-->
<!--            </el-container>-->
<!--          </el-container>-->
<!--        </div>-->
<!--      </el-col>-->
<!--    </el-row>-->
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
