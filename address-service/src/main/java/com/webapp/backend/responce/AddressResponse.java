package com.webapp.backend.responce;


public class AddressResponse {

	private long addressId;
	private String addressLineFirst;
	private String addressLineSecond;
	private String postalCode;
	
	public AddressResponse(Address address) {
		this.addressId = address.getAddressId();
		this.addressLineFirst = address.getAddressLineFirst();
		this.addressLineSecond = address.getAddressLineSecond();
		this.postalCode = address.getPostalCode();
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
