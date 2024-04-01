package com.webapp.backend.responce;



public class AddressResponce {

	private long addressId;
	private String addressLineFirst;
	private String addressLineSecond;
	private String postalCode;
	
	
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
