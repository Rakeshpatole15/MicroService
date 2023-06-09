package com.user.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.hotel.services.HotelService;
import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;

import ch.qos.logback.classic.Logger;


@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	private HotelService hotelService;
	
	private org.slf4j.Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	
	}
    
	//get Single user by id
	@Override
	public User getUsre(int userId) {
		
		//get User From Database with the help of User Repository
	User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! :" + userId));
	//fetch the rating of the above user from RATING SRVICE
    //	http://localhost:8082/ratings/users/2
	Rating[] ratingsOfUser=  restTemplate.getForObject("http://localhost:8082/ratings/users/"+user.getUserId(), Rating[].class);
	
	logger.info("{} ",ratingsOfUser);
	
    List<Rating> ratings = Arrays.stream(ratingsOfUser).toList(); 

	 List<Rating> ratingList = ratings.stream().map(rating -> {
         //api call to hotel service to get the hotel
         //http://localhost:8081/hotels/1
         ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8081/hotels/"+rating.getHotelId(), Hotel.class);
         Optional<com.lcwd.hotel.entities.Hotel> hotel = hotelService.getHotel(rating.getHotelId());
         logger.info("response status code: {} ",forEntity.getStatusCode());
         //set the hotel to rating
         rating.setHotel(hotel);
         //return the rating
         return rating;
     }).collect(Collectors.toList());

     user.setRatings(ratingList);
	//http://localhost:8081/hotels/1
	
	//List<Rating> ratings =Arrays.Object(forObject).toList();
	
	//user.setRatings(ratingsOfUSer)+
	//return user;
//	Rating[] ratingOfUser=restTemplate.getForObject("http://localhost:8082/ratings/users/"+user.getUserId(),Rating[].class);
//	
//	System.out.println(ratingOfUser);
     return user;
	}

	@Override
	public String deletUser(int userId) {
		
		 userRepository.deleteById(userId);
		 return "User Deleted Suseccsully...";
	}

	@Override
	public User updateUser( User user, int userId ) {
		 userRepository.save(user);
		 return user;
	}

}
