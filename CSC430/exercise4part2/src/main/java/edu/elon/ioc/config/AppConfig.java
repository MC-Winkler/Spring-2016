package edu.elon.ioc.config;

import org.springframework.context.annotation.*;

import edu.elon.ioc.dao.EmployeeDAOImpl;
import edu.elon.ioc.dao.EmployerDAOImpl;
import edu.elon.ioc.service.EmployeeServiceImpl;
import edu.elon.ioc.service.EmployerServiceImpl;

@Configuration
@ComponentScan(basePackages={"edu.elon.ioc.service", "edu.elon.ioc.dao"})
public class AppConfig {

}

