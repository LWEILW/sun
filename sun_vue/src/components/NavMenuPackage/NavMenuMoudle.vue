<template>
  <div class="NavMoudle">
    <!-- 手机显示导航栏 -->
    <div class="navNone">
      <div class="navPhone">
        <div class="head-logo">
          <el-image class="NavImage" :src="imgUrl" lazy></el-image>
        </div>
        <div class="head-title">
          <h4>Jensonhui's blog</h4>
        </div>
        <div class="head-menu">
          <el-dropdown :hide-on-click="false">
            <i class="iconfont iconalign-justify" style="font-size: 27px;"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>黄金糕</el-dropdown-item>
              <el-dropdown-item>狮子头</el-dropdown-item>
              <el-dropdown-item>螺蛳粉</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
    <!-- 网站显示导航栏 -->
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#6e8aad"
      text-color="#fff"
      active-text-color="#ffd04b"
      min-width:200px
    >
      <a>
        <el-image class="NavImage" :src="imgUrl" lazy></el-image>
      </a>
      <el-menu-item index="4">AboutMePage</el-menu-item>
      <el-menu-item index="3">GamePage</el-menu-item>
      <el-menu-item index="2">MoodPage</el-menu-item>
      <el-menu-item index="1">首页</el-menu-item>
    </el-menu>
    <div class="line"></div>
  </div>
</template>

<script>
export default {
  name: "NavMoudle",
  data() {
    return {
      activeIndex: "1",
      imgUrl: require("../../images/yang.jpg")
    };
  },
  methods: {
    // 我们给左侧的菜单栏添加了一个响应，在响应函数中作出了路由跳转的处理。
    // this.$router.push('/Page1');这句话的意思就是将当前要跳转的页面push到router的数组中。
    // 这里使用push而不是直接给数组赋值的原因是希望用户点击浏览器中的后退和前进按钮时可以回到之前操作的页面。
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      switch (key) {
        case "1":
          this.$router.push("/HomePage");
          break;
        case "2":
          this.$router.push("/MoodPage");
          break;
        case "3":
          this.$router.push("/GamePage");
          break;
        case "4":
          this.$router.push("/AboutMePage");
          break;
        // case "5":
        //   this.$router.push("/MoodPage");
        //   break;
        // case "6":
        //   this.$router.push("/GamePage");
        //   break;
        // case "7":
        //   this.$router.push("/DirectoryPage");
        //   break;
        // case "8":
        //   this.$router.push("/ContentPage");
        //   break;
        // case "9":
        //   this.$router.push("/CurriculumVitaePage");
        //   break;
      }
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
.head-logo {
  width: 100px;
}
.head-menu {
  width: 30px;
}

.NavImage {
  width: 100px;
  height: 59px;
}
.el-menu-item {
  float: right;
}

.navNone {
  display: none;
}

.navPhone {
  display: flex;
  display: inline-flex;
  display: -webkit-flex;
  justify-content: space-between;
  align-items: center;
  background-color: #6e8aad;
  color: rgb(255, 255, 255);
}

@media (max-width: 500px) {
  .navNone {
    display: inline;
  }
  .el-menu-demo {
    display: none;
  }
}
</style>
