package com.diningreview.diningreview.controller;

import com.diningreview.diningreview.model.AdminReviewAction;
import com.diningreview.diningreview.model.DiningReview;
import com.diningreview.diningreview.model.DiningReviewStatus;
import com.diningreview.diningreview.repository.DiningReviewRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {
    private final DiningReviewRepository diningReviewRepository;

    public AdminController(DiningReviewRepository diningReviewRepository) {
        this.diningReviewRepository = diningReviewRepository;
    }
    
    @PutMapping("/reviews/{reviewId}/approve")
    public ResponseEntity<?> reviewAction(@PathVariable Long reviewId, @RequestBody AdminReviewAction action) {
        Optional<DiningReview> reviewOptional = diningReviewRepository.findById(reviewId);
        
        if (reviewOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DiningReview review = reviewOptional.get();
        review.setStatus(action.isApproved() ? DiningReviewStatus.APPROVED : DiningReviewStatus.REJECTED);
        diningReviewRepository.save(review);

        return ResponseEntity.ok(review);
    }
}
