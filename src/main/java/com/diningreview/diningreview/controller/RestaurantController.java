package com.diningreview.diningreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diningreview.diningreview.model.Restaurant;
import com.diningreview.diningreview.repository.RestaurantRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantRepository.findByNameAndZipcode(restaurant.getName(), restaurant.getZipcode()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(restaurantRepository.save(restaurant));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Restaurant> searchRestaurants(@RequestParam String zipCode, @RequestParam String alergy) {
        return switch (alergy.toLowerCase()) {
            case "peanut" -> restaurantRepository.findByZipcodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(zipCode);
            case "egg" -> restaurantRepository.findByZipcodeAndEggScoreIsNotNullOrderByEggScoreDesc(zipCode);
            case "dairy" -> restaurantRepository.findByZipcodeAndDairyScoreIsNotNullOrderByDairyScoreDesc(zipCode);
            default -> List.of();
        };
    }
}
