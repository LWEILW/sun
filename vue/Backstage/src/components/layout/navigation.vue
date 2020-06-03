<template>
  <div class="navigation">
    <!-- el-menu导航栏
     1.default-active:高亮显示 刷新页面后，对应menu高亮
     2.collapse:侧边栏是否收展
     3.@select:选中事件
     4.background-color:菜单的背景色
     5.text-color:菜单的文字颜色
     6.active-text-color:当前激活菜单的文字颜色
     7.unique-opened:是否只保持一个子菜单的展开
     8.collapse-transition:是否开启折叠动画
     -->
    <el-menu class="el-menu-vertical-demo" :default-active="activeIndex" :collapse="isCollapse" @select="handleSelect"
             background-color="#304156" text-color="rgb(191, 203, 217)" active-text-color="#1890ff"
             :unique-opened="true" :collapse-transition="false">

      <!-- 首页 -->
      <el-menu-item index="HomePage">
        <i class="el-icon-s-grid"></i>
        <span slot="title">首页</span>
      </el-menu-item>

      <!-- 用户管理 -->
      <el-submenu index="SystemManage">
        <template slot="title">
          <i class="el-icon-s-custom"></i>
          <span>用户管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup" index="UserManage">
            <span>用户一览</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 角色管理 -->
      <el-submenu index="SystemManage">
        <template slot="title">
          <i class="el-icon-coordinate"></i>
          <span>角色管理</span>
        </template>

        <el-menu-item-group class="itemGroup">
          <el-menu-item class="twoGroup"  index="RoleManage">
            <span>角色一览</span>
          </el-menu-item>
        </el-menu-item-group>

      </el-submenu>

      <!-- 模块管理 -->
      <el-submenu index="SystemManage">
        <template slot="title">
          <i class="el-icon-date"></i>
          <span>模块管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="UserManage">
            <span>模块一览</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 权限管理 -->
      <el-submenu index="SystemManage">
        <template slot="title">
          <i class="el-icon-s-opportunity"></i>
          <span>权限管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="PermissionManage">
            <span>权限一览</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 博客文章 -->
      <el-submenu index="ArticleManage">
        <template slot="title">
          <i class="el-icon-notebook-2"></i>
          <span>博客文章</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="ArticleManage">
            <span>文章一览</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 创建文章 -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-edit"></i>
          <span>创建文章</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="BloggerListPage">
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="BloggerCreatePage">
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 文章列表 -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>文章列表</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="BloggerListPage">
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="BloggerCreatePage">
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 产品展示 -->
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>产品展示</span>
        </template>

        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="3-1">
            <span>新闻一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="3-2">
            <span>新闻创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 图片展示 -->
      <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>图片展示</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="4-1">
            <span>产品一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="4-2">
            <span>产品创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 富文本编辑器 -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>富文本编辑器</span>
        </template>
        <el-menu-item-group>
          <el-menu-item  class="twoGroup" index="BloggerListPage">
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="BloggerCreatePage">
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 列表拖拽  -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>列表拖拽</span>
        </template>
        <el-menu-item-group>
          <el-menu-item  class="twoGroup" index="BloggerListPage">
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="BloggerCreatePage">
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <!-- 路由嵌套 -->
      <el-submenu index="BloggerListPage">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>路由嵌套</span>
        </template>
        <el-menu-item-group>
          <el-menu-item class="twoGroup"  index="BloggerListPage">
            <span>博客一览</span>
          </el-menu-item>
          <el-menu-item class="twoGroup"  index="BloggerCreatePage">
            <span>博客创建</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

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
        isCollapse: this.store.state.isCollapse
      };
    },
    // 初始化加载
    created() {
      // this.$refs.changeStatus
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
      },
      changeStatus() {
        this.isCollapse = true;
      }
    }
  };
</script>


<style scoped>
  .navigation {
    height: 100%;
    width: 100%;
  }


  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 210px!important;
    min-height: 1100px;
  }

  .navigation  .el-menu-vertical-demo .twoGroup{
    /*min-width: 210px!important;*/
    background-color: #1f2d3d!important;
  }





  /*!* 导航栏收缩样式 *!*/
  /*.el-menu-vertical-demo:not(.el-menu--collapse) {*/
  /*  width: 200px;*/
  /*  min-width: 140px;*/
  /*  !* height: 100%; *!*/
  /*}*/

  /*.logo {*/
  /*  height: 60px;*/
  /*  font-size: 22px;*/
  /*  padding-left: 20px;*/
  /*  padding-right: 20px;*/
  /*  border-color: rgba(238, 241, 146, 0.3);*/
  /*  border-right-width: 1px;*/
  /*  border-right-style: solid;*/
  /*}*/
</style>
