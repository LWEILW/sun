<template>
  <div class="headerMoudle">
    <el-row>
      <!-- logo样式 -->
      <el-col :span="18" class="logo">
        <div v-on:click="shrinkNav">logoBIG12345</div>
      </el-col>
      <el-col :span="2">
        <div><span>账户</span>{{account}}</div>
      </el-col>
      <el-col :span="2">
        <div><span>角色</span>{{password}}</div>
      </el-col>
      <el-col :span="2">
        <el-image styl="width: 100px; height: 60pxe" :src="url"></el-image>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  export default {
    name: "headerMoudle",
    // 存储数据
    data() {
      return {
        account: 123456,
        password: 1234522,
        url: ''
      };
    },
    // 初始化加载
    created() {
    },
    // 方法
    methods: {
      shrinkNav: function (event) {
        this.$store.dispatch("app/toggleSideBar");
      }
    }
  };
</script>


<style scoped>
  .headerMoudle {
    line-height: 60px;
    color: #000000;
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
