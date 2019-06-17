<template>
  <div class="headerMoudle">
    <!-- <el-image class="headerImg" :src="imgUrl"></el-image> -->
    <!-- 标题 -->
    <section class="main-title">
      <h2>I like you, but just like you</h2>
      <span style="color:#6e8aad">纵然万劫不复，纵然相思入骨。 我也待你眉眼如初，岁月如故</span>
    </section>
  </div>
</template>
 
<script>
export default {
  name: "headerMoudle",
  data() {
    return {
      // imgUrl: require("../../images/bg2.png")
    };
  }
};
</script>
 
<style scoped>
.main-title {
  /* 下外边距属性 */
  margin-bottom: 1em;
  /* 文本对齐属性 */
  text-align: center;
  /* 将动画与 div 元素绑定 */
  animation: fade-in-bottom 0.3s both;
}

.main-title h2 {
  color: #6e8aad;
}

.main-title span {
  /* 此元素将显示为块级元素，此元素前后会带有换行符。 */
  display: block;
  margin-bottom: 1em;
  /* 设置字体 */
  font-weight: 100;
  font-family: Raleway;
}

.headerImg {
  max-height: 300px;
  width: 100%;
  overflow: hidden;
}
</style>
