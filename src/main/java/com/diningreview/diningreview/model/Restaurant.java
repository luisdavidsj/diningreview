package com.diningreview.diningreview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "RESTAURANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "PEANUTSCORE")
    private Double peanutScore;

    @Column(name = "EGGSCORE")
    private Double eggScore;

    @Column(name = "DAIRYSCORE")
    private Double dairyScore;

    @Column(name = "OVERALLSCORE")
    private Double overallScore;
}
