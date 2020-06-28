// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// element框架
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 导入组件
import navigation from './components/layout/navigation'
import header from './components/layout/header'
import aside from './components/layout/aside'
import footer from './components/layout/footer'

// love.js
import './utils/love.js'

// vue 粒子特效
import particles from 'particles.js'

// 导入全局样式
import './assets/css/global.css'

// 引入公共方法
import store from './utils/store'
Vue.prototype.store = store


Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(particles)

// 引用组件
Vue.component('Navigation', navigation)
Vue.component('Header', header)
Vue.component('Aside', aside)
Vue.component('Footer', footer)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
