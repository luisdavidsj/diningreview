package com.diningreview.diningreview.repository;

import com.diningreview.diningreview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipcode(String name, String zipcode);
    List<Restaurant> findByZipcodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(String zipcode);
    List<Restaurant> findByZipcodeAndEggScoreIsNotNullOrderByEggScoreDesc(String zipcode);
    List<Restaurant> findByZipcodeAndDairyScoreIsNotNullOrderByDairyScoreDesc(String zipcode);
}
