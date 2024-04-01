package com.webapp.backend.grpcclient;

import com.webapp.backend.grpc.Address;
import com.webapp.backend.grpc.AddressServiceGrpc;
import com.webapp.backend.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceGrpcClient {

	@Autowired
	@Qualifier("addressServiceBlockingStub")
	AddressServiceGrpc.AddressServiceBlockingStub addressServiceBlockingStub;
	public Address.AddressResponse createAddress(UserRequest user) {

		Address.AddressResponse bookResponse = addressServiceBlockingStub
				.createAddress(Address.CreateAddressRequest.newBuilder().setAddressLineFirst(user.getAddressLineFirst()).setAddressLineSecond(user.getAddressLineSecond()).setPostalCode(user.getPostalCode()).build());

		return bookResponse;

	}

	public Address.AddressResponse getAddress(Long id) {

		Address.AddressResponse bookResponse = addressServiceBlockingStub
				.getAddress(Address.GetAddressRequest.newBuilder().setAddressId(id).build());
		return bookResponse;

	}
}