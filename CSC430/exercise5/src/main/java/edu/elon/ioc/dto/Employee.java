package edu.elon.ioc.dto;

public class Employee {
  private long employeeId;
  private String firstName;
  private String lastName;

  /**
   * @return the employeeId
   */
  public long getEmployeeId() {
    return employeeId;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param employeeId the employeeId to set
   */
  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    String string = new String();
    string += "  employeeId=" + employeeId + "\n";
    string += "  lastName=" + lastName + "\n";
    string += "  firstName=" + firstName + "\n";
    return string;
  }

}
