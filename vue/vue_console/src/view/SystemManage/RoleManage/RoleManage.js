import api from "@/api/role";

export default {
  name: "RoleManage",
  data() {
    return {
      // 角色模糊查询
      roleParams: {},
      // 角色台账列表
      roleTable: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pageSize: 5,
      // 显示总共有多少数据
      totalCount: 40,

      // 角色详情数据
      roleDetails: {},

      // 模态框标题名称
      updateTitle: '',
      // 按钮判断 (创建:create 编辑:edit)
      roleStatus: '',
      // 角色模块模态框隐藏
      roleDialog: false,

      // 用户台账模态框
      userListDialog: false,
      // 用户台账数据
      userTable: [],
      // 批量添加用户模态框隐藏
      addUserListDialog: false,
      // 选中角色ID
      changesRoleId: 0,
      // 可添加用户台账数据
      userOtherTable: [],
      // 已选中添加人员数组
      multipleSelection: [],

      // 权限展示所有数据
      permissionShowData: [],
      // 权限展示树状图规则
      permissionShowProps: {
        id: 'permissionId',
        label: 'permissionName',
        children: 'children'
      },
      // 权限展示模态框隐藏
      permissionShowDialog: false,


      // 权限编辑已选数据
      permissionEditData: [],
      permissionChangeData: [],
      // 权限编辑树状图规则
      permissionEditProps: {
        id: 'permissionId',
        label: 'permissionName',
        children: 'children'
      },
      // 权限编辑模态框隐藏
      permissionEditDialog: false
    };
  },
  // 初始化加载
  created() {
    this.getRoleList();
  },
  methods: {
    // 角色台账列表
    getRoleList() {
      const params = {
        'currentPage': this.currentPage,
        'pageSize': this.pageSize
      }
      api.getRoleList(params).then(res => {
        // if (res.data.retCode === 200) {
          // 角色台账列表
          this.roleTable = res.data.roleList;
          this.totalCount = res.data.roleList.length;
        // } else if (res.data.retCode === 400) {
        //   console.log(400)
        // }

      });
    },

    /** 分页方法 */
    // handleSizeChange: 切换每页显示的数量
    handleSizeChange(size) {
      this.pageSize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
    // handleCurrentChange: 切换页码
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      console.log(`当前页: ${currentPage}`); //点击第几页
    },

    // 添加角色
    handleCreate() {
      this.roleDialog = true;
      this.updateTitle = '添加角色';
      this.roleStatus = 'create';
      this.roleDetails = {};
      this.resetForm("roleForm");
    },

    // 编辑角色-显示详情
    handleEdit(row) {
      api.detailsRole(row.roleId).then(res => {
        if (res.data.retCode === 200) {
          this.roleDialog = true;
          this.updateTitle = '编辑角色';
          this.roleStatus = 'edit';
          this.roleDetails = res.data;
        } else {
          console.log(res.data.message)
        }
      });
    },

    // 角色保存
    submitForm(formName) {
      api.saveRole(this.roleDetails).then(res => {
        if (this.roleStatus == "create") {
          this.$message.success("创建成功");
        } else if (this.roleStatus == "edit") {
          this.$message.success("更新成功");
        }
        // 关闭模态框
        this.roleDialog = false;

        // 刷新页面
        this.getRoleList();
      });
    },

    // 重置方法
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    // 删除方法
    handleDelete(row) {
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          api.deleteRole(row.roleId).then(res => {
            // 刷新页面
            this.getRoleList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },

    /** 人员维护  */
    // 人员维护台账
    handleUserList(row) {
      this.userListDialog = true;
      // 选中角色ID
      this.changesRoleId = row.roleId;
      api.getUserListByRoleId(row.roleId).then(res => {
        this.userTable = res.data.data;
      });
    },
    // 人员维护可添加台账
    handleAddUserList() {
      this.addUserListDialog = true;
      api.getUserOthersByRoleId(this.changesRoleId).then(res => {
        this.userOtherTable = res.data.data;
      });
    },
    // 已选中添加人员数组
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 人员维护添加人员
    addUserToRole() {
      api.addUserToRole({userList: this.multipleSelection, changesRoleId: this.changesRoleId}).then(res => {
        this.addUserListDialog = false;
        api.getUserListByRoleId(this.changesRoleId).then(res => {
          this.userTable = res.data.data;
        });
      });
    },


    /** 权限维护  */
    // 权限维护展示台账
    handlePermissionShowList(row) {
      this.permissionShowDialog = true;
      api.getPermissionChangeListByRoleId(row.roleId).then(res => {
        // 已选权限数据
        this.permissionEditData = res.data.data;
      });
    },
    // 权限维护添加
    handlePermissionAdd(row) {
      this.permissionShowDialog = true;
      const params = {
        'roleId': roleId,
      }
      api.addPermissionByRoleId(params).then(res => {
        this.data = res.data.data;
      });
    },
    handleNodeClick() {

    },

    // 权限已选择编辑台账
    handlePermissionEditList(row) {
      this.permissionEditDialog = true;

      api.getPermissionAllListByRoleId(row.roleId).then(res => {
        // 所有权限数据
        this.permissionShowData = res.data.data;
      });

      api.getPermissionChangeListByRoleId(row.roleId).then(res => {
        this.permissionChangeData = [];
        // 已选权限数据
        this.permissionEditData = res.data.data;
        var permission = this.permissionEditData;
        for (var i = 0; i < permission.length; i++) {
          for (var a = 0; a < permission[i].children.length; a++) {
            this.permissionChangeData.push(permission[i].children[a].permissionId)
          }
        }
      });
    },

  }
};


