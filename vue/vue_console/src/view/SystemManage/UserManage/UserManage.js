import api from "@/api/user";

export default {
  name: "userManage",
  data() {
    return {
      // 台账模糊查询参数
      userParams: {
        userAccount: '',
        userName: '',
        userSex: ''
      },
      // 用户台账列表
      userList: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pageSize: 5,
      // 显示总共有多少数据
      totalCount: 40,

      // 模态框初始化隐藏/显示
      UserDialog: false,
      // 模态框标题名称
      updateTitle: '',
      // 模态框用户详情信息
      userData: {},

      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },


      // 按钮判断 (创建:create 编辑:edit)
      fromStatus: "create",
      // 查询输入框数据
      input: "",


      value: '100'

    };
  },
  // 初始化加载
  created() {
    this.getUserList();
  },
  methods: {
    /** 显示用户台账
     * userParams 模糊查询参数
     * userList 用户列表
     * totalCount 个数
     */
    getUserList() {
      const params = {
        'currentPage': this.currentPage,
        'pageSize': this.pageSize
      }
      api.getUserList(params).then(res => {
        this.userList = res.data.userList;
        console.log(this.userList);
        this.totalCount = res.data.userList.length;
      });
    },
    // 序列方法
    indexMethod(index) {
      return index * 1;
    },
    // 当选择项发生变化时会触发该事件
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 取消选择方法
    toggleSelection(rows) {
      this.$refs.multipleTable.clearSelection();
    },
    // 全部删除方法
    handleDeleteAll(index, row) {
      console.log(index, row);
    },
    // handleSizeChange:切换每页显示的数量
    handleSizeChange(size) {
      this.pageSize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
    // handleCurrentChange:切换页码
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      console.log(`当前页: ${currentPage}`); //点击第几页
    },

    /**
     * 创建方法
     */
    handleCreate() {
      this.UserDialog = true;
      this.updateTitle = '用户新建';
      this.fromStatus = "create";
      this.userData = {};
      // this.resetForm("userform");
    },
    // 重置方法
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    /**
     * 编辑-显示详情
     * userData 用户详情
     */
    handleEdit(row) {
      this.UserDialog = true;
      this.updateTitle = '用户编辑';
      api.detailsUser(row.userId).then(res => {
        this.userData = res.data;
        console.log(this.userData)
      });
    },
    /**
     * 用户保存
     * userData 用户详情
     * */
    submitForm(formName) {
      // 关闭模态框
      this.UserDialog = false;

      api.saveUser(this.userData).then(res => {
        if (this.fromStatus == "create") {
          this.$message.success("创建成功");
        } else if (this.fromStatus == "edit") {
          this.$message.success("更新成功");
        }
        // 刷新页面
        this.getUserList(this.userParams);
      });
    },
    /**
     * 删除方法
     * UserId 用户ID
     */
    handleDelete(row) {
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {

          api.deleteUser(row.userId).then(res => {
            if (res.data.data) {
              this.$message({
                type: "success",
                message: "删除成功!"
              });
            } else {
              this.$message({
                type: "fail",
                message: "删除失败!"
              });
            }

            // 刷新页面
            this.getUserList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    changeSwitch: function ($event, userStatus) {
      console.log($event);
      console.log(userStatus);
    },
    // changeSwitch(user) {
    //   console.log(this.user)
    //
    //   console.log(this.user.userStatus);
    //   // shopUpdate(b), then(response => {
    //   //   if (response.code == 0) {
    //   //     // 成功了不做处理，因为switch状态已经修改
    //   //     this.message({
    //   //       message: "状态修改成功",
    //   //       type: "success"
    //   //     })
    //   //   } else {
    //   //     let newData = b;
    //   //     newData.state = newData.state == 1 ? "2" : "1";
    //   //     this.tableData(index) = newData;
    //   //   }
    //   // })
    // }
  }
};
