<template>
    <div>
    <a-form :form="form"  @submit="handleSubmit">
        <!--名字-->
        <a-form-item  v-bind="formItemLayout" >
      <span slot="label">
        菜单名字
      </span>
            <a-input
                    v-decorator="[
          'name',
          {
            rules: [{ required: true, message: '请输入菜单的名字!', whitespace: true }]
          }
        ]"
            />
        </a-form-item>
        <!--URL-->
        <a-form-item v-bind="formItemLayout" >
      <span slot="label">
        url
      </span>
            <a-input
                    v-decorator="[
          'url'
        ]"
            />
        </a-form-item>
        <!--菜单类型-->
        <a-form-item
                v-bind="formItemLayout"
                label="菜单类型"
                
        >
                <a-select v-decorator="[ 'type',{
                initialValue:'menu'
                } ]">
                    <a-select-option value="menu">菜单</a-select-option>
                    <a-select-option value="button">按钮/链接</a-select-option>
                </a-select>
        </a-form-item>
        <!--上级菜单-->
        <a-form-item
                v-bind="formItemLayout"
                label="上级菜单"
                
        >
            <a-select v-decorator="[ 'parentId',{
                initialValue:'0'
                } ]">
                <a-select-option value="0">无</a-select-option>
                <a-select-option value="1">其他</a-select-option>
            </a-select>
        </a-form-item>
        <!--图标-->
        <a-form-item
                v-bind="formItemLayout"
                label="图标"
                
        >
            <a-input v-model="chooseIcon" @click="showIcon = true" />
        </a-form-item>
        <a-form-item v-bind="formItemLayout">
            <a-button
                    type="primary"
                    html-type="submit"
            >
                添加
            </a-button>
        </a-form-item>
    </a-form>
        <!-- 图标选择 -->
    <a-drawer
            title="图标选择"
            placement="bottom"
            :closable="false"
            @close="closeIcon"
            :visible="showIcon"
            height="50%"
    >
        <div>
        <a-icon @click="clickIcon(icon)" v-for="icon in pageIcons" :type="icon" style="width: 25%;height: 50px;"></a-icon>
        </div>
        <a-pagination v-model="currentPage" :total="icons.length*10/12 +1" />
    </a-drawer>
    </div>
</template>

<script>
    export default {
        computed: {
            pageIcons() {
                let index = (this.currentPage -1)*12;
                return this.icons.slice(index,index+12);
            }
        },
        data () {
            return {
                chooseIcon: '',
                currentPage:1,
                icons: ['lock', 'unlock', 'bars', 'book', 'calendar', 'cloud', 'cloud-download', 'code', 'copy', 'credit-card', 'delete', 'desktop', 'download', 'ellipsis', 'file', 'file-text', 'file-unknown', 'file-pdf', 'file-word', 'file-excel', 'file-jpg', 'file-ppt', 'file-markdown', 'file-add', 'folder', 'folder-open', 'folder-add', 'hdd', 'frown', 'meh', 'smile', 'inbox', 'laptop', 'appstore', 'link', 'mail', 'mobile', 'notification', 'paper-clip', 'picture', 'poweroff', 'reload', 'search', 'setting', 'share-alt', 'shopping-cart', 'tablet', 'tag', 'tags', 'to-top', 'upload', 'user', 'video-camera', 'home', 'loading', 'loading-3-quarters', 'cloud-upload', 'star', 'heart', 'environment', 'eye', 'eye-invisible', 'camera', 'save', 'team', 'solution', 'phone', 'filter', 'exception', 'export', 'customer-service', 'qrcode', 'scan', 'like', 'dislike', 'message', 'pay-circle', 'calculator', 'pushpin', 'bulb', 'select', 'switcher', 'rocket', 'bell', 'disconnect', 'database', 'compass', 'barcode', 'hourglass', 'key', 'flag', 'layout', 'printer', 'sound', 'usb', 'skin', 'tool', 'sync', 'wifi', 'car', 'schedule', 'user-add', 'user-delete', 'usergroup-add', 'usergroup-delete', 'man', 'woman', 'shop', 'gift', 'idcard', 'medicine-box', 'red-envelope', 'coffee', 'copyright', 'trademark', 'safety', 'wallet', 'bank', 'trophy', 'contacts', 'global', 'shake', 'api', 'fork', 'dashboard', 'table', 'profile', 'alert', 'audit', 'branches', 'build', 'border', 'crown', 'experiment', 'fire', 'money-collect', 'property-safety', 'read', 'reconciliation', 'rest', 'security-scan', 'insurance', 'interation', 'safety-certificate', 'project', 'thunderbolt', 'block', 'cluster', 'deployment-unit', 'dollar', 'euro', 'pound', 'file-done', 'file-exclamation', 'file-protect', 'file-search', 'file-sync', 'gateway', 'gold', 'robot', 'shopping',],
                showIcon:false,
                confirmDirty: false,
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
            closeIcon() {
                console.log(this.icons.length /20)
                this.showIcon=false;
            },
            clickIcon(icon) {
              this.chooseIcon = icon;
              this.showIcon=false;
              return this.chooseIcon;
            },
        },
    };
</script>
<style scoped>

</style>