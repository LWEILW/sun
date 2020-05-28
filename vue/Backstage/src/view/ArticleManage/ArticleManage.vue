<template>
  <el-container>
    <el-container>
      <el-aside>
        <Navigation></Navigation>
      </el-aside>

      <el-container>
        <el-header>
          <Header></Header>
          <!-- 面包屑组件 -->
          <BreadBox></BreadBox>
        </el-header>

        <el-main>

          <div class="article-container">
            <div class='article-table' v-if="active === '1'">

              <!--搜索框-->
              <div class="article-operation">
                <div class="article-input">
                  <el-input placeholder="请输入内容" size="small">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>
                <div class="article-input">
                  <el-input placeholder="请输入内容" size="small">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>
                <div class="article-input">
                  <el-input placeholder="请输入内容" size="small">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>

                <el-button type="primary" icon="el-icon-search" size="small">搜索</el-button>
                <el-button type="primary" icon="el-icon-circle-plus-outline" size="small" @click="handleCreate">新增
                </el-button>
                <el-button type="primary" icon="el-icon-delete" size="small" @click="handleDelete">全删</el-button>
                <!--导出报表-->
                <el-button type="primary" icon="el-icon-delete" size="small"><a
                  :href='`http://localhost:9999/api/v1/article/wordExport`' target="_blank">word导出 </a></el-button>
              </div>


              <!--  1.data:显示的数据
                    2.stripe:是否为斑马纹
                    3.border:是否带有纵向边框,
                    4.row-click:表格添加行点击事件
                    5.ref:显示元素身份 -->
              <div class="ArticleTable">
                <el-table :data="articleTable.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                          stripe border @row-click="handleDetails" max-height="1000px" ref="multipleTable">
                  <el-table-column type="selection" width="55"></el-table-column>
                  <el-table-column prop="articleNum" label="文章编号" sortable></el-table-column>
                  <el-table-column prop="articleName" label="文章名称"></el-table-column>
                  <el-table-column prop="articleType" label="文章类型"></el-table-column>
                  <el-table-column prop="articleContent" label="文章内容"></el-table-column>
                  <el-table-column prop="articleStatus" label="文章状态"></el-table-column>
                  <el-table-column prop="createDate" label="创建时间" sortable></el-table-column>
                  <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>

                  <el-table-column fixed="right" label="操作" width="200">
                    <template slot-scope="scope">
                      <el-button @click.stop="handleEdit( scope.row)" type="primary" size="small">查看</el-button>
                      <el-button @click.stop="handleDelete(scope.row)" type="danger" size="small">编辑</el-button>
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
                  :hide-on-single-page="false">
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
                <!--                <el-row>-->
                <!--                  <div>{{ msg }}-->
                <!--                    <tinymce v-model="msg" :disabled="disabled" @onClick="onClick" ref="editor"></tinymce>-->
                <!--                    <button @click="clear">清空内容</button>-->
                <!--                    <button @click="disabled = true">禁用</button>-->
                <!--                  </div>-->
                <!--                  &lt;!&ndash;                    <editor :catchData="catchData" :content="ruleForm.info.description"></editor>&ndash;&gt;-->
                <!--                  &lt;!&ndash;                    <wangEditor></wangEditor>&ndash;&gt;-->
                <!--                  &lt;!&ndash;          <Editor ref="editor"></Editor>&ndash;&gt;-->
                <!--                  &lt;!&ndash;          <CKEditor></CKEditor>&ndash;&gt;-->
                <!--                </el-row>-->
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

        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
  import ArticleManage from './ArticleManage'

  export default ArticleManage
</script>

<style scoped>
  .article-operation {
    display: flex;
    display: inline-flex;
    display: -webkit-flex;
    flex-direction: row;
    margin-bottom: 10px;
  }

  .article-input {
    width: 150px;
    margin-right: 10px;
  }
</style>
