<template>
    <div>
        <a-list :grid="{ gutter: 16}">
            <a-list-item >
                <strong>选择要重置密码的用户：{{ chooseUser.nickname }}</strong>
                <a-button type="primary" style="margin-left: 20px" @click="showDrawer=true">选择用户</a-button>
            </a-list-item>
        </a-list>

        <a-form :form="form"  @submit="handleSubmit">
            <!--密码-->
            <a-form-item
                    v-bind="formItemLayout"
                    label="密码"
                    has-feedback
            >
                <a-input
                        v-decorator="[
          'password',
          {
            rules: [{
              required: true, message: '请输入password!',
            }],
          }
        ]"
                        type="password"
                />
            </a-form-item>
            <!--确认密码-->
            <a-form-item
                    v-bind="formItemLayout"
                    label="确认密码"
                    has-feedback
            >
                <a-input
                        v-decorator="[
          'confirm',
          {
            rules: [{
              required: true, message: '请确认你的密码!',
            }, {
              validator: compareToFirstPassword,
            }],
          }
        ]"
                        type="password"
                />
            </a-form-item>
            <a-button type="primary" html-type="submit" >
                修改
            </a-button>
        </a-form>

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
                formItemLayout: {
                    labelCol: {
                        xs: { span: 24 },
                        sm: { span: 8 },
                    },
                    wrapperCol: {
                        xs: { span: 24 },
                        sm: { span: 16 },
                        lg:{ span:6 },
                    },
                },
            }
        },
        beforeCreate () {
            this.form = this.$form.createForm(this);
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
            compareToFirstPassword  (rule, value, callback) {
                const form = this.form;
                if (value && value !== form.getFieldValue('password')) {
                    callback('两次密码不相同!');
                } else {
                    callback();
                }
            },
            handleSubmit  (e) {
                e.preventDefault();
                this.form.validateFieldsAndScroll((err, values) => {
                    if (!err) {
                        console.log('Received values of form: ', values);
                    }
                });
            },
        }
    }
</script>

<style scoped>
.userButton {
    margin: 10px;
    border-radius:15px;
}
</style>