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
        {
            path: '/web/manager',
            name: 'index',
            component: () => import('./components/manager/main.vue')
        },
        {
            path: '/web/manager/passReset',
            name: 'pass',
            component: () => import('./components/manager/passwordReset.vue')
        },
        {
            path: '/web/manager/userAdd',
            name: 'userAdd',
            component: () => import('./components/manager/userAdd.vue')
        },
        {
            path: '/web/manager/userInfo',
            name: 'userInfo',
            component: () => import('./components/manager/userInfo.vue')
        },
        {
            path: '/web/manager/roleManager',
            name: 'roleManager',
            component: () => import('./components/manager/roleManager.vue')
        },
        {
            path: '/web/manager/menuAdd',
            name: 'menuAdd',
            component: () => import('./components/manager/menuAdd.vue')
        },
        {
            path: '/web/manager/permissManager',
            name: 'permissManager',
            component: () => import('./components/manager/permissManager.vue')
        },
    ]
})

export default router