import request from '@/utils/request'

export default {
  /* 用户接口 */
  getDetail() {
    return request({
      url: '/user/userDetaill',
      method: 'get'
    })
  },
  newsList(data) {
    return request({
      url: '/article/getArticleList',
      method: 'post',
      data
    })
  },
  getNews(id) {
    return request({
      url: `/user/getNews/${id} `,
      method: 'get'
    })
  }
}
