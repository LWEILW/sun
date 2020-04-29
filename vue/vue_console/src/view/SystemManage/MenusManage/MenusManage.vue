<template>
  <div class="MenusManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="MenusOperation">
      <el-button type="text" @click="handleCreate">新增</el-button>
      <el-button type="text" @click="handleEdit">修改</el-button>
      <el-button type="text" @click="handleSwitch">展开/折叠</el-button>
    </div>

    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="MenusTable">
      <el-table :data="menusTable.slice((currentPage-1)*pageSize,currentPage*pageSize)" stripe border max-height="800px"
                ref="MenusTable">
        <el-table-column prop="permissionId" label="菜单名称" sortable></el-table-column>
        <el-table-column prop="modName" label="排序"></el-table-column>
        <el-table-column prop="parentId" label="请求地址"></el-table-column>
        <el-table-column prop="funName" label="类型"></el-table-column>
        <el-table-column prop="path" label="可见"></el-table-column>
        <el-table-column prop="createPerson" label="权限标识"></el-table-column>
        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">

            <el-tooltip effect="dark" content="编辑" placement="top-start">
              <i class="iconfont iconbianji" @click="handleEdit(scope.row)" style=" margin-left: 1em;"></i>
            </el-tooltip>
            <el-tooltip effect="dark" content="删除" placement="top-start">
              <i class="iconfont iconchangyonggoupiaorenshanchu" @click="handleDelete(scope.row)" style=" margin-left: 1em;"></i>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!--     弹出模态框-->
    <el-dialog :title="updateTitle" :visible.sync="menusDialog" width="700px" center>
      <el-form :model="menusData" ref="menusForm" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="模块目录" prop="modName">
              <el-input v-model="permissionData.modName"></el-input>
            </el-form-item>


            <el-form-item label="父类ID">
              <el-select v-model="permissionData.parentId" filterable placeholder="请选择" :default-first-option="true"
                         value-key="VALUE">
                <el-option
                  v-for="item in parentId"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="权限等级" prop="levelNo">
              <el-select v-model="permissionData.levelNo" filterable placeholder="请选择" :default-first-option="true"
                         value-key="VALUE">
                <el-option
                  v-for="item in levelNo"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="功能名称" prop="funName">
              <el-input v-model="permissionData.funName"></el-input>
            </el-form-item>
            <el-form-item label="功能英文名称" prop="modName">
              <el-input v-model="permissionData.path"></el-input>
            </el-form-item>

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
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount"
        :hide-on-single-page="true"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
  import MenusManage from './MenusManage'

  export default MenusManage
</script>

<style scoped>

</style>
