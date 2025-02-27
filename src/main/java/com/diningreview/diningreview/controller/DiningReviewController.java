package com.diningreview.diningreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diningreview.diningreview.repository.DiningReviewRepository;
import com.diningreview.diningreview.repository.RestaurantRepository;
import com.diningreview.diningreview.repository.UserRepository;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {
	
	private final DiningReviewRepository diningReviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;
	
	
	public DiningReviewController(
			DiningReviewRepository diningReviewRepository,
			RestaurantRepository restaurantRepository,
			UserRepository userRepository
			) {
		this.diningReviewRepository = diningReviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}
}
