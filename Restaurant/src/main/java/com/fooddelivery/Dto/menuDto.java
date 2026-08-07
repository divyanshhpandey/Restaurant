package com.fooddelivery.Dto;

public class menuDto {
	private Long itemId;
	private String itemName;
	private String itemDescription;
	private double itemPrice;
	private Long restaurantId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

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

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public menuDto(Long itemId, String itemName, String itemDescription, double itemPrice, Long restaurantId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "menuDto [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemPrice=" + itemPrice + "]";
	}

	public menuDto() {
		super();
	}

}
