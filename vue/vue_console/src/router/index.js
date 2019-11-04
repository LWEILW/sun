import Vue from 'vue'
import Router from 'vue-router'

// 登录
import Login from '@/view/Login/Login'
// 首页
import HomePage from '@/view/Home/HomePage'
// 管理员模块
// 用户模块
import UserManage from '@/view/SystemManage/UserManage/UserManage.vue'
import RoleManage from '@/view/SystemManage/RoleManage/RoleManage.vue'

import ArticleManage from '@/view/ArticleManage/ArticleManage.vue'


// import BloggerListPage from '@/view/BloggerListPage/BloggerListPage'


// import skip from '@/view/Login/skip'
// import PointOvelay from '@/view/Login/PointOvelay'


Vue.use(Router)

export default new Router({
  // history 模式,该模式下没有#前缀
  mode: 'history',
  // build打包添加的地方
  // base: '/blogger/',
  routes: [
    {
      // 登录
      path: '/Login',
      name: 'Login',
      component: Login
    }, {
      // 首页
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage
    }, {
      // 用户管理
      path: '/UserManage',
      name: 'UserManage',
      component: UserManage
    }, {
      // 角色管理
      path: '/RoleManage',
      name: 'RoleManage',
      component: RoleManage
    }, {
      // 文章模块
      path: '/ArticleManage',
      name: 'ArticleManage',
      component: ArticleManage
    },
    // {
    //   // 博客详情
    //   path: '/BloggerListPage',
    //   name: 'BloggerListPage',
    //   component: BloggerListPage
    // },


    // {
    //   // 博客创建
    //   path: '/BloggerCreatePage',
    //   name: 'BloggerCreatePage',
    //   component: BloggerCreatePage
    // },
    // {
    //   // 博客编辑
    //   path: '/BloggerEditPage',
    //   name: 'BloggerEditPage',
    //   component: BloggerEditPage,
    //   children: [{path: ':id', name: 'id', component: BloggerEditPage}]
    // },
    // {
    //   // 博客编辑
    //   path: '/BloggerDetailPage',
    //   name: 'BloggerDetailPage',
    //   component: BloggerDetailPage,
    //   children: [{path: ':id', name: 'id', component: BloggerDetailPage}]
    // },
    //
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
