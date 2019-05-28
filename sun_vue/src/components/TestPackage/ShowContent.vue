<template>
  <el-row :gutter="10">
    <el-col class="contentDiv" :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div
        style=" box-sizing: content-box; margin: 0 auto; padding-right: 20px; padding-left: 20px; max-width: 1200px; max-width: 950px;"
      >
        <section
          class="home-title"
          style="margin-bottom: 3em;text-align: center;animation: fade-in-bottom .3s both;"
        >
          <h1 style="color: #6e8aad;">Jensonhui's blog</h1>
          <span
            style="display: block;margin-bottom: 1em;font-weight: 100;font-family: Raleway;"
          >The Harder You Work , The Luckier You Will Be .</span>
        </section>

        <section class="home-posts" v-for="(item, index) in items" :key="index">
          <div class="post-item" style="margin-bottom: 3.5em;">
            <h2 style="margin-bottom: 1em;border-bottom: 1px solid #eee;">
              <a
                href="https://jensonhui.top/2017/08/15/18.html"
                style="font-size: .9em;line-height: 2em;-webkit-transition: all .25s;transition: all .25s;"
              >
                <span class="stick">﹝TOP﹞</span>
                {{item.title}}
              </a>
            </h2>
            <p style="margin-bottom: 1em;line-height: 1.8em;">{{item.content}}</p>
            <div class="post-meta">
              <time class="date">{{item.time}}</time>
              <span class="category"></span>
              <span class="tags">
                <a href="https://jensonhui.top/tag/ContOS/">ContOS</a>，
                <a href="https://jensonhui.top/tag/Php/">Php</a>，
                <a href="https://jensonhui.top/tag/MySQL/">MySQL</a>
              </span>
            </div>
          </div>
        </section>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "qpContent",
  data() {
    return {
      src: require("../../images/logo.jpg"),
      items: [
        {
          title: "Vue项目npm run build打包后，路径找不到问题",
          content:
            "步骤一： 1 ) . 解决打包后JS、CSS路径找不到问题 本地测试完之后，查询项目目录下：' config ' ==&gt; ' index.js ' ==&gt; ' build ' ==&gt; 的'assetsPublicPath'； 将[ as...",
          time: "2018.06.19"
        },
        {
          title: "腾讯云ContOS7 配置Nginx1.2 + PHP7.1 + MySQL5.7",
          content:
            "环境准备 # 设置ssh登录服务器 ssh root@你的ip # 然后输入密码登录 tail ~/.ssh/id_rsa.pub # 本机运行，拿到你的公钥 vi authorized_keys # 服务器端运行，把上一...",
          time: "2018.06.19"
        }
      ]
    };
  }
};
</script>


<style scoped>
</style>
