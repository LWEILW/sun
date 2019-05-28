<template>
  <div class="headerMoudle">
    <el-image :src="imgUrl" class="headerImg"></el-image>
  </div>
</template>
 
<script>
export default {
  name: "headerMoudle",
  data() {
    return {
      imgUrl: require("../../images/yang.jpg")
    };
  }
};
</script>
 
<style scoped>
.el-image {
  max-width: 100%;
  max-height: 100%;
  min-width: 195px;
  box-sizing: border-box;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.headerImg {
  max-height: 300px;
  width: 100%;
  overflow: hidden;
}
</style>
