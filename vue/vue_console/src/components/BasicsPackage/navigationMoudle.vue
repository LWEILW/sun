<template>
  <div class="navigationMoudle">
    <!-- :default-active=""高亮显示 :collapse="":侧边栏是否收展   -->
    <el-menu
      :default-active="activeIndex"
      :collapse="isCollapse"
      class="el-menu-vertical-demo"
      @select="handleSelect"
      text-color="#fff"
      background-color="rgb(48, 65, 86)"
      active-text-color="#ffd04b"
    >
      <!-- 首页 -->
      <el-menu-item index="HomePage">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>

      <!-- 文章 -->
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>文章</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="2-1">
            <i class="el-icon-location"></i>
            <span>文章一览</span>
          </el-menu-item>
          <el-menu-item index="2-2">
            <i class="el-icon-location"></i>
            <span>文章创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 新闻 -->
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>新闻</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="3-1">
            <i class="el-icon-location"></i>
            <span>新闻一览</span>
          </el-menu-item>
          <el-menu-item index="3-2">
            <i class="el-icon-location"></i>
            <span>新闻创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 产品 -->
      <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>产品</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="4-1">
            <i class="el-icon-location"></i>
            <span>产品一览</span>
          </el-menu-item>
          <el-menu-item index="4-2">
            <i class="el-icon-location"></i>
            <span>产品创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 博客 -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>博客</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="BloggerListPage">
            <i class="el-icon-location"></i>
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item index="BloggerCreatePage">
            <i class="el-icon-location"></i>
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "navigationMoudle",
  // 存储数据
  data() {
    return {
      activeIndex: this.$route.name,
      isCollapse: false
    };
  },
  // 初始化加载
  created() {},
  // 方法
  methods: {
    // 选择路由方法
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      switch (key) {
        case "HomePage":
          this.$router.push("/HomePage");
          break;

        case "2-1":
          this.$router.push("/BloggerListPage");
          break;
        case "2-2":
          this.$router.push("/BloggerCreatePage");
          break;

        case "3-1":
          this.$router.push("/BloggerListPage");
          break;
        case "3-2":
          this.$router.push("/BloggerCreatePage");
          break;

        case "4-1":
          this.$router.push("/BloggerListPage");
          break;
        case "4-2":
          this.$router.push("/BloggerCreatePage");
          break;

        case "BloggerListPage":
          this.$router.push("/BloggerListPage");
          break;
        case "BloggerCreatePage":
          this.$router.push("/BloggerCreatePage");
          break;
      }
    }
  }
};
</script>


<style scoped>
/* 导航栏收缩样式 */
.el-menu-vertical-demo:not(.el-menu--collapse) {
   width: 200px;
  min-width: 140px;
  /* height: 100vh;  */
}
</style>
