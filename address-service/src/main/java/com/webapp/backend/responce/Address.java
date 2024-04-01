package com.webapp.backend.responce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private String addressLineFirst;
	private String addressLineSecond;
	private String postalCode;

	
	
	public Address() {
	
		// TODO Auto-generated constructor stub
	}



	public Address(long addressId, String addressLineFirst, String addressLineSecond, String postalCode) {
		super();
		this.addressId = addressId;
		this.addressLineFirst = addressLineFirst;
		this.addressLineSecond = addressLineSecond;
		this.postalCode = postalCode;
	}



	public long getAddressId() {
		return addressId;
	}



	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}



	public String getAddressLineFirst() {
		return addressLineFirst;
	}



	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}



	public String getAddressLineSecond() {
		return addressLineSecond;
	}



	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	

}
