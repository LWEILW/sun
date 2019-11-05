<template>
  <div class="navigationMoudle">
    <!--  default-active:高亮显示 刷新页面后，对应menu高亮
    collapse:侧边栏是否收展
    background-color:菜单的背景色
    active-text-color:当前激活菜单的文字颜色
    text-color:菜单的文字颜色
    @select:选中事件 -->
    <el-menu
      class="el-menu-vertical-demo"
      :default-active="activeIndex"
      :collapse="isCollapse"
      @select="handleSelect"
      background-color="rgb(48, 65, 86)"
      text-color="#fff"
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

      <!-- 用户 -->
      <el-submenu index="UserListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="UserListPage">
            <i class="el-icon-location"></i>
            <span>用户一览</span>
          </el-menu-item>
          <el-menu-item index="UserListPage">
            <i class="el-icon-location"></i>
            <span>用户创建</span>
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
        // 是否水平折叠收起菜单
        isCollapse: false
      };
    },
    // 初始化加载
    created() {
    },
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

          case "UserListPage":
            this.$router.push("/UserListPage");
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
  .navigationMoudle {
    height: 100%;
  }

  /* 导航栏收缩样式 */
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-width: 140px;
    /* height: 100%; */
  }
</style>
