// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// element框架
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


// 导入组件
import Navigation from './components/navigation/navigation'
import Header from './components/header/header'
import Tags from './components/tags/tags'
import BreadBox from './components/breadBox/breadBox'
import Tinymce from './components/tinymce/tinymce'

import has from './view/SystemManage/PremissionManage/shiro';


Vue.config.productionTip = false
Vue.use(ElementUI)

// 引用组件
Vue.component('Navigation', Navigation)
Vue.component('Header', Header)
Vue.component('Tags', Tags)
Vue.component('BreadBox', BreadBox)
Vue.component('Tinymce', Tinymce)



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
