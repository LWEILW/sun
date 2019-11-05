import api from "@/api/article";

export default {
  name: "articleManage",
  data() {
    return {
      // 切换显示
      active: '1',
      // 文章模糊查询
      articleParams: {},
      // 文章台账列表
      articleTable: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40,
      // 文章详情数据
      articleData: {},
      articleStatus: ''

    };
  },
  // 初始化加载
  created() {
    this.getArticleList();
  },
  methods: {
    // 文章台账列表
    getArticleList() {
      api.getArticleList(this.articleParams).then(res => {
        // 赋值台账数据
        this.articleTable = res.data.data;
        // 获取台账数量,赋值分页总个数
        this.totalCount = res.data.data.length;
      });
    },
    // 跳转创建画面
    handleCreate() {
      this.active = "2";
      this.articleStatus = 'create';
    },
    // 跳转编辑画面
    handleEdit(row) {
      this.active = "2";
      this.articleStatus = 'edit';
      //查看详情
      api.detailsArticle(row.articleId).then(res => {
        this.articleData = res.data;
      });
    },
    // 用户保存
    submitForm(formName) {
      if (this.articleStatus == "create") {
        api.saveArticle(this.articleData).then(res => {
          this.$message.success("创建成功");
          this.active = "1";
          // 刷新页面
          this.getArticleList(this.articleParams);
          this.resetForm("articleFrom");
        });
      } else if (this.articleStatus == "edit") {
        api.saveArticle(this.articleData).then(res => {
          this.$message.success("更新成功");
          this.active = "1";
          // 刷新页面
          this.getArticleList(this.articleParams);
          this.resetForm("articleFrom");
        });
      }


    },
    // 跳转详情画面
    handleDetails(row) {
      console.log(row)
      this.active = "2";
      api.detailsArticle(row.articleId).then(res => {
        this.articleData = res.data;
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
          api.deleteArticle(row.articleId).then(res => {
            // 刷新页面
            this.getArticleList();
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
    handleBack() {
      this.active = '1';
      this.resetForm("articleFrom");
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
