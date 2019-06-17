<template>
  <el-row :gutter="10">
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div class="homePage" :style="backgroundDiv">
        <el-container>
          <!-- header组件 -->
          <!-- <el-header style="height:100%; padding:0;">
            <HeaderMoudle></HeaderMoudle>
          </el-header>-->
          <el-container>
            <!-- main组件 -->
            <el-main>
              <MainMoudle></MainMoudle>
            </el-main>

            <!-- aside组件 -->
            <el-aside width="263px" class="asideNone">
              <AsideMoudle></AsideMoudle>
            </el-aside>
          </el-container>

          <!-- footer组件 -->
          <el-footer>
            <FooterMoudle></FooterMoudle>
          </el-footer>
        </el-container>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "homePage",
  data() {
    return {
      backgroundDiv: {
        backgroundImage: "url(" + require("../images/beijing.jpg") + ")"
      }
    };
  }
};
</script>

<style scoped>
.homePage {
  height: 100%;
  width: 100%;
  overflow: hidden;
  /* background: no-repeat; */
  background-size: 100%;
}
</style>
