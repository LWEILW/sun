<template>
  <div class="header-container">
    <div class="header_box">
      <div class="header-font">
        <span>BlOgGeR_WW</span>
      </div>


      <!-- logo样式 -->
      <div class="header_logo" style="margin-left:10px" @click="changeStatus">
        <span>Bókè guǎnlǐ xìtǒng 6/5000 Blog management system</span>
      </div>

<!--      <div>-->
<!--&lt;!&ndash;        <el-button @click="drawer = true">12312</el-button>&ndash;&gt;-->
<!--        <img @click="drawer = true" style="width: 50px; height: 50px" src="../../assets/image/cat.jpg"/>-->
<!--      </div>-->


      <!-- 用户名下拉菜单
       command:点击菜单项触发的事件回调
       trigger:触发下拉的行为
       divided:显示分割线
        -->
      <div class="header-user">
<!--        <span>账户:{{account}}</span>-->
<!--        <span>角色:{{password}}</span>-->

        <el-dropdown trigger="click" @command="handleCommand">
          <!-- 用户头像 -->
          <!--          <el-avatar class="header-avatar" shape="square" :src="url"></el-avatar>-->

          <i class="el-icon-caret-bottom"></i>
          <div class="header-image">
            <img src="../../assets/image/cat.jpg"/>
          </div>

          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="info">个人资料</el-dropdown-item>
            <el-dropdown-item command="loginOut" divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>

      <!-- 右侧抽屉 -->
      <el-drawer title="我是标题" :visible.sync="drawer" :with-header="false">

        <span>我来啦!</span>
      </el-drawer>
    </div>
  </div>
</template>

<script>

  export default {
    name: "Header",
    // 存储数据
    data() {
      return {
        account: "欧阳锋",
        password: "小龙女",
        url: '../static/image/tx.jpg',
        // 右侧抽屉
        drawer: false,
        direction: 'rtl',
      };
    },
    // 初始化加载
    created() {
    },
    // 方法
    methods: {
      // 下拉菜单事件回调
      handleCommand(command) {
        if ("loginOut" == command) {
          //登录成功之后重定向到首页
          this.$router.push({path: "/Login"});
        }
      },
      change() {
        this.store.commit('changeStatus', true);
        this.isLeftOpen = true;
        // store.commit('ON_HTTP_ERROR', httpError)
        // this.store.state.isCollapse = true
        // console.log(this.store.state.isCollapse)
      },
      changeStatus() {
        this.store.commit('changeStatus', false);
        this.isLeftOpen = true;
      }
    }
  }
</script>


<style scoped>
  .header-container {
    height: 60px;
    line-height: 60px;
    /*margin: 1px;*/
    border-bottom: 1px solid #d8dce5;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }

  .header_box {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    justify-content: space-between;
    font-size: 16px;
    /*color: #eeeeee;*/
  }

  .header_logo {
  }

  .header-avatar {
    width: 100px;
  }


  .navigation-box {
    display: flex;
    justify-content: space-around;
  }

  .navigation-image {
    border: 1px solid #fffef8;
    /*圆弧*/
    border-radius: 50%;
    padding: 2px;
    /*阴影*/
    box-shadow: 0 0 10px #cdd1d3;
    height: 50px;
    width: 50px;
    background-color: #737c7b;
  }

  .navigation-image img {
    height: 100%;
    width: 100%;
    border-radius: 50%;
    background-color: #eee;
  }
</style>
