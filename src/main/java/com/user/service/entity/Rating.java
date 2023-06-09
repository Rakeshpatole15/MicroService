package com.user.service.entity;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
	
	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
    
	
	private Optional<com.lcwd.hotel.entities.Hotel> hotel;


	public int getRatingId() {
		return ratingId;
	}


	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Optional<com.lcwd.hotel.entities.Hotel> getHotel() {
		return hotel;
	}


	public void setHotel(Optional<com.lcwd.hotel.entities.Hotel> hotel2) {
		this.hotel = hotel2;
	}


	public Rating(int ratingId, int userId, int hotelId, int rating, String feedback, Optional<com.lcwd.hotel.entities.Hotel> hotel) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel = hotel;
	}


	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
				+ ", feedback=" + feedback + ", hotel=" + hotel + "]";
	}
	
    
	

}
