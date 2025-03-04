package com.diningreview.diningreview.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diningreview.diningreview.model.User;
import com.diningreview.diningreview.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		if (userRepository.existsByDisplayName(user.getDisplayName())) {
			return ResponseEntity.badRequest().body("Display name already exists");
		}
		return ResponseEntity.ok(userRepository.save(user));
	}

	@GetMapping("/{displayName}")
	public ResponseEntity<?> getUserByDisplayName(@PathVariable String displayName) {
		Optional<User> user = userRepository.findByDisplayName(displayName);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{displayName}")
	public ResponseEntity<?> updateUser(@PathVariable String displayName, @RequestBody User updatedUser) {
		Optional<User> userOptional = userRepository.findByDisplayName(displayName);
		if (userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		User user = userOptional.get();
		user.setDisplayName(updatedUser.getDisplayName());
		userRepository.save(user);

		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{displayName}")
	public ResponseEntity<?> deleteUser(@PathVariable String displayName) {
		Optional<User> userOptional = userRepository.findByDisplayName(displayName);
		if (userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		userRepository.delete(userOptional.get());
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}
}
