<%--
  Created by IntelliJ IDEA.
  User: 淡水
  Date: 2023/11/20
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://cdn.staticfile.org/layui/2.5.7/css/layui.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--<script src="https://cdn.staticfile.org/layui/2.5.7/layui.js"></script>--%>
<html>
  <head>
    <title>$Title$</title>
    <script src="jquery-3.6.0.js"></script>
  </head>
  <body>
  <div class="layui-container">
    <div class="layui-row" style="margin-top: 10%;">
      <div class="layui-col-md4 layui-col-md-offset4">

          <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
              <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" autocomplete="off"
                     class="layui-input" id="inputUsername">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
              <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                     class="layui-input" id="inputPassword">
            </div>
          </div>
          <div class="layui-btn-container">
            <div class="layui-input-block">
              <input type="button" class="layui-btn" lay-submit onclick="login()" value="登录">
            </div>

          </div>

      </div>
    </div>
  </div>



<%--  <script>--%>

<%--&lt;%&ndash;    这是登陆的可能能用的实例（应该暂时用不起）没施工抱歉 我自己也看不懂监听啥的啊哈哈……&ndash;%&gt;--%>
<%--    // 页面初始化--%>
<%--    layui.use(['form', 'layer', 'jquery'], function () {--%>
<%--      var form = layui.form;--%>
<%--      var layer = layui.layer;--%>
<%--      var $ = layui.jquery;--%>

<%--      // 监听提交--%>
<%--      form.on('submit(login)', function (data) {--%>
<%--        // 模拟ajax请求--%>
<%--        $.ajax({--%>
<%--          type: 'POST',--%>
<%--          url: '${pageContext.servletContext.contextPath}/login', // 替换成实际的后端登录接口--%>
<%--          data: data.field,--%>
<%--          success: function (res) {--%>
<%--            if (res.code === 0) {--%>
<%--              layer.msg('登录成功');--%>
<%--              // 登录成功后的操作，例如跳转到主页--%>
<%--              // window.location.href = '/home';--%>
<%--            } else {--%>
<%--              layer.msg(res.msg, {icon: 5});--%>
<%--            }--%>
<%--          },--%>
<%--          error: function () {--%>
<%--            layer.msg('请求失败，请重试', {icon: 5});--%>
<%--          }--%>
<%--        });--%>

<%--        return false; // 阻止表单跳转--%>
<%--      });--%>
<%--    });--%>
<%--  </script>--%>

  <script>
    const error = '<%=request.getParameter("error")%>'
    if(error == 'fail'){
      alert("账号密码错误，请重新检查输入")
    }

    function login(){
      var id = $("#inputUsername").val()
      var pwd = $("#inputPassword").val()

      $.ajax({
        type:'post',
        url:'${pageContext.servletContext.contextPath}/login',
        data:{id:id,password:pwd},
        dataType:'json',
        success:function (response){
          var state=response.currentState;
          var data=response.url;
          // console.info(response)
          if(state!='fail'){
          window.location.href="${pageContext.servletContext.contextPath}"+data;
          alert("登录成功,欢迎您!");
          }
          else {
            alert("账号密码有误，请重新输入");
          }
          <%--window.location.href= ${pageContext.servletContext.contextPath}+data;--%>
        },
        onerror: function (response){
          alert(response)
        }
      })
    }
  </script>

  </body>
</html>
