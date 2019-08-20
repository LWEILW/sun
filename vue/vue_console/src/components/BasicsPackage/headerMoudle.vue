<template>
  <div class="headerMoudle">
    <el-col :span="24">
      <!-- logo样式 -->
      <el-col :span="10" class="logo">
        <div v-on:click="shrinkNav">logoBIG12345</div>
      </el-col>
      <el-col :span="3" >
        <div><span>账户</span>{{account}}</div>
      </el-col>
      <el-col :span="3" >
         <div><span>角色</span>{{password}}</div>
      </el-col>
      <el-col :span="4" >
        <div><el-image style="width: 100px; height: 60px"  :src="url"></el-image></div>
      </el-col>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "headerMoudle",
  // 存储数据
  data() {
    return {
      account:123456,
      password:1234522,
        url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    };
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
