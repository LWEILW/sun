import request from '@/utils/request'

export default {
  // /* 文章接口 */
  // getArticleList(data) {
  //   return request({
  //     url: '/article/articleList',
  //     method: 'post',
  //     data
  //   })
  // }

  // 文章台账
  articleList(data) {
    return request({
      url: '/api/v1/article/articleList',
      method: 'post',
      data
    })
  },
  // 文章详情
  articleDetails(id) {
    return request({
      url: `/api/v1/article/articleDetails/${id} `,
      method: 'get',
    })
  },
}
