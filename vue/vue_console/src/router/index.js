import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/view/Login/Login'
import HomePage from '@/view/Home/HomePage'
import BloggerListPage from '@/view/Blogger/BloggerListPage'
import BloggerCreatePage from '@/view/Blogger/BloggerCreatePage'
import BloggerEditPage from '@/view/Blogger/BloggerEditPage'
import BloggerDetailPage from '@/view/Blogger/BloggerDetailPage'

import UserListPage from '@/view/User/UserListPage'

import skip from '@/view/Login/skip'
import PointOvelay from '@/view/Login/PointOvelay'




Vue.use(Router)

export default new Router({
  // history 模式,该模式下没有#前缀
  // mode: 'history',
  // build打包添加的地方
  // base: '/blogger/',
  routes: [
    {
      path: '/',
      name: '登录',
      component: Login
    },
    // 首页
    {
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage
    },
    // 博客详情
    {
      path: '/BloggerListPage',
      name: 'BloggerListPage',
      component: BloggerListPage
    },
    // 博客创建
    {
      path: '/BloggerCreatePage',
      name: 'BloggerCreatePage',
      component: BloggerCreatePage
    },
    // 博客编辑
    {
      path: '/BloggerEditPage',
      name: 'BloggerEditPage',
      component: BloggerEditPage,
      children: [{ path: ':id', name: 'id', component: BloggerEditPage }]
    },
    // 博客编辑
    {
      path: '/BloggerDetailPage',
      name: 'BloggerDetailPage',
      component: BloggerDetailPage,
      children: [{ path: ':id', name: 'id', component: BloggerDetailPage }]
    },
    // 用户一览
    {
      path: '/UserListPage',
      name: 'UserListPage',
      component: UserListPage
    },
    // 地图处理
    {
      path: '/skip',
      name: 'skip',
      component: skip
    },
    // 地图处理
    {
      path: '/PointOvelay',
      name: 'PointOvelay',
      component: PointOvelay
    }
  
  ]
})