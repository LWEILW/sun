<template>
  <div class="navigation">
    <!-- logo样式 -->
    <div class="logo" style="line-height: 40px;">logoBIG12345</div>
    <!--
     1.default-active:高亮显示 刷新页面后，对应menu高亮
     2.collapse:侧边栏是否收展
     3.@select:选中事件
     4.background-color:菜单的背景色
     5.active-text-color:当前激活菜单的文字颜色
     6.text-color:菜单的文字颜色
     -->
    <el-menu class="el-menu-vertical-demo"
             :default-active="activeIndex"
             :collapse="isCollapse"
             @select="handleSelect"
             background-color="rgb(48, 65, 86)"
             text-color="#fff"
             active-text-color="#ffd04b">
      <!-- 首页 -->
      <el-menu-item index="HomePage">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>

      <!-- 管理员工具 -->
      <el-submenu index="SystemManage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>管理员工具</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="UserManage">
            <i class="el-icon-location"></i>
            <span>用户管理</span>
          </el-menu-item>
          <el-menu-item index="RoleManage">
            <i class="el-icon-location"></i>
            <span>角色管理</span>
          </el-menu-item>
          <el-menu-item index="PermissionManage">
            <i class="el-icon-location"></i>
            <span>权限管理</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 文章 -->
      <el-submenu index="ArticleManage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>文章</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="ArticleManage">
            <i class="el-icon-location"></i>
            <span>文章一览</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!--      &lt;!&ndash; 新闻 &ndash;&gt;-->
      <!--      <el-submenu index="3">-->
      <!--        <template slot="title">-->
      <!--          <i class="el-icon-location"></i>-->
      <!--          <span>新闻</span>-->
      <!--        </template>-->
      <!--        <el-menu-item-group>-->
      <!--          <el-menu-item index="3-1">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>新闻一览</span>-->
      <!--          </el-menu-item>-->
      <!--          <el-menu-item index="3-2">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>新闻创建</span>-->
      <!--          </el-menu-item>-->
      <!--        </el-menu-item-group>-->
      <!--      </el-submenu>-->

      <!--      &lt;!&ndash; 产品 &ndash;&gt;-->
      <!--      <el-submenu index="4">-->
      <!--        <template slot="title">-->
      <!--          <i class="el-icon-location"></i>-->
      <!--          <span>产品</span>-->
      <!--        </template>-->
      <!--        <el-menu-item-group>-->
      <!--          <el-menu-item index="4-1">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>产品一览</span>-->
      <!--          </el-menu-item>-->
      <!--          <el-menu-item index="4-2">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>产品创建</span>-->
      <!--          </el-menu-item>-->
      <!--        </el-menu-item-group>-->
      <!--      </el-submenu>-->

      <!--      &lt;!&ndash; 博客 &ndash;&gt;-->
      <!--      <el-submenu index="BloggerListPage">-->
      <!--        <template slot="title">-->
      <!--          <i class="el-icon-location"></i>-->
      <!--          <span>博客</span>-->
      <!--        </template>-->
      <!--        <el-menu-item-group>-->
      <!--          <el-menu-item index="BloggerListPage">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>博客一览</span>-->
      <!--          </el-menu-item>-->
      <!--          <el-menu-item index="BloggerCreatePage">-->
      <!--            <i class="el-icon-location"></i>-->
      <!--            <span>博客创建</span>-->
      <!--          </el-menu-item>-->
      <!--        </el-menu-item-group>-->
      <!--      </el-submenu>-->


    </el-menu>
  </div>
</template>

<script>
  export default {
    name: "navigation",
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
          case "UserManage":
            this.$router.push("/UserManage");
            break;
          case "RoleManage":
            this.$router.push("/RoleManage");
            break;
          case "PermissionManage":
            this.$router.push("/PermissionManage");
            break;
          case "ArticleManage":
            this.$router.push("/ArticleManage");
            break;



          // case "2-2":
          //   this.$router.push("/BloggerCreatePage");
          //   break;
          //
          // case "3-1":
          //   this.$router.push("/BloggerListPage");
          //   break;
          // case "3-2":
          //   this.$router.push("/BloggerCreatePage");
          //   break;
          //
          // case "4-1":
          //   this.$router.push("/BloggerListPage");
          //   break;
          // case "4-2":
          //   this.$router.push("/BloggerCreatePage");
          //   break;
          //
          // case "BloggerListPage":
          //   this.$router.push("/BloggerListPage");
          //   break;
          // case "BloggerCreatePage":
          //   this.$router.push("/BloggerCreatePage");
          //   break;
          //
          // case "UserListPage":
          //   this.$router.push("/UserListPage");
          //   break;
          // case "BloggerCreatePage":
          //   this.$router.push("/BloggerCreatePage");
          //   break;
        }
      }
    }
  };
</script>


<style scoped>
  .navigation {
    height: 100%;
  }

  /* 导航栏收缩样式 */
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-width: 140px;
    /* height: 100%; */
  }

  .logo {
    height: 60px;
    font-size: 22px;
    padding-left: 20px;
    padding-right: 20px;
    border-color: rgba(238, 241, 146, 0.3);
    border-right-width: 1px;
    border-right-style: solid;
  }
</style>
