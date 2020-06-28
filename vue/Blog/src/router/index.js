import Vue from 'vue'
import Router from 'vue-router'

import HomePage from '@/view/Home'
import ArticleContent from '@/view/Article/ArticleContent'
import MoodPage from '@/view/Mood/MoodMoudle'


Vue.use(Router)

export default new Router({
  // history 模式,该模式下没有#前缀
  mode: 'history',
  // build打包添加的地方
  // base: '/blogger/',
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage,
      meta: {
        title: '首页',
        keepAlive: true
      }
    },
    {
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage,
      meta: {
        title: '首页',
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
        keepAlive: true
      }
    },
    // {
    //   path: '/AboutMePage',
    //   name: 'AboutMePage',
    //   component: AboutMePage
    // },
    // {
    //   path: '/ShowPage',
    //   name: 'ShowPage',
    //   component: ShowPage,
    //   children: [
    //     { path: ':id', name: 'id', component: ShowPage }
    //   ]
    // },
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
