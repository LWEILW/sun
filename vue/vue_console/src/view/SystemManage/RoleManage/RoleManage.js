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
      pagesize: 5,
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

      // 权限数据
      permissionData: [],
      // 权限树状图规则
      Props: {
        id: 'id',
        label: 'label',
        children: 'children'
      },
      // 权限模态框隐藏
      permissionDialog: false
    };
  },
  // 初始化加载
  created() {
    this.getRoleList();
  },
  methods: {
    // 角色台账列表
    getRoleList() {
      api.getRoleList(this.roleParams).then(res => {
        console.log(res.data.data)
        this.roleTable = res.data.data;
        this.totalCount = res.data.data.length;
      });
    },

    /** 分页方法
     * handleSizeChange: 切换每页显示的数量
     * handleCurrentChange: 切换页码
     * */
    handleSizeChange(size) {
      this.pagesize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
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
      this.roleDialog = true;
      this.updateTitle = '编辑角色';
      this.roleStatus = 'edit';
      api.detailsRole(row.roleId).then(res => {
        this.roleDetails = res.data;
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

    /** 人员维护
     * handleUserList: 人员维护台账
     * handleAddUserList: 人员维护可添加台账
     * addUserToRole: 人员维护添加人员
     * */
    // 人员维护台账
    handleUserList(row) {
      this.userListDialog = true;
      // 选中角色ID
      this.changesRoleId = row.roleId;
      api.getUserListByRoleId(row.roleId).then(res => {
        this.userTable = res.data.data;
      });
    },
    // 人员维护可添加列表
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


    /** 权限维护
     * handleUserList: 权限维护台账
     * handleAddUserList: 权限维护添加
     * */
    // 权限维护台账
    handlePermissionList(row) {
      this.permissionDialog = true;
      api.getPermissionListByRoleId(row.roleId).then(res => {
        this.permissionData = res.data.data;
      });
    },
    // 权限维护添加
    handlePermissionAdd(row) {
      this.permissionDialog = true;
      const params = {
        'roleId': roleId,
      }
      api.addPermissionByRoleId(params).then(res => {
        this.data = res.data.data;
      });
    },
    handleNodeClick() {

    }

  }
};
