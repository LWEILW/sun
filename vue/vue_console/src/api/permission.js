import request from '@/utils/request'

export default {
  // 权限台账
  getPermissionList(data) {
    return request({
      url: '/permission/getPermissionList',
      method: 'post',
      data
    })
  },
  // 权限详情
  detailsPermission(id) {
    return request({
      url: `/permission/detailsPermission/${id} `,
      method: 'get',
    })
  },
  // 保存权限
  savePermission(data) {
    return request({
      url: '/permission/savePermission',
      method: 'post',
      data
    })
  },
  // 删除权限
  deletePermission(id) {
    return request({
      url: `/permission/deletePermission/${id} `,
      method: 'get',
    })
  }
}
