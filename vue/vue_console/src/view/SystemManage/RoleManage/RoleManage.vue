<template>
  <div class="RoleManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="RoleOperation" style="margin-bottom: 10px;">
      <el-row type="flex" class="row-bg" justify="end">
        <el-button size="medium" round @click="handleCreate">添加角色</el-button>
        <el-button size="medium" round @click="handleCreate">删除</el-button>
        <el-button size="medium" round @click="handleCreate">导出</el-button>
      </el-row>
    </div>

    <!--  1.data:显示的数据,
    2.stripe:是否为斑马纹,
    3.border:是否带有纵向边框,
    4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="userTable">
      <el-table :data="roleTable.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                stripe border max-height="800px" ref="RoleTable"
                :header-cell-style="{background:'grey',color:'#FFF'}">
        <el-table-column prop="roleId" label="角色ID" sortable></el-table-column>
        <el-table-column prop="roleName" label="角色名称"></el-table-column>
        <el-table-column prop="roleDescribe" label="角色描述"></el-table-column>

        <!--        <el-table-column prop="roleDescribe" label="权限字符"></el-table-column>-->
        <!--        <el-table-column prop="roleDescribe" label="角色状态"></el-table-column>-->
        <el-table-column prop="createPerson" label="创建者"></el-table-column>
        <el-table-column prop="createDate" label="创建时间"></el-table-column>
        <el-table-column prop="updatePerson" label="更新者"></el-table-column>
        <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>

        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <el-tooltip effect="dark" content="编辑" placement="top-start">
              <i class="iconfont iconbianji" @click="handleEdit(scope.row)" style=" margin-left: 1em;"></i>
            </el-tooltip>
            <el-tooltip effect="dark" content="人员维护" placement="top-start">
              <i class="iconfont iconadd-account" @click="handleUserList(scope.row)" style=" margin-left: 1em;"></i>
            </el-tooltip>
            <el-tooltip effect="dark" content="权限展示" placement="top-start">
              <i class="iconfont iconshuzhuangtu_o" @click="handlePermissionShowList(scope.row)"
                 style=" margin-left: 1em;"></i>
            </el-tooltip>
            <el-tooltip effect="dark" content="权限编辑" placement="top-start">
              <i class="iconfont iconshuzhuangtu_o" @click="handlePermissionEditList(scope.row)"
                 style=" margin-left: 1em;"></i>
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

    <!--   角色编辑-弹出模态框  -->
    <el-dialog :title="updateTitle" :visible.sync="roleDialog" width="850px" center>
      <el-form :model="roleDetails" ref="roleForm" label-width="120px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="角色名称" prop="roleName">
              <el-input v-model="roleDetails.roleName"></el-input>
            </el-form-item>
            <el-form-item label="角色描述" prop="roleDescribe">
              <el-input v-model="roleDetails.roleDescribe"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="8">
            <el-form-item label="角色名称" prop="roleName">
              <el-input v-model="roleDetails.roleName"></el-input>
            </el-form-item>
            <el-form-item label="角色描述" prop="roleDescribe">
              <el-input v-model="roleDetails.roleDescribe"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="8">
            <el-form-item label="创建人" prop="createPerson">
              <el-input v-model="roleDetails.createPerson" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="创建时间" prop="createDate">
              <el-input v-model="roleDetails.createDate" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="更新者" prop="updatePerson">
              <el-input v-model="roleDetails.updatePerson" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="更新时间" prop="updateDate">
              <el-input v-model="roleDetails.updateDate" :disabled="true"></el-input>
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
    <el-dialog title="人员维护" :visible.sync="userListDialog" width="900px" center>
      <el-button @click="handleAddUserList">批量添加人员</el-button>
      <el-table :data="userTable" style="width: 100%">
        <el-table-column prop="userAccount" label="用户工号"></el-table-column>
        <el-table-column prop="userName" label="用户名称"></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
      </el-table>
    </el-dialog>

    <!--   人员维护可添加台账-弹出模态框  -->
    <el-dialog title="批量添加人员维护" :visible.sync="addUserListDialog" width="900px" center>
      <el-button @click="addUserToRole">添加人员</el-button>
      <el-table :data="userOtherTable" style="width: 100%" tooltip-effect="dark"
                @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="userAccount" label="用户工号"></el-table-column>
        <el-table-column prop="userName" label="用户名称"></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
      </el-table>
    </el-dialog>

    <!--   权限展示台账-弹出模态框
     accordion:手风琴风格
     -->
    <el-dialog title="权限展示" :visible.sync="permissionShowDialog" width="900px" center>
      <el-tree :data="permissionEditData" :props="permissionShowProps" accordion
               @node-click="handleNodeClick"></el-tree>
    </el-dialog>

    <!--   权限编辑台账-弹出模态框
    show-checkbox:节点是否可被选择
    node-key:每个树节点用来作为唯一标识的属性，整棵树应该是唯一的
    default-expanded-keys:设置默认展开
    default-checked-keys:默认选中的节点
    -->
    <el-dialog title="权限编辑" :visible.sync="permissionEditDialog" width="900px" center>
      <!--      <div style="margin:10px 15px;text-align:right;">-->
      <!--        <el-button type="primary" icon="el-icon-plus" @click="handleMultiPerson" v-waves>批量添加用户-->
      <!--        </el-button>-->
      <!--      </div>-->
      <el-tree :data="permissionShowData"
               show-checkbox
               node-key="permissionId"
               :default-expanded-keys="[1]"
               :default-checked-keys="permissionChangeData"
               :props="permissionEditProps" @node-click="handleNodeClick"></el-tree>
    </el-dialog>

  </div>
</template>

<script>
  import RoleManage from './RoleManage'

  export default RoleManage
</script>

<style scoped>

</style>
