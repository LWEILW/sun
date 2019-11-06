import request from '@/utils/request'

export default {
  // 角色台账
  getRoleList(data) {
    return request({
      url: '/role/getRoleList',
      method: 'post',
      data
    })
  },
  // 角色详情
  detailsRole(id) {
    return request({
      url: `/role/detailsRole/${id} `,
      method: 'get',
    })
  },
  // 保存角色
  saveRole(data) {
    return request({
      url: '/role/saveRole',
      method: 'post',
      data
    })
  },
  // 删除角色
  deleteRole(id) {
    return request({
      url: `/role/deleteRole/${id} `,
      method: 'get'
    })
  },
  // 人员维护台账
  getUserListByRoleId(id) {
    return request({
      url: `/role/getUserListByRoleId/${id}`,
      method: 'get'
    })
  },
// 人员维护添加
  addUserByRoleId(data) {
    return request({
      url: `/role/addUserByRoleId`,
      method: 'post',
      data
    })
  },
  // 权限维护台账
  getPermissionListByRoleId(id) {
    return request({
      url: `/role/getPermissionListByRoleId/${id}`,
      method: 'get'
    })
  },
  // 人员维护台账
  addPermissionByRoleId(data) {
    return request({
      url: `/role/addPermissionByRoleId`,
      method: 'get',
      data
    })
  },

}
