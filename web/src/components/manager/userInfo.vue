<template>
    <div>
        <a-list :grid="{ gutter: 16}">
            <a-list-item >
                <strong>选择要修改的用户：{{ chooseUser.nickname }}</strong>
                <a-button type="primary" style="margin-left: 20px" @click="showDrawer=true">选择用户</a-button>
            </a-list-item>
        </a-list>

        <a-form :form="form"  @submit="handleSubmit">
            <!--昵称-->
            <a-form-item v-bind="formItemLayout" has-feedback>
      <span slot="label">
        昵称
      </span>
                <a-input />
            </a-form-item>
            <!--邮箱-->
            <a-form-item
                    v-bind="formItemLayout"
                    label="E-mail"
                    has-feedback
            >
                <a-input
                        v-decorator="[
          'email',
          {
            rules: [{
              type: 'email', message: '请输入正确的E-mail!',
            }, {
              required: false, message: '请输入 E-mail!',
            }]
          }
        ]"
                />
            </a-form-item>
            <!--手机号-->
            <a-form-item v-bind="formItemLayout" label="手机号" has-feedback>
                <a-input
                        v-decorator="['phone',{rules:[{type:'pattern',pattern:/^1[3|4|5|7|8]\d{9}$/,message:'请输入正确的手机号！'}]}]">
                    <a-select
                            slot="addonBefore"
                            v-decorator="[
            'prefix',
            { initialValue: '86' }
          ]"
                            style="width: 70px"
                    >
                        <a-select-option value="86">
                            +86
                        </a-select-option>
                        <a-select-option value="87">
                            +87
                        </a-select-option>
                    </a-select>
                </a-input>
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