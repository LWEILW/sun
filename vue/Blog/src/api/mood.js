import request from '@/utils/request'

export default {
  /* 用户接口 */
  moodList() {
    return request({
      url: '/mood/moodList',
      method: 'get'
    })
  }
}