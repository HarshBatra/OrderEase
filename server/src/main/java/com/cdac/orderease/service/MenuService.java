package com.cdac.orderease.service;

import java.util.List;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;
import com.cdac.orderease.exception.MenuDataNotFoundException;
import com.cdac.orderease.exception.NoItemAvailableException;

public interface MenuService {
	MenuDTO addMenuData(MenuDTO menuDto) throws ItemAlreadyExistsException;
	
	MenuDTO getSingleMenuData(Long itemId) throws CurrentItemNotPresentException;

	MenuDTO updateSingleMenuData(Long itemId, MenuDTO menuDto) throws CurrentItemNotPresentException;

	List<MenuDTO> getAllMenu() throws MenuDataNotFoundException;

	List<MenuDTO> getIsAvailableMenu() throws NoItemAvailableException;
}
