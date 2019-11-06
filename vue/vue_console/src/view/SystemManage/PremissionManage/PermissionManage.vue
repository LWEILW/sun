<template>
  <div class="PermissionManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="PermissionOperation">
      <el-button type="text" @click="handleCreate">添加权限</el-button>
    </div>

    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="permission-table">
      <el-table :data="permissionTable.slice((currentPage-1)*pagesize,currentPage*pagesize)" stripe border
                max-height="800px" ref="PermissionTable">
        <el-table-column prop="permissionId" label="权限ID" sortable></el-table-column>
        <el-table-column prop="modName" label="模块目录"></el-table-column>
        <el-table-column prop="funName" label="功能名称"></el-table-column>
        <el-table-column prop="createDate" label="创建时间"></el-table-column>

        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <el-button type="text" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!--     弹出模态框-->
    <el-dialog :title="updateTitle" :visible.sync="permissionDialog" width="700px" center>
      <el-form :model="permissionData" ref="permissionForm" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="模块目录" prop="modName">
              <el-input v-model="permissionData.modName"></el-input>
            </el-form-item>
            <el-form-item label="功能名称" prop="funName">
              <el-input v-model="permissionData.funName"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="创建时间" prop="createDate">
              <el-input v-model="permissionData.createDate"></el-input>
            </el-form-item>

          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="submitForm">立即创建</el-button>
          <el-button @click="permissionDialog = false">取消</el-button>
        </el-form-item>

      </el-form>
    </el-dialog>

    <!-- 分页 total:总数,hide-on-single-page:一页是否隐藏,page-size: -->
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20, 50]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount"
        :hide-on-single-page="true"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
  import PermissionManage from './PermissionManage'

  export default PermissionManage
</script>

<style scoped>

</style>
