package com.hotelratingsystem.ratingmicroservice.services;

import java.util.List;

import com.hotelratingsystem.ratingmicroservice.entities.Rating;

public interface RatingService {
	
	public List<Rating> getAllRatings();
	public Rating getRating(String id);
	public Rating addRating(Rating rating);
	public List<Rating> getRatingsByUserId(int userId);
	public List<Rating> getRatingsByHotelId(String hotelId);
}
