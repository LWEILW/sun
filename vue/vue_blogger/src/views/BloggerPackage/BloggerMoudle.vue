<template>
  <div class="wrap min">
    <section class="post-title">
      <h2>macOS下MAMP安装oci8扩展</h2>
      <div class="post-meta">
        <time class="date">2019年1月6日</time>
        <span class="views" style="float: right;">252次阅读</span>
      </div>
    </section>

    <article class="post-content"></article>
  </div>
</template>

<script>
import api from "@/api/user";

export default {
  data() {
    return {
      title: "",

      items: ""
    };
  },

  // 初始化加载
  created() {
    console.log(this.$route);
    var that = this;
    that.getNews();
  },
  // 方法
  methods: {
    getNews(id) {
      api.getNews(this.$route.params.id).then(res => {
        var that = this;
        that.items = res.data;
        console.log(that.items);
      });
    }
  }
};
</script>

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
/* - 阅读页标题 */
main .post-title,
main .page-title {
  animation: fade-in-bottom 0.3s both;
}
main .post-title h2,
main .page-title h2 {
  color: #6e8aad;
  margin-right: 0.25rem;
  display: inline-block;
}

main .page-title h2 {
  margin-bottom: 0;
}

main .post-title,
main .page-title {
  margin-bottom: 1em;
  padding-bottom: 1em;
  transition: border 0.3s;
  border-bottom: 1px solid #ddd;
}
</style>

