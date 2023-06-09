package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.User;
import com.user.service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create 
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	//geting single user
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId){
		
		User user=userService.getUsre(userId);
		return ResponseEntity.ok(user);
		
	}
	
	//Getting all Users
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser=userService.getAllUser();
		return ResponseEntity.ok(allUser);
	} 
	
   //Deleting the User
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deletUser(@PathVariable int userId){
		String user=userService.deletUser(userId);
		return ResponseEntity.ok("Deleted User");
	}
	
	//Updating the User
	
	@PutMapping("updateUser/{userId}")
	public ResponseEntity<String>  updateUser(@PathVariable int userId, @RequestBody User user){
	   userService.saveUser(user);
	   return ResponseEntity.ok("User Updeted Seccsefully");
	   
	    
	}
	

}
