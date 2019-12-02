<template>
  <div id="app">
    <el-container style="height:100%;">

      <!-- Navigation组件 -->
      <el-aside style="width: 200px; background-color: rgb(48, 65, 86);">
        <NavigationMoudle></NavigationMoudle>
      </el-aside>

      <el-container>
        <!-- header组件 -->
        <el-header style="background-color: antiquewhite;">
          <HeaderMoudle></HeaderMoudle>
        </el-header>

        <!-- main组件 -->
        <el-main style="background-color: #E9EEF3;">
          <!-- 多重标签页 -->
          <Tags></Tags>

          <!-- 面包屑组件 -->
          <BreadBoxMoudle></BreadBoxMoudle>

          <!-- 主页内容 -->
          <router-view></router-view>

          <!-- 增加keep-alive缓存机制 -->
          <keep-alive :include="tagsList">
<!--            <router-view></router-view>-->
          </keep-alive>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>
  // import Tabs from '@/components/BasicsPackage/tags.vue'  // 引入Tags组件
  // import bus from '@/components/BasicsPackage/bus.js'  // 组件传值使用的bus
  export default {
    name: "App",
    data() {
      return {
        tagsList: [],
      }
    },
    // created() {
    //   // 用于keep-alive缓存，只有在标签页列表里的页面才使用keep-alive，即关闭标签之后就不保存到内存中了。
    //   bus.$on('tags', msg => {
    //     let arr = []
    //     for (let i = 0, len = msg.length; i < len; i++) {
    //       msg[i].name && arr.push(msg[i].name)
    //     }
    //     this.tagsList = arr
    //   })
    // },
    // components: {
    //   // tabs: Tabs,   // 注册tabs组件
    //   // bus,    // 注册bus组件传值公共文件
    // }
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
