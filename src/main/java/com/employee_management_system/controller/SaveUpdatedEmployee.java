package com.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee_management_system.dao.EmployeeDao;
import com.employee_management_system.dto.Admin;
import com.employee_management_system.dto.Employee;

@WebServlet("/saveUpdatedEmployee")
public class SaveUpdatedEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
  
		if(admin!=null) {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        String employeeName = req.getParameter("employeeName");
        String employeeEmail = req.getParameter("employeeEmail");
        long employeePhoneNumber =Long.parseLong(req.getParameter("employeePhoneNumber"));
        
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeePhoneNumber(employeePhoneNumber);
        employee.setAdmin(admin);
        
        new EmployeeDao().updateEmployee(employee);
        
        List<Employee> employees = new EmployeeDao().getAllEmployees(admin);
        req.setAttribute("employees", employees);
        
        req.getRequestDispatcher("ViewEmployees.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
