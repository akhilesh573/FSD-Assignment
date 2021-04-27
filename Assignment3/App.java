package com.akhilesh.spring_orm_hibernate;


import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akhilesh.spring_orm_hibernate.dao.EmployeeDao;
import com.akhilesh.spring_orm_hibernate.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
        
//        Employee newEmployee = new Employee();
//        newEmployee.setId(1);
//        newEmployee.setName("Abhishek");
//        newEmployee.setEmail("abhishek@gmail.com");
//        
//        int result =  dao.addEmployee(newEmployee);
//        System.out.println("("+result+") rows inserted...");
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	System.out.println("**************");
        	System.out.println("PRESS 1: Add Employee");
        	System.out.println("PRESS 2: Get All Employee");
        	System.out.println("PRESS 3: Get Employee by Id");
        	System.out.println("PRESS 4: Delete Employee");
        	System.out.println("PRESS 5: Update Employee");
        	System.out.println("PRESS 6: Exit");
        	System.out.println("**************");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
        		switch (input) {
        		case 1:
        			// add employee
        			System.out.println("Enter employee id: ");
        			int id = Integer.parseInt(br.readLine());
        			
        			System.out.println("Enter employee name: ");
        			String name = br.readLine();
        			
        			System.out.println("Enter employee email: ");
        			String email = br.readLine();
        			
        			Employee newEmployee = new Employee();
        			newEmployee.setId(id);
        			newEmployee.setName(name);
        			newEmployee.setEmail(email);
        			
        			dao.addEmployee(newEmployee);
        			System.out.println("Employee inserted successfully");
        			
        			break;
        			
        		case 2:
        			//get all 
        			List<Employee> employees= dao.getAllEmployees();
        			for(Employee employee: employees) {
        				System.out.println(employee);
        			}
        			break;
        			
        		case 3:
        			// get employee by Id
        			System.out.println("Enter Id to get full information..");
        			int id4= Integer.parseInt(br.readLine());
        			Employee employee4 = dao.getEmployeeById(id4);
        			System.out.println(employee4);
        			break;
        			
        		case 4:
        			// To delete employee details
        			System.out.println("enter employee Id to delete record..");
        			int id5 = Integer.parseInt(br.readLine());
        			dao.deleteEmployee(id5);
        			System.out.println("Record deleted");
        			
        			break;
        			
        		case 5:
        			//update employee
        			System.out.println("Enter employee id: ");
        			int EmpId = Integer.parseInt(br.readLine());
        			
        			System.out.println("Enter employee name: ");
        			String EmpNmae = br.readLine();
        			
        			System.out.println("Enter employee email: ");
        			String Email = br.readLine();
        			break;
        		case 6:
        			System.out.println("Thank you......!!!!!");
        			boolean flag = false;
        			
        			default:
        				break;
        			
        	    }
        	} catch (Exception e) {
        		System.out.println("Invalid Selection");
        	}
        }
        
        		
        
        
    }
}



