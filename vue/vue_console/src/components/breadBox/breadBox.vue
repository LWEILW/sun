<template>
  <div class="breadBox" style="margin:15px;height: 20px;">
    <!--  面包屑组件  -->
    <el-breadcrumb separator="/" >
      <el-breadcrumb-item
        v-for="(item,index) in breadList"
        :key="index"
        :to="{ path: item.path }"
      >{{item.meta.title}}
      </el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
  export default {
    name: "breadBox",
    data() {
      return {
        breadList: [] // 路由集合
      };
    },
    watch: {
      $route() {
        this.getBreadcrumb();
      }
    },
    methods: {
      isHome(route) {
        return route.name === "HomePage";
      },
      getBreadcrumb() {
        let matched = this.$route.matched;
        //如果不是首页
        if (!this.isHome(matched[0])) {
          matched = [{path: "/HomePage", meta: {title: "首页"}}].concat(matched);
        }
        this.breadList = matched;
        console.log(this.breadList)
      }
    },
    created() {
      this.getBreadcrumb();
    }
  }
</script>

<style scoped>

</style>
