package com.cdac.orderease.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.entity.Menu;
import com.cdac.orderease.exception.CurrentItemNotPresentException;
import com.cdac.orderease.exception.ItemAlreadyExistsException;
import com.cdac.orderease.exception.MenuDataNotFoundException;
import com.cdac.orderease.exception.NoItemAvailableException;
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

//	@Override
//	public MenuDTO updateSingleMenuData(Long itemId, MenuDTO menuDto) throws CurrentItemNotPresentException {
//		Menu menu = menuRepository.findById(itemId)
//				.orElseThrow(() -> new CurrentItemNotPresentException("Item with ID : " + itemId + " doesnot exists."));
//		menu = MenuMapper.mapMenuDtoToMenu(menuDto);
//		Menu updatedMenu = menuRepository.save(menu);
//		
//		return MenuMapper.mapMenuToMenuDto(updatedMenu);
//	}
	
	@Override
	public MenuDTO updateSingleMenuData(Long itemId, MenuDTO menuDto) throws CurrentItemNotPresentException {
	    // Fetch the existing menu item from the database
	    Menu menu = menuRepository.findById(itemId)
	            .orElseThrow(() -> new CurrentItemNotPresentException("Item with ID : " + itemId + " does not exist."));

	    // Update only the modified fields (avoid overwriting with null values)
	    if (menuDto.getItemName() != null) {
	        menu.setItemName(menuDto.getItemName());
	    }
	    if (menuDto.getItemDescription() != null) {
	        menu.setItemDescription(menuDto.getItemDescription());
	    }
	    if (menuDto.getItemPrice() != null) {
	        menu.setItemPrice(menuDto.getItemPrice());
	    }
	    if (menuDto.getItemIsAvailable() != null) {
	        menu.setItemIsAvailable(menuDto.getItemIsAvailable());
	    }
	    if (menuDto.getItemType() != null) {
	        menu.setItemType(menuDto.getItemType());
	    }
	    if (menuDto.getItemImage() != null) {
	        menu.setItemImage(menuDto.getItemImage());
	    }
	    if (menuDto.getItemImageUrl() != null) {
	        menu.setItemImageUrl(menuDto.getItemImageUrl());
	    }
	    if (menuDto.getOrderItemList() != null) {
	        menu.setOrderItemList(menuDto.getOrderItemList());
	    }

	    // Save the updated menu item
	    Menu updatedMenu = menuRepository.save(menu);

	    // Convert back to DTO and return
	    return MenuMapper.mapMenuToMenuDto(updatedMenu);
	}

	@Override
	public List<MenuDTO> getAllMenu() throws MenuDataNotFoundException {
		List<Menu> menuList = menuRepository.findAll();
		if(menuList.isEmpty()) {
			throw new MenuDataNotFoundException("There is no Menu available");
		}
		return menuList.stream()
				.map(MenuMapper::mapMenuToMenuDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<MenuDTO> getIsAvailableMenu() throws NoItemAvailableException {
		List<Menu> menuList = menuRepository.findByItemIsAvailable(true);
		if(menuList.isEmpty()) {
			throw new NoItemAvailableException("There is no Available item in the Menu");
		}
		return menuList.stream()
				.map(MenuMapper::mapMenuToMenuDto)
				.collect(Collectors.toList());
	}

	@Override
	public String deleteMenuById(Long itemId) throws CurrentItemNotPresentException {
		// TODO Auto-generated method stub
		boolean existsById = menuRepository.existsById(itemId);
		if(!existsById) {
			throw new CurrentItemNotPresentException("Item with ID : " + itemId + " doesnot exists.");
		}
		menuRepository.deleteById(itemId);
		return "Menu With Item Id " + itemId + " is deleted";
	}
	
	
}
