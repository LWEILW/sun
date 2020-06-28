<template>
  <div class="homePage">
    <el-backtop target=".page-component__scroll .el-scrollbar__wrap" :bottom="100">
      <div
        style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
      }"
      >
        UP
      </div>
    </el-backtop>
    <!-- 标题 -->
<!--    <section class="main-title">-->
<!--      <h2>I like you, but just like you</h2>-->
<!--      <span style="color:#6e8aad">纵然万劫不复，纵然相思入骨。 我也待你眉眼如初，岁月如故</span>-->
<!--    </section>-->

    <!-- 文章 -->
    <article class="main-posts">
      <div class="main-item" v-for="(item,index) in items" :key="index">
        <h2>
          <a>
            <span class="stick">﹝TOP﹞</span>
            {{item.articleName}}
          </a>
        </h2>
        <p>{{item.articleTitle}}</p>
        <div class="main-meta">
          <i class="iconfont iconshijian"></i>
          <time class="date">2019.05.18</time>
          <i class="iconfont iconyuedu" style=" margin-left: 1em;"></i>
          <router-link :to="'/BloggerPage/' + item.id">阅读全文</router-link>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
  import api from "@/api/article";

  export default {
    name: "homePage",
    // 存储数据
    data() {
      return {
        items: [],
        backgroundDiv: {
          backgroundImage: "url(" + require("../../images/beijing.jpg") + ")"
        }
      };
    },
    // 初始化加载
    created() {
      this.articleList();
    },
    // 方法
    methods: {
      articleList() {
        const userParams = {
          currentPage: 1,
          pageSize: 10
        }
        api.articleList(userParams).then(res => {
          this.items = res.data.articleList;
          console.log(this.items);
        });
      }
    }
  };
</script>


<style scoped>
  .homePage {
    box-sizing: content-box;
    /* 外边距属性 */
    margin: 0 auto;
    padding-right: 20px;
    padding-left: 20px;
    /* overflow: auto; */
    /* max-height: 800px; */
    max-width: 1280px;
    /*min-height: 500px;*/

    background-color: #eeeeee;
  }

  .main-title {
    /* 下外边距属性 */
    margin-bottom: 1em;
    /* 文本对齐属性 */
    text-align: center;
    /* 将动画与 div 元素绑定 */
    animation: fade-in-bottom 0.3s both;
  }

  .main-title h2 {
    color: #6e8aad;
  }

  .main-title span {
    /* 此元素将显示为块级元素，此元素前后会带有换行符。 */
    display: block;
    margin-bottom: 1em;
    /* 设置字体 */
    font-weight: 100;
    font-family: Raleway;
  }

  .main-posts {
  }

  .main-item {
    margin-bottom: 3.5em;
  }

  .main-item h2 {
    margin-bottom: 1em;
    /* 设置下边框的样式 */
    border-bottom: 1px solid #eee;
  }

  .main-item h2 a {
    font-size: 0.9em;
    /* 行高 */
    line-height: 2em;
    -webkit-transition: all 0.25s;
    /* 把鼠标指针放到 div 元素上，其宽度会从 100px 逐渐变为 300px */
    transition: all 0.25s;
  }

  .main-item h2 a .stick {
    color: #6e8aad;
  }

  .main-item p {
    margin-bottom: 1em;
    line-height: 1.8em;
  }

  /**  @media 可以针对不同的屏幕尺寸设置不同的样式， 特别是如果你需要设置设计响应式的页面，@media 是非常有用的。  */
  /* @media (max-width: 900px) {
    .main-posts {
      height: 800px;
      overflow-y: scroll;
      overflow-x: scroll;
    }
  } */

  /* 苹果6/7/8 Plus样式*/
  @media (max-width: 500px) {
    /* .mainMoudle {
      min-height: 500px;
    } */
    /* .main-posts {
      height: 500px;
      overflow-y: scroll;
      overflow-x: scroll;
    } */
    .main-posts h2 {
      font-size: 16px;
    }

    .main-posts p {
      font-size: 13px;
    }
  }

  /* 苹果5s样式 */
  @media (max-width: 320px) {
    /* .mainMoudle {
      min-height: 500px;
    } */
    /* .main-posts {
      height: 370px;
      overflow-y: scroll;
      overflow-x: scroll;
    } */
    .main-posts h2 {
      font-size: 16px;
    }

    .main-posts p {
      font-size: 13px;
    }
  }
</style>
