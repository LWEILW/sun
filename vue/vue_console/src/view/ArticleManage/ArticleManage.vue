<template>
  <div class="ArticleManage">
    <div class='articleTable' v-if="active === '1'">
      <!-- 靠右显示css样式：text-align:right     -->
      <div style="text-align:right">
        <el-button @click="handleCreate">添加文章</el-button>
      </div>
      <!--      &lt;!&ndash;搜索框&ndash;&gt;-->
      <!--      <div class="blogger-operation">-->
      <!--        <el-row :gutter="5">-->
      <!--          <el-col :span="3">-->
      <!--            <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>-->
      <!--          </el-col>-->
      <!--          <el-col :span="2">-->
      <!--            <el-button type="success" icon="el-icon-search" size="mini">搜索</el-button>-->
      <!--          </el-col>-->

      <!--          <el-col :span="2" :offset="16" style="display:flex;">-->
      <!--            &lt;!&ndash;新增按钮&ndash;&gt;-->
      <!--            <el-button type="success" icon="el-icon-circle-plus-outline" size="mini" round>新增</el-button>-->
      <!--            &lt;!&ndash;全删按钮&ndash;&gt;-->
      <!--            <el-button type="danger" icon="el-icon-delete" size="mini" round>全删</el-button>-->
      <!--          </el-col>-->
      <!--        </el-row>-->
      <!--      </div>-->
      <!--      <br>-->


      <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框,
      4.row-click:表格添加行点击事件 5.ref:显示元素身份 -->
      <div class="ArticleTable">
        <el-table :data="articleTable.slice((currentPage-1)*pageSize,currentPage*pageSize)" stripe border
                  @row-click="handleDetails" max-height="800px" ref="multipleTable">
          <el-table-column prop="articleNum" label="文章编号" sortable></el-table-column>
          <el-table-column prop="articleName" label="文章名称"></el-table-column>
          <el-table-column prop="articleType" label="文章类型"></el-table-column>
          <el-table-column prop="articleContent" label="文章内容"></el-table-column>
          <el-table-column prop="articleStatus" label="文章状态"></el-table-column>
          <el-table-column prop="createPerson" label="创建者" sortable></el-table-column>
          <el-table-column prop="createDate" label="创建时间" sortable></el-table-column>
          <el-table-column prop="createPerson" label="更新者" sortable></el-table-column>
          <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>

          <el-table-column fixed="right" label="操作">
            <template slot-scope="scope">
              <el-tooltip effect="dark" content="编辑" placement="top-start">
                <i class="iconfont iconbianji" @click.stop="handleEdit( scope.row)" style=" margin-left: 1em;"></i>
              </el-tooltip>
              <el-tooltip effect="dark" content="删除" placement="top-start">
                <i class="iconfont iconchangyonggoupiaorenshanchu" @click.stop="handleDelete(scope.row)"
                   style=" margin-left: 1em;"></i>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!--  分页  hide-on-single-page:一页是否隐藏 -->
      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 100]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalCount"
          :hide-on-single-page="true">
        </el-pagination>
      </div>
    </div>

    <div class='articleOperate' v-if="active === '2'">
      <el-form :model="articleData" ref="articleFrom" label-width="120px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="文章编号" prop="articleNum">
              <el-input v-model="articleData.articleNum" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="文章名称" prop="articleName">
              <el-input v-model="articleData.articleName"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="8">
            <el-form-item label="文章类型" prop="articleType">
              <el-input v-model="articleData.articleType"></el-input>
            </el-form-item>
            <el-form-item label="文章状态" prop="articleStatus">
              <el-input v-model="articleData.articleStatus"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="8">
            <el-form-item label="创建人" prop="createPerson">
              <el-input v-model="articleData.createPerson" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="创建时间" prop="createDate">
              <el-input v-model="articleData.createDate" :disabled="true"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <TinymceMoudle></TinymceMoudle>
        </el-row>
        <el-row>
          <el-button @click="submitForm">保存</el-button>
          <el-button @click="handleBack">取消</el-button>
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
