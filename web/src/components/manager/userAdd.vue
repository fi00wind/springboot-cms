<template>
    <a-form :form="form"  @submit="handleSubmit">
        <!--用户名-->
        <a-form-item  v-bind="formItemLayout" has-feedback>
      <span slot="label">
        用户名&nbsp;
          <a-tooltip title="用户登录的用户名">
          <a-icon type="question-circle-o" />
        </a-tooltip>
      </span>
            <a-input
                    v-decorator="[
          'username',
          {
            rules: [{ required: true, message: '请输入用户名!', whitespace: true }]
          }
        ]"
            />
        </a-form-item>
        <!--昵称-->
        <a-form-item v-bind="formItemLayout" has-feedback>
      <span slot="label">
        昵称&nbsp;
        <a-tooltip title="用户展示的昵称">
          <a-icon type="question-circle-o" />
        </a-tooltip>
      </span>
            <a-input
                    v-decorator="[
          'nickname',
          {
            rules: [{ required: true, message: '请输入昵称!', whitespace: true }]
          }
        ]"
            />
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
            }, {
              validator: validateToNextPassword,
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
                    @blur="handleConfirmBlur"
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
        <a-form-item v-bind="tailFormItemLayout">
            <a-checkbox
                    v-decorator="['agreement', {valuePropName: 'checked'}]"
                    @click="isAgree = !isAgree"
            >
                我已阅读并同意 <a href="#">
                注册协议
            </a>
            </a-checkbox>
        </a-form-item>
        <a-form-item v-bind="tailFormItemLayout">
            <template v-if="!isAgree">
                <a-popover placement="right">
                    <template slot="content">
                        <p>请先阅读并同意注册协议</p>
                    </template>
                    <a-button
                            type="primary"
                            html-type="submit"
                            disabled
                    >
                        Register
                    </a-button>
                </a-popover>
            </template>
            <a-button
                    type="primary"
                    html-type="submit"
                    v-else
            >
                Register
            </a-button>
        </a-form-item>
    </a-form>
</template>

<script>
    export default {
        data () {
            return {
                confirmDirty: false,
                isAgree: false,
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
                tailFormItemLayout: {
                    wrapperCol: {
                        xs: {
                            span: 24,
                            offset: 0,
                        },
                        sm: {
                            span: 16,
                            offset: 8,
                        },
                    },
                },
            };
        },
        beforeCreate () {
            this.form = this.$form.createForm(this);
        },
        methods: {
            handleSubmit  (e) {
                e.preventDefault();
                this.form.validateFieldsAndScroll((err, values) => {
                    if (!err) {
                        console.log('Received values of form: ', values);
                    }
                });
            },
            handleConfirmBlur  (e) {
                const value = e.target.value;
                this.confirmDirty = this.confirmDirty || !!value;
            },
            compareToFirstPassword  (rule, value, callback) {
                const form = this.form;
                if (value && value !== form.getFieldValue('password')) {
                    callback('两次密码不相同!');
                } else {
                    callback();
                }
            },
            validateToNextPassword  (rule, value, callback) {
                const form = this.form;
                if (value && this.confirmDirty) {
                    form.validateFields(['confirm'], { force: true });
                }
                callback();
            },
        },
    };
</script>
<style scoped>

</style>