<template>
    <a-layout class="content-body" >
        <a-layout-sider
                class="left-menu"
                :trigger="null"
                collapsible
                v-model="collapsed"
        >
            <div class="logo" ><p>CoolWind</p></div>
            <a-menu  mode="inline"
                     :openKeys="openKeys"
                     @openChange="onOpenChange">
                <a-sub-menu key="sub1">
                    <span slot="title"><a-icon type="user" /><span>用户管理</span></span>
                    <a-menu-item key="1"><a-icon type="user-add" /><span>新增用户</span></a-menu-item>
                    <a-menu-item key="2"><a-icon type="lock" /><span>修改密码</span></a-menu-item>
                    <a-menu-item key="3"><a-icon type="tool" /><span>修改用户信息</span></a-menu-item>
                    <a-menu-item key="4"><a-icon type="team" /><span>所有用户</span></a-menu-item>
                </a-sub-menu>
                <a-menu-item @click="showPage" key="5"><a-icon type="idcard" /><span>角色管理</span></a-menu-item>
                <a-sub-menu key="sub4">
                    <span slot="title"><a-icon type="bars" /><span>菜单管理</span></span>
                    <a-menu-item key="6"><a-icon type="folder-add" /><span>新增菜单</span></a-menu-item>
                    <a-menu-item key="7"><a-icon type="fork" /><span>配置角色权限</span></a-menu-item>
                </a-sub-menu>
            </a-menu>
        </a-layout-sider>
        <a-layout>
            <a-layout-header :style="{ background: '#fff'}" >
                <a-icon
                        class="trigger"
                        :type="collapsed ? 'menu-unfold' : 'menu-fold'"
                        @click="()=> collapsed = !collapsed"
                />
            </a-layout-header>
            <a-layout-content :style="{ margin: '24px 16px 0' }">
                <div :style="{ background: '#f1f1f1' }">
                </div>
            </a-layout-content>
            <a-layout-footer style="textAlign: center">
                CoolWind ©2019 Created by CoolWind
            </a-layout-footer>
        </a-layout>
    </a-layout>
</template>
<script>
    export default {
        data() {
            return {
                collapsed: false,
                rootSubmenuKeys: ['sub1', 'sub2', 'sub4'],
                openKeys: [],
            }
        },
        methods: {
            onOpenChange (openKeys) {
                const latestOpenKey = openKeys.find(key => this.openKeys.indexOf(key) === -1)
                if (this.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
                    this.openKeys = openKeys
                } else {
                    this.openKeys = latestOpenKey ? [latestOpenKey] : []
                }
            },
            showPage() {
                this.$router.push('/web/pass')
            },
        }
    }
</script>

<style scoped>
    .left-menu {
        background-color: #ffffff;
    }
    .left-menu-top {
        height: 64px;
        background: #c7fff1;
    }
     .logo {
        height: 64px;
        background: rgba(199,255,241,.2);
        padding: 16px;
    }
     .trigger {
        font-size: 18px;
        line-height: 64px;
        padding: 0 24px;
        cursor: pointer;
        transition: color .3s;
    }

    .trigger:hover {
        color: #1890ff;
    }
    .content-body {
        height: -webkit-fill-available;
    }
</style>
