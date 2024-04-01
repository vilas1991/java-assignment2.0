package com.webapp.backend.controller;

import java.util.List;
import java.util.Optional;

import com.webapp.backend.request.LoginRequest;
import com.webapp.backend.model.User;
import com.webapp.backend.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.webapp.backend.responce.UserResponce;
import com.webapp.backend.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    UserService userService;
	
	@PostMapping("/create")
	public UserResponce createUser (@RequestBody UserRequest createUserRequest) {
		System.out.print("in user");
		return userService.createUser(createUserRequest);
	}
	
	@GetMapping("getById/{id}")
	public UserResponce getById (@PathVariable long id) {
		return userService.getById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.getUserById(id);
	
		return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		User updatedUser = userService.updateUser(id, user);
		return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//login
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        // Implement your authentication logic here
	        // For demonstration purposes, let's assume a simple username/password check
	        String uname = loginRequest.getUsername();
	        String pass = loginRequest.getPassword();
	        // Replace this with your actual authentication logic (e.g., checking credentials against a database)
	        if (uname.equals(loginRequest.getUsername()) && pass.equals(loginRequest.getPassword())) {
	            // Authentication successful
	            // You can fetch user details from the database and return them as response
	            //get id by username
	        	Long userId = userService.getUserIdByUsername(loginRequest.getUsername());
	        	//fetch user by id
	        	UserResponce userDetails = userService.getById(userId); 
	        	System.out.println(userDetails);
	        	return ResponseEntity.ok().body(userDetails);
	        } else {
	            // Authentication failed
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }
	

}
