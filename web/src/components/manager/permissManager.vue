<template>
    <div>
    <div v-for="parent in menuList">
    <div :style="{ borderBottom: '1px solid #E9E9E9' }">
        <a-checkbox
        >
            {{ parent.name }}
        </a-checkbox>
    </div>
        <br />
    <a-checkbox-group style="width: 100%" >
        <a-row >
            <a-col v-for="menu in parent.children" :span="6">
                <a-checkbox :value="menu.id" @change="onChange(menu.id)">{{ menu.name }}</a-checkbox>
            </a-col>
        </a-row>
    </a-checkbox-group>
    </div>
    </div>
</template>
<script>
    export default {
        data() {
            return{
                checkList:[],
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
            }
        },
        methods: {
            onChange (checkedValues) {
                this.checkList=checkedValues;
                console.log('checked = ', checkedValues)
            },
        },
    }
</script>
