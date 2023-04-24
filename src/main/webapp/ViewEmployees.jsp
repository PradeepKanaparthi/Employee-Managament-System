<%@page import="com.employee_management_system.dto.Admin"%>
<%@page import="com.employee_management_system.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	html{
		overflow: hidden;
	}
	body{
		display: flex;
		flex-direction: column;
		align-items: center;
		font-family: 'Poppins', sans-serif;
		width: 100vw;
	}
	h1{
		font-size: 3rem;
	}
	table{
		border:0;
		font-size: 1.2rem;
	}
	th{
		background-color:salmon;
		border:0;
		color:#fff;
		padding: 1rem;
	}
	tr{
		border: 0;
		border-bottom: 3px solid #565656;
	}
	td{
		border: 0;
		padding: 1rem;
	}
	a{
		padding:.5em 1em;
		font-size: 1.3rem;
		text-decoration: none;
		color: #202020;
		margin: .5rem 2rem;
		font-weight: 600;
	}
	a:hover{
		color: salmon;
	}
	div{
		width:100%;
		position:fixed;
	}
</style>
<body>
    <%
    Admin admin = (Admin) session.getAttribute("admin");
    if(admin!=null){
    List <Employee> employees = (List) request.getAttribute("employees"); %>
    <h1>Employees List</h1>
    <table border="" cellPadding="10px" cellSpacing="0">
         <tr>
            <th>Emoloyee_Id</th>
            <th>Employee_Name</th>
            <th>Employee_Email</th>
            <th>Employee_PhoneNumber</th>
            <th>Update_Employee</th>
            <th>Delete_Employee</th>
         </tr>
         <%for(Employee employee : employees){ %>
         <tr>
             <td><%= employee.getEmployeeId() %></td>
             <td><%= employee.getEmployeeName() %></td>
             <td><%= employee.getEmployeeEmail() %></td>
             <td><%= employee.getEmployeePhoneNumber() %></td>
             <td><a href="updateEmployee?employeeId=<%= employee.getEmployeeId() %>">Update</a></td>
             <td><a href="deleteEmployee?employeeId=<%= employee.getEmployeeId()%>">Delete</a></td>
         </tr>
         <% } %>
    </table>
    <div><a href="Dashboard.jsp">Home</a></div>
    
    <%}else{
		response.sendRedirect("AdminLogin.jsp");
	}%>
</body>
</html>