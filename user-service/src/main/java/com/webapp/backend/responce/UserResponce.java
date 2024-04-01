package com.webapp.backend.responce;


import com.webapp.backend.model.User;
import com.webapp.backend.responce.AddressResponce;

public class UserResponce {
	 private Long id;
	 private String username;
	 private String password;
	 private String firstName;
	 private String lastName;
	 private String dob;   
	 private String phoneNumber;
	 private String valid;
	 private String role;
//	 private long addressId;
	 
	 private AddressResponce addressResponse;
	 
	 
	 public UserResponce(User user) {
			
			this.id = user.getId();
			this.username = user.getUsername();
			this.password = user.getPassword();
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.dob = user.getDob();
			this.phoneNumber = user.getPhoneNumber();
			this.valid = user.getValid();
			this.role = user.getRole();
//			this.addressId = user.getAddressId();
		}
	 
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
//	public long getAddressId() {
//		return addressId;
//	}
//	public void setAddressId(long addressId) {
//		this.addressId = addressId;
//	}
	
	public AddressResponce getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponce addressResponse) {
		this.addressResponse = addressResponse;
	}
	 

}
