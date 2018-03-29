package com.cdc.mitrais.jpa_one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdc.mitrais.jpa_one_to_many.entity.Department;
import com.cdc.mitrais.jpa_one_to_many.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entitymanager = emFactory.createEntityManager();
        
        entitymanager.getTransaction().begin();
        
        Employee employee1 = new Employee();
    	employee1.setEname("Satish");
    	employee1.setSalary(45000);
    	employee1.setDeg("Technical Writer");
    	
    	Employee employee2 = new Employee();
    	employee2.setEname("Krisna");
    	employee2.setSalary(45000);
    	employee2.setDeg("Technical Writer");
    	
    	Employee employee3 = new Employee();
    	employee3.setEname("Masthanvali");
    	employee3.setSalary(50000);
    	employee3.setDeg("Technical Writer");
    	
    	List<Employee> employeeList = new ArrayList<Employee>();
    	employeeList.add(employee1);
    	employeeList.add(employee2);
    	employeeList.add(employee3);
    	
    	Department department = new Department();
    	department.setName("Production & Support");
    	department.setEmployeeList(employeeList);
    	
    	entitymanager.persist(department);
        
        entitymanager.getTransaction().commit();
    }
}
