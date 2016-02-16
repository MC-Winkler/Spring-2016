package edu.elon.ioc.service;

import edu.elon.ioc.dao.EmployerDAO;
import edu.elon.ioc.dto.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("EmployerService")
public class EmployerServiceImpl implements EmployerService {

  private EmployerDAO employerDAO;
 
  @Autowired  
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
