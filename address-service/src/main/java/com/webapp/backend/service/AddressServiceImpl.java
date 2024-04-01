package com.webapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.backend.responce.Address;
import com.webapp.backend.repository.AddressRepository;
import com.webapp.backend.responce.AddressRequest;
import com.webapp.backend.responce.AddressResponse;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(AddressRequest createAddressRequest) {
		
		Address address = new Address();
		address.setAddressLineFirst(createAddressRequest.getAddressLineFirst());
		address.setAddressLineSecond(createAddressRequest.getAddressLineSecond());
		address.setPostalCode(createAddressRequest.getPostalCode());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
		
	}

	public AddressResponse getById (long id) {
		
		Address address = addressRepository.findById(id).get();
		
		return new AddressResponse(address);
	}

}
