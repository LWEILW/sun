<template>
  <div id="app">
    <!--<router-view></router-view>是用来渲染通过路由映射过来的组件,当路由更改时,<router-view>的内容也会发生更改.-->
    <router-view :key="key"></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
  computed: {
    key() {
      return this.$route.name !== undefined
        ? this.$route.name + +new Date()
        : this.$route + +new Date();
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
