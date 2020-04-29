<template>
  <div class="PermissionManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="PermissionOperation" style="margin-bottom: 10px;">
      <el-row type="flex" class="row-bg" justify="end">
        <el-button size="medium" round @click="handleCreate">添加权限</el-button>
        <!--        <el-button size="medium" round @click="handleSwtich">展开/折叠</el-button>-->
      </el-row>
    </div>

    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="permission-table">
      <el-table :data="permissionTable.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                stripe border max-height="800px" ref="PermissionTable"
                :header-cell-style="{background:'grey',color:'#FFF'}"
                row-key="permissionId" :default-expand-all="defaultOpen"
                :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
<!--        <el-table-column prop="permissionId" label="权限ID"></el-table-column>-->
        <el-table-column prop="permissionName" label="权限名称"></el-table-column>s
        <el-table-column prop="permissionPath" label="权限路径"></el-table-column>
        <el-table-column prop="parentName" label="父类名称"></el-table-column>
        <!--        <el-table-column prop="ParentName" label="父类名称"></el-table-column>-->
        <!--        <el-table-column prop="functionName" label="功能名称"></el-table-column>-->
        <el-table-column prop="levelNo" label="权限等级"></el-table-column>
        <el-table-column prop="createPerson" label="创建者"></el-table-column>
        <el-table-column prop="createDate" label="创建时间"></el-table-column>
<!--        <el-table-column prop="updatePerson" label="更新者"></el-table-column>-->
<!--        <el-table-column prop="updateDate" label="更新时间"></el-table-column>-->
        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">

            <el-tooltip effect="dark" content="编辑" placement="top-start">
              <i class="iconfont iconbianji" @click="handleEdit(scope.row)" style=" margin-left: 1em;"></i>
            </el-tooltip>
            <el-tooltip effect="dark" content="删除" placement="top-start">
              <i class="iconfont iconchangyonggoupiaorenshanchu" @click="handleDelete(scope.row)"
                 style=" margin-left: 1em;"></i>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
    </div>

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

    <!--     弹出模态框-->
    <el-dialog :title="updateTitle" :visible.sync="permissionDialog" width="900px" center>
      <el-form :model="permissionData" ref="permissionForm" label-width="120px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="权限名称" prop="permissionName">
              <el-input v-model="permissionData.permissionName"></el-input>
            </el-form-item>

            <el-form-item label="权限路径" prop="permissionPath">
              <el-input v-model="permissionData.permissionPath"></el-input>
            </el-form-item>

            <el-form-item label="父类名称" prop="ParentId">
              <!--              <el-input v-model="permissionData.ParentId"></el-input>-->
              <el-select v-model="permissionData.parentId" clearable filterable placeholder="请选择"
                         :default-first-option="true" value-key="VALUE">
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

          <el-col :span="8">
            <el-form-item label="权限名称" prop="permissionName">
              <el-input v-model="permissionData.permissionName"></el-input>
            </el-form-item>

            <el-form-item label="权限路径" prop="permissionPath">
              <el-input v-model="permissionData.permissionPath"></el-input>
            </el-form-item>

            <el-form-item label="父类名称" prop="ParentId">
              <!--              <el-input v-model="permissionData.ParentId"></el-input>-->
              <el-select v-model="permissionData.parentId" clearable filterable placeholder="请选择"
                         :default-first-option="true" value-key="VALUE">
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

          <el-col :span="8">
            <el-form-item label="创建者" prop="createPerson">
              <el-input v-model="permissionData.createPerson" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="创建时间" prop="createDate">
              <el-input v-model="permissionData.createDate" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="更新者" prop="updatePerson">
              <el-input v-model="permissionData.updatePerson" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="更新时间" prop="updateDate">
              <el-input v-model="permissionData.updateDate" :disabled="true"></el-input>
            </el-form-item>

          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="submitForm">保存</el-button>
          <el-button @click="permissionDialog = false">取消</el-button>
        </el-form-item>

      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import PermissionManage from './PermissionManage'

  export default PermissionManage
</script>

<style scoped>

</style>
