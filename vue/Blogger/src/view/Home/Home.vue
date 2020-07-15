<template>
  <div class="home_container">

    <div class="home_lamp">
      <el-carousel height="1000px" :interval="55000" arrow="never">
        <el-carousel-item v-for="(image,index)  in imageList" :key="index">
          <img v-bind:src="image.img"><br>

          <div class="home_title">
            <h1><b>{{image.title}}</b></h1>
            <p>{{image.txt}}</p>
            <el-button type="primary">点击查看</el-button>
          </div>

          <div class="home_hot">
            <h3>热门文章</h3>
            <div class="hot_article" v-for="item in 5">
              <img src="../../assets/image/sky.jpg"/>
              <div class="hot_content">
                <div class="hot_title">寻味广州美食旅游线路</div>
                <div class="hot_date">发布日期：2019.07.30</div>
              </div>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="home_website">
      <h1>个人网站</h1>
      <p>当今最领先的响应式自助建站平台，我们的流线式网页布局设计方案和可视化图文内容编辑模式让网站制作和维护成为一件轻松惬意的事。</p>
      <p>专业网站制作人员，都能使用起飞页设计出最具专业水准的网站。我们的流线式网页布局设计方案和可视化图文内容编辑模式让网站制作和</p>
      <p>维护成为起飞页提供了海量精美网站模板和成品网站。</p>
    </div>

    <div class="home_card">
      <el-row>
        <el-col :span="8" v-for="(item, index) in imageList" :key="index" class="card_article">
          <el-card>
            <img :src="item.img">
            <div class="card_content">
              <p>{{item.title}}</p>
              <p>{{item.txt}}</p>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <div style="height: 280px" v-show="show">

      <h2>模板功能</h2>
      <p>这些文字都是可以根据您的需要自行更改的，所以不要怕和您的需要不一样哦.
        图片的话都没有具体的大小要求，合适就好，开心就好</p>
      <!--        <el-row>-->
      <!--          <el-col :span="4" :offset="2">-->
      <!--            <h3>一页式模板</h3>-->
      <!--            <p>起飞页不仅是一个方便快捷的构建网站</p>-->
      <!--          </el-col>-->
      <!--          <el-col :span="4" :offset="2">-->
      <!--            <h3>一页式模板</h3>-->
      <!--            <p>起飞页不仅是一个方便快捷的构建网站</p>-->
      <!--          </el-col>-->
      <!--          <el-col :span="4" :offset="2">-->
      <!--            <h3>一页式模板</h3>-->
      <!--            <p>起飞页不仅是一个方便快捷的构建网站</p>-->
      <!--          </el-col>-->
      <!--          <el-col :span="4" :offset="2">-->
      <!--            <h3>一页式模板</h3>-->
      <!--            <p>起飞页不仅是一个方便快捷的构建网站</p>-->
      <!--          </el-col>-->
      <!--        </el-row>-->
    </div>

    <div class="home_project">
      <el-row>
        <el-col :span="16">
          <el-row>
            <el-col :span="12" v-for="(item, index) in imageList" :key="index" class="project_content">
              <el-card>
                <img :src="item.img"/>
                <div style=" height: 100px; padding: 10px;">
                  <p>{{item.title}}</p>
                  <p>{{item.txt}}</p>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-col>

        <el-col :span="8">
          <div class="home_aside">
            <div class="home_about">
              <span>关于我们</span>
              <div style="display: flex; justify-content: flex-start;">
                <p>微博</p>
                <p>QQ</p>
                <p>博客</p>
                <p>飞鸟</p>
              </div>
            </div>
            <div class="home_new">
              <h3>最新文章</h3>
              <div v-for="item in 6" class="new_article">
                <img src="../../assets/image/sky.jpg"/>
                <div class="new_content">
                  <div class="new_title">寻味广州美食旅游线路</div>
                  <div class="new_date">发布日期：2019.07.30</div>
                </div>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>

  </div>


</template>

<script>
  import api from "@/api/article";

  export default {
    name: "Home",
    data() {
      return {
        show: true,
        slidename: "slide-left",
        isshow: true,
        imageList: [
          {
            img: require('../../assets/image/1.jpg'),
            title: '我在灯火阑珊处',
            txt: '起飞页是放飞梦想的地方，也是寻梦的地方'
          },
          {
            img: require('../../assets/image/2.jpg'),
            title: '做一个精彩的站点',
            txt: '为情怀而干杯，告别朴素的重复和一望无际的平庸'
          },
          {
            img: require('../../assets/image/sky.jpg'),
            title: '我在灯火阑珊处',
            txt: '起飞页是放飞梦想的地方，也是寻梦的地方'
          },
          {
            img: require('../../assets/image/1.jpg'),
            title: '我在灯火阑珊处',
            txt: '起飞页是放飞梦想的地方，也是寻梦的地方'
          },
          {
            img: require('../../assets/image/2.jpg'),
            title: '做一个精彩的站点',
            txt: '为情怀而干杯，告别朴素的重复和一望无际的平庸'
          }, {
            img: require('../../assets/image/3.jpg'),
            title: '做一个精彩的站点',
            txt: '为情怀而干杯，告别朴素的重复和一望无际的平庸'
          }
          ,
        ]
      }
        ;
    },
    created() {
    },
    methods: {}
  }
</script>

<style scoped>
  @import "Home.scss";
</style>
