package com.cdac.orderease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.orderease.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByUserEmail(String userEmail);

	Optional<User> findByUsernameAndPassword(String username, String password);

}
