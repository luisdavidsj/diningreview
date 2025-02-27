package com.diningreview.diningreview.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    private Long restaurantId;

    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;

    private String commentary;
    
    @Enumerated(EnumType.STRING)
    private DiningReviewStatus status;
    
}
