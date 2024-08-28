<template>
  <div class="container">
    <div class="operation-panel">

      <div class="operation-cover-panel"
           :class="{ 'cover-left': operationMode === 'login', 'cover-right': operationMode === 'register' }">
        <img class="cover-image" src="@/assets/images/login_background.png" alt="logo">
      </div>

      <!-- 左面板 -->
      <div class="operation-child-panel">
        <!-- 注册面板 -->
        <div class="register-panel"
             :class="{ 'panel-hide': operationMode === 'login', 'panel-show': operationMode === 'register' }">
          <div class="tip-area">
            <h1 class="title-tip-label">注册</h1>
          </div>
          <el-form class="input-area" ref="registerFormRef" :rules="registerRules" :model="registerRuleForm"
                   status-icon>
            <el-form-item prop="username">
              <el-input class="input-item" v-model="registerRuleForm.username" placeholder="请输入用户名"
                        :prefix-icon="User"/>
            </el-form-item>
            <el-form-item prop="password">
              <el-input class="input-item" v-model="registerRuleForm.password" type="password"
                        placeholder="请输入密码" show-password :prefix-icon="Lock"/>
            </el-form-item>
            <el-form-item prop="check">
              <el-input class="input-item" v-model="registerRuleForm.check" type="password"
                        placeholder="请确认密码" show-password :prefix-icon="Lock"/>
            </el-form-item>
          </el-form>
          <div class="button-area">
            <el-button class="btn-main" type="primary" @click="handleRegisterRequest"
                       :disabled="registerPermission">注册
            </el-button>
            <el-button class="btn-main" type="primary" @click="loginReset">返回登录</el-button>
          </div>
        </div>
      </div>

      <!-- 右面板 -->
      <div class="operation-child-panel">
        <!-- 登录面板 -->
        <div class="login-panel"
             :class="{ 'panel-hide': operationMode === 'register', 'panel-show': operationMode === 'login' }">
          <div class="tip-area">
            <h1 class="title-tip-label">登录</h1>
          </div>
          <el-form class="input-area" ref="loginFormRef" :rules="loginRules" :model="loginRuleForm"
                   status-icon>
            <el-form-item prop="id">
              <el-input class="input-item" v-model="loginRuleForm.id" placeholder="请输入账号"
                        :prefix-icon="User"/>
            </el-form-item>
            <el-form-item prop="password">
              <el-input class="input-item" v-model="loginRuleForm.password" type="password"
                        placeholder="请输入密码" show-password :prefix-icon="Lock"/>
            </el-form-item>
            <div style="display: flex;justify-content:space-between;align-items: center;width: 15vw;">
              <el-form-item prop="remember">
                <el-checkbox v-model="loginRuleForm.remember"
                             style="margin-right: 10px;">记住密码
                </el-checkbox>
              </el-form-item>
              <el-form-item>
                <el-checkbox v-model="loginRuleForm.keep">保持登录</el-checkbox>
              </el-form-item>
            </div>
          </el-form>
          <div class="button-area">
            <el-button class="btn-main" type="primary" @click="handleLoginRequest"
                       :disabled="loginPermission">登录
            </el-button>
            <el-button class="btn-main" type="primary" @click="registerReset">注册</el-button>
          </div>
        </div>
      </div>
    </div>

    <!-- 注册信息确认对话框 -->
    <el-dialog v-model="confirmDialogVisible" title="注册成功" width="500" align-center>
      <span>您的账号为：{{ userNewID }}</span>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="confirmDialogVisible = false">
            确认保存
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
  import {ref, reactive, computed} from 'vue';
  import {useRouter} from 'vue-router';
  import authenticationRequest from '@/api/modules/authenticationApi';
  import {User, Lock} from '@element-plus/icons-vue'
  import type {FormInstance, FormRules} from 'element-plus';
  import {ElNotification} from 'element-plus'

  // async function download() {
  //     axios.get("http://localhost:8080/api/download", { responseType: 'blob' }).then((response) => {
  //         console.log(response)
  //         // 创建 Blob 对象
  //         let blob = new Blob([response.data], { type: response.headers['content-type'] })
  //         // 获取文件名
  //         // let fileName = response.headers['content-disposition'].match(/filename=(.*)/)[1]
  //         let fileName = 'test.jpg'
  //         // 创建指向 Blob 对象地址的URL
  //         let href = window.URL.createObjectURL(blob)
  //         // 创建用于跳转至下载链接的 a 标签
  //         let downloadElement = document.createElement('a')
  //         // 属性配置
  //         downloadElement.style.display = 'none'
  //         downloadElement.href = href
  //         downloadElement.download = fileName
  //         // 将 a 标签挂载至当前页面
  //         document.body.appendChild(downloadElement)
  //         // 触发下载事件
  //         downloadElement.click()
  //         // 移除已挂载的 a 标签
  //         document.body.removeChild(downloadElement)
  //         // 释放 Blob URL
  //         window.URL.revokeObjectURL(href)
  //     });
  // }

  const router = useRouter();

  // const localStorage = window.localStorage;
  // const sessionStorage = window.sessionStorage;

  // 当前操作模式
  const operationMode = ref<string>('default');

  // 是否显示ID对话框
  const userNewID = ref<number>();
  const confirmDialogVisible = ref<boolean>(false);

  // 判断是否允许操作
  const loginPermission = computed(() => {
    return !(loginRuleForm.value.id && loginRuleForm.value.password);
  })

  const registerPermission = computed(() => {
    return !(registerRuleForm.value.username != '' && registerRuleForm.value.password != '' && registerRuleForm.value.check != '' && (registerRuleForm.value.password == registerRuleForm.value.check));
  })

  const loginFormRef = ref<FormInstance>();
  const registerFormRef = ref<FormInstance>();

  // 表单元素类型
  type loginFormType = {
    id: number | undefined,
    password: string,
    remember: boolean,
    keep: boolean,
  }

  type registerFormType = {
    username: string,
    password: string,
    check: string,
  }

  // 表单内容
  const loginRuleForm = ref<loginFormType>({
    id: undefined,
    password: '',
    remember: false,
    keep: false,
  })

  const registerRuleForm = ref<registerFormType>({
    username: '',
    password: '',
    check: '',
  })

  // 表单验证逻辑
  const checkId = (rule: any, value: any, callback: any) => {
    if (!value) {
      return callback(new Error('请输入账号'))
    }
    setTimeout(() => {
      if (!Number.isInteger(parseInt(value))) {
        callback(new Error('账号格式不合法'))
      } else {
        callback();
      }
    }, 1000)
  }

  const checkName = (rule: any, value: any, callback: any) => {
    if (!value) {
      return callback(new Error('请输入用户名'))
    }
    setTimeout(() => {
      if (value.length > 10) {
        callback(new Error('用户名长度不能超过10个字符'))
      } else {
        callback()
      }
    }, 500)
  }

  const validateLoginPass = (rule: any, value: any, callback: any) => {
    if (value === '') {
      callback(new Error('请输入密码'))
    } else {
      callback()
    }
  }

  const validateRegisterPass = (rule: any, value: any, callback: any) => {
    if (value === '') {
      callback(new Error('请输入密码'))
    }
    setTimeout(() => {
      if (value.length < 8) {
        callback(new Error('密码长度不能少于8个字符'))
      } else if (value.length > 16) {
        callback(new Error('密码长度不能多于16个字符'))
      } else {
        callback()
      }
    }, 500)
  }

  const validatePassCheck = (rule: any, value: any, callback: any) => {
    if (value === '') {
      callback(new Error('请再次输入密码'))
    }
    setTimeout(() => {
      if (value !== registerRuleForm.value.password) {
        callback(new Error("两次输入的密码不一致!"))
      } else {
        callback()
      }
    }, 500)
  }

  // 表单验证规则
  const loginRules = reactive<FormRules<typeof loginRuleForm>>({
    id: [{validator: checkId, trigger: 'blur'}],
    password: [{validator: validateLoginPass, trigger: 'blur'}],
  })

  const registerRules = reactive<FormRules<typeof registerRuleForm>>({
    username: [{validator: checkName, trigger: 'blur'}],
    password: [{validator: validateRegisterPass, trigger: 'blur'}],
    check: [{validator: validatePassCheck, trigger: 'blur'}],
  })

  // 重置登录输入
  const loginReset = () => {
    operationMode.value = 'login';
    if (loginFormRef.value) {
      loginFormRef.value.resetFields();
    }
  }

  // 重置注册输入
  const registerReset = () => {
    operationMode.value = 'register';
    if (registerFormRef.value) {
      registerFormRef.value.resetFields();
    }
  }

  // 处理登录请求
  const handleLoginRequest = async () => {
    await authenticationRequest.userLogin({userId: loginRuleForm.value.id, password: loginRuleForm.value.password})
                               .then((response: any) => {
                                 if (response.data.data.permission === true) {
                                   // ElMessage.success("登录成功");
                                   ElNotification.success({
                                     title: "登录成功",
                                     message: "欢迎回来",
                                     customClass: "notification-success"
                                   })
                                   router.push('/home');
                                 } else {
                                   // ElMessage.warning("账号或密码不正确，请重新输入！");
                                   ElNotification.warning({
                                     title: "登录失败",
                                     message: "账号或密码不正确，请重新输入",
                                     customClass: "notification-warning"
                                   })
                                   loginRuleForm.value.password = '';
                                   if (loginFormRef.value) {
                                     loginFormRef.value.clearValidate("password");
                                   }
                                 }
                               })
                               .catch(() => {
                                 // ElMessage.error('登录过程中发生了错误，请稍后重新尝试');
                                 ElNotification.error({
                                   title: "请求失败",
                                   message: "登录过程发生错误，请稍后重新尝试",
                                   customClass: "notification-error"
                                 })
                               });
  }

  // 处理注册请求
  const handleRegisterRequest = async () => {
    await authenticationRequest.userRegister({
      username: registerRuleForm.value.username,
      password: registerRuleForm.value.password
    })
                               .then((response: any) => {
                                 // ElMessage.success('注册成功');
                                 ElNotification.success({
                                   title: "注册成功",
                                   message: "欢迎使用",
                                   customClass: "notification-success"
                                 })
                                 operationMode.value = 'login';
                                 userNewID.value = response.data.data.userId;
                                 confirmDialogVisible.value = true;
                               })
                               .catch(() => {
                                 // ElMessage.error('注册过程发生错误，请稍后重新尝试');
                                 ElNotification.error({
                                   title: "请求失败",
                                   message: "登录过程发生错误，请稍后重新尝试",
                                   customClass: "notification-error"
                                 })
                               });
  }
</script>

<style scoped>
  .container {
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: white;
    /* background-image: url('@/assets/images/login_background.png'); */
    background-size: cover;
  }

  .operation-panel {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 50vw;
    height: 60vh;
    background-color: white;
    border-radius: 2vw;
    box-shadow: 0 0 0.5vw #ccc;
    overflow: hidden;
    position: relative;
  }

  .tip-area {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 100%;
  }

  .title-tip-label {
    color: black;
    font-size: 1.5em;
    margin-bottom: 2vh;
  }

  .register-panel {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    transition: opacity 0.7s ease;
  }

  .login-panel {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    transition: opacity 0.7s ease;
  }

  .panel-hide {
    opacity: 0;
  }

  .panel-show {
    opacity: 100;
  }

  .operation-cover-panel {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 50%;
    height: 100%;
    position: absolute;
    z-index: 10;
    top: 0;
    left: 0;
    border-radius: 2vw;
    background-color: lightblue;
    transition: all 1s ease;
  }

  .cover-left {
    transform: translateX(0vw);
  }

  .cover-right {
    transform: translateX(25vw);
  }

  .cover-image {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 2vw;
  }

  .operation-child-panel {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 25vw;
    height: 60vh;
  }

  .input-area {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-bottom: 5vh;
  }

  .input-item {
    width: 16vw;
  }

  .button-area {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 2vh;
  }

  .btn-main {
    width: 10vw;
    border-radius: 2vw;
    margin: 0;
  }
</style>