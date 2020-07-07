<template>
  <div class="aside_container">

    <div class="aside_box">
      <div class="avatar_box">
        <img src="../../assets/image/cat.jpg">
      </div>
      <div class="aside_introduce">
        <p>昵称：Blog display system</p>
        <p>描述：一个安静的小角落，嘻嘻嘻嘻</p>
      </div>
    </div>

    <div class="aside_article_hot">
      <h5 class="aside_title">热门文章</h5>
      <div class="inner">
        <ol class="hot-list-article">
          <li>
            <a href="read?b_id=2">Java 基础数据类型</a>
          </li>
          <li>
            <a href="read?b_id=5">Java 代码执行顺序</a>
          </li>
          <li>
            <a href="read?b_id=10">synchronized 和 Lock详解总结</a>
          </li>
          <li>
            <a href="read?b_id=4">Java 中static和final关键字</a>
          </li>
          <li>
            <a href="read?b_id=8">== 和 equals 区别详解</a>
          </li>
        </ol>
      </div>
    </div>

    <div class="aside_article_new">
      <h5 class="aside_title">最新文章</h5>
      <div class="inner">
        <ol class="hot-list-article">
          <li>
            <a href="read?b_id=20">Eclipse 设置编码格式</a>
          </li>
          <li>
            <a href="read?b_id=19">Java 反射机制详解</a>
          </li>
          <li>
            <a href="read?b_id=18">Java 细节易错题</a>
          </li>
          <li>
            <a href="read?b_id=17">Java Object 通用方法</a>
          </li>
          <li>
            <a href="read?b_id=16">Java this和super关键字</a>
          </li>
        </ol>
      </div>
    </div>

  </div>
</template>

<script>
  import api from "@/api/user";

  export default {
    name: "asideModular",
    // 存储数据
    data() {
      return {
        items: []
      };
    },
    // 初始化加载
    created() {
      console.log(this.$route);
      // var that = this;
      // that.news();
    },
    // 方法
    methods: {
      // news() {
      //   api.newsList().then(res => {
      //     var that = this;
      //     that.items = res.data;
      //     console.log(that.items);
      //   });
      // }
    }
  };
</script>


<style scoped>

  .aside_container {
    height: 100%;
    width: 100%;
  }

  .aside_box {
    width: 100%;
    height: 300px;
    background-color: #d0e5f2;
    /* 添加圆角的边框 */
    border-radius: 10px;
    /*position: absolute;*/
    margin: 20px 0;
  }

  .avatar_box {
    width: 130px;
    height: 130px;
    border: 1px solid #eee;
    /*圆弧*/
    border-radius: 50%;
    padding: 10px;
    /*阴影*/
    box-shadow: 0 0 10px #000000;
    position: relative;
    left: 65px;
    /*transform: translate(-50%, -10%);*/
  }

  .avatar_box img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background-color: #eee;
  }

  .aside_introduce {
    /*position: absolute;*/
    /*padding-top: 130px;*/
    width: 100%;
    text-align: center;
  }

  .aside_introduce p {
    font-size: 16px;
  }

  .aside_article_hot {
    width: 100%;
    height: 300px;
    background-color: #e5e9e1;
    /* 添加圆角的边框 */
    border-radius: 10px;
    margin-top: 20px;
    /*position: absolute;*/
    /*left: 85%;*/
    /*top: 430px;*/
  }

  .aside_article_new {
    width: 100%;
    height: 300px;
    /* 添加圆角的边框 */
    border-radius: 10px;
    overflow: hidden;
    background-color: #e5e9e1;
    margin-top: 20px;
    /*position: absolute;*/
    /*top: 780px;*/
  }

  /* 标题样式 */
  .aside_title {
    margin: 10px 20px;
    padding: 5px;
    line-height: 30px;
    font-weight: 400;
    border-bottom: 1px solid #000000;
    color: #383937;
    position: relative;
    font-size: 18px;
  }

  /* 内部样式 */
  .inner {
    margin: 0 10px;
    padding-bottom: 10px;
  }


  /* 文章内部li样式 */
  .hot-list-article li {
    display: block;
    line-height: 32px;
    position: relative;
    margin: 3px 0;
    counter-increment: nums;
    padding-left: 5px;
    overflow: hidden;
    word-wrap: normal !important;
    white-space: nowrap;
    text-overflow: ellipsis;
  }

</style>
