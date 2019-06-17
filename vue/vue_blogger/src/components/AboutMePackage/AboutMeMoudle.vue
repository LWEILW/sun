<!-- 文章列表 -->
<template>
  <!-- <el-row :gutter="10">
    <el-col
      :xs="24"
      :sm="24"
      :md="24"
      :lg="24"
      :xl="24"
      v-for="(item, index) in newsList"
      :key="index"
    >
      <section>
        <header>
          <h1>{{item.title}}</h1>
        </header>
      </section>

      <section>
        <div>
          <p>{{item.content}}</p>
          <p style="max-height:300px;overflow:hidden;text-align:center;">
            <el-image :src="src" alt></el-image>
          </p>
        </div>
      </section>

      <div>阅读全文</div>
    </el-col>
  </el-row>-->
  <div style="min-height:950px;">
    <!-- <div style=" padding: 20px 10px;">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>活动管理</el-breadcrumb-item>
        <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        <el-breadcrumb-item>活动详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>-->
    <div>
      <el-tabs type="border-card">
        <el-tab-pane>
          <span slot="label">
            <i class="el-icon-date"></i>关于博客
          </span>
          关于博客
        </el-tab-pane>
        <el-tab-pane label="关于作者">关于作者</el-tab-pane>
        <el-tab-pane label="友情链接">
          <article class="page-content friend-ship">
            <h2 id="友情链接 | FriendShip" style="font-weight: 600;font-size: 1.17em;">友情链接 | FriendShip</h2>
            <p>本站欢迎交换友链，如果想和本站交换友情链接的，欢迎在此留言，本站会不定时的对友情链接进行互动访问。如果检测到该链接无法正常访问，即从检测的时间起，本站依然会为您保留12h，24h之后如还没有恢复则删除该友链，敬请见谅。</p>
            <p>交换友链站点需注意以下事项：</p>
            <p>① . 网站内容需健康积极向上，全技术类或者偏技术类博客，对网站RP，收录量无要求，But，文章最好是原创文章,不济的话也是伪原创的文章哦</p>
            <p>
              ② . 贵站需先做好本站友链-
              <strong>Jensonhui's blog</strong>，本站会在12小时内跟上友链
            </p>
            <p>③ . 如若发现互换友链后未经通知私自撤换友链者，本站将拉黑并永不交换。</p>
          </article>
        </el-tab-pane>
        <el-tab-pane label="留言墙">留言墙</el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import api from "@/api/user";

export default {
  //data用于存放数据或者变量

  data() {
    return {
      newsList: [],
      src: require("../../images/logo.jpg")
    };
  },
  //用于数据初始化
  created() {
    console.log(this.$route);
    var that = this;
    that.routeChange();
  },
  //用于存放所有的事件方法集合
  methods: {
    routeChange: function() {
      var that = this;
      console.log("NIHAO");
      this.news();
    },
    news() {
      api.newsList().then(res => {
        var that = this;
        that.newsList = res.data;
        console.log(that.newsList);
      });
    }
  }
};
</script>

<style scoped>
.el-col {
  border-radius: 4px;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.bg-purple h1 {
  margin: 10px 0;
  font-size: 25px;
  font-weight: 700;
  text-align: center;
  line-height: 30px;
}

p {
  margin-bottom: 1em;
  line-height: 1.8em;
}
</style>

