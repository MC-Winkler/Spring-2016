package edu.elon.ioc.dto;

public class Employer {
  private String address;
  private long employerId;
  private String name;

  public String getAddress() {
    return address;
  }

  public long getEmployerId() {
    return employerId;
  }

  public String getName() {
    return name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setEmployerId(long employerId) {
    this.employerId = employerId;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    String string = new String();
    string += "  employerId=" + employerId + "\n";
    string += "  name=" + name + "\n";
    string += "  address=" + address + "\n";
    return string;
  }

}
