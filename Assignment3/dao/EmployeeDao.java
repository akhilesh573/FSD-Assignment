package com.akhilesh.spring_orm_hibernate.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.akhilesh.spring_orm_hibernate.entities.Employee;

import java.util.List;

public class EmployeeDao {

	
	private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}
	
	// get all employee
	public List<Employee> getAllEmployees(){
		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
		return employees;
	}
	
	// get employees by Id
	public Employee getEmployeeById(int Id) {
		Employee employee = hibernateTemplate.get(Employee.class, Id);
		return employee;
		
	}
	
	//update employee
	@Transactional
	public void updateEmployee(Employee updateEmployee) {
		hibernateTemplate.update(updateEmployee);
	}
	
	//delete employee
	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
