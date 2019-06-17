<template>
  <div class="BloggerMoudle">
    <!-- 路由 -->
    <!-- <div class="blogger-route">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>活动管理</el-breadcrumb-item>
        <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        <el-breadcrumb-item>活动详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>-->
    <br>

    <!--搜索框-->
    <div class="blogger-operation">
      <el-row :gutter="5">
        <el-col :span="3">
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </el-col>
        <el-col :span="2">
          <el-button type="success" icon="el-icon-search" size="mini">搜索</el-button>
        </el-col>

        <el-col :span="2" :offset="16" style="display:flex;">
          <!--新增按钮-->
          <el-button type="success" icon="el-icon-circle-plus-outline" size="mini" round>新增</el-button>
          <!--全删按钮-->
          <el-button type="danger" icon="el-icon-delete" size="mini" round>全删</el-button>
        </el-col>
      </el-row>
    </div>
    <br>

    <!--  表格数据及操作 -->
    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="blogger-table">
      <el-table
        :data="items"
        stripe
        border
        height="550px"
        max-height="850px"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <!--勾选框-->
        <el-table-column type="selection" width="55"></el-table-column>
        <!--索引-->
        <el-table-column type="index" label="序号" :index="indexMethod" width="50"></el-table-column>
        <el-table-column prop="id" label="日期" width="180" sortable></el-table-column>
        <el-table-column prop="title" label="姓名" width="180"></el-table-column>
        <el-table-column prop="title" label="地址" width="180">
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
        <el-table-column prop="createTime" label="地址" width="180"></el-table-column>
        <el-table-column prop="createTime" label="地址"></el-table-column>

        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑</el-button>
            <!-- <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
          </template>
        </el-table-column>
      </el-table>
    </div>
    <br>
  </div>
</template>

<script>
import api from "@/api/blogger";

export default {
  name: "BloggerMoudle",
  data() {
    return {
      items: [],
      //查询输入框数据
      input: ""
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
    //
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 序列方法
    indexMethod(index) {
      return index * 1;
    },
    // 查看方法
    handleClick(row) {
      console.log(row);
      this.$router.push({ path: "/bloggerDetailPage/"+row.id });
    },
    // 编辑方法
    handleEdit(row) {
      console.log(row);
      this.$router.push({ path: "/bloggerEditPage/"+row.id });
    },
    // 删除方法
    handleDelete(index, row) {
      console.log(index, row);
    }
  }
};
</script>


<style scoped>
</style>
