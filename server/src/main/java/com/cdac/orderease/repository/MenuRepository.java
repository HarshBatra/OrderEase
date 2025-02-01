package com.cdac.orderease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.orderease.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	boolean existsByItemName(String itemName);

}
