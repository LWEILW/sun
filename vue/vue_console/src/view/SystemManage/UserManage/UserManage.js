import api from "@/api/user";

export default {
  name: "userManage",
  data() {
    return {
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
      params: {
        userAccount: '',
        userName: '',
        userSex: ''
      },

      // 按钮判断 (创建:create 编辑:edit)
      fromStatus: "create",
      // 查询输入框数据
      input: "",
      // 表格初始化信息
      formData: {},
      user: [],

      // 模态框初始化隐藏
      UserDialog: false,
      // 模态框标题名称
      updateTitle: '',
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40,


    };
  },
  // 初始化加载
  created() {
    this.getUserList();
  },
  methods: {
    // 显示用户台账
    getUserList() {
      api.getUserList(this.params).then(res => {
        this.user = res.data.data;
        console.log(this.user);
        // this.totalCount = res.data.data.length;
      });
    },
    // 创建方法
    handleCreate() {

      // this.$refs["ruleForm"].resetFields();
      // ruleForm.resetFields();
      this.UserDialog = true;
      this.updateTitle = '用户新建';

      this.fromStatus = "create";
    },
    // 编辑-显示详情
    handleEdit(row) {
      this.UserDialog = true;
      this.updateTitle = '用户编辑';
      api.detailsUser(row.userId).then(res => {
        this.formData = res.data;
      });
    },
    // 用户保存
    submitForm(formName) {
      // 关闭模态框
      this.UserDialog = false;


      if (this.fromStatus == "create") {
        api.saveUser(this.formData).then(res => {
          this.$message.success("创建成功");
          // 刷新页面
          this.getUserList(this.params);
        });
      } else if (this.fromStatus == "edit") {
        api.updateBlogger({blogger: this.formData}).then(res => {
          this.dialogFormVisible = false;
          this.$message.success("更新成功");
          // 刷新页面
          this.getBloggerList();
        });
      }


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
          api.deleteUser(row.UserId).then(res => {
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
    // 搜索方法
    handleSearch() {
      api.getBloggerByParam({searchParam: this.input}).then(res => {
        // 刷新页面
        var that = this;
        that.items = res.data;
      });
    },

    // 发布方法
    handleUploading(row) {
      this.$message.success("发布成功");
    },
    // 查看方法
    handleClick(row) {
      console.log(row);
      this.$router.push({path: "/bloggerDetailPage/" + row.id});
    },
    // 全部删除方法
    handleDeleteAll(index, row) {
      console.log(index, row);
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
