package com.cdac.orderease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.orderease.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	boolean existsByUserEmail(String userEmail);

	Optional<Users> findByUsernameAndPassword(String username, String password);
	public Optional<Users> findByUsername(String username);
}
