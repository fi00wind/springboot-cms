import Vue from 'vue'
import App from './App.vue'
import router from './router.js'
import $ from 'jquery'
import './static/css/styles.css'
import VueParticles from 'vue-particles'
import axios from 'axios'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import { Button, message } from 'ant-design-vue'

Vue.use(VueParticles)
Vue.use(Antd)
Vue.use(Button)
Vue.prototype.$message = message
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
