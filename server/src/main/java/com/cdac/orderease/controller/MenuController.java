package com.cdac.orderease.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;
import com.cdac.orderease.exception.MenuDataNotFoundException;
import com.cdac.orderease.exception.NoItemAvailableException;
import com.cdac.orderease.service.MenuService;

@RestController
public class MenuController {
	private final MenuService menuService;
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/menu/{itemId}")
	public ResponseEntity<MenuDTO> getSingleMenu(@PathVariable("itemId") Long itemId) throws CurrentItemNotPresentException {
		MenuDTO singleMenuData = menuService.getSingleMenuData(itemId);
		return ResponseEntity.status(HttpStatus.FOUND).body(singleMenuData);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/menu/isAvailable")
	public ResponseEntity<List<MenuDTO>> getIsAvailableMenu() throws NoItemAvailableException {
		List<MenuDTO> menuDtoList = menuService.getIsAvailableMenu();
		return ResponseEntity.ok(menuDtoList);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/menu")
	public ResponseEntity<List<MenuDTO>> getAllMenu() throws MenuDataNotFoundException {
		List<MenuDTO> menuDtoList = menuService.getAllMenu();
		return ResponseEntity.ok(menuDtoList);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/admin/{itemId}")
	public ResponseEntity<MenuDTO> updateMenu(@PathVariable("itemId") Long itemId, @RequestBody MenuDTO menuDto) throws CurrentItemNotPresentException {
		MenuDTO updatedMenuData = menuService.updateSingleMenuData(itemId, menuDto);
		return ResponseEntity.ok(updatedMenuData);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/menu/add")
	public ResponseEntity<MenuDTO> addMenu(@RequestBody MenuDTO menuDto) throws ItemAlreadyExistsException {
		MenuDTO savedMenu = menuService.addMenuData(menuDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMenu);
	}
	@DeleteMapping("/{itemId}")
	public ResponseEntity<String> deleteMenu(@PathVariable("itemId") Long itemId) throws CurrentItemNotPresentException {
		String deleteMenuById = menuService.deleteMenuById(itemId);
		return ResponseEntity.status(HttpStatus.FOUND).body(deleteMenuById);
	}
}