import type { AxiosRequestConfig } from 'axios'
import axiosService from './config'

// get请求
const get = (config: AxiosRequestConfig<any>) => {
  return axiosService({
    ...config,
    method: 'get',
    params: config.data
  })
}

// post请求
const post = (config: AxiosRequestConfig<any>) => {
  return axiosService({
    ...config,
    method: 'post',
    data: config.data
  })
}

// put请求
const put = (config: AxiosRequestConfig<any>) => {
  return axiosService({
    ...config,
    method: 'put',
    data: config.data
  })
}

// delete请求
const del = (config: AxiosRequestConfig<any>) => {
  return axiosService({
    ...config,
    method: 'delete',
    data: config.data
  })
}

export default {
  get,
  post,
  put,
  del
}
