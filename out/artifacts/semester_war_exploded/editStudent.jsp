<%@ page import="project.service.StudentService" %>
<%@ page import="project.service.Impl.StudentServiceImpl" %>
<%@ page import="project.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student Information</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<body>

<h1>编辑学生信息</h1>

<%--<%--%>
<%--    // Retrieve studentId from request parameters--%>
<%--    String studentId = request.getParameter("id");--%>
<%--    // Fetch student information based on studentId--%>
<%--    StudentService studentService = new StudentServiceImpl();--%>
<%--    Student student = studentService.getStudentInfoById(studentId);--%>
<%--%>--%>
<%

    // 从会话中获取值
    String username = (String) session.getAttribute("id");

%>


<label for="studentName">Name:</label>
<input type="text" id="studentName" name="studentName" required>
<br>

<label for="age">Age:</label>
<input type="number" id="age" name="age" required>
<br>

<label for="majorClass">Major Class:</label>
<input type="text" id="majorClass" name="majorClass" required>
<br>

<label for="studentSex">Sex:</label>
<input type="text" id="studentSex" name="studentSex" required>
<br>

<label for="idCardNum">ID Card Number:</label>
<input type="text" id="idCardNum" name="idCardNum" required>
<br>

<label for="phoneNumber">Phone Number:</label>
<input type="text" id="phoneNumber" name="phoneNumber" required>
<br>

<label for="studentPwd">New Password:</label>
<input type="password" id="studentPwd" name="studentPwd" required>
<span class="password-toggle" onclick="togglePassword('studentPwd')">Show Password</span>
<br>

<input type="submit" value="Save" onclick="postChangeInfo()">


<script>


    // Function to toggle password visibility
    function togglePassword(fieldId) {
        var field = document.getElementById(fieldId);
        if (field.type === "password") {
            field.type = "text";
        } else {
            field.type = "password";
        }
    }
    function postChangeInfo(){
        var studentid ="<%= username %>";

        $.ajax({
            type: "POST",
            url: "${pageContext.servletContext.contextPath}/updateStudent",
            data: {
                studentId: studentid,
                studentName: $("#studentName").val(),
                age: $("#age").val(),
                majorClass: $("#majorClass").val(),
                studentSex: $("#studentSex").val(),
                idCardNum: $("#idCardNum").val(),
                phoneNumber: $("#phoneNumber").val(),
                studentPwd: $("#studentPwd").val()
            },
            success: function (response) {
                console.log("Changes saved successfully");

                window.location.href = "student.jsp";
            },
            error: function () {
                alert("Failed to save changes");
            }
        });
    }
</script>


</body>
</html>
