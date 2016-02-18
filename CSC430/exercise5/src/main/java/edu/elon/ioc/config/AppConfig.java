package edu.elon.ioc.config;

import org.springframework.context.annotation.*;

import edu.elon.ioc.dao.EmployeeDAOImpl;
import edu.elon.ioc.dao.EmployerDAOImpl;
import edu.elon.ioc.service.EmployeeServiceImpl;
import edu.elon.ioc.service.EmployerServiceImpl;

@Configuration
public class AppConfig {

	@Bean(name="EmployeeDAO")
	public EmployeeDAOImpl employeeDAO(){
		return new EmployeeDAOImpl();
	}
	
	@Bean(name="EmployeeService")
	public EmployeeServiceImpl employeeService(){
		EmployeeServiceImpl x= new EmployeeServiceImpl();
		x.setEmployeeDAO(employeeDAO());
		return x;
	}
	
	@Bean(name="EmployerDAO")
	public EmployerDAOImpl employerDAO(){
		return new EmployerDAOImpl();
	}
	
	@Bean(name="EmployerService")
	public EmployerServiceImpl employerService(){
		return new EmployerServiceImpl(employerDAO());
	}
}

