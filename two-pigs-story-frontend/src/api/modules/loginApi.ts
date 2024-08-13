import request from '../request'

const userLogin = (data: any) => {
  return request.post({
    url: '/api/login',
    data
  })
}

const userRegister = (data: any) => {
  return request.post({
    url: '/api/register',
    data
  })
}
export default {
  userLogin,
  userRegister
}
