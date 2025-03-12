package com.hotelratingsystem.ratingmicroservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelratingsystem.ratingmicroservice.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String>{
	
	public List<Rating> findByUserId(int userId);
	public List<Rating> findByHotelId(String hotelId);
}
