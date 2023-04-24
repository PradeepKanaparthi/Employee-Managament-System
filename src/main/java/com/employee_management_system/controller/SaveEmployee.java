package com.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee_management_system.dao.AdminDao;
import com.employee_management_system.dao.EmployeeDao;
import com.employee_management_system.dto.Admin;
import com.employee_management_system.dto.Employee;

@WebServlet("/saveEmployee")
public class SaveEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Admin admin =(Admin) session.getAttribute("admin");
		if(admin!=null) {
		String name = req.getParameter("employeeName");
		String email = req.getParameter("employeeEmail");
	    String phoneNumber1 = req.getParameter("employeePhoneNumber");
	    
	    long phoneNumber = Long.parseLong(phoneNumber1);
	    
	    Employee employee = new Employee();
	    employee.setEmployeeName(name);
	    employee.setEmployeeEmail(email);
	    employee.setEmployeePhoneNumber(phoneNumber);
	    employee.setAdmin(admin);
	    
	    new EmployeeDao().saveEmployee(employee);
	    
	    List<Employee> employees = admin.getEmployees();
		employees.add(employee);
		new AdminDao().updateAdmin(admin);
	    
	    resp.sendRedirect("Dashboard.jsp");
	    
		}else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
