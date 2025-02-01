package com.cdac.orderease.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.entity.Menu;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;
import com.cdac.orderease.mapper.MenuMapper;
import com.cdac.orderease.repository.MenuRepository;
import com.cdac.orderease.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private final MenuRepository menuRepository;
	
	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	@Override
	public MenuDTO addMenuData(MenuDTO menuDto) throws ItemAlreadyExistsException {
		Menu menu = MenuMapper.mapMenuDtoToMenu(menuDto);
		if(menuRepository.existsByItemName(menu.getItemName())) {
			throw new ItemAlreadyExistsException("Item with name : " + menu.getItemName() + " already exists.");
		}
		Menu savedMenu = menuRepository.save(menu);
		return MenuMapper.mapMenuToMenuDto(savedMenu);
	}

	@Override
	public MenuDTO getSingleMenuData(Long itemId) throws CurrentItemNotPresentException {
		Optional<Menu> itemById = menuRepository.findById(itemId);
		if(itemById.isEmpty()) {
			throw new CurrentItemNotPresentException("Item with ID : " + itemId + " doesnot exists.");
		}
		Menu menu = itemById.get();
		return MenuMapper.mapMenuToMenuDto(menu);
	}
	
}
