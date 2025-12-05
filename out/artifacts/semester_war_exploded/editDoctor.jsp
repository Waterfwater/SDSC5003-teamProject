<%--
  Created by IntelliJ IDEA.
  User: xjLi
  Date: 2023/12/1
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="project.service.DoctorService" %>
<%@ page import="project.service.Impl.DoctorServiceImpl" %>
<%@ page import="project.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Doctor Information</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

<h1>编辑医生信息</h1>

<%

    // 从会话中获取值
    String username = (String) session.getAttribute("id");

%>


    <label for="doctorName">Name:</label>
    <input type="text" id="doctorName" name="doctorName" required>
    <br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required>
    <br>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required>
    <br>

    <label for="doctorSex">Sex:</label>
    <input type="text" id="doctorSex" name="doctorSex"  required>
    <br>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title"  required>
    <br>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber"  required>
    <br>

    <label for="doctorPwd">Password:</label>
    <input type="password" id="doctorPwd" name="doctorPwd" required>
    <span class="password-toggle" onclick="togglePassword('doctorPwd')">Show Password</span>
    <br>

    <input type="submit" value="Save" onclick="postChangeInfo()">

<script>

    function togglePassword(fieldId) {
        var field = document.getElementById(fieldId);
        if (field.type === "password") {
            field.type = "text";
        } else {
            field.type = "password";
        }
    }

    function postChangeInfo(){
        var doctorid ="<%= username %>";

        $.ajax({
            type: "POST",
            url: "${pageContext.servletContext.contextPath}/updateDoctor",
            data: {
                doctorId: doctorid,
                doctorName: $("#doctorName").val(),
                age: $("#age").val(),
                department: $("#department").val(),
                doctorSex: $("#doctorSex").val(),
                title: $("#title").val(),
                phoneNumber: $("#phoneNumber").val(),
                doctorPwd: $("#doctorPwd").val()
            },
            success: function (response) {
                console.log("Changes saved successfully");
                window.location.href = "doctor.jsp";
            },
            error: function () {
                alert("Failed to save changes");
            }
        });
    }
</script>

</body>
</html>

