<template>
  <!--  webkit-box-shadow:边框颜色-->
  <div class="header-container">
    <div class="header_box">
      <!-- logo样式 -->
      <div class="header_logo" @click="changeStatus">
        <i class="el-icon-s-fold"></i>
      </div>

      <!-- 用户名下拉菜单 -->
      <div class="header-user">
        <span>账户:{{account}}</span>
        <span>角色:{{password}}</span>
        <el-dropdown trigger="click">
          <!-- 用户头像 -->
          <el-avatar class="header-avatar" shape="square" :src="url"></el-avatar>
          <i class="el-icon-caret-bottom"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="info">个人资料</el-dropdown-item>
            <el-dropdown-item command="loginOut" divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>

    </div>
  </div>
</template>

<script>

  export default {
    name: "header-container",
    // 存储数据
    data() {
      return {
        account: "欧阳锋",
        password: "小龙女",
        url: '../static/image/tx.jpg'
      };
    },
    // 初始化加载
    created() {
    },
    // 方法
    methods: {
      change() {
        this.store.commit('changeStatus', true)
        this.isLeftOpen = true;
        // store.commit('ON_HTTP_ERROR', httpError)
        // this.store.state.isCollapse = true
        // console.log(this.store.state.isCollapse)
      },
      changeStatus() {
        this.store.commit('changeStatus', false)
        this.isLeftOpen = true;
      }
    }
  }
</script>


<style scoped>
  .header-container {
    height: 50px;
    line-height: 50px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }

  .header_box {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    justify-content: space-between;
  }

  .header_logo {

  }

  .header-avatar {
    width: 100px;
  }
</style>
