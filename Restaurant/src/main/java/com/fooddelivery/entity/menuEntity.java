package com.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menuitems")
public class menuEntity {
	@Id
	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_description")
	private String itemDescription;

	@Column(name = "item_price")
	private double itemPrice;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private restaurantEntity restaurant;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public menuEntity() {
		super();
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
	
	 public restaurantEntity getRestaurant() {
	        return restaurant;
	    }

	    public void setRestaurant(restaurantEntity restaurant) {
	        this.restaurant = restaurant;
	    }

	public menuEntity(Long itemId, String itemName, String itemDescription, double itemPrice , restaurantEntity restaurant) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "menuEntity [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemPrice=" + itemPrice + "]";
	}

}
