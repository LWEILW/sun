import request from '@/utils/request'

export default {
  // 用户台账
  getUserList(data) {
    return request({
      url: '/user/getUserList',
      method: 'post',
      data
    })
  },
 // 用户保存
  saveUser(data) {
    return request({
      url: '/user/saveUser',
      method: 'post',
      data
    })
  },
  // 用户删除
  deleteUser(userId) {
    return request({
      url: `/user/deleteUser/${userId} `,
      method: 'get',
    })
  },
  // 用户详情
  detailsUser(userId) {
    return request({
      url: `/user/detailsUser/${userId} `,
      method: 'get',
    })
  }

}
