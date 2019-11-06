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

      <el-submenu :index="item.id+''" v-for="(item,k) in menusList" :key="item.id">

        <template slot="title">

          <i :class="'iconfont icon-'+menuicon[k]"></i>

          <span>{{item.authName}}</span>

        </template>

        <el-menu-item v-for="item2 in item.children" :index="item2.path" :key="item2.id">

          <i class="el-icon-menu"></i>

          <span>{{item2.authName}}</span>

        </el-menu-item>

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
        isCollapse: false,
        menusList: {},
        menuicon: ['users', 'tijikongjian', 'shangpin', 'danju', 'baobiao']
      };
    },
    // 初始化加载
    created() {
      this.getmenus()
    },
    // 方法
    methods: {
      async getmenus() {
        const {data: res} = await this.$http.get('/menus')
        if (res.meta.status !== 200) return this.$message.error(res.meta.msg)
        this.menusList = res.data
        console.log(res.data)
      },

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
