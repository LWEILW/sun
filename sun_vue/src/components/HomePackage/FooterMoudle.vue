<template>
  <div class="footerMoudle">
    <a class="turn-up active" href="#"></a>
    <div class="wrap min">
      <p>
        © 2017
        <a href="https://jensonhui.top/">Jensonhui's blog</a>
        . All Rights Reserved. Theme Created By
        <a href="https://github.com/Dreamer-Paul/Single" target="_blank" rel="nofollow">Single</a>
        Modify By
        <a href="https://github.com/Jensonhui/" target="_blank" rel="nofollow">Jensonhui</a> .
        <a href="http://www.miitbeian.gov.cn" target="_blank" rel="nofollow">京ICP备18053796号-1</a>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "footerMoudle",
  data() {
    return {};
  }
};
</script>


<style scoped>
.footerSun{
  border-top: 1px solid #eee;
    text-align: center;
}
..turn-up {
    position: fixed;
    right: 10px;
    bottom: 60px;
    display: block;
    padding: .5em;
    border: 1px solid #eee;
    border-radius: 4px;
    background: #fff;
    cursor: pointer;
    transition: transform .3s;
    transform: translateX(60px);
}
.wrap {
    box-sizing: content-box;
    margin: 0 auto;
    padding-right: 20px;
    padding-left: 20px;
    max-width: 1200px;
}
 p {
    padding: 1em 0;
    font-size: .875em;
}
</style>
