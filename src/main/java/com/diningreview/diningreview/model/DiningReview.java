package com.diningreview.diningreview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "DINING_REVIEW")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DISPLAYNAME", nullable = false, unique = true)
    private String displayName;

    @Column(name = "RESTAURANTID")
    private Long restaurantId;

    @Column(name = "PEANUTSCORE")
    private Integer peanutScore;

    @Column(name = "EGGSCORE")
    private Integer eggScore;

    @Column(name = "DAIRYSCORE")
    private Integer dairyScore;

    @Column(name = "COMENTARY")
    private String commentary;
    
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private DiningReviewStatus status;
    
}
