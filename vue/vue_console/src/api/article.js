import request from '@/utils/request'

export default {
  // 文章台账
  getArticleList(data) {
    return request({
      url: '/api/v1/article/getArticleList',
      method: 'post',
      data
    })
  },
  // 文章详情
  detailsArticle(id) {
    return request({
      url: `/article/detailsArticle/${id} `,
      method: 'get',
    })
  },
  // 保存文章
  saveArticle(data) {
    return request({
      url: '/article/saveArticle',
      method: 'post',
      data
    })
  },
  // 删除文章
  deleteArticle(id) {
    return request({
      url: `/article/deleteArticle/${id} `,
      method: 'get',
    })
  }
}
