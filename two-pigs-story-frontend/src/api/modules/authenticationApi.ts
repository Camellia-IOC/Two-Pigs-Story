import { authenticationService as service } from '@/api/AxiosRequestManager'

/**
 * 用户登录
 * @param data 请求数据
 */
const userLogin = (data: any) => {
    return service.post({
        url: '/api/authentication/login',
        data
    })
}

/**
 * 用户注册
 * @param data 请求数据
 */
const userRegister = (data: any) => {
    return service.post({
        url: '/api/authentication/register',
        data
    })
}

export default {
    userLogin,
    userRegister
}
