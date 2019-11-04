import request from '@/utils/request'

export default {
  /* 博客接口 */
  getArticleList(data) {
    return request({
      url: '/article/getArticleList',
      method: 'post',
      data
    })
  },
  createBlogger(data) {
    return request({
      url: '/blogger/createBlogger',
      method: 'post',
      data

    })
  },
  deleteBlogger(id) {
    return request({
      url: `/blogger/deleteBlogger/${id} `,
      method: 'get',
    })
  },
  updateBlogger(data) {
    return request({
      url: '/blogger/updateBlogger',
      method: 'post',
      data

    })
  },
  detailsArticle(id) {
    return request({
      url: `/article/detailsArticle/${id} `,
      method: 'get',
    })
  }

}
