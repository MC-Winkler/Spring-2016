package edu.elon.ioc.dao;

import edu.elon.ioc.dto.Employer;
import org.springframework.stereotype.Component;

@Component
public class EmployerDAOImpl implements EmployerDAO {

  /* (non-Javadoc)
 * @see edu.elon.ioc.dao.EmployerDAO#getEmployer(long)
 */
public Employer getEmployer(long employerId) {
    Employer employer = new Employer();
    employer.setEmployerId(employerId);
    employer.setName("coreservlets.com");
    employer.setAddress("6 Meadowsweet Ct., Suite B1, Reisterstown, MD 21136-6020");
    return employer;
  }

}
