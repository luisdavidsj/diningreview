package com.diningreview.diningreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diningreview.diningreview.repository.DiningReviewRepository;
import com.diningreview.diningreview.repository.RestaurantRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final DiningReviewRepository diningReviewRepository;
	private final RestaurantRepository restaurantRepository;
	
	public AdminController(
			DiningReviewRepository diningReviewRepository,
			RestaurantRepository restaurantRepository
			) {
		this.diningReviewRepository = diningReviewRepository;
		this.restaurantRepository = restaurantRepository;
	}
}
