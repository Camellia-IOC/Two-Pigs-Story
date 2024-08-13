import './assets/main.css'
import 'animate.css'
import 'element-plus/dist/index.css'
import 'ant-design-vue/dist/reset.css';

import { createApp } from 'vue'
import { createPinia } from 'pinia'

// ElementPlus
import ElementPlus from 'element-plus'

// AntDesign
import Antd from 'ant-design-vue';

// ECharts
import ECharts from 'vue-echarts'
import 'echarts'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.component('ECharts', ECharts)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.use(Antd)   

app.mount('#app')
