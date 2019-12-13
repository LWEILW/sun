<template>
  <div class="contentMoudle">
    <el-calendar>
      <!-- 这里使用的是 2.5 slot 语法，对于新项目请使用 2.6 slot 语法-->
      <template slot="dateCell" slot-scope="{date, data}">
        <p
          :class="data.isSelected ? 'is-selected' : ''"
        >{{ data.day.split('-').slice(1).join('-') }} {{ data.isSelected ? '✔️' : ''}}</p>
      </template>
    </el-calendar>
  </div>
</template>

<script>
export default {
  name: "contentMoudle",
  data() {
    return {};
  }
};
</script>

 <!-- Add "scoped" attribute to limit CSS to this component only -->
<!-- 翻译：加上"scoped"属性，可以仅将本页面的CSS限制为该组件（私有作用域的概念） -->
<style scoped>
.is-selected {
  color: #1989fa;
}
</style>

