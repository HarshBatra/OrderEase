package com.cdac.orderease.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid")
	private Long itemId;
	@Column(name = "itemname")
	private String itemName;
	@Column(name = "itemdescription")
	private String itemDescription;
	@Column(name = "itemprice")
	private String itemPrice;
	@Column(name = "itemtype")
	private String itemType;
	@Column(name = "itemisavailable")
	private Boolean itemIsAvailable;
	@Column(name = "itemimage")
	private String itemImage;
	@Column(name = "itemimageurl")
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
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(Long itemId, String itemName, String itemDescription, String itemPrice, String itemType,
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
