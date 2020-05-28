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
      pageSize: 5,
      // 显示总共有多少数据
      totalCount: 40,
      // 文章详情数据
      articleData: {},
      articleStatus: '',
      msg: 'Welcome to Use Tinymce Editor',
      disabled: false

    };
  },
  // 初始化加载
  created() {
    this.getArticleList();
  },
  methods: {
    // 文章台账列表
    getArticleList() {
      const params = {
        'currentPage': this.currentPage,
        'pageSize': this.pageSize
      }
      api.getArticleList(params).then(res => {
        // 赋值台账数据
        this.articleTable = res.data.articleList;
        // 获取台账数量,赋值分页总个数
        this.totalCount = res.data.articleList.length;
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
      console.log(this.$refs.editor) //返回的是一个vue对象，所以可以直接调用其方法
      const params = {
        'articleName': this.articleData.articleName,
        'articleType': this.articleData.articleType,
        'articleContent': this.$refs.editor.editorContent,
        'articleStatus': this.articleData.articleStatus
      }

      api.saveArticle(params).then(res => {
        if (this.articleStatus == "create") {
          this.$message.success("创建成功");
        } else if (this.articleStatus == "edit") {
          this.$message.success("更新成功");
        }
        this.active = "1";
        // 刷新页面
        this.getArticleList(this.articleParams);
        this.resetForm("articleFrom");
      });
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
      this.pageSize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      console.log(`当前页: ${currentPage}`); //点击第几页
    },

    // //鼠标单击的事件
    // onClick(e, editor) {
    //   console.log('Element clicked')
    //   console.log(e)
    //   console.log(editor)
    // },
    // //清空内容
    // clear() {
    //   this.$refs.editor.clear()
    // }
  }
};
