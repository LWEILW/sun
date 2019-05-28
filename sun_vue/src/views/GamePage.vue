<template>
  <el-row :gutter="10">
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div class="gamePage">
        <el-container>
          <el-container>
            <!-- main组件 -->
            <el-main>
              <GameMoudle></GameMoudle>
            </el-main>
            <!-- aside组件 -->
            <el-aside width="263px"  class="asideNone">
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
  name: "gamePage",
  data() {
    return {};
  }
};
</script>

<style scoped>
</style>
