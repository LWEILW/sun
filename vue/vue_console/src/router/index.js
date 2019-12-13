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
// 菜单模块
import MenusManage from '@/view/SystemManage/MenusManage/MenusManage.vue'

// 文章模块
import ArticleManage from '@/view/ArticleManage/ArticleManage.vue'

// import skip from '@/view/Login/skip.vue'
// import PointOvelay from '@/view/Login/PointOvelay'

Vue.use(Router)

export default new Router({
  // build打包添加的地方
  // base: '/blogger/',
  // history 模式,该模式下没有#前缀
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/Login'
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: {
        title: '登录'
      }
    },
    {
      path: '/HomePage',
      name: 'HomePage',
      component: HomePage,
      meta: {
        title: '首页'
      }
    },
    {
      path: '/UserManage',
      name: 'UserManage',
      component: UserManage,
      meta: {
        title: '用户管理'
      }
    },
    {
      path: '/RoleManage',
      name: 'RoleManage',
      component: RoleManage,
      meta: {
        title: '角色管理'
      }
    },
    {
      path: '/PermissionManage',
      name: 'PermissionManage',
      component: PermissionManage,
      meta: {
        title: '权限详情'
      }
    },
    {
      path: '/ArticleManage',
      name: 'ArticleManage',
      component: ArticleManage,
      meta: {
        title: '文章模块'
      }
    },
    // {
    //   path: '/skip',
    //   name: 'skip',
    //   component: skip,
    //   meta: {
    //     title: '地图处理'
    //   }
    // },
    {
      path: '/MenusManage',
      name: 'MenusManage',
      component: MenusManage,
      meta: {
        title: '菜单'
      }
    }
    // // 地图处理
    // {
    //   path: '/PointOvelay',
    //   name: 'PointOvelay',
    //   component: PointOvelay
    // }

  ]
})
