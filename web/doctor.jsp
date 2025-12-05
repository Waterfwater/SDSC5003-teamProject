<%--
  Created by IntelliJ IDEA.
  User: xjLi
  Date: 2023/12/1
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="project.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生页面</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

<h1>医生页面</h1>

<button onclick="showDoctorInfo()">查看信息</button>
<div id="doctorInfo">
    <p>医生ID: <span id="doctorId">${doctor.doctorId}</span></p>
    <p>姓名: <span id="doctorName">${doctor.doctorName}</span></p>
    <p>年龄: <span id="age">${doctor.age}</span></p>
    <p>科室: <span id="department">${doctor.department}</span></p>
    <p>性别: <span id="doctorSex">${doctor.doctorSex}</span></p>
    <p>职称: <span id="title">${doctor.title}</span></p>
    <p>手机号: <span id="phoneNumber">${doctor.phoneNumber}</span></p>

</div>
<button onclick="navigateToEditPage()">编辑信息</button>
<script>
    function showDoctorInfo() {
        $.ajax({
            type: "GET",
            url: "getDoctorInfo",
            data: { action: "getDoctorInfo" },
            success: function (data) {
                console.log(data);

                $("#doctorInfo").html(
                    "<p>医生ID: " + data.doctorId + "</p>" +
                    "<p>姓名: " + data.doctorName + "</p>" +
                    "<p>年龄: " + data.age + "</p>" +
                    "<p>科室: " + data.department + "</p>" +
                    "<p>性别: " + data.doctorSex + "</p>" +
                    "<p>职称: " + data.title + "</p>" +
                    "<p>手机号: " + data.phoneNumber + "</p>"
                );
            },
            error: function () {
                alert("获取医生信息失败");
            }
        });
    }
    function navigateToEditPage() {

        window.location.href = "editDoctor.jsp?" ;
    }
</script>

</body>
</html>

