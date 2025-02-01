package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.MenuDTO;
import com.cdac.orderease.entity.Menu;

public class MenuMapper {
	public static Menu mapMenuDtoToMenu(MenuDTO menuDto) {
		Menu menu = new Menu();
		menu.setItemId(menuDto.getItemId());
		menu.setItemName(menuDto.getItemName());
		menu.setItemDescription(menuDto.getItemDescription());
		menu.setItemPrice(menuDto.getItemPrice());
		menu.setItemIsAvailable(menuDto.getItemIsAvailable());
		menu.setItemType(menuDto.getItemType());
		menu.setItemImage(menuDto.getItemImage());
		menu.setItemImageUrl(menuDto.getItemImageUrl());
		return menu;
	}
	public static MenuDTO mapMenuToMenuDto(Menu menu) {
		MenuDTO menuDto = new MenuDTO();
		menuDto.setItemId(menu.getItemId());
		menuDto.setItemName(menu.getItemName());
		menuDto.setItemDescription(menu.getItemDescription());
		menuDto.setItemPrice(menu.getItemPrice());
		menuDto.setItemIsAvailable(menu.getItemIsAvailable());
		menuDto.setItemType(menu.getItemType());
		menuDto.setItemImage(menu.getItemImage());
		menuDto.setItemImageUrl(menu.getItemImageUrl());
		return menuDto;
	}
}
