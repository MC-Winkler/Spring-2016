package edu.elon.ioc.dao;


import edu.elon.ioc.dto.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

  /* (non-Javadoc)
 * @see edu.elon.ioc.dao.EmployeeDAO#getEmployee(long)
 */
public Employee getEmployee(long employeeId) {
    Employee employee = new Employee();
    employee.setEmployeeId(employeeId);
    employee.setFirstName("Marty");
    employee.setLastName("Hall");
    return employee;
  }

}
