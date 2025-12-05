
<%@ page import="project.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 淡水
  Date: 2023/11/24
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页面</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

</head>
<body>

<h1>学生页面</h1>

<button onclick="showStudentInfo()">查看信息</button>
<div id="studentInfo">
    <p>学生ID: <span id="studentId">${student.studentId}</span></p>
    <p>姓名: <span id="studentName">${student.studentName}</span></p>
    <p>年龄: <span id="age">${student.age}</span></p>
    <p>专业班级: <span id="majorClass">${student.majorClass}</span></p>
    <p>性别: <span id="studentSex">${student.studentSex}</span></p>
    <p>身份证号: <span id="idCardNum">${student.idCardNum}</span></p>
    <p>手机号: <span id="phoneNumber">${student.phoneNumber}</span></p>

</div>
<button onclick="navigateToEditPage()"编辑信息</button>
<script>
    function showStudentInfo() {
        $.ajax({
            type: "GET",
            url: "getStudentInfo",
            data: { action: "getStudentInfo" }, // 通过 data 属性传递参数
            success: function (data) {
                console.log(data);

                // 处理返回的学生信息，更新页面
                $("#studentInfo").html(
                    "<p>学生ID: " + data.studentId + "</p>" +
                    "<p>姓名: " + data.studentName + "</p>" +
                    "<p>年龄: " + data.age + "</p>" +
                    "<p>专业班级: " + data.majorClass + "</p>" +
                    "<p>性别: " + data.studentSex + "</p>" +
                    "<p>身份证号: " + data.idCardNum + "</p>" +
                    "<p>手机号: " + data.phoneNumber + "</p>"
                );
            },
            error: function () {
                alert("获取学生信息失败");
            }
        });
    }
    function navigateToEditPage() {

        window.location.href = "editStudent.jsp";
    }
</script>


</body>
</html>
