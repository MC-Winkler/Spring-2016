package edu.elon.ioc.service;

import edu.elon.ioc.dao.EmployeeDAO;
import edu.elon.ioc.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;

  /* (non-Javadoc)
 * @see edu.elon.ioc.service.EmployeeService#setEmployeeDAO(edu.elon.ioc.dao.EmployeeDAO)
 */
public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	this.employeeDAO = employeeDAO;
}

/* (non-Javadoc)
 * @see edu.elon.ioc.service.EmployeeService#getEmployee(long)
 */
public Employee getEmployee(long employeeId) {
    return employeeDAO.getEmployee(employeeId);
  }

}
