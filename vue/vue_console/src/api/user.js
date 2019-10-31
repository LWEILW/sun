import request from '@/utils/request'

export default {
  /* 用户接口 */
  getUserList(data) {
    return request({
      url: '/user/getUserList',
      method: 'post',
      data
    })
  },
  updateUser(data) {
    return request({
      url: '/user/updateUser',
      method: 'post',
      data
    })
  },
  deleteUser(id) {
    return request({
      url: `/user/deleteUser/${id} `,
      method: 'get',
    })
  },
  detailUser(id) {
    return request({
      url: `/user/detailUser/${id} `,
      method: 'get',
    })
  }

}
