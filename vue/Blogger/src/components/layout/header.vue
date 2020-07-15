<template>
  <div class="header_container">
    <!-- 网站显示导航栏 -->
    <div class="header_website">

      <div class="header_logo">
        <span>Blog display system</span>
      </div>
      <!--      <div class="header_image">-->
      <!--        <img :src="imgUrl"/>-->
      <!--      </div>-->

      <!-- el-menu导航栏
       1.default-active:高亮显示 刷新页面后，对应menu高亮
       2.collapse:侧边栏是否收展
       3.@select:选中事件
       4.background-color:菜单的背景色
       5.text-color:菜单的文字颜色
       6.active-text-color:当前激活菜单的文字颜色
       7.unique-opened:是否只保持一个子菜单的展开
       8.collapse-transition:是否开启折叠动画
       rgb(191, 203, 217)
       -->
      <div class="header_navigation">
        <el-menu class="el-menu-demo" :default-active="activeIndex" @select="handleSelect"
                 background-color="#baccd9" text-color="#f9f4dc" active-text-color="#ffd04b"
                 mode="horizontal"
        >
          <el-menu-item index="Home">首页</el-menu-item>
          <el-menu-item index="ArticleList">归档</el-menu-item>
          <el-menu-item index="MoodPage">分类</el-menu-item>
          <el-menu-item index="MoodPage">时光轴</el-menu-item>
          <el-menu-item index="Product">产品</el-menu-item>
          <el-menu-item index="Project">项目介绍</el-menu-item>
          <el-menu-item index="AboutMe">关于我</el-menu-item>
        </el-menu>
      </div>
    </div>

    <!--    &lt;!&ndash; 手机显示导航栏 &ndash;&gt;-->
    <!--    <div class="navNone">-->
    <!--      <div class="navPhone">-->
    <!--        <div class="phoneImage">-->
    <!--          <el-image class="websiteImage" :src="imgUrl" lazy></el-image>-->
    <!--        </div>-->

    <!--        <div class="phoneTitle">-->
    <!--          <h4>Jensonhui's blogger</h4>-->
    <!--        </div>-->
    <!--        <div class="phoneIcon">-->
    <!--          <i class="iconfont iconalign-justify"></i>-->
    <!--        </div>-->
    <!--      </div>-->
    <!--    </div>-->

  </div>
</template>

<script>
  export default {
    name: "Header",
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
          case "Home":
            this.$router.push("/Home");
            break;
          case "ArticleList":
            this.$router.push("/ArticleList");
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

<style scoped>
  .header_container {
    height: 100%;
  }

  /* 网站导航样式 */
  .header_website {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    justify-content: space-between;
    align-items: center;
    height: 100%;
  }

  .header_logo span {
    /*padding-left: 20px;*/
    line-height: 60px;
    font-size: 18px;
    color: #FFFFFF
  }

  .header_navigation {
    /*height: 60px;*/
  }

  .header_image img {
    width: 100px;
    height: 100%;
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
