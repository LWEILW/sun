import request from '@/utils/request'

export default {
  /* 登录接口 */
  ajaxLogin(data) {
    return request({
      url: '/admin/login',
      method: 'post',
      data
    })
  }
}
