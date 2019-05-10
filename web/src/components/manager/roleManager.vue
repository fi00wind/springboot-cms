<template>
    <div>
        <a-list :grid="{ gutter: 16}">
            <a-list-item >
                <strong>选择要配置角色的用户：{{ chooseUser.nickname }}</strong>
                <a-button type="primary" style="margin-left: 20px" @click="showDrawer=true">选择用户</a-button>
            </a-list-item>
        </a-list>

        <div>
            <a-transfer
                    :dataSource="mockData"
                    locale="{itemUnit: '个', itemsUnit: '个'}"
                    :titles="['未拥有角色', '已拥有角色']"
                    :targetKeys="targetKeys"
                    @change="handleChange"
                    :render="item=>item.title"
            />
        </div>

        <a-drawer
                title="用户选择"
                placement="top"
                :closable="false"
                @close="showDrawer=false"
                :visible="showDrawer"
        >
            <a-button class="userButton" v-for="user in users" @click="changeUser(user)" :type="isChooseUser(user.id)">{{ user.nickname}}</a-button>
        </a-drawer>
    </div>
</template>

<script>
    import AListItem from "ant-design-vue/es/list/Item";
    export default {
        components: {AListItem},
        data() {
            return{
                chooseUser:'',
                showDrawer:false,
                users:[
                    {id:1,nickname:'aaa'},
                    {id:2,nickname:'bbb'},
                    {id:3,nickname:'ccc'},
                    {id:4,nickname:'ddd'},
                ],
                mockData:[
                    {key:'1',title:"aaa"},
                    {key:'2',title:"bbb"},
                    {key:'3',title:"ccc"},
                    {key:'4',title:"ddd"},
                    ],
                targetKeys: ['2','3'],
            }
        },
        methods:{
            changeUser(user) {
                this.chooseUser=user;
                this.showDrawer=false;
            },
            isChooseUser(id) {
                if (this.chooseUser.id == id) {
                    return "primary";
                }
                return "default";
            },
            handleChange(nextTargetKeys, direction, moveKeys) {
                this.targetKeys = nextTargetKeys
            },
        },
    }
</script>

<style scoped>
.userButton {
    margin: 10px;
    border-radius:15px;
}
</style>