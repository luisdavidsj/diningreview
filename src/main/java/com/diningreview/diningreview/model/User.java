package com.diningreview.diningreview.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DISPLAYNAME", nullable = false, unique = true)
    private String displayName;
    
    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIPCODE")
    private String zipcode;
    
    @Column(name = "PEANUTALLERGY")
    private Boolean interestedInPeanutAllergy;

    @Column(name = "EGGALLERGY")
    private Boolean interestedInEggAllergy;

    @Column(name = "DAIRYALLERGY")
    private Boolean interestedInDairyAllergy;
}
