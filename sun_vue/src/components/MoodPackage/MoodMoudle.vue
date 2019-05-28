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
            <h4>{{item.title}}</h4>
            <p>{{item.content}}</p>
            <el-image class="mood-image" :src="imgUrl" lazy></el-image>
            <div>
              <!-- <router-link to="/ShowPage/" + {{item.content}}>阅读全文</router-link> -->
              <!-- <router-link :to="'/ShowPage/' + item.id"> -->
              <router-link :to="'/ShowPage/' + item.id">阅读全文</router-link>
            </div>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>
</template>

<script>
import api from "@/api/user";

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

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
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
</style>
