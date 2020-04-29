import request from '@/utils/request'

export default {
  /* 博客接口 */
  bloggerList() {
    return request({
      url: '/api/v1/blogger/bloggerList',
      method: 'get'
    })
  },
  createBlogger(data) {
    return request({
      url: '/api/v1/blogger/createBlogger',
      method: 'post',
      data

    })
  },
  deleteBlogger(id) {
    return request({
      url: `/api/v1/blogger/deleteBlogger/${id} `,
      method: 'get',
    })
  },
  updateBlogger(data) {
    return request({
      url: '/api/v1/blogger/updateBlogger',
      method: 'post',
      data

    })
  },
  getBlogger(id) {
    return request({
      url: `/api/v1/blogger/getBlogger/${id} `,
      method: 'get',
    })
  },
  getBloggerByParam(data) {
    return request({
      url: '/api/v1/blogger/getBloggerByParam',
      method: 'post',
      data
    })
  }

}
