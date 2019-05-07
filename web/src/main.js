import Vue from 'vue'
import App from './App.vue'
import router from './router.js'
import $ from 'jquery'
import './static/css/styles.css'
import VueParticles from 'vue-particles'
import axios from 'axios'


Vue.use(VueParticles)
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
