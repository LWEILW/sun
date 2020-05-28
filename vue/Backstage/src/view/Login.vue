<template>
  <div class="login_container">
    <h2>博客控制台管理</h2>
    <div class="login_box">

      <div class="avatar_box">
        <img src="../assets/logo.png">
      </div>


      <!-- model:表单数据对象,rules:表单验证规则,status-icon:是否在输入框中显示校验结果反馈图标
      label-position:表单域标签的位置,label-width:表单域标签的宽度 -->
      <el-form class="login_form" :model="ruleForm" :rules="rules" status-icon ref="ruleForm"
               label-position="left" label-width="0">
        <el-form-item prop="account">
          <el-input v-model="ruleForm.account"></el-input>
        </el-form-item>

        <el-form-item prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>

<!--        <el-form-item prop="checkPass">-->
<!--          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->

        <el-form-item class="login_button">
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <div id="wave" :style="`height:${waveAllHeight}px`">

      <div class="wave-box">
        <canvas id="wave1"></canvas>
        <canvas id="wave2"></canvas>
        <canvas id="wave3"></canvas>
        <canvas id="wave4"></canvas>
      </div>
    </div>
  </div>
</template>

<script>
  import api from "@/api/login";

  export default {
    name: "login",
    data() {
      // 验证邮箱
      var checkAccount = (rule, value, callback) => {
        if (!value) {
          return callback();
        }
        if (value) {
          setTimeout(() => {
            var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            if (!reg.test(value)) {
              callback(new Error("请输入有效的电子邮箱！"));
            } else {
              callback();
            }
          }, 500);
        }
      };
      // 验证密码
      var validatePass = (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请输入密码"));
        } else {
          if (this.ruleForm.checkPass !== "") {
            this.$refs.ruleForm.validateField("checkPass");
          }
          callback();
        }
      };
      // 验证二次密码
      var validatePass2 = (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请再次输入密码"));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error("两次输入密码不一致!"));
        } else {
          callback();
        }
      };
      return {
        //波浪的整体高度
        waveAllHeight: 350,
        //波浪个数
        waveCount: 4,
        //波浪起伏高度
        waveHeight: 20,
        // 登录默认值
        ruleForm: {
          account: "欧阳锋",
          pass: "123",
          checkPass: "123"
        },
        // 验证规则
        rules: {
          // account: [{ validator: checkAccount, trigger: "blur" }],
          pass: [{validator: validatePass, trigger: "blur"}],
          checkPass: [{validator: validatePass2, trigger: "blur"}]
        }
      };
    },
    mounted() {
      this.wavePlay("wave1", 100, "hsl(230, 90%, 61%)", 3000);
      this.wavePlay("wave2", 130, "hsl(200, 70%, 61%)", 3000);
      this.wavePlay("wave3", 160, "hsl(180, 50%, 61%)", 3000);
      this.wavePlay("wave4", 200, "hsl(190, 20%, 61%)", 3000);
    },
    methods: {
      //  * 底部波浪
      //  * @param $canvasID     canvasID
      //  * @param $progress     波浪位置的高度
      //  * @param $maveColor    波浪颜色
      //  * @param $time         运动周期
      //
      //波浪运动动画
      wavePlay($canvasID, $progress, $maveColor, $time) {
        let _this = this;
        let waveWidth = 3800, //波浪长度
          offset = 0,
          waveHeight = _this.waveHeight, //波浪起伏高度
          waveCount = _this.waveCount, //波浪个数
          startX = -1000,
          startY = 212, //canvas 高度
          progress = $progress, //波浪位置高度
          d2 = waveWidth / waveCount, //单个波浪的宽度
          d = d2 / 2,
          hd = d / 2,
          c = document.getElementById($canvasID),
          ctx = c.getContext("2d");
        c.width = 2555; //画布宽度
        c.height = _this.waveAllHeight; //画布高度
        function move() {
          offset -= 5;
          if (-1 * offset === d2) {
            offset = 0;
          }
          ctx.clearRect(0, 0, c.width, c.height);
          ctx.fillStyle = $maveColor; //画布填充色
          ctx.beginPath();
          let offsetY = startY - progress;
          //绘制贝塞尔曲线
          ctx.moveTo(startX - offset, offsetY); //开始点
          for (let i = 0; i < waveCount; i++) {
            let dx = i * d2;
            let offsetX = dx + startX - offset;
            //   quadraticCurveTo(1,1,2,2) 方法通过使用表示二次贝塞尔曲线的指定控制点，向当前路径添加一个点。(1,1控制点，2,2结束点)
            ctx.quadraticCurveTo(
              offsetX + hd,
              offsetY + waveHeight,
              offsetX + d,
              offsetY
            );
            ctx.quadraticCurveTo(
              offsetX + hd + d,
              offsetY - waveHeight,
              offsetX + d2,
              offsetY
            );
          }
          ctx.lineTo(startX + waveWidth, 3000);
          ctx.lineTo(startX, 3000);
          ctx.fill();
          setTimeout(move, $time / 60); //速度
        }

        move();
      },
      // 登录方法
      submitForm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            api.ajaxLogin({
              userName: this.ruleForm.account,
              password: this.ruleForm.pass
            }).then(res => {
              console.log(res.data);
              if (res.data.status == 1) {
                //登录成功之后重定向到首页
                this.$router.push({path: "/ArticleManage"});
                this.$message.success(res.data.message);
              } else {
                this.$message.warning(res.data.message);
              }
            });
          } else {
            console.log("error submit!!");
            return false;
          }
        });
      },
      // 重置
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  };
</script>

<style>
  #wave {
    width: 100%;
    overflow: hidden;
    position: absolute;
    bottom: 0;
  }

  h2 {
    text-align: center;
    color: #3a8ee6;
    font-size: 40px;
    font-weight: 300;
    text-transform: uppercase;
    line-height: 100px;
  }

  .wave-box {
    transform: scaleY(1);
    /**翻转波浪位置**/
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
  }

  canvas {
    opacity: 0.5;
    position: absolute;
    left: 0;
    top: 0;
  }

  .login_container {
    /*background-color: #b8e7ff;*/
    height: 100%;
  }

  .login_box {
    width: 450px;
    height: 300px;
    background-color: #d0e5f2;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    /*圆弧*/
    border-radius: 50%;
    padding: 10px;
    /*阴影*/
    box-shadow: 0 0 10px #000000;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;

  }

  img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background-color: #eee;
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }

  .login_button {
    display: flex;
    justify-content: flex-end;
  }
</style>
