<template>
<div>111</div>
  <!-- <div class="BloggerMoudle"> -->
<!--    &lt;!&ndash;搜索框,添加按钮,全部删除按钮 &ndash;&gt;-->
<!--    <div class="blogger-operation">-->
<!--      &lt;!&ndash; 搜索框 &ndash;&gt;-->
<!--      <div class="filter-item el-input el-input&#45;&#45;medium" style="width: 200px;">-->
<!--        <input-->
<!--          type="text"-->
<!--          autocomplete="off"-->
<!--          placeholder="标题"-->
<!--          v-model="input"-->
<!--          class="el-input__inner"-->
<!--        >-->
<!--      </div>-->
<!--      &lt;!&ndash; 搜索 &ndash;&gt;-->
<!--      <button-->
<!--        type="button"-->
<!--        class="el-button filter-item el-button&#45;&#45;primary el-button&#45;&#45;medium"-->
<!--        @click="handleSearch()"-->
<!--      >-->
<!--        <i class="el-icon-search"></i>-->
<!--        <span>搜索</span>-->
<!--      </button>-->
<!--      &lt;!&ndash; 添加按钮 &ndash;&gt;-->
<!--      <button-->
<!--        type="button"-->
<!--        class="el-button filter-item el-button&#45;&#45;primary el-button&#45;&#45;medium"-->
<!--        style="margin-left: 10px;"-->
<!--        @click="handleCreate()"-->
<!--      >-->
<!--        <i class="el-icon-edit"></i>-->
<!--        <span>添加</span>-->
<!--      </button>-->
<!--      &lt;!&ndash; 全部删除按钮 &ndash;&gt;-->
<!--      <button-->
<!--        type="button"-->
<!--        class="el-button filter-item el-button&#45;&#45;primary el-button&#45;&#45;medium"-->
<!--        style="margin-left: 10px;"-->
<!--        @click="handleDeleteAll()"-->
<!--      >-->
<!--        <i class="el-icon-edit"></i>-->
<!--        <span>全部删除</span>-->
<!--      </button>-->
<!--      &lt;!&ndash; 取消按钮 &ndash;&gt;-->
<!--      <button-->
<!--        type="button"-->
<!--        class="el-button filter-item el-button&#45;&#45;primary el-button&#45;&#45;medium"-->
<!--        style="margin-left: 10px;"-->
<!--        @click="toggleSelection()"-->
<!--      >-->
<!--        <i class="el-icon-edit"></i>-->
<!--        <span>取消</span>-->
<!--      </button>-->
<!--    </div>-->
<!--    <br>-->

<!--    &lt;!&ndash;  表格数据及操作 &ndash;&gt;-->
<!--    &lt;!&ndash;  1.data:显示的数据, 2.stripe:是否为斑马纹, 3.border:是否带有纵向边框, 4.selection-change:当选择项发生变化时会触发该事件 &ndash;&gt;-->
<!--    <div class="blogger-table">-->
<!--      <el-table-->
<!--        :data="items.slice((currentPage-1)*pagesize,currentPage*pagesize)"-->
<!--        stripe-->
<!--        border-->
<!--        max-height="800px"-->
<!--        style="width: 100%"-->
<!--        @selection-change="handleSelectionChange"-->
<!--        ref="multipleTable"-->
<!--      >-->
<!--        &lt;!&ndash;勾选框&ndash;&gt;-->
<!--        <el-table-column type="selection" width="55"></el-table-column>-->
<!--        &lt;!&ndash;索引&ndash;&gt;-->
<!--        <el-table-column type="index" label="序号" :index="indexMethod" width="50"></el-table-column>-->
<!--        <el-table-column prop="account" label="账户" width="150" sortable></el-table-column>-->
<!--        <el-table-column prop="password" label="密码" width="150" sortable></el-table-column>-->
<!--        <el-table-column prop="name" label="姓名" width="150" sortable>-->
<!--          &lt;!&ndash; 悬浮显示 &ndash;&gt;-->
<!--          <template slot-scope="scope">-->
<!--            <el-popover trigger="hover" placement="top">-->
<!--              <p>姓名: {{ scope.row.name }}</p>-->
<!--              <p>住址: {{ scope.row.name }}</p>-->
<!--              <div slot="reference" class="name-wrapper">-->
<!--                <el-tag size="medium">{{ scope.row.name }}</el-tag>-->
<!--              </div>-->
<!--            </el-popover>-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--        <el-table-column prop="token" label="token" width="200" sortable></el-table-column>-->
<!--        <el-table-column fixed="right" label="操作">-->
<!--          <template slot-scope="scope">-->
<!--            <button-->
<!--              type="button"-->
<!--              @click="handleEdit(scope.row)"-->
<!--              class="el-button el-button&#45;&#45;primary el-button&#45;&#45;mini"-->
<!--            >-->
<!--              <span>编辑</span>-->
<!--            </button>-->
<!--            <button-->
<!--              type="button"-->
<!--              @click="handleUploading(scope.row)"-->
<!--              class="el-button el-button&#45;&#45;success el-button&#45;&#45;mini"-->
<!--            >-->
<!--              <span>发布</span>-->
<!--            </button>-->
<!--            <button-->
<!--              type="button"-->
<!--              @click="handleDelete(scope.row)"-->
<!--              class="el-button el-button&#45;&#45;danger el-button&#45;&#45;mini"-->
<!--            >-->
<!--              <span>删除</span>-->
<!--            </button>-->

<!--            &lt;!&ndash; <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑</el-button>-->
<!--            <el-button @click="handleUploading(scope.row)" type="text" size="small">发布</el-button>-->
<!--            <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>&ndash;&gt;-->

<!--            &lt;!&ndash; <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> &ndash;&gt;-->
<!--            &lt;!&ndash; <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
<!--            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>&ndash;&gt;-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--      </el-table>-->
<!--    </div>-->
<!--    <br>-->
<!---->
<!--    &lt;!&ndash; 分页 total:总数,hide-on-single-page:一页是否隐藏,page-size: &ndash;&gt;-->
<!--    <div class="block">-->
<!--      <el-pagination-->
<!--        @size-change="handleSizeChange"-->
<!--        @current-change="handleCurrentChange"-->
<!--        :current-page="currentPage"-->
<!--        :page-sizes="[5, 10, 20, 50]"-->
<!--        :page-size="pagesize"-->
<!--        layout="total, sizes, prev, pager, next, jumper"-->
<!--        :total="totalCount"-->
<!--        :hide-on-single-page="true"-->
<!--      ></el-pagination>-->
<!--    </div>-->
  <!-- </div> -->
</template>

<script>
  // import UserManage from './UserManage'
  //
  // export default UserManage
</script>

<style scoped>
</style>
