import axios from 'axios'
import { ElMessage } from 'element-plus'

// axios实例
const axiosService = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 10000
})

// 请求拦截器
axiosService.interceptors.request.use(
  (config) => {
    // 请求预处理
    config.headers = config.headers || {}
    return config
  },
  (error) => {
    // 错误处理
    return Promise.reject(error)
  }
)

// 响应拦截器
axiosService.interceptors.response.use(
  (response) => {
    // 响应数据预处理
    return response
  },
  (error) => {
    // TODO: 发布时要删除以下代码
    // 错误处理
    if (error.response) {
      ElMessage({
        message: error.response.data.status + ' ' + error.response.data.error,
        type: 'error',
        duration: 5 * 1000
      })
    }
    return Promise.reject(error)
  }
)

export default axiosService
