package edu.elon.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.elon.ioc.service.EmployeeService;
import edu.elon.ioc.service.EmployerService;

/**
 * Exercise 2
 */
public class App {

  public static void main(String[] args) {
    //EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	  
	ApplicationContext context = new ClassPathXmlApplicationContext("edu/elon/ioc/config/application-config.xml");  
    
	EmployeeService employeeService = (EmployeeService) context.getBean("EmployeeService");
	System.out.println("Employee: ");
    System.out.println(employeeService.getEmployee(100));

    //EmployerServiceImpl employerService = new EmployerServiceImpl();
    
    EmployerService employerService = (EmployerService) context.getBean("EmployerService");
    System.out.println("Employer: ");
    System.out.println(employerService.getEmployer(100));
    
    ((ClassPathXmlApplicationContext)context).close();

  }

}
