package com.fooddelivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class restaurantEntity {
	@Id
	@Column(name = "restaurantId")
	private Long restaurantId;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@Column(name = "restaurant_address")
	private String restaurant_address;

	@Column(name = "restaurant_phone")
	private String restaurant_phone;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public restaurantEntity(Long restaurantId, String restaurantName, String restaurant_address,
			String restaurant_phone) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurant_address = restaurant_address;
		this.restaurant_phone = restaurant_phone;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	public String getRestaurant_phone() {
		return restaurant_phone;
	}

	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}

	public restaurantEntity() {
	}

	@Override
	public String toString() {
		return "Restaurant_Entity [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurant_address=" + restaurant_address + ", restaurant_phone=" + restaurant_phone + "]";
	}

}
