<template>

        <div class="login-body" id="particles">
            <vue-particles
                    color="#dedede"
                    :particleOpacity="0.7"
                    :particlesNumber="180"
                    shapeType="star"
                    :particleSize="4"
                    linesColor="#133b88"
                    :linesWidth="1"
                    :lineLinked="true"
                    :lineOpacity="0.1"
                    :linesDistance="150"
                    :moveSpeed="3"
                    :hoverEffect="true"
                    hoverMode="grab"
                    :clickEffect="true"
                    clickMode="push"
            class="particles">
            </vue-particles>
            <div class='login'>
                <div class='login_title'>
                    <span>管理员登录</span>
                </div>
                <div class='login_fields'>
                    <div class='login_fields__user'>
                        <div class='icon'>
                            <img alt="" src='../../static/img/user_icon_copy.png'>
                        </div>
                        <input v-model="username" name="login" placeholder='用户名' maxlength="16" type='text' autocomplete="off" />
                        <div class='validation'>
                            <img alt="" src='../../static/img/tick.png'>
                        </div>
                    </div>
                    <div class='login_fields__password'>
                        <div class='icon'>
                            <img alt="" src='../../static/img/lock_icon_copy.png'>
                        </div>
                        <input v-model="password" name="password" placeholder='密码' maxlength="16" type='password' autocomplete="off">
                        <div class='validation'>
                            <img alt="" src='../../static/img/tick.png'>
                        </div>
                    </div>
                    <div class='login_fields__submit'>
                        <input @click="submit" type='button' value='登录'>
                    </div>
                </div>


            </div>



        </div>

</template>

<script>
    export default {
        data() {
            return{
                username: '',
                password: ''
            }
        },
        mounted() {
        },
        methods:{
            submit() {
                if (this.username == '' || this.password == '') {
                    this.$message.error("用户名或密码不能为空！");
                }else {
                    let params = new URLSearchParams();
                    params.append("username", this.username);
                    params.append("password", this.password);
                    this.$axios.post("/manager/service/login",params).then(res=>{
                        let data = res.data;
                        if (data.code = "0000") {
                            this.$message.success(data.msg);
                            this.$router.push('/web/manager/index');
                        }else {
                            this.$message.error(data.msg);
                        }
                    })
                }
            }
        }
    }
</script>

<style scoped>
    .particles{
        height: 672px;
    }
    .login-body {
        -webkit-perspective: 800px;
        perspective: 800px;
        height: 100vh;
        margin: 0;
        overflow: hidden;
        font-family: 'Gudea', sans-serif;
        /*background: #EA5C54;*/
        background-image: url(../../static/img/Starry.jpg);
        /* Old browsers */
        /* FF3.6+ */

        /* W3C */
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#EA5C54 ', endColorstr='#bb6dec',GradientType=1 );
        /* IE6-9 fallback on horizontal gradient */
    }
    .login
    {
        box-shadow: -15px 15px 15px rgba(6, 17, 47, 0.7);
        opacity: 1;
        /*top: 20px;*/
        /*-webkit-transition-timing-function: cubic-bezier(0.68, -0.25, 0.265, 0.85);*/
        /*-webkit-transition-property: -webkit-transform,opacity,box-shadow,top,left;*/
        transition-property: transform,opacity,box-shadow,top,left;
        /*-webkit-transition-duration: .5s;*/
        transition-duration: .5s;
        /*-webkit-transform-origin: 161px 100%;*/
        -ms-transform-origin: 161px 100%;
        transform-origin: 161px 100%;
        /*-webkit-transform: rotateX(0deg);*/
        transform: rotateX(0deg);
        /*position: relative;*/
        width: 240px;
        /*border-top: 2px solid #D8312A;*/
        height: 300px;
        position: absolute;
        left: 0;
        right: 0;
        margin: auto;
        top: 0;
        bottom: 0;
        padding: 100px 40px 40px 40px;
        /*background: #35394a;*/
        /* Old browsers */
        /* FF3.6+ */
        /*background: -webkit-gradient(linear, left bottom, right top, color-stop(0%, #35394a), color-stop(100%, rgb(0, 0, 0)));*/
        /* Chrome,Safari4+ */
        /*background: -webkit-linear-gradient(230deg, rgba(53, 57, 74, 0) 0%, rgb(0, 0, 0) 100%);*/
        /* Chrome10+,Safari5.1+ */
        /* Opera 11.10+ */
        /* IE10+ */
        background: linear-gradient(230deg, rgba(53, 57, 74, 0) 0%, rgb(0, 0, 0) 100%);
        /* W3C */
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='rgba(53, 57, 74, 0)', endColorstr='rgb(0, 0, 0)',GradientType=1 );
        /* IE6-9 fallback on horizontal gradient */
    }
     .login .validation {
        position: absolute;
        z-index: 1;
        right: 10px;
        top: 14px;
        opacity: 0;
    }
     .login_title {
        color: #D3D7F7;
        height: 60px;
        text-align: left;
        font-size: 16px;
         position: relative;
         top: -50px;
    }
     .login_fields {
        height: 208px;
        position: absolute;
        left: 0;
         top: 100px;
    }
     .login_fields .icon {
        position: absolute;
        z-index: 1;
        left: 36px;
        top: 8px;
        opacity: .5;
    }
     .login_fields input[type='password'], .login_fields input[type='text'] {
        color: #61BFFF !important;
    }
     .login_fields input[type='text'],  .login_fields input[type='password'] {
        color: #afb1be;
        width: 190px;
        margin-top: -2px;
        background: rgba(57, 61, 82, 0);
        left: 0;
        padding: 10px 65px;
        border-top: 2px solid rgba(57, 61, 82, 0);
        border-bottom: 2px solid rgba(57, 61, 82, 0);
        border-right: none;
        border-left: none;
        outline: none;
        font-family: 'Gudea', sans-serif;
        box-shadow: none;
    }
     .login_fields__user,  .login_fields__password {
        position: relative;
    }
     .login_fields__submit {
        position: relative;
        top: 17px;
        left: 0;
        width: 80%;
        right: 0;
        margin: auto;
    }
     .login_fields__submit .forgot {
        float: right;
        font-size: 10px;
        margin-top: 11px;
        text-decoration: underline;
    }
     .login_fields__submit .forgot a {
        color: #606479;
    }
     .login_fields__submit input {
        border-radius: 50px;
        background: transparent;
        padding: 10px 50px;
        border: 2px solid #4FA1D9;
        color: #4FA1D9;
        text-transform: uppercase;
        font-size: 11px;
        -webkit-transition-property: background,color;
        transition-property: background,color;
        -webkit-transition-duration: .2s;
        transition-duration: .2s;
    }
     .login_fields__submit input:focus {
        box-shadow: none;
        outline: none;
    }
     .login_fields__submit input:hover {
        color: white;
        background: #4FA1D9;
        cursor: pointer;
        -webkit-transition-property: background,color;
        transition-property: background,color;
        -webkit-transition-duration: .2s;
        transition-duration: .2s;
    }

</style>