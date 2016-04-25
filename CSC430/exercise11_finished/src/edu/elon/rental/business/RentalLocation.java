package edu.elon.rental.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="rentallocations")
public class RentalLocation {
	
	@Size(min=1, message="This input field cannot be left blank")
	private String address1;
	
	private String address2;
	
	@Size(min=1, message="This input field cannot be left blank")
	private String city;
	
	@Size(min=1, message="This input field cannot be left blank")
	private String name;
	
	@Size(min=1, message="This input field cannot be left blank")
	private String postalCode;
	
	@Id
	@GeneratedValue
	private Integer rentalLocationId;
	
	@Size(min=1, message="This input field cannot be left blank")
	private String state;
	
	public RentalLocation() {
	 // intentionally empty
	 }
	 public String getAddress1() {
	 return address1;
	 }
	 public String getAddress2() {
	 return address2;
	 }
	 public String getCity() {
	 return city;
	 }
	 public String getName() {
	 return name;
	 }
	 public String getPostalCode() {
	 return postalCode;
	 }
	 public Integer getRentalLocationId() {
	 return rentalLocationId;
	 }
	 public String getState() {
	 return state;
	 }
	 public void setAddress1(String address1) {
	 this.address1 = address1;
	 }
	 public void setAddress2(String address2) {
	 this.address2 = address2;
	 }
	 public void setCity(String city) {
	 this.city = city;
	 }
	 public void setName(String name) {
	 this.name = name;
	 }
	 public void setPostalCode(String postalCode) {
	 this.postalCode = postalCode;
	 }
	 public void setRentalLocationId(Integer rentalLocationId) {
	 this.rentalLocationId = rentalLocationId;
	 }
	 public void setState(String state) {
	 this.state = state;
	 }
	 @Override
	 public String toString() {
	 return "RentalLocation [rentalLocationId=" + rentalLocationId + ", name="
	 + name + ", address1=" + address1 + ", address2=" + address2
	 + ", city=" + city + ", state=" + state + ", postalCode="
	 + postalCode + "]";
	 }
	}