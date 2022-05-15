package com.project.mabarba.repository;

import java.util.Optional;

import com.project.mabarba.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findById(long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
