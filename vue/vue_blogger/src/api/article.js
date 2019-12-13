import request from '@/utils/request'

export default {
  /* 文章接口 */
  getArticleList(data) {
    return request({
      url: '/article/getArticleList',
      method: 'post',
      data
    })
  }
}
