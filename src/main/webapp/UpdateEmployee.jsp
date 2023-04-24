<%@page import="com.employee_management_system.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
html {
	overflow: hidden;
}
body {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100vw;
	height: 90vh;
	font-family: 'Poppins', sans-serif;
}
form {
	width: 40%;
	height: max-content;
	border: 3px solid #565656;
	border-radius: 20px;
	padding: 1rem;
}
input {
	width:90%;
	padding: .5em 1em;
	font-size: 1.3rem;
	font-weight: 500;
	border: 0;
	border-bottom: 3px solid #565656;
}
.btn {
	width: 30%;
	border: 3px solid #565656;
	border-radius: 50px;
	text-decoration: none;
	color: #303030;
	margin-top: 2rem;
	font-weight: 600;
}
.btn:hover {
	background-color: salmon;
	border: 3px solid salmon;
	color: #fff;
}
h2 {
	font-size: 2rem;
}
</style>
<body>
      <% Employee employee = (Employee) request.getAttribute("employee"); %>
      
     <form action="saveUpdatedEmployee" method="post">
     <h2>Update Student</h2>
       <input type="text" name="employeeId" value="<%= employee.getEmployeeId()%>" readonly="readonly"><br><br>
       <input type="text" name="employeeName" value="<%= employee.getEmployeeName() %>"><br><br>
       <input type="email" name="employeeEmail" value="<%= employee.getEmployeeEmail() %>"><br><br>
       <input type="text" name="employeePhoneNumber" value="<%= employee.getEmployeePhoneNumber() %>"><br><br>
       <input type="submit" value="Update" class="btn">
    </form>
</body>
</html>