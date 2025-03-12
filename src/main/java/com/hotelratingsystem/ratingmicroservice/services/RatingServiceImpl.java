package com.hotelratingsystem.ratingmicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelratingsystem.ratingmicroservice.entities.Rating;
import com.hotelratingsystem.ratingmicroservice.exception.ResourceNotFoundException;
import com.hotelratingsystem.ratingmicroservice.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		List<Rating> ratings = ratingRepo.findAll();
		return ratings;
	}

	@Override
	public Rating getRating(String id) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("rating id not found"));
		
	}

	@Override
	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatingsByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Rating> ratingsByUser = ratingRepo.findByUserId(userId);
		return ratingsByUser;
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		List<Rating> hotelRatings = ratingRepo.findByHotelId(hotelId);
		return hotelRatings;
	}
	
}
