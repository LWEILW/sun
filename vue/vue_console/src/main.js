// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// element框架
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


// 导入组件
import NavigationMoudle from './components/BasicsPackage/navigationMoudle'
import HeaderMoudle from './components/BasicsPackage/headerMoudle'
import TinymceMoudle from './components/TinymcePackage/tinymceMoudle'


Vue.config.productionTip = false
Vue.use(ElementUI)

// 引用组件
Vue.component('NavigationMoudle', NavigationMoudle)
Vue.component('HeaderMoudle', HeaderMoudle)
Vue.component('TinymceMoudle', TinymceMoudle)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
