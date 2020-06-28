<template>
  <div class="article-container">
    <div class="article-content">
      <h2>{{items.articleName}}</h2>
      <p>{{items.articleTitle}}</p>
      <p v-html="items.articleContent"></p>
    </div>
  </div>
</template>

<script>
  import api from "@/api/article";

  export default {
    name: "ArticleContent",
    data() {
      return {
        items: []
      };
    },
    created() {
      this.articleDetails();
    },
    methods: {
      articleDetails() {
        api.articleDetails(this.$route.params.id).then(res => {
          this.items = res.data.article;
        });
      }
    }
  }
</script>

<style scoped>
  .article-container {
    background-color: #ffffff;
    padding: 0 20px;
    -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
    box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
  }

  .article-content {
    padding: 20px;
  }

  .article-content h2 {
    text-align: center;
    font-weight: 400;
    font-size: 26px;
    padding-bottom: 10px;
  }
</style>
