<template>
  <div class="project-container">
    <el-collapse >
      <el-collapse-item title="佛 山 地 铁 运 作 管 理 系 统">
        <div>简化流程：设计简洁直观的操作流程；</div>
        <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
        <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
      </el-collapse-item>
      <el-collapse-item title="高 明 有 轨 电 车">
        <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
        <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
      </el-collapse-item>
      <el-collapse-item>
        <template slot="title">
          <i class="header-icon el-icon-info"></i>洋 马 农 机 2017年6月-2018年2月
        </template>
        <div>改变传统纸质单据检修方式,到每个员工人手一台ipad点检,做到无纸化办公的过程</div>
        <div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
      </el-collapse-item>
      <el-collapse-item title="天合光能">
        <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
        <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
  export default {
    name: "Project"
  }
</script>

<style scoped>
.project-container{
  margin: 0 auto;
  padding: 0 20px;
  max-width: 1280px;
}
</style>
