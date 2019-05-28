<template>
  <div id="app">
    <!--导航栏-->
    <NavMenuMoudle></NavMenuMoudle>
    <!--<router-view></router-view>是用来渲染通过路由映射过来的组件,当路由更改时,<router-view>的内容也会发生更改.-->
    <router-view></router-view>
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

/**
  @media 可以针对不同的屏幕尺寸设置不同的样式，
  特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
*/
@media (max-width: 1280px) {
  .asideNone {
    display: none;
  }
}
</style>
