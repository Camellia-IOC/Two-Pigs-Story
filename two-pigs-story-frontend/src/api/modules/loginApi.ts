import request from '../request'

const userLogin = (data: any) => {
  return request.post({
    url: '/api/authentication/login',
    data
  })
}

const userRegister = (data: any) => {
  return request.post({
    url: '/api/authentication/register',
    data
  })
}
export default {
  userLogin,
  userRegister
}
