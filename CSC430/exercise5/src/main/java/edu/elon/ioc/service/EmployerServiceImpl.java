package edu.elon.ioc.service;

import edu.elon.ioc.dao.EmployerDAO;
import edu.elon.ioc.dto.Employer;

public class EmployerServiceImpl implements EmployerService {

  private EmployerDAO employerDAO;

  public EmployerServiceImpl(EmployerDAO employerDAO) {
	super();
	this.employerDAO = employerDAO;
}

/* (non-Javadoc)
 * @see edu.elon.ioc.service.EmployerService#getEmployer(long)
 */
public Employer getEmployer(long employerId) {
    return employerDAO.getEmployer(employerId);
  }

}
