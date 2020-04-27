<template>
  <div>
    <div id="editor" style="text-align:left"></div>
    <button v-on:click="getContent">查看内容</button>
  </div>
</template>

<script>
  import E from 'wangeditor'

  export default {
    name: 'editor',
    data() {
      return {
        editorContent: '',
        editorText: ''
      }
    },
    methods: {
      getContent: function () {
        alert(this.editorContent)
      }
    },
    mounted() {
      var editor = new E('#editor')
      editor.customConfig.onchange = (html) => {
        this.editorContent = html
      }
      editor.create()
    }
  }
</script>

<style scoped>
</style>
