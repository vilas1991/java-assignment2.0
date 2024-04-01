package com.webapp.backend.grpc;


import com.webapp.backend.repository.AddressRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressServiceImpl extends com.webapp.backend.grpc.AddressServiceGrpc.AddressServiceImplBase {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void createAddress(com.webapp.backend.grpc.Address.CreateAddressRequest request, StreamObserver<com.webapp.backend.grpc.Address.AddressResponse> responseObserver) {
        com.webapp.backend.responce.Address address = new com.webapp.backend.responce.Address();
        address.setAddressLineFirst(request.getAddressLineFirst());
        address.setAddressLineSecond(request.getAddressLineSecond());
        address.setPostalCode(request.getPostalCode());
        address = addressRepository.save(address);

        com.webapp.backend.grpc.Address.AddressResponse addressResponse = com.webapp.backend.grpc.Address.AddressResponse.newBuilder().setAddressId(address.getAddressId()).setAddressLineFirst(address.getAddressLineFirst()).setAddressLineSecond(address.getAddressLineSecond()).setPostalCode(address.getPostalCode()).build();
        responseObserver.onNext(addressResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getAddress(com.webapp.backend.grpc.Address.GetAddressRequest request, StreamObserver<com.webapp.backend.grpc.Address.AddressResponse> responseObserver) {
        Optional<com.webapp.backend.responce.Address> addressOptional = addressRepository.findById(request.getAddressId());
        com.webapp.backend.responce.Address address= addressOptional.get();
        com.webapp.backend.grpc.Address.AddressResponse addressResponse = com.webapp.backend.grpc.Address.AddressResponse.newBuilder().setAddressId(address.getAddressId()).setAddressLineFirst(address.getAddressLineFirst()).setAddressLineSecond(address.getAddressLineSecond()).setPostalCode(address.getPostalCode()).build();
        responseObserver.onNext(addressResponse);
        responseObserver.onCompleted();
    }
}