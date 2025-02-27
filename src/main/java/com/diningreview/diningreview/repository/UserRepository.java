package com.diningreview.diningreview.repository;

import com.diningreview.diningreview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDisplayName(String displayName);
    Boolean existsByDisplayName(String displayName);
}
