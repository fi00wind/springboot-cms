<template>
  <div v-if="isManagerPage" id="app">
      <a-layout class="content-body" >
        <a-layout-sider
                theme="light"
                class="left-menu"
                collapsible
                v-model="collapsed"
                breakpoint="md"
                collapsedWidth="80"
                @collapse="onCollapse"
                @breakpoint="onBreakPoint"
        >
          <div class="logo" ><p>CoolWind</p></div>
          <a-menu  mode="inline"
                   :openKeys="openKeys"
                   @openChange="onOpenChange">
            <a-sub-menu v-if="parent.children.length >0" :key="parent.id" v-for="parent in menuList">
              <span slot="title"><a-icon :type="parent.icon" /><span>{{ parent.name }}</span></span>
              <a-menu-item v-for="item in parent.children" @click="showPage(item.url)" :key="item.id"><a-icon :type="item.icon" /><span>{{ item.name}}</span></a-menu-item>
            </a-sub-menu>
            <a-menu-item v-else @click="showPage(parent.url)" :key="parent.id"><a-icon :type="parent.icon" /><span>{{ parent.name}}</span></a-menu-item>
          </a-menu>
        </a-layout-sider>
        <a-layout>
          <a-layout-header :style="{ background: '#fff'}" >
<!--            <a-icon-->
<!--                    ref="trigger"-->
<!--                    class="trigger"-->
<!--                    :type="collapsed ? 'menu-unfold' : 'menu-fold'"-->
<!--                    @click="()=> collapsed = !collapsed"-->
<!--            />-->
          </a-layout-header>
          <a-layout-content :style="{ margin: '24px 0 0 16px',background: '#f1f1f1' }">
    <router-view></router-view>
          </a-layout-content>
<!--          <a-layout-footer style="textAlign: center">-->
<!--            CoolWind ©2019 Created by CoolWind-->
<!--          </a-layout-footer>-->
        </a-layout>
      </a-layout>
  </div>
  <div v-else id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    computed: {
      isManagerPage() {
        return this.$route.path.toString().includes('manager');
      },
    },
    data() {
      return {
        menuList: [
                  {id:1,name:'用户管理',icon:'user',url:'',children:[
                      {id:2,name:'新增用户',icon:'user-add',url:'/web/manager/userAdd',children:[]},
                      {id:3,name:'修改密码',icon:'lock',url:'/web/manager/passReset',children:[]},
                      {id:4,name:'修改用户信息',icon:'tool',url:'/web/manager/userInfo',children:[]},
                      {id:5,name:'所有用户',icon:'team',url:'',children:[]},
                    ]},
                  {id:6,name:'角色管理',icon:'idcard',url:'/web/manager/roleManager',children:[]},
                  {id:7,name:'菜单管理',icon:'bars',url:'',children:[
                      {id:8,name:'新增菜单',icon:'folder-add',url:'/web/manager/menuAdd',children:[]},
                      {id:9,name:'配置角色权限',icon:'fork',url:'/web/manager/permissManager',children:[]},
                    ]},
                  ],
        collapsed: false,
        rootSubmenuKeys: ['1', '6', '7'],
        openKeys: [],
        path:this.$route.path,
        firstClick:false,
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
      showPage(url) {
        this.$router.push(url)
      },
      onBreakPoint() {
        // this.$refs.trigger.click();
      },
      onCollapse(collapsed, type) {
        this.firstClick=true
        // this.$refs.trigger.click();
      },
    }
  }
</script>

<style scoped>
  .left-menu {
    background-color: #ffffff;
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
