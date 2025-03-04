package com.diningreview.diningreview.controller;

import com.diningreview.diningreview.model.DiningReview;
import com.diningreview.diningreview.model.DiningReviewStatus;
import com.diningreview.diningreview.repository.DiningReviewRepository;
import com.diningreview.diningreview.repository.RestaurantRepository;
import com.diningreview.diningreview.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public DiningReviewController(
        DiningReviewRepository diningReviewRepository,
        RestaurantRepository restaurantRepository,
        UserRepository userRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> submitReview(@RequestBody DiningReview review) {
        if (!restaurantRepository.existsById(review.getId()) ||
            !userRepository.existsByDisplayName(review.getDisplayName())) {
            return ResponseEntity.badRequest().body("Invalid restaurant or user");
        }
        review.setStatus(DiningReviewStatus.PENDING);
        return ResponseEntity.ok(diningReviewRepository.save(review));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<DiningReview>> getPendingReviews() {
        return ResponseEntity.ok(diningReviewRepository.findByStatus(DiningReviewStatus.PENDING));
    }
}
