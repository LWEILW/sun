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
// import VueParticles from 'vue-particles'
// vue 粒子特效
import particles from 'particles.js'

// 导入组件
// NavMenuPackage包
import NavMenuMoudle from './components/NavMenuPackage/NavMenuMoudle'
// HomePackage包
import HeaderMoudle from './components/HomePackage/HeaderMoudle'
import MainMoudle from './components/HomePackage/MainMoudle'
import FooterMoudle from './components/HomePackage/FooterMoudle'
import AsideMoudle from './components/HomePackage/AsideMoudle'
// MoodPackage包
import MoodMoudle from './components/MoodPackage/MoodMoudle'
import MdcontentMoudle from './components/MoodPackage/MdcontentMoudle'
// GamePackage包
import GameMoudle from './components/GamePackage/GameMoudle'
// AboutMePackage包
import AboutMeMoudle from './components/AboutMePackage/AboutMeMoudle'
// BloggerPackage包
import BloggerMoudle from './components/BloggerPackage/BloggerMoudle'
// import ContentPageMoudle from './components/AboutMePackage/ContentMoudle'
// import ShowContentMoudle from './components/TestPackage/ShowContentMoudle'
import IndexMoudle from './components/IndexPackage/IndexMoudle'
Vue.component('IndexMoudle', IndexMoudle)


Vue.config.productionTip = false
// Vue.use(VueParticles)
Vue.use(ElementUI)
Vue.use(particles)


// 引用组件
// NavMenuPackage包
Vue.component('NavMenuMoudle', NavMenuMoudle)
// HomePackage包
Vue.component('HeaderMoudle', HeaderMoudle)
Vue.component('MainMoudle', MainMoudle)
Vue.component('AsideMoudle', AsideMoudle)
Vue.component('FooterMoudle', FooterMoudle)
// MoodPackage包
Vue.component('MoodMoudle', MoodMoudle)
Vue.component('MdcontentMoudle', MdcontentMoudle)
// GamePackage包
Vue.component('GameMoudle', GameMoudle)
// AboutMePackage包
Vue.component('AboutMeMoudle', AboutMeMoudle)
// BloggerPackage包
Vue.component('BloggerMoudle', BloggerMoudle)
// Vue.component('ContentMoudle', ContentPageMoudle)
// Vue.component('ShowContentMoudle', ShowContentMoudle)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
