<template>
  <el-row :gutter="10">
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div class="homePage">
        <el-container>
          <!-- Navigation组件 -->
          <el-aside style="width:auto; ">
            <NavigationMoudle></NavigationMoudle>
          </el-aside>
          <el-container>
            <!-- header组件 -->
            <el-header style="background-color: antiquewhite;">
              <HeaderMoudle></HeaderMoudle>
            </el-header>
            <!-- main组件 -->
            <el-main>
              <editMoudle></editMoudle>
            </el-main>
          </el-container>
        </el-container>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import editMoudle from "./components/editMoudle";

export default {
  name: "homePage",
  components: {
    editMoudle
  },
  data() {
    return {};
  }
};
</script>

<style scoped>
</style>
