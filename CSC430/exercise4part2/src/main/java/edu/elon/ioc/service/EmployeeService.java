package edu.elon.ioc.service;

import edu.elon.ioc.dao.EmployeeDAO;
import edu.elon.ioc.dto.Employee;

public interface EmployeeService {

	void setEmployeeDAO(EmployeeDAO employeeDAO);

	Employee getEmployee(long employeeId);

}