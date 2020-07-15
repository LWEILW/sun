<template>
  <div class="article-list">
    <!--    <div class="home-title">-->
    <!--      <h2>I like you, but just like you</h2>-->
    <!--      <span>纵然万劫不复，纵然相思入骨。 我也待你眉眼如初，岁月如故</span>-->
    <!--    </div>-->
    <div class="home-article">
      <div class="home-item" v-for="(item,index) in items" :key="index">
        <div class="home-content">
          <h2><a>{{item.articleName}}</a></h2>
          <div class="home-data">
            <div class="home-icon">
              <i class="el-icon-tickets"></i><span>阅读数量:</span><span>{{item.readingAmount}}</span>
            </div>
            <div class="home-icon">
              <i class="el-icon-user"></i><span>发布人:</span><span>{{item.publisher}}</span></div>
            <div class="home-icon">
              <i class="el-icon-alarm-clock"></i><span>发布日期:</span><span>{{item.publisherTime}}</span>
            </div>
            <div class="home-icon">
              <i class="el-icon-timer"></i><span>更新日期:</span><span>{{item.updateDate}}</span>

              <i class="iconfont iconshijian"></i>
              <time class="date">2019.05.18</time>
              <i class="iconfont iconyuedu" style=" margin-left: 1em;"></i>
            </div>
          </div>
          <p>{{item.articleTitle}}</p>
          <div class="main-meta">
            <router-link :to="'/ArticleContent/' + item.articleId">阅读全文</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import api from "@/api/article";

  export default {
    name: "BloggerPage",
    data() {
      return {
        items: [],
      };
    },
    created() {
      this.articleList();
    },
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

  .home-title {
    color: #6e8aad;
    /* 下外边距属性 */
    margin-bottom: 1em;
  }

  .home-article {
    /*border-radius: 6px;*/
    /*border: none;*/
  }

  .home-item {
    /*设置下外边距：*/
    /*margin-bottom: 3.5em;*/
    /*webkit-box-shadow: 0 0 5px rgba(202, 203, 203, 0.5);*/

    margin-bottom: 20px;
    background-color: #ffffff;
    border: 1px solid transparent;
    border-radius: 4px;
    -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
    box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
  }

  .home-content {
    padding: 30px
  }

  .home-item h2 {
    /*margin-bottom: 1em;*/
    /* 设置下边框的样式 */
    border-bottom: 1px solid #000000;

    margin-top: 0 !important;
  }

  .home-item h2 a {
    font-size: 0.9em;
    /* 行高 */
    line-height: 2em;
  }

  .home-item .home-data {
    display: flex;
    justify-content: flex-start;
  }

  .home-item .home-icon {
    margin-right: 10px;
  }

  .home-item p {
    margin-bottom: 1em;
    line-height: 1.8em;
    font-size: 16px;
  }
</style>
