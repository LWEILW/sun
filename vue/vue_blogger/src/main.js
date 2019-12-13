import Vue from 'vue'
import App from './App'
import router from './router'
// element框架
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// flex布局
import 'lib-flexible'
// love.js
import './utils/love.js'
// vue 粒子特效
import particles from 'particles.js'

// 导入组件
import navigation from './components/navigation/navigation'
import header from './components/header/header'
import aside from './components/aside/aside'
import footer from './components/footer/footer'

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
