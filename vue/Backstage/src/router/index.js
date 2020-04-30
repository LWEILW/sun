import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

// 登录模块
import Login from '@/view/Login.vue'

import Test from '@/view/Test.vue'

// 文章模块
// import ArticleManage from '@/view/ArticleManage/ArticleManage.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/Test',
      name: 'Test',
      component: Test
    },
    // {
    //   path: '/ArticleManage',
    //   name: 'ArticleManage',
    //   component: ArticleManage,
    //   meta: {
    //     title: '文章模块'
    //   }
    // },
  ]
})
