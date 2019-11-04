<template>
  <div class="ArticleManage">
    <div v-if="active === '1'">
      <div>
        <el-button @click="createArticle">createArticle</el-button>
<!--        <el-breadcrumb separator-class="el-icon-arrow-right">-->
<!--          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>-->
<!--          <el-breadcrumb-item>活动管理</el-breadcrumb-item>-->
<!--          <el-breadcrumb-item>活动列表</el-breadcrumb-item>-->
<!--          <el-breadcrumb-item>活动详情</el-breadcrumb-item>-->
<!--        </el-breadcrumb>-->
      </div>
      <!--  表格数据及操作 -->
      <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.row-click:表格添加行点击事件 5.ref:返回值清空 -->
      <div class="ArticleTable">
        <el-table
          :data="article.slice((currentPage-1)*pagesize,currentPage*pagesize)"
          stripe
          border
          @row-click="articleDetails"
          max-height="800px"
          ref="multipleTable"
        >
          <el-table-column prop="articleNum" label="博客编号" sortable></el-table-column>
          <el-table-column prop="articleName" label="博客名称"></el-table-column>
          <el-table-column prop="articleType" label="博客类型"></el-table-column>
          <el-table-column prop="articleContent" label="博客内容"></el-table-column>
          <el-table-column prop="articleStatus" label="博客状态"></el-table-column>
          <el-table-column prop="createPerson" label="创建人" sortable></el-table-column>
          <el-table-column prop="createDate" label="创建时间" sortable></el-table-column>
          <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>

          <el-table-column fixed="right" label="操作">
            <template slot-scope="scope">
              <el-button @click.stop="handleClick(scope.row)" type="text" size="small">查看</el-button>
              <el-button size="mini" @click.stop="handleClick( scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click.stop="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>

        </el-table>
      </div>

      <!--  分页  -->
      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 100]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>

    <div v-if="active === '2'">
      <el-form :model="articleData" ref="form" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="博客编号" prop="articleNum">
              <el-input v-model="articleData.articleNum"></el-input>
            </el-form-item>
            <el-form-item label="用户工号" prop="articleName">
              <el-input v-model="articleData.articleName"></el-input>
            </el-form-item>
            <el-form-item label="博客类型" prop="articleType">
              <el-input v-model="articleData.articleType"></el-input>
            </el-form-item>
            <el-form-item label="博客内容" prop="articleContent">
              <el-input v-model="articleData.articleContent"></el-input>
            </el-form-item>
            <el-form-item label="博客状态" prop="articleStatus">
              <el-input v-model="articleData.articleStatus"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="博客编号" prop="articleNum">
              <el-input v-model="articleData.articleNum"></el-input>
            </el-form-item>
            <el-form-item label="用户工号" prop="articleName">
              <el-input v-model="articleData.articleName"></el-input>
            </el-form-item>
            <el-form-item label="博客类型" prop="articleType">
              <el-input v-model="articleData.articleType"></el-input>
            </el-form-item>
            <el-form-item label="博客内容" prop="articleContent">
              <el-input v-model="articleData.articleContent"></el-input>
            </el-form-item>
            <el-form-item label="博客状态" prop="articleStatus">
              <el-input v-model="articleData.articleStatus"></el-input>
            </el-form-item>

          </el-col>
        </el-row>
        <el-row>
          <el-button @click="submitForm">保存</el-button>
          <el-button @click="fanhuia">取消</el-button>
        </el-row>
      </el-form>
    </div>

    <div v-if="active === '3'">
      <h1>33</h1>
    </div>

  </div>
</template>

<script>
  import ArticleManage from './ArticleManage'

  export default ArticleManage
</script>

<style scoped>

</style>
