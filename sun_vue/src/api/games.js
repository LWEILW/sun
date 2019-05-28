import request from '@/utils/request'

export default {
  /* 用户接口 */
  getDetail() {
    return request({
      url: '/user/userDetaill',
      method: 'get'
    })
  },
  newsList() {
    return request({
      url: '/user/newsList',
      method: 'get'
    })
  },
  getNews(id) {
    return request({
      url: `/user/getNews/${id} `,
      method: 'get'
    })
  }
}