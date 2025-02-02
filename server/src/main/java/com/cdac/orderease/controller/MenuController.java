package com.cdac.orderease.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;
import com.cdac.orderease.exception.MenuDataNotFoundException;
import com.cdac.orderease.exception.NoItemAvailableException;
import com.cdac.orderease.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	private final MenuService menuService;
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<MenuDTO> addMenu(@RequestBody MenuDTO menuDto) throws ItemAlreadyExistsException {
		MenuDTO savedMenu = menuService.addMenuData(menuDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMenu);
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<MenuDTO> getSingleMenu(@PathVariable("itemId") Long itemId) throws CurrentItemNotPresentException {
		MenuDTO singleMenuData = menuService.getSingleMenuData(itemId);
		return ResponseEntity.status(HttpStatus.FOUND).body(singleMenuData);
	}
	
	@PutMapping("/{itemId}")
	public ResponseEntity<MenuDTO> updateMenu(@PathVariable("itemId") Long itemId, @RequestBody MenuDTO menuDto) throws CurrentItemNotPresentException {
		MenuDTO updatedMenuData = menuService.updateSingleMenuData(itemId, menuDto);
		return ResponseEntity.ok(updatedMenuData);
	}
	
	@GetMapping
	public ResponseEntity<List<MenuDTO>> getAllMenu() throws MenuDataNotFoundException {
		List<MenuDTO> menuDtoList = menuService.getAllMenu();
		return ResponseEntity.ok(menuDtoList);
	}
	
	@GetMapping("/isAvailable")
	public ResponseEntity<List<MenuDTO>> getIsAvailableMenu() throws NoItemAvailableException {
		List<MenuDTO> menuDtoList = menuService.getIsAvailableMenu();
		return ResponseEntity.ok(menuDtoList);
	}
	
}
