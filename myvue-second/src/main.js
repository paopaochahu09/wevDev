// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import VueRouter from "vue-router";
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

Vue.config.productionTip = false
Vue.use(VueRouter)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render:h => h(App)
})
