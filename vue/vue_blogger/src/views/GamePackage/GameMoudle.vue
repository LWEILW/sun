<template>
  <div class="gameMoudle">
    <el-carousel :interval="5000" arrow="always" height="200px" style="text-align: center;">
      <el-carousel-item v-for="url in urls" :key="url" lazy>
        <el-image :src="url"></el-image>
      </el-carousel-item>
    </el-carousel>

    <div class="whitebg">
      <!-- <h2 class="htitle">
        <span class="hnav"></span>友情专题
      </h2>-->
      <ul>
        <li v-for="(item,index) in items" :key="index">
          <i class="ztpic">
            <a href="javascrpt:void(0)" target="_blank">
              <img src="/Content/images/1.jpg">
            </a>
          </i>
          <b>{{item.title}}</b>
          <span>{{item.content}}</span>
          <a href target="_blank" class="readmore">文章阅读</a>
        </li>
      </ul>
    </div>

    <!-- 粒子特效代码-->
    <vue-particles
      color="#dedede"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#dedede"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="3"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    >
    11111
    
    </vue-particles>
  </div>
</template>

<script>
import api from "@/api/user";

export default {
  name: "gameMoudle",
  data() {
    return {
      urls: [
        "https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg",
        "https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg",
        "https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg",
        "https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg",
        "https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg",
        "https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg",
        "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg"
      ],
      items: []
    };
  },
  created() {
    var that = this;
    that.news();
  },
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

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
.gameMoudle {
  box-sizing: content-box;
  /* 外边距属性 */
  margin: 0 auto;
  padding-right: 20px;
  padding-left: 20px;
  max-width: 1280px;
}

.whitebg {
  background: #fff;
  border-radius: 3px;
  padding: 20px;
  margin-bottom: 20px;
  overflow: hidden;
}
.whitebg .htitle {
  font-size: 16px;
  line-height: 40px;
  border-bottom: 1px solid #eee;
  color: #484848;
  font-weight: normal;
  position: relative;
  margin-bottom: 10px;
}
.whitebg ul {
  overflow: hidden;
  padding: 10px 0 20px 10px;
  position: relative;
}
.whitebg li {
  float: left;
  width: 20%;
  border-bottom: #eee 1px solid;
  border-left: #eee 1px solid;
  overflow: hidden;
  padding: 20px;
  -moz-transition: all 0.5s ease;
  -webkit-transition: all 0.5s ease;
  transition: all 0.5s ease;
}
.whitebg .ztpic {
  width: 100%;
  height: 100px;
  overflow: hidden;
  border-radius: 3px;
  background: #ccc;
  display: block;
}

.whitebg a {
  text-decoration: none;
  color: #333;
}

.whitebg img {
  display: inline-block;
  width: 100%;
  min-height: 100%;
  height: auto;
  vertical-align: middle;
  transition: all 0.5s ease-out 0.1s;
}

.whitebg b {
  display: block;
  width: 100%;
  overflow: hidden;
  height: 30px;
  line-height: 30px;
  margin: 10px 0;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.whitebg span {
  color: #999;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  font-size: 14px;
  height: 62px;
}
.readmore {
  margin: 10px 0 0 0;
  color: #096;
  display: block;
}
</style>
