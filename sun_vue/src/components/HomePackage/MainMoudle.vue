<template>
  <div class="mainMoudle">
    <!-- 标题 -->
    <section class="main-title">
      <h1>I like you, but just like you</h1>
      <span style="color:#6e8aad">纵然万劫不复，纵然相思入骨。 我也待你眉眼如初，岁月如故</span>
    </section>
    <!-- 文章 -->
    <article class="main-posts">
      <div class="main-item" v-for="(item,index) in items" :key="index">
        <h2>
          <a>
            <span class="stick">﹝TOP﹞</span>
            {{item.title}}
          </a>
        </h2>
        <p>{{item.content}}</p>
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
import api from "@/api/user";

export default {
  name: "mainMoudle",
  // 存储数据
  data() {
    return {
      items: []
    };
  },
  // 初始化加载
  created() {
    console.log(this.$route);
    var that = this;
    that.news();
  },
  // 方法
  methods: {
    news() {
      api.newsList().then(res => {
        var that = this;
        that.items = res.data;
        console.log(that.items);
      });
    }
  }
};
</script>


<style scoped>
.mainMoudle {
  box-sizing: content-box;
  /* 外边距属性 */
  margin: 0 auto;
  padding-right: 20px;
  padding-left: 20px;
  max-width: 950px;
  /* min-height: 900px; */
}

.main-title {
  /* 下外边距属性 */
  margin-bottom: 3em;
  /* 文本对齐属性 */
  text-align: center;
  /* 将动画与 div 元素绑定 */
  animation: fade-in-bottom 0.3s both;
}
.main-title h1 {
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
.main-item .stick {
  color: #6e8aad;
}
.main-item p {
  margin-bottom: 1em;
  line-height: 1.8em;
}
.article-list {
  position: fixed;
  top: 3.5em;
  right: 0;
  bottom: 0;
  padding: 1em;
  min-width: 15em;
  border-left: 1px solid #ccc;
  border-radius: 4px;
  background: rgba(255, 255, 255, 0.5);
  /* opacity: 0; */
  transition: border 0.3s, opacity 0.3s, background 0.3s;
  pointer-events: none;
}
.article-list a {
  display: block;
  margin-bottom: 0.5em;
}

/**
  @media 可以针对不同的屏幕尺寸设置不同的样式，
  特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
*/
@media (max-width: 500px) {
  .main-posts h2 {
    font-size: 16px;
  }
  .main-posts p {
    font-size: 13px;
  }
}
</style>
