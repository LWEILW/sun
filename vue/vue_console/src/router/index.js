import Vue from 'vue'
import Router from 'vue-router'

// 登录
import Login from '@/view/Login/Login'
// 首页
import HomePage from '@/view/Home/HomePage'

// 用户模块
import UserManage from '@/view/SystemManage/UserManage/UserManage.vue'
// 角色模块
import RoleManage from '@/view/SystemManage/RoleManage/RoleManage.vue'
// 权限模块
import PermissionManage from '@/view/SystemManage/PremissionManage/PermissionManage.vue'

// 文章模块
import ArticleManage from '@/view/ArticleManage/ArticleManage.vue'


// import skip from '@/view/Login/skip'
// import PointOvelay from '@/view/Login/PointOvelay'


Vue.use(Router)

export default new Router({
  // history 模式,该模式下没有#前缀
  // build打包添加的地方
  mode: 'history',
  // base: '/blogger/',
  routes: [
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: {
        title: '登录'
      },
    }, {
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage,
      meta: {
        title: '首页'
      },
    }, {
      path: '/UserManage',
      name: '用户管理',
      component: UserManage,
      meta: {
        title: 'UserManage'
      },
    }, {
      path: '/RoleManage',
      name: 'RoleManage',
      component: RoleManage,
      meta: {
        title: '角色管理'
      },
    }, {
      path: '/PermissionManage',
      name: 'PermissionManage',
      component: PermissionManage,
      meta: {
        title: '权限详情'
      },
    }, {
      path: '/ArticleManage',
      name: 'ArticleManage',
      component: ArticleManage,
      meta: {
        title: '文章模块'
      },
    }
    // // 地图处理
    // {
    //   path: '/skip',
    //   name: 'skip',
    //   component: skip
    // },
    // // 地图处理
    // {
    //   path: '/PointOvelay',
    //   name: 'PointOvelay',
    //   component: PointOvelay
    // }

  ]
})
