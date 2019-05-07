import Vue from 'vue'
import Router from 'vue-router'
import login from './components/login/login.vue'

Vue.use(Router)
let router = new Router({
    base: '/manager/',
    mode: 'history',
    routes: [
        {
            path: '/web/login',
            name: 'login',
            component: () => import('./components/login/login.vue')
        },
    ]
})

export default router