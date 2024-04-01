package com.webapp.backend.request;

public class UserRequest {
	
	 private Long id;
	 private String username;
	 private String password;
	 private String firstName;
	 private String lastName;
	 private String dob;   
	 private String postalCode;

	public String getAddressLineFirst() {
		return addressLineFirst;
	}

	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}

	private String addressLineFirst;

	public String getAddressLineSecond() {
		return addressLineSecond;
	}

	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}

	private String addressLineSecond;
	 private String phoneNumber;
	 private String valid;
	 private String role;
	 private long addressId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	 
	 

}
