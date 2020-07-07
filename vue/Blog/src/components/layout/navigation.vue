<template>
  <div class="navigation">
    <!-- 网站显示导航栏 -->
    <div class="navWebsite">
      <div class="webImage">
<!--        <p style="font-size: 18px;color: #FFFFFF">Blog display system</p>-->
<!--        <el-image class="websiteImage" :src="imgUrl" lazy></el-image>-->
      </div>

      <div class="webNavigation">
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          text-color="#fff"
          background-color="#4C3B4D"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="HomePage">首页</el-menu-item>
          <el-menu-item index="MoodPage">归档</el-menu-item>
          <el-menu-item index="MoodPage">分类</el-menu-item>
          <el-menu-item index="MoodPage">时光轴</el-menu-item>
          <el-menu-item index="Product">产品</el-menu-item>
          <el-menu-item index="Project">项目介绍</el-menu-item>
          <el-menu-item index="AboutMe">关于我</el-menu-item>
        </el-menu>
      </div>

      <div class="webIcon">
        <span>登录信息</span>
        <i class="iconfont iconliebiao"></i>
      </div>
    </div>

    <!-- 手机显示导航栏 -->
    <div class="navNone">
      <div class="navPhone">
        <div class="phoneImage">
          <el-image class="websiteImage" :src="imgUrl" lazy></el-image>
        </div>

        <div class="phoneTitle">
          <h4>Jensonhui's blogger</h4>
        </div>
        <div class="phoneIcon">
          <i class="iconfont iconalign-justify"></i>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: "navigation",
    data() {
      return {
        activeIndex: this.$route.name,
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
          case "HomePage":
            this.$router.push("/HomePage");
            break;
          case "MoodPage":
            this.$router.push("/MoodPage");
            break;
          case "MoodPage":
            this.$router.push("/MoodPage");
            break;
          case "MoodPage":
            this.$router.push("/MoodPage");
            break;
          case "Product":
            this.$router.push("/Product");
            break;
          case "Project":
            this.$router.push("/Project");
            break;
          case "AboutMe":
            this.$router.push("/AboutMe");
            break;
        }
      }
    }
  };
</script>

<!-- "scoped"属性（私有作用域的概念） -->
<style scoped>


  .webNavigation{
    height: 60px;
  }


  /* 网站导航样式 */
  .navWebsite {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    justify-content: space-between;
    background: #4C3B4D;
    align-items: center;
  }

  .websiteImage {
    width: 100px;
    height: 59px;
  }


  .webIcon {
    margin-right: 20px;
  }

  .webIcon i {
    font-size: 27px;
  }

  /* 手机导航样式 */
  .navNone {
    display: none;
  }

  .navPhone {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    justify-content: space-between;
    background-color: #6e8aad;
    color: rgb(255, 255, 255);
    align-items: center;
  }


  .phoneTitle {
  }

  .phoneIcon {
    margin-right: 20px;
  }

  .phoneIcon i {
    font-size: 27px;
  }

  /**
    @media 可以针对不同的屏幕尺寸设置不同的样式，
    特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
  */
  @media (max-width: 986px) {
    .navNone {
      display: inline;
    }

    .navWebsite {
      display: none;
    }
  }
</style>
