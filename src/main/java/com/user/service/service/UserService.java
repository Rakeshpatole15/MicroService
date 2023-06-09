package com.user.service.service;

import java.util.List;

import com.user.service.entity.User;

public interface UserService {
	
	//Perform the Users Releted Operations
	
	//Create
	User saveUser(User user);
	
	//Get All Users 
	
	List<User> getAllUser();
	
	//Get Single user with UserId
	
	User getUsre(int userId);
	
	//deleting the User
	
	String deletUser (int userId);
	
	//updating the user
	
    User updateUser( User user, int userId);

}
