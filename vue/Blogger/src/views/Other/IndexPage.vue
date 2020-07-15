<template>
  <el-row :gutter="10">
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div class="indexPage" :style="backgroundDiv">
        <el-container>
            <!-- main组件 -->
            <el-main>
              <IndexMoudle></IndexMoudle>
            </el-main>
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
  name: "indexPage",
  data() {
    return {
      backgroundDiv: {
        // backgroundImage: "url(" + require("../images/bj.png") + ")"
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
  background: no-repeat;
  background-size: 100%;
}

/**
  @media 可以针对不同的屏幕尺寸设置不同的样式，
  特别是如果你需要设置设计响应式的页面，@media 是非常有用的。
*/
@media (max-width: 500px) {
  .el-main {
    padding: 0;
  }
}
</style>
