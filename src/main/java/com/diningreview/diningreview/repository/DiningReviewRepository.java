package com.diningreview.diningreview.repository;

import com.diningreview.diningreview.model.DiningReview;
import com.diningreview.diningreview.model.DiningReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
    List<DiningReview> findByStatus(DiningReviewStatus status);
    List<DiningReview> findByRestaurantIdAndStatus(Long restaurantId, DiningReviewStatus status);
}
