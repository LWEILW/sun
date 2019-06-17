<template>
  <div class="asideMoudle">
    <div class="bloggerItem shadow">
      <h5 class="itemTitle">自我介绍</h5>
      <div class="inner bloggerInfo">
        <div class="bloggerInfo-img">
          <img src="../../images/logo.jpg" alt="welphenEDM">
        </div>
        <!-- <p class="bloggerInfo-nickname">dayu</p> -->
        <!-- <p class="bloggerInfo-introduce">永远不要放弃你那颗追梦之心 up up~</p> -->
      </div>
    </div>

    <div class="bloggerItem shadow">
      <h5 class="itemTitle">热门文章</h5>
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

    <!-- <div class="bloggerItem shadow">
      <h5 class="itemTitle">最新文章</h5>
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
    </div>-->

    <div class="bloggerItem shadow">
      <h5 class="itemTitle">最近访客</h5>
      <div class="inner">
        <dl class="vistor">
          <dd>
            <a href="javasript:;">
              <img src="http://q1.qlogo.cn/g?b=qq&amp;nk=1070650845&amp;s=100">
              <cite>静待花开，</cite>
            </a>
          </dd>

          <dd>
            <a href="javasript:;">
              <img src="http://q1.qlogo.cn/g?b=qq&amp;nk=765899398&amp;s=100">
              <cite>饼干小火锅</cite>
            </a>
          </dd>
          <dd>
            <a href="javasript:;">
              <img src="http://q1.qlogo.cn/g?b=qq&amp;nk=1136299846&amp;s=100">
              <cite>负暄</cite>
            </a>
          </dd>
          <dd>
            <a href="javasript:;">
              <img src="http://q1.qlogo.cn/g?b=qq&amp;nk=1164957232&amp;s=100">
              <cite>与涅槃</cite>
            </a>
          </dd>
        </dl>
      </div>
    </div>
  </div>
</template>

<script>
import api from "@/api/user";

export default {
  name: "asideMoudle",
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
.asideMoudle {
  padding: 20px;
  margin-top: 10px;
}
/* 阴影样式 */
.shadow {
  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  filter: alpha(Opacity=80);
  -moz-opacity: 0.8;
  opacity: 0.8;
}
/*博主信息*/
.bloggerInfo {
  text-align: center;
}

.bloggerInfo-img {
  display: inline-block;
  margin: 20px auto;
}

.bloggerInfo-img img {
  border-radius: 50%;
  max-width: 47%;
}

.bloggerInfo-nickname {
  font-size: 32px;
  font-weight: bold;
  margin: 0 0 15px 0;
}

/* .bloggerInfo-introduce {
  margin: 15px auto;
  font-size: 18px;
  width: 90%;
} */

/* .blogerinfo-location {
  color: #808080;
  margin: 15px;
}

.blogerinfo-contact {
  padding: 15px;
  padding-top: 5px;
}

.blogerinfo-contact > a {
  padding: 0 10px;
} */

/* 侧边div样式 */
.bloggerItem {
  position: relative;
  background-color: rgba(255, 255, 255, 0.8);
  margin-top: 10px;
  margin-bottom: 20px;
  overflow: hidden;
  border-radius: 10px;
  background: #e5e9e1;
}

/* 内部样式 */
.inner {
  margin: 0 10px;
  padding-bottom: 10px;
}

/* 热门文章样式 */
.itemTitle {
  margin: 10px 20px;
  padding: 5px;
  line-height: 30px;
  font-weight: 400;
  border-bottom: 1px solid #5a5c57;
  color: #383937;
  position: relative;
  font-size: 18px;
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

/* 最近访客样式*/
.vistor {
  text-align: center;
}

.vistor dl {
  margin-top: 0;
  margin-bottom: 20px;
}

.vistor dd {
  position: relative;
  width: 60px;
  height: 65px;
  margin: 10px 10px 0 0;
  display: inline-block;
  vertical-align: top;
  font-size: 12px;
}

.vistor dd a {
  text-decoration: none;
}

.vistor dd a img {
  width: 60px;
  height: 60px;
  border-radius: 2px;
  vertical-align: middle;
}

.vistor dd a cite {
  position: absolute;
  bottom: 5px;
  left: 0;
  width: 100%;
  height: 20px;
  line-height: 20px;
  text-align: center;
  background-color: rgba(0, 0, 0, 0.2);
  color: #fff;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
