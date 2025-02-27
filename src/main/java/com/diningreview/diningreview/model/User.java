package com.diningreview.diningreview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String displayName;
    
    private String city;
    private String state;
    private String zipcode;
    
    private Boolean interestedInPeanutAllergy;
    private Boolean interestedInEggAllergy;
    private Boolean interestedInDairyAllergy;
}
