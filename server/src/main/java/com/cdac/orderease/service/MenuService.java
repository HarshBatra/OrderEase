package com.cdac.orderease.service;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;

public interface MenuService {
	MenuDTO addMenuData(MenuDTO menuDto) throws ItemAlreadyExistsException;
	
	MenuDTO getSingleMenuData(Long itemId) throws CurrentItemNotPresentException;
}
