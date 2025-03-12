package com.hotelratingsystem.ratingmicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelratingsystem.ratingmicroservice.entities.Rating;
import com.hotelratingsystem.ratingmicroservice.services.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
	}
	
	@GetMapping("/get/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
		Rating rating = ratingService.getRating(ratingId);
		return new ResponseEntity<Rating>(rating,HttpStatus.FOUND);
	}
	
	@PostMapping("/addrating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = ratingService.addRating(rating);
		return new ResponseEntity<Rating>(createdRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/getratings/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable int userId){
		List<Rating> userRatings = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<List<Rating>>(userRatings, HttpStatus.OK);
	}
	
	@GetMapping("/getratings/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		List<Rating> hotelRatings = ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(hotelRatings, HttpStatus.OK);
	}
	
}
