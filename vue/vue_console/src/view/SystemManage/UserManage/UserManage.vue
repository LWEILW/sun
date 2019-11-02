<template>
  <div class="UserManage">
    <!--搜索框,添加按钮,删除按钮 -->
    <div class="userOperation">
      <!-- 搜索框 -->
      <div class="filter-item el-input el-input--medium" style="width: 200px;">
        <input type="text" autocomplete="off" placeholder="请输入检测单号" v-model="input" class="el-input__inner">
      </div>
      <!-- 搜索 -->
      <button type="button" class="el-button filter-item el-button--primary el-button--medium" @click="handleSearch()">
        <i class="el-icon-search"></i>
        <span>搜索</span>
      </button>
      <!-- 取消按钮 -->
      <button type="button" class="el-button filter-item el-button--primary el-button--medium"
              style="margin-left: 10px;" @click="toggleSelection()">
        <i class="el-icon-edit"></i>
        <span>取消</span>
      </button>


      <el-button type="text" @click="createUserDialog = true,updateTitle='用户新建'">新建</el-button>

      <el-button type="text" @click="createUserDialog = true,updateTitle='用户编辑'">编辑</el-button>

      <!-- 添加按钮 -->
      <button type="button" class="el-button filter-item el-button--primary el-button--medium"
              style="margin-left: 10px;" @click="handleCreate()">
        <i class="el-icon-edit"></i>
        <span>添加</span>
      </button>

      <!-- 删除按钮 -->
      <button type="button" class="el-button filter-item el-button--primary el-button--medium"
              style="margin-left: 10px;" @click="handleDeleteAll()">
        <i class="el-icon-edit"></i>
        <span>删除</span>
      </button>
    </div>


    <!--  表格数据及操作 -->
    <!--  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 -->
    <div class="user-table">
      <el-table
        :data="user.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        stripe
        border
        @selection-change="handleSelectionChange"
        max-height="800px"
        ref="multipleTable"
      >
        <el-table-column prop="userAccount" label="用户工号" sortable></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
        <el-table-column prop="userSex" label="性别"></el-table-column>
        <el-table-column prop="userPhone" label="手机话"></el-table-column>
        <el-table-column prop="userEmail" label="邮箱"></el-table-column>
        <el-table-column prop="createPerson" label="创建人" sortable></el-table-column>
        <el-table-column prop="createDate" label="创建时间" sortable></el-table-column>
        <el-table-column prop="updateDate" label="更新时间" sortable></el-table-column>
        <!--        <el-table-column prop="userPassword" label="密码"></el-table-column>-->
        <!--        <el-table-column prop="name" label="姓名" width="150" sortable>-->
        <!--        &lt;!&ndash; 悬浮显示 &ndash;&gt;-->
        <!--        <template slot-scope="scope">-->
        <!--          <el-popover trigger="hover" placement="top">-->
        <!--            <p>姓名: {{ scope.row.name }}</p>-->
        <!--            <p>住址: {{ scope.row.name }}</p>-->
        <!--            <div slot="reference" class="name-wrapper">-->
        <!--              <el-tag size="medium">{{ scope.row.name }}</el-tag>-->
        <!--            </div>-->
        <!--          </el-popover>-->
        <!--        </template>-->
        <!--        </el-table-column>-->

        <!--        <el-table-column prop="token" label="token" width="200" sortable></el-table-column>-->

        <el-table-column fixed="right" label="操作">
          <template slot-scope="scope">
            <button type="button" @click="handleEdit(scope.row)" class="el-button el-button--primary el-button--mini">
              <span>编辑</span>
            </button>
            <button type="button" @click="handleUploading(scope.row)"
                    class="el-button el-button--success el-button--mini">
              <span>发布</span>
            </button>
            <button type="button" @click="handleDelete(scope.row)" class="el-button el-button--danger el-button--mini">
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

    <el-dialog :title="updateTitle" :visible.sync="createUserDialog" width="700px" center>

      <el-form :model="formData" ref="form" label-width="120px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户工号" prop="userAccount">
              <el-input v-model="formData.userAccount"></el-input>
            </el-form-item>

            <el-form-item label="用户姓名" prop="userName">
              <el-input v-model="formData.userName"></el-input>
            </el-form-item>

            <el-form-item label="性别" prop="userSex">
              <el-radio-group v-model="formData.userSex">
                <el-radio label="男"></el-radio>
                <el-radio label="女"></el-radio>
              </el-radio-group>
            </el-form-item>

          </el-col>
          <el-col :span="12">
            <el-form-item label="手机号" prop="userPhone">
              <el-input v-model="formData.userPhone"></el-input>
            </el-form-item>

            <el-form-item label="邮箱" prop="userEmail">
              <el-input v-model="formData.userEmail"></el-input>
            </el-form-item>


          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="submitForm">立即创建</el-button>
          <el-button @click="createUserDialog = false">取消</el-button>
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
  import UserManage from './UserManage'

  export default UserManage
</script>

<style scoped>

</style>
