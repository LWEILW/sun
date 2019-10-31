import api from "@/api/user";

export default {
  name: "userManage",
  data() {
    return {
      // 表格初始化信息
      items: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40
    };
  },
  // 初始化加载
  created() {
    this.getUserList();
  },
  // 方法
  methods: {
    // 获取bloggerList数据
    getUserList() {
      api.getUserList(this.items).then(res => {
        var that = this;
        that.items = res.data;
        this.totalCount = res.data.length;
        console.log(that.items);
      });
    },

  }
};
