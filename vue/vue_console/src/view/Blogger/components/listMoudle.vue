<template>
  <div class="BloggerMoudle">
    <!-- <el-page-header @back="goBack" content="详情页面"></el-page-header> -->

    <!-- Form弹出框 -->
    <el-dialog title="创建" :visible.sync="dialogFormVisible">
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="创建时间" required>
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="ruleForm.date1"
                style="width: 100%;"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="date2">
              <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item label="标题名" prop="title">
          <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
          <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item label="内容" prop="content">
          <el-input type="textarea" v-model="ruleForm.content"></el-input>
          <!-- <TinymceMoudle/> -->
        </el-form-item>

        <!-- <el-form-item label="内容" prop="content">
          <el-input type="textarea" v-model="ruleForm.content"></el-input>
        </el-form-item>-->

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>

      <!-- <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>-->
    </el-dialog>

    <!--搜索框,添加按钮,全部删除按钮 -->
    <div class="blogger-operation">
      <!-- 搜索框 -->
      <div class="filter-item el-input el-input--medium" style="width: 200px;">
        <input
          type="text"
          autocomplete="off"
          placeholder="标题"
          v-model="input"
          class="el-input__inner"
        >
      </div>
      <!-- 搜索 -->
      <button
        type="button"
        class="el-button filter-item el-button--primary el-button--medium"
        @click="handleSearch()"
      >
        <i class="el-icon-search"></i>
        <span>搜索</span>
      </button>
      <!-- 添加按钮 -->
      <button
        type="button"
        class="el-button filter-item el-button--primary el-button--medium"
        style="margin-left: 10px;"
        @click="handleCreate()"
      >
        <i class="el-icon-edit"></i>
        <span>添加</span>
      </button>
      <!-- 全部删除按钮 -->
      <button
        type="button"
        class="el-button filter-item el-button--primary el-button--medium"
        style="margin-left: 10px;"
        @click="handleDeleteAll()"
      >
        <i class="el-icon-edit"></i>
        <span>全部删除</span>
      </button>
      <!-- 取消按钮 -->
      <button
        type="button"
        class="el-button filter-item el-button--primary el-button--medium"
        style="margin-left: 10px;"
        @click="toggleSelection()"
      >
        <i class="el-icon-edit"></i>
        <span>取消</span>
      </button>
    </div>
    <br>

    <!--  表格数据及操作 -->
    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="blogger-table">
      <el-table
        :data="items.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        stripe
        border
        max-height="800px"
        style="width: 100%"
        @selection-change="handleSelectionChange"
        ref="multipleTable"
      >
        <!--勾选框-->
        <el-table-column type="selection" width="55"></el-table-column>
        <!--索引-->
        <el-table-column type="index" label="序号" :index="indexMethod" width="50"></el-table-column>
        <el-table-column prop="id" label="时间" width="200" sortable></el-table-column>
        <el-table-column prop="title" label="标题" width="500" sortable></el-table-column>
        <el-table-column prop="title" label="作者" width="200" sortable>
          <!-- 悬浮显示 -->
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>姓名: {{ scope.row.id }}</p>
              <p>住址: {{ scope.row.title }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.title }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="阅读数" width="200" sortable></el-table-column>
        <el-table-column prop="createTime" label="状态" width="200" sortable></el-table-column>
        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <button
              type="button"
              @click="handleEdit(scope.row)"
              class="el-button el-button--primary el-button--mini"
            >
              <span>编辑</span>
            </button>
            <button
              type="button"
              @click="handleUploading(scope.row)"
              class="el-button el-button--success el-button--mini"
            >
              <span>发布</span>
            </button>
            <button
              type="button"
              @click="handleDelete(scope.row)"
              class="el-button el-button--danger el-button--mini"
            >
              <span>删除</span>
            </button>

            <!-- <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑</el-button>
            <el-button @click="handleUploading(scope.row)" type="text" size="small">发布</el-button>
            <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>-->

            <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> -->
            <!-- <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
          </template>
        </el-table-column>
      </el-table>
    </div>
    <br>

    <!-- 分页 total:总数,hide-on-single-page:一页是否隐藏,page-size: -->
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 50, 100, 200]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount"
        :hide-on-single-page="true"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import api from "@/api/blogger";

export default {
  name: "BloggerMoudle",
  data() {
    return {
      // 弹出窗
      dialogFormVisible: false,
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
          { required: true, message: "请输入标题名", trigger: "blur" },
          { min: 3, max: 8, message: "长度在 3 到 8 个字符", trigger: "blur" }
        ],

        content: [{ required: true, message: "请输入内容", trigger: "blur" }],

        author: [{ required: true, message: "请输入作者名", trigger: "blur" }],

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
      },
      // 按钮判断 (创建:create 编辑:edit)
      fromStatus: "",
      // 查询输入框数据
      input: "",
      // 表格初始化信息
      items: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 10,
      // 显示总共有多少数据
      totalCount: 40
    };
  },
  // 初始化加载
  created() {
    this.getBloggerList();
  },
  // 方法
  methods: {
    // 获取bloggerList数据
    getBloggerList() {
      api.bloggerList().then(res => {
        var that = this;
        that.items = res.data;
        console.log(that.items);
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
      api.getBloggerByParam({ searchParam: this.input }).then(res => {
        // 刷新页面
        var that = this;
        that.items = res.data;
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
    // 发布方法
    handleUploading(row) {
      this.$message.success("发布成功");
    },
    // 查看方法
    handleClick(row) {
      console.log(row);
      this.$router.push({ path: "/bloggerDetailPage/" + row.id });
    },
    // 全部删除方法
    handleDeleteAll(index, row) {
      console.log(index, row);
    },
    // 提交方法
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.fromStatus == "create") {
            api.createBlogger({ blogger: this.ruleForm }).then(res => {
              this.dialogFormVisible = false;
              this.$message.success("创建成功");
              // 刷新页面
              this.getBloggerList();
            });
          } else if (this.fromStatus == "edit") {
            api.updateBlogger({ blogger: this.ruleForm }).then(res => {
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
</script>


<style scoped>
.blogger-table {
  /* width: 80%; */
}
</style>
