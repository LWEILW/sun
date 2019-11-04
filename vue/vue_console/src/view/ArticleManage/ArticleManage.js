import api from "@/api/article";

export default {
  name: "articleManage",
  data() {
    return {
      // 文章模糊查询
      params: {},
      // 文章台账列表
      article: [],

      articleData: {},
      active: '1',

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
    this.getArticleList();
  },
  methods: {
    // 文章台账列表
    getArticleList() {
      api.getArticleList(this.params).then(res => {
        // 赋值台账数据
        this.article = res.data.data;
        // 获取台账数量,赋值分页总个数
        this.totalCount = res.data.data.length;
      });
    },
    // 文章台账-点击行显示详情
    articleDetails(row) {
      console.log(row)
      this.active = "2";
      api.detailsArticle(row.articleId).then(res => {
        this.articleData = res.data;
      });
    },
    handleClick(row) {
      this.active = "2";
      //查看详情
      api.detailsArticle(row.articleId).then(res => {
        this.articleData = res.data;
      });
    },
    // 跳转编辑画面
    handleEdit(row) {
      this.active = '2';
      api.detailsArticle(row.articleId).then(res => {
        this.articleData = res.data;
      });
    },
    // 用户保存
    submitForm(formName) {
      // 关闭模态框
      this.createUserDialog = false;


      if (this.fromStatus == "create") {
        api.saveUser({user: this.formData}).then(res => {
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
    // 返回画面
    fanhuia() {
      this.active = '1';
      this.resetForm("form");
    },
    createArticle() {

      this.active = "2";

    },

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
