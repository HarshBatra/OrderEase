package com.cdac.orderease.dto;

public class MenuDTO {
	private Long itemId;
	private String itemName;
	private String itemDescription;
	private String itemPrice;
	private String itemType;
	private Boolean itemIsAvailable;
	private String itemImage;
	private String itemImageUrl;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Boolean getItemIsAvailable() {
		return itemIsAvailable;
	}
	public void setItemIsAvailable(Boolean itemIsAvailable) {
		this.itemIsAvailable = itemIsAvailable;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemImageUrl() {
		return itemImageUrl;
	}
	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDTO(Long itemId, String itemName, String itemDescription, String itemPrice, String itemType,
			Boolean itemIsAvailable, String itemImage, String itemImageUrl) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemIsAvailable = itemIsAvailable;
		this.itemImage = itemImage;
		this.itemImageUrl = itemImageUrl;
	}
}
