<template>
  <div class="headerMoudle">
    <el-col :span="24">
      <!-- logo样式 -->
      <el-col :span="10" class="logo">
        <div v-on:click="shrinkNav">logoBIG12345</div>
      </el-col>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "headerMoudle",
  // 存储数据
  data() {
    return {};
  },
  // 初始化加载
  created() {},
  // 方法
  methods: {
    shrinkNav: function(event) {
      this.$store.dispatch("app/toggleSideBar");
    }
  }
};
</script>


<style scoped>
.headerMoudle {
  line-height: 60px;
  color: #fff;
}

.logo {
  height: 60px;
  font-size: 22px;
  padding-left: 20px;
  padding-right: 20px;
  border-color: rgba(238, 241, 146, 0.3);
  border-right-width: 1px;
  border-right-style: solid;
}
</style>
