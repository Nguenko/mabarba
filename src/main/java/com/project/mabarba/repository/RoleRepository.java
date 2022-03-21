package com.project.mabarba.repository;

import java.util.Optional;

import com.project.mabarba.models.ERole;
import com.project.mabarba.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
