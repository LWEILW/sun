<template>
  <div class="RoleManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="RoleOperation">
      <el-button type="text" @click="handleCreate">添加角色</el-button>
    </div>

    <!--  1.data:显示的数据,
    2.stripe:是否为斑马纹,
    3.border:是否带有纵向边框,
    4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="userTable">
      <el-table :data="roleTable.slice((currentPage-1)*pagesize,currentPage*pagesize)" stripe border
                max-height="800px" ref="RoleTable">
        <el-table-column prop="roleId" label="角色ID" sortable></el-table-column>
        <el-table-column prop="roleName" label="角色名称"></el-table-column>
        <el-table-column prop="roleDescribe" label="角色描述"></el-table-column>
        <el-table-column prop="createPerson" label="创建人"></el-table-column>
        <el-table-column prop="createDate" label="创建时间"></el-table-column>
        <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>

        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <el-button type="text" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button type="text" @click="handleUserList(scope.row)">人员维护</el-button>
            <el-button type="text" @click="handlePermissionList(scope.row)">权限编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!--   角色编辑-弹出模态框  -->
    <el-dialog :title="updateTitle" :visible.sync="roleDialog" width="700px" center>
      <el-form :model="roleDetails" ref="roleForm" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="角色名称" prop="roleName">
              <el-input v-model="roleDetails.roleName"></el-input>
            </el-form-item>
            <el-form-item label="角色描述" prop="roleDescribe">
              <el-input v-model="roleDetails.roleDescribe"></el-input>
            </el-form-item>
            <el-form-item label="创建人" prop="createPerson">
              <el-input v-model="roleDetails.createPerson"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="创建时间" prop="createDate">
              <el-input v-model="roleDetails.createDate"></el-input>
            </el-form-item>
            <el-form-item label="更新时间" prop="updateDate">
              <el-input v-model="roleDetails.updateDate"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="submitForm">立即创建</el-button>
          <el-button @click="roleDialog = false">取消</el-button>
        </el-form-item>

      </el-form>
    </el-dialog>

    <!--   人员维护台账-弹出模态框  -->
    <el-dialog title="人员维护" :visible.sync="userListDialog" width="700px" center>
      <el-button @click="handleAddUserList">批量添加人员</el-button>
      <el-table :data="userTable" style="width: 100%">
        <el-table-column prop="userAccount" label="用户工号"></el-table-column>
        <el-table-column prop="userName" label="用户名称"></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
      </el-table>
    </el-dialog>

    <!--   人员维护可添加台账-弹出模态框  -->
    <el-dialog title="批量添加人员维护" :visible.sync="addUserListDialog" width="700px" center>
      <el-button @click="addUserToRole">添加人员</el-button>
      <el-table :data="userOtherTable" style="width: 100%"  tooltip-effect="dark" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="userAccount" label="用户工号"></el-table-column>
        <el-table-column prop="userName" label="用户名称"></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
      </el-table>
    </el-dialog>

    <!--   权限编辑台账-弹出模态框  -->
    <el-dialog title="权限编辑" :visible.sync="permissionDialog" width="700px" center>
      <el-tree :data="permissionData" :props="Props" @node-click="handleNodeClick"></el-tree>
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
  import RoleManage from './RoleManage'

  export default RoleManage
</script>

<style scoped>

</style>
