import api from "@/api/user";

export default {
  name: "userManage",
  data() {
    return {
      // 台账模糊查询参数
      userParams: {
        userAccount: '',
        userName: '',
        userSex: ''
      },
      // 用户台账列表
      userList: [],
      // 初始选中页码
      currentPage: 1,
      // 显示每页的数据
      pagesize: 5,
      // 显示总共有多少数据
      totalCount: 40,

      // 模态框初始化隐藏/显示
      UserDialog: false,
      // 模态框标题名称
      updateTitle: '',
      // 模态框用户详情信息
      userData: {},

      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },


      // 按钮判断 (创建:create 编辑:edit)
      fromStatus: "create",
      // 查询输入框数据
      input: "",


      value: '100'

    };
  },
  // 初始化加载
  created() {
    this.getUserList();
  },
  methods: {
    /** 显示用户台账
     * userParams 模糊查询参数
     * userList 用户列表
     * totalCount 个数
     */
    getUserList() {
      api.getUserList(this.userParams).then(res => {
        this.userList = res.data.data;

        // var WORKPLANNUM = params["WORKPLANNUM"].value;
        // var JOBCLASS = params["JOBCLASS"].value;
        // var SITE = params["SITE"].value;
        // var JOBCODE = params["JOBCODE"].value;
        // var WORKAREA = params["WORKAREA"].value;
        // var TEAM = params["TEAM"].value;
        // var JOBCONTENT = params["JOBCONTENT"].value;
        // var STATUS = params["STATUS"].value;
        // var POWERINFLUENCE = params["POWERINFLUENCE"].value;
        // var STARTPLACE = params["STARTPLACE"].value;
        // var ENDPLACE = params["ENDPLACE"].value;
        // var CONTENT = params["CONTENT"].value;
        // var START = params["START"].value;
        // var END = params["END"].value;

        var queryText = "SELECT WP.JOBCODE,                                                                -- 施工代码（作业代码）                     " +
          "             WP.JOBCLASS,                                                               -- 代码类别                           " +
          "             concat(concat(TO_CHAR(WP.PLANBEGINDATE, 'MM'), '月'),                                                         " +
          "                    concat(TO_CHAR(WP.PLANBEGINDATE, 'dd'), '日')) AS WORKDATE,          -- 施工日期                           " +
          "             TO_CHAR(WP.PLANBEGINDATE, 'HH24:mi')                    PLANBEGINDATE_1,   -- 施工开始时间                         " +
          "             TO_CHAR(WP.PLANENDDATE, 'HH24:mi')                      PLANENDDATE_1,     -- 施工结束时间                         " +
          "             WP.APPLICANTMSG,                                                           -- 施工单位                           " +
          "             PER.DISPLAYNAME                                      AS APPLICANTDESC,     -- 施工计划员                          " +
          "             PER.PHONENUM,                                                              -- 联系方式                           " +
          "             WP.JOBCONTENT,                                                             -- 作业名称（作业内容）                     " +
          "             WP.WORKAREA,                                                               -- 施工地点（作业区域描述）                   " +
          "             PA.ACTUALNUMBER,                                                           -- 施工人数                           " +
          "             DECODE(A.ID, 0, '否', '是')                            AS ISPOWERINFLUENCE,  --是否需停电                           " +
          "             A.COOPERATEGROUP,                                                          -- 配合单位                           " +
          "             DECODE(B.ID, 0, '否', '是')                            AS ISFILE,            --是否需技术方案                         " +
          "             WP.APPROVALDATE,                                                           -- 审核通过时间                         " +
          "             WP.CONTENT,                                                                -- 备注                             " +
          "             ALN.DESCRIPTION                                      AS WORKPLANTYPE,      -- 计划类型                           " +
          "             PL.WORKPLANSTARTTIME,                                                      -- 请点时间                           " +
          "             CEIL((PL.WORKPLANENDTIME - WP.PLANBEGINDATE) * 24 * 60) PLDELAYTIME_START, -- 延迟请点时间                         " +
          "             PA.REMARKS                                           AS STRREMARKS,        -- 请点备注                           " +
          "             PL.WORKPLANENDTIME,                                                        -- 销点时间                           " +
          "             CEIL((PL.WORKPLANENDTIME - WP.PLANENDDATE) * 24 * 60)   PLDELAYTIME_END,   -- 延迟销点时间                         " +
          "             PE.REMARKS                                           AS ENDREMARKS,        -- 销点备注                           " +
          "             DECODE(WP.CLOSEREASON, NULL, '否', '是')               AS WORKPLANSTATUS,    -- 是否取消                           " +
          "             WP.CLOSEREASON                                                             -- 取消原因                           " +
          "      FROM WORKPLAN WP                                                                                                    " +
          "               LEFT JOIN PERSON PER ON PER.PERSONID = WP.APPLICANT                                                        " +
          "               LEFT JOIN PLS_WORKPLAN PL ON PL.WORKPLANID = WP.WORKPLANID                                                 " +
          "               LEFT JOIN PLS_APPLYSTART PA ON PL.PLEASEID = PA.PLEASEID                                                   " +
          "               LEFT JOIN PLS_APPLYEND PE ON PE.PLEASEID = PL.PLEASEID                                                     " +
          "               LEFT JOIN ALNDOMAIN ALN ON ALN.VALUE = WP.WORKPLANTYPE AND ALN.ALNDOMAINID = 'WORKPLANTYPE'                " +
          "               LEFT JOIN ALNDOMAIN ALN2 ON ALN2.VALUE = WP.SITEID AND ALN2.ALNDOMAINID = 'SITE'                           " +
          "               LEFT JOIN ALNDOMAIN ALN3 ON ALN3.VALUE = WP.STATUS AND ALN3.ALNDOMAINID = 'WORKPLAN'                       " +
          "               LEFT JOIN LOCATION LO1 ON LO1.LOCATIONID = WP.STARTPLACE                                                   " +
          "               LEFT JOIN LOCATION LO2 ON LO2.LOCATIONID = WP.ENDPLACE                                                     " +
          "               LEFT JOIN TEAM TEA ON TEA.TEAMID = WP.WORKUNIT                                                             " +
          "               LEFT JOIN (SELECT WORKPLANID, LISTAGG(PG_NAME, '/') WITHIN GROUP ( ORDER BY PG_NAME) AS COOPERATEGROUP     " +
          "                          FROM (SELECT WT.WORKPLANID, PG.PG_NAME                                                          " +
          "                                FROM WORKPLAN_TEAM WT                                                                     " +
          "                                         LEFT JOIN STRUCTURE S ON S.ID = WT.STRUCTUREID                                   " +
          "                                         LEFT JOIN STRUCTURE_PG SP ON SP.ID = S.ID                                        " +
          "                                         LEFT JOIN PERSONGROUP PG ON PG.PG_ID = WT.TEAMID)                                " +
          "                          GROUP BY WORKPLANID) A ON A.WORKPLANID = WP.WORKPLANID                                          " +
          "               LEFT JOIN (SELECT PI.WORKPLANID, COUNT(PI.ID) ID                                                           " +
          "                          FROM POWERINFLUENCE PI                                                                          " +
          "                          WHERE PI.STATUS = 1                                                                             " +
          "                          GROUP BY PI.WORKPLANID) A ON A.WORKPLANID = WP.WORKPLANID                                       " +
          "               LEFT JOIN (SELECT AT.BUSINESS_ID, COUNT(AT.ATTACHMENT_ID) ID                                               " +
          "                          FROM ATTACHMENT AT                                                                              " +
          "                          WHERE AT.TYPE = 'WORKPLAN'                                                                      " +
          "                          GROUP BY AT.BUSINESS_ID) B ON B.BUSINESS_ID = WP.WORKPLANID                                     " +
          "      WHERE 1 = 1                                                                                                      ";

        // if (WORKPLANNUM) {
        //   queryText += "AND  WP.WORKPLANNUM LIKE '%" + WORKPLANNUM + "%'";
        // }
        // if (JOBCLASS) {
        //   queryText += "AND  WP.JOBCLASS LIKE '%" + JOBCLASS + "%'";
        // }
        // if (SITE) {
        //   queryText += "AND  WP.SITE LIKE '%" + SITE + "%'";
        // }
        // if (JOBCODE) {
        //   queryText += "AND  WP.JOBCODE LIKE '%" + JOBCODE + "%'";
        // }
        // if (WORKAREA) {
        //   queryText += "AND  WP.WORKAREA LIKE '%" + WORKAREA + "%'";
        // }
        // if (TEAM) {
        //   queryText += "AND  WP.TEAM LIKE '%" + TEAM + "%'";
        // }
        // if (JOBCONTENT) {
        //   queryText += "AND  WP.JOBCONTENT LIKE '%" + JOBCONTENT + "%'";
        // }
        // if (STATUS) {
        //   queryText += "AND  WP.STATUS LIKE '%" + STATUS + "%'";
        // }
        // if (POWERINFLUENCE) {
        //   queryText += "AND  WP.POWERINFLUENCE LIKE '%" + POWERINFLUENCE + "%'";
        // }
        // if (STARTPLACE) {
        //   queryText += "AND  WP.STARTPLACE LIKE '%" + STARTPLACE + "%'";
        // }
        // if (ENDPLACE) {
        //   queryText += "AND  WP.ENDPLACE LIKE '%" + ENDPLACE + "%'";
        // }
        // if (CONTENT) {
        //   queryText += "AND  WP.CONTENT LIKE '%" + CONTENT + "%'";
        // }

        queryText += "AND (wp.planbegindate <= (to_date('" + START + "', 'yyyy-mm-dd hh24:mi:ss')) AND " +
          " wp.planenddate >= (to_date('" + START + "', 'yyyy-mm-dd hh24:mi:ss'))) " +
          "  or (wp.planbegindate >= (to_date('" + START + "', 'yyyy-mm-dd hh24:mi:ss')) AND " +
          "    wp.planenddate <= (to_date('" + END + "', 'yyyy-mm-dd hh24:mi:ss'))) " +
          "  or (wp.planbegindate <= (to_date('" + END + "', 'yyyy-mm-dd hh24:mi:ss')) AND " +
          "     wp.planenddate >= (to_date('" + END + "', 'yyyy-mm-dd hh24:mi:ss')))" +
          "  order by WP.WORKPLANNUM ";

        console.log(queryText)


        console.log(this.userList);
        this.totalCount = res.data.data.length;
      });
    },
    // 序列方法
    indexMethod(index) {
      return index * 1;
    },
    // 当选择项发生变化时会触发该事件
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    // 取消选择方法
    toggleSelection(rows) {
      this.$refs.multipleTable.clearSelection();
    },
    // 全部删除方法
    handleDeleteAll(index, row) {
      console.log(index, row);
    },
    // handleSizeChange:切换每页显示的数量
    handleSizeChange(size) {
      this.pagesize = size;
      console.log(`每页 ${size} 条`); //每页下拉显示数据
    },
    // handleCurrentChange:切换页码
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      console.log(`当前页: ${currentPage}`); //点击第几页
    },

    /**
     * 创建方法
     */
    handleCreate() {
      this.UserDialog = true;
      this.updateTitle = '用户新建';
      this.fromStatus = "create";
      this.userData = {};
      // this.resetForm("userform");
    },
    // 重置方法
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    /**
     * 编辑-显示详情
     * userData 用户详情
     */
    handleEdit(row) {
      this.UserDialog = true;
      this.updateTitle = '用户编辑';
      api.detailsUser(row.userId).then(res => {
        this.userData = res.data;
        console.log(this.userData)
      });
    },
    /**
     * 用户保存
     * userData 用户详情
     * */
    submitForm(formName) {
      // 关闭模态框
      this.UserDialog = false;

      api.saveUser(this.userData).then(res => {
        if (this.fromStatus == "create") {
          this.$message.success("创建成功");
        } else if (this.fromStatus == "edit") {
          this.$message.success("更新成功");
        }
        // 刷新页面
        this.getUserList(this.userParams);
      });
    },
    /**
     * 删除方法
     * UserId 用户ID
     */
    handleDelete(row) {
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {

          api.deleteUser(row.userId).then(res => {
            if (res.data.data) {
              this.$message({
                type: "success",
                message: "删除成功!"
              });
            } else {
              this.$message({
                type: "fail",
                message: "删除失败!"
              });
            }

            // 刷新页面
            this.getUserList();
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    changeSwitch: function ($event, userStatus) {
      console.log($event);
      console.log(userStatus);
    },
    // changeSwitch(user) {
    //   console.log(this.user)
    //
    //   console.log(this.user.userStatus);
    //   // shopUpdate(b), then(response => {
    //   //   if (response.code == 0) {
    //   //     // 成功了不做处理，因为switch状态已经修改
    //   //     this.message({
    //   //       message: "状态修改成功",
    //   //       type: "success"
    //   //     })
    //   //   } else {
    //   //     let newData = b;
    //   //     newData.state = newData.state == 1 ? "2" : "1";
    //   //     this.tableData(index) = newData;
    //   //   }
    //   // })
    // }
  }
};
