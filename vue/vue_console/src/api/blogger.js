import request from '@/utils/request'

export default {
  /* 博客接口 */
  bloggerList() {
    return request({
      url: '/blogger/bloggerList',
      method: 'get'
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
  getBlogger(id) {
    return request({
      url: `/blogger/getBlogger/${id} `,
      method: 'get',
    })
  },
  getBloggerByParam(data) {
    return request({
      url: '/blogger/getBloggerByParam',
      method: 'post',
      data
    })
  }

}
