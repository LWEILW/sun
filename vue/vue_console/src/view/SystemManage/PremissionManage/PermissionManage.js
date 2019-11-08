import api from "@/api/permission";

export default {
  name: "PermissionManage",
  data() {
    return {
      // 权限模糊查询
      permissionParams: {},
      // 权限台账列表
      permissionTable: [],
      // 权限详情数据
      permissionData: {},
      // 模态框初始化隐藏
      permissionDialog: false,
      // 模态框标题名称
      updateTitle: '',
      // 按钮判断 (创建:create 编辑:edit)
      permissionStatus: '',
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40,
      parentId: [
        {value: 1, label: '用户模块'},
        {value: 2, label: '角色模块'},
        {value: 3, label: '权限模块'},
        {value: 4, label: '文章模块'}],
      levelNo: [
        {value: 1, label: 1},
        {value: 2, label: 2},
        {value: 3, label: 3},
        {value: 4, label: 4}]
    };
  },
  // 初始化加载
  created() {
    this.getPermissionList();
  },
  methods: {
    // 权限台账列表
    getPermissionList() {
      api.getPermissionList(this.permissionParams).then(res => {
        console.log(res.data.data)
        this.permissionTable = res.data.data;
        this.totalCount = res.data.data.length;
      });
    },
    // 添加权限
    handleCreate() {
      this.permissionDialog = true;
      this.updateTitle = '添加权限';
      this.permissionStatus = 'create';
      this.permissionData = {};
      this.resetForm("permissionForm");
    },

    // 编辑权限-显示详情
    handleEdit(row) {
      this.permissionDialog = true;
      this.updateTitle = '编辑权限';
      this.permissionStatus = 'edit';
      api.detailsPermission(row.permissionId).then(res => {

        this.permissionData = res.data;
      });
    },

    // 权限保存
    submitForm(formName) {
      api.savePermission(this.permissionData).then(res => {
        if (this.permissionStatus == "create") {
          this.$message.success("创建成功");
        } else if (this.permissionStatus == "edit") {
          this.$message.success("更新成功");
        }
        // 关闭模态框
        this.permissionDialog = false;

        // 刷新页面
        this.getPermissionList();
      });
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
          api.deletePermission(row.permissionId).then(res => {
            // 刷新页面
            this.getPermissionList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },


    // 重置方法
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    /** 分页方法 handleSizeChange:切换每页显示的数量,handleCurrentChange:切换页码  */
    handleSizeChange(size) {
      this.pagesize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      console.log(`当前页: ${currentPage}`); //点击第几页
    }
  }
};
