package com.webapp.backend.service;

import java.util.List;
import java.util.Optional;

import com.webapp.backend.grpc.Address;
import com.webapp.backend.grpcclient.AddressServiceGrpcClient;
import com.webapp.backend.model.User;
import com.webapp.backend.repository.UserRepository;
import com.webapp.backend.request.UserRequest;
import com.webapp.backend.responce.AddressResponce;
import com.webapp.backend.responce.UserResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;



import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	WebClient webClient;

	@Autowired
	AddressServiceGrpcClient addressServiceGrpcClient;
	public UserResponce createUser(UserRequest userRequest) {

		User user = new User();
		
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setDob(userRequest.getDob());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setValid(userRequest.getValid());
		user.setRole(userRequest.getRole());
		
		user.setAddressId(userRequest.getAddressId());
		Address.AddressResponse address = addressServiceGrpcClient.createAddress(userRequest);
		user.setAddressId(address.getAddressId());
		user = userRepository.save(user);
		UserResponce userResponse = new UserResponce(user);

		AddressResponce addressResponce = new AddressResponce();
		addressResponce.setAddressId(address.getAddressId());
		addressResponce.setAddressLineFirst(address.getAddressLineFirst());
		addressResponce.setAddressLineSecond(address.getAddressLineSecond());
		addressResponce.setPostalCode(address.getPostalCode());
		userResponse.setAddressResponse(addressResponce);

		
		return userResponse;
		
		
	}
	
	public UserResponce getById (long id) {
		User user = userRepository.findById(id).get();
		UserResponce userResponse = new UserResponce(user);
		Address.AddressResponse address = addressServiceGrpcClient.getAddress(user.getAddressId());
		AddressResponce addressResponce = new AddressResponce();
		addressResponce.setAddressId(address.getAddressId());
		addressResponce.setAddressLineFirst(address.getAddressLineFirst());
		addressResponce.setAddressLineSecond(address.getAddressLineSecond());
		addressResponce.setPostalCode(address.getPostalCode());
		userResponse.setAddressResponse(addressResponce);
		return userResponse;
	}
	
	public AddressResponce getAddressById (long addressId) {
		Mono<AddressResponce> addressResponse = 
				webClient.get().uri("/getById/" + addressId)
		.retrieve().bodyToMono(AddressResponce.class);
		
		return addressResponse.block();
	}
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
		
	}


	@Override
	public User updateUser(Long id, User user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		}
		return null; // or throw an exception indicating user not found
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	 public Long getUserIdByUsername(String username) {
        return userRepository.findUserIdByUsername(username);
    }

	
	
}
