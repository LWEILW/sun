<template>
  <div class="indexMoudle">
    <div style="width:25%;">
      <div style="background-color: bisque; height:40%"></div>
      <div style="background-color: #0001;  height:60%"></div>
    </div>
    <div style="width:75%; min-height:800px; max-height:800px; background-color: black;">
      <div class="fontTitle" style="display: flex;display: inline-flex; display: -webkit-flex;">
        <!--  -->
        <p style="color:Black; font-size:5em;">I like y</p>
        <p style="color:white; font-size:5em;">ou,but just like you</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "indexMoudle",
  // 存储数据
  data() {
    return {};
  }
};
</script>


<style scoped>
.indexMoudle {
  display: flex;
  display: inline-flex;
  display: -webkit-flex;
  /* justify-content: space-between;
  align-items: center; */
}
@media (max-width: 1280px) {
  /* .fontTitle p {
    font-size:80px;
  } */
}
</style>
