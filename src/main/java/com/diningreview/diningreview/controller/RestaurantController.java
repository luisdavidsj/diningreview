package com.diningreview.diningreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diningreview.diningreview.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
}
