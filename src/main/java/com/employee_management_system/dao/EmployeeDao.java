package com.employee_management_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.employee_management_system.dto.Admin;
import com.employee_management_system.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("alpha");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void saveEmployee(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	public List<Employee> getAllEmployees(Admin admin){
		Query query = manager.createQuery("Select e from Employee e where e.admin=?1");
		query.setParameter(1,admin);
		List employees = query.getResultList();
		return employees;
	}
	public Employee getEmployee(int employeeId) {
		return manager.find(Employee.class, employeeId);
		
	}
	public void updateEmployee(Employee employee) {
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
	}
	public void deleteEmployee(int employeeId) {
		transaction.begin();
		manager.remove(manager.find(Employee.class, employeeId));
		transaction.commit();
	}
}
