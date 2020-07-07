<template>
  <div class="moodMoudle">
    <div class="block" style="text-align: left; min-height:900px;">
      <h1 class="moodTitle">
        <i class="fa fa-clock-o"></i>时光轴
        <span>—— 记录生活点点滴滴</span>
      </h1>
      <el-timeline>
        <el-timeline-item
          timestamp="2018/4/12"
          placement="top"
          v-for="(item,index) in items"
          :key="index"
        >
          <el-card>
            <h4>{{item.articleName}}</h4>
            <p>{{item.articleContent}}</p>
            <!-- <el-image class="mood-image" :src="imgUrl" lazy></el-image> -->
            <!-- <div> -->
            <!-- <router-link to="/ShowPage/" + {{item.content}}>阅读全文</router-link> -->
            <!-- <router-link :to="'/ShowPage/' + item.id"> -->
            <!-- <router-link :to="'/ShowPage/' + item.id">阅读全文</router-link> -->
            <!-- </div> -->
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>
</template>

<script>
import api from "@/api/article";

export default {
  name: "moodMoudle",
  // 存储数据
  data() {
    return {
      imgUrl: require("../../images/yang.jpg"),
      items: []
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
      });
    }
  }
};
</script>

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
.moodMoudle {
  box-sizing: content-box;
  /* 外边距属性 */
  margin: 0 auto;
  padding-right: 20px;
  padding-left: 20px;
  max-width: 1280px;
}

.mood-image {
  /* hidden内容会被修剪，并且其余内容是不可见的。*/
  overflow: hidden;
  max-height: 300px;
  max-width: 200px;
}

.moodTitle {
  font-size: 22px;
  padding-left: 40px;
}

.el-timeline {
  filter: alpha(Opacity=80);
  -moz-opacity: 0.8;
  opacity: 0.8;
}
</style>
