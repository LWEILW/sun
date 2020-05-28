import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

// 登录模块
import Login from '@/view/Login.vue'

import Test from '@/view/Test.vue'

// 文章模块
import ArticleManage from '@/view/ArticleManage/ArticleManage.vue'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
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
    {
      path: '/ArticleManage',
      name: 'ArticleManage',
      component: ArticleManage,
      meta: {
        title: '文章模块'
      }
    },
  ]
})


// // 挂载路由导航守卫
// router.beforeEach((to, from, next) => {
//   // to 将要访问的路径
//   // from 代表从哪个路径跳转而来
//   // next 是一个函数，表示放行
//   // next() 放行  next('/login') 强制跳转
//   if (to.path === '/login') return next();
//   // 获取token
//   const tokenStr = window.sessionStorage.getItem('token')
//   if (!tokenStr) return next('/login')
//   next()
// })


export default router
