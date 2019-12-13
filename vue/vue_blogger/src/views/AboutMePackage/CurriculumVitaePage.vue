<template>
  <div class="curriculumVitae" style="text-align: center;">
    <div id="loading-panel">
      <h1>
        <strong>Loading...</strong>
      </h1>
      <h2>
        <strong>{{percent}}</strong>
      </h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "curriculumVitae",
  data() {
    // 自己写的组件，data这里是一个方法，return出来的一定是一个对象
    return {
      count: 0,
      percent: ""
    };
  },
  mounted: function() {
    this.preload();
  },
  methods: {
    preload: function() {
      let imgs = [
        "../images/beijin.jpg",
        "../images/logo1.jpg",
        "../images/logo.jpg",
        "../images/scroll.png"
      ];

      for (let img of imgs) {
        let image = new Image();
        image.src = img;
        image.onload = () => {
          this.count++;
          // 计算图片加载的百分数，绑定到percent变量
          let percentNum = Math.floor((this.count / 14) * 100);
          this.percent = `${percentNum}%`;
        };
      }
    }
  },
  watch: {
    count: function(val) {
      // console.log(val)
      if (val === 14) {
        // 图片加载完成后跳转页面
        this.$router.push({ path: "cover" });
      }
    }
  }
};
</script>

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
/*本组件专用样式*/
.Home {
  height: 100%;
  width: 100%;
  overflow: hidden;
  background: no-repeat;
  background-size: 100%;
}
/* 图片设置*/
.climate {
  display: inline-block;
}

.climate img {
  width: 100%;
  height: 700px;
  vertical-align: middle;
}
</style>
