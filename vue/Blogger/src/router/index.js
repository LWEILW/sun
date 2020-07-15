import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/view/Home/Home'

import ArticleList from '@/view/Article/ArticleList'
import ArticleContent from '@/view/Article/ArticleContent'
import MoodPage from '@/view/Mood/MoodMoudle'
import Product from '@/view/Product/Product'
import Project from '@/view/Project/Project'
import AboutMe from '@/view/AboutMe/AboutMe'

Vue.use(Router)

export default new Router({
  // history 模式,该模式下没有#前缀
  mode: 'history',
  // build打包添加的地方
  base: '/blogger/',
  routes: [
    {
      path: '/',
      name: 'initial',
      component: Home,
      meta: {
        title: '首页',
        keepAlive: false
      }
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home,
      meta: {
        title: '首页',
        keepAlive: false
      }
    },
    {
      path: '/ArticleList',
      name: 'ArticleList',
      component: ArticleList,
      meta: {
        title: '文章列表',
        keepAlive: true
      }
    },
    {
      path: '/ArticleContent',
      name: 'ArticleContent',
      component: ArticleContent,
      meta: {
        title: '文章内容',
        keepAlive: false
      },
      children: [
        { path: ':id', name: 'id', component: ArticleContent }
      ]
    },
    {
      path: '/MoodPage',
      name: 'MoodPage',
      component: MoodPage,
      meta: {
        title: '首页',
        keepAlive: false
      }
    },
    {
      path: '/Product',
      name: 'Product',
      component: Product,
      meta: {
        title: '首页',
        keepAlive: false
      }
    },{
      path: '/Project',
      name: 'Project',
      component: Project,
      meta: {
        title: '首页',
        keepAlive: false
      }
    },
    {
      path: '/AboutMe',
      name: 'AboutMe',
      component: AboutMe,
      meta: {
        title: '首页',
        keepAlive: false
      }
      // children: [
      //   { path: ':id', name: 'id', component: ShowPage }
      // ]
    },
    // {
    //   path: '/BloggerPage',
    //   name: 'BloggerPage',
    //   component: BloggerPage,
    //   children: [
    //     { path: ':id', name: 'id', component: BloggerPage }
    //   ]
    // }
    // { /* Not Found 路由，必须是最后一个路由 */
    //   path: '*',
    //   component: NotFound,
    //   meta: {
    //     title: '找不到页面'
    //   }
    // }
    // {
    //   path: '/ContentPage',
    //   name: 'ContentPage',
    //   component: ContentPage
    // },
    // {
    //   path: '/CurriculumVitaePage',
    //   name: 'CurriculumVitaePage',
    //   component: CurriculumVitaePage
    // },
    // {
    //   path: '/DirectoryPage',
    //   name: 'DirectoryPage',
    //   component: DirectoryPage
    // },
    // {
    //   path: '/MainPage',
    //   name: 'MainPage',
    //   component: MainPage
    // },
    // {
    //   path: '/MessageBoard',
    //   name: 'MessageBoard',
    //   component: MessageBoard
    // }
  ]
})
