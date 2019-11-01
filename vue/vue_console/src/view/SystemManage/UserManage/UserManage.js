import api from "@/api/user";

export default {
  name: "userManage",
  data() {
    return {
      updateTitle: '',
      // 模态框初始化隐藏
      createUserDialog: false,
      // 表格初始化信息
      formData: {},
      user: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40,
      // 按钮判断 (创建:create 编辑:edit)
      fromStatus: "",
      // 查询输入框数据
      input: "",
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
      // 表单默认值
      ruleForm: {
        title: "",
        content: "",
        author: "",
        date1: "",
        date2: ""
      },
      // 验证方法
      rules: {
        title: [
          {required: true, message: "请输入标题名", trigger: "blur"},
          {min: 3, max: 8, message: "长度在 3 到 8 个字符", trigger: "blur"}
        ],

        content: [{required: true, message: "请输入内容", trigger: "blur"}],

        author: [{required: true, message: "请输入作者名", trigger: "blur"}],

        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ]
      }
    };
  },
  created() {
    this.getUserList();
  },
  methods: {
    // 显示台账数据
    getUserList() {
      const params = {
        userAccount: '',
        userName: '',
        userSex: ''
      }
      api.getUserList(params).then(res => {
        this.user = res.data.data;
        console.log(this.user);
        this.totalCount = res.data.data.length;
      });
    },
    // 创建方法
    handleCreate() {

      // this.$refs["ruleForm"].resetFields();
      // ruleForm.resetFields();
      this.dialogFormVisible = true;
      this.fromStatus = "create";
    },
    // 编辑方法
    handleEdit(row) {
      this.dialogFormVisible = true;
      this.fromStatus = "edit";
      api.getBlogger(row.id).then(res => {
        var that = this;
        that.ruleForm = res.data;
        console.log(that.ruleForm);
      });
    },
    // 提交方法
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.fromStatus == "create") {
            api.createBlogger({blogger: this.ruleForm}).then(res => {
              this.dialogFormVisible = false;
              this.$message.success("创建成功");
              // 刷新页面
              this.getBloggerList();
            });
          } else if (this.fromStatus == "edit") {
            api.updateBlogger({blogger: this.ruleForm}).then(res => {
              this.dialogFormVisible = false;
              this.$message.success("更新成功");
              // 刷新页面
              this.getBloggerList();
            });
          }
        } else {
          this.dialogFormVisible = false;
          console.log("error submit!!");
          return false;
        }
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
          api.deleteBlogger(row.id).then(res => {
            // 刷新页面
            this.getBloggerList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    onSubmit() {
      this.centerDialogVisible = false;
      console.log('submit!');
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
