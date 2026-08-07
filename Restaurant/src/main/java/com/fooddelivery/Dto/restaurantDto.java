package com.fooddelivery.Dto;

public class restaurantDto {

	private Long restaurantId;
	private String restaurantName;
	private String restaurant_address;
	private String restaurant_phone;
	
	private RatingDTO ratingDTO;
	

	public RatingDTO getRatingDTO() {
		return ratingDTO;
	}

	public void setRatingDTO(RatingDTO ratingDTO) {
		this.ratingDTO = ratingDTO;
	}

	public restaurantDto() {
		super();
	}

	public restaurantDto(Long restaurantId, String restaurantName, String restaurant_address, String restaurant_phone) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurant_address = restaurant_address;
		this.restaurant_phone = restaurant_phone;
	}

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

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	public String getRestaurant_phone() {
		return restaurant_phone;
	}

	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}

	@Override
	public String toString() {
		return "restaurantDto [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurant_address=" + restaurant_address + ", restaurant_phone=" + restaurant_phone
				+ ", ratingDTO=" + ratingDTO + "]";
	}

	public restaurantDto(Long restaurantId, String restaurantName, String restaurant_address, String restaurant_phone,
			RatingDTO ratingDTO) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurant_address = restaurant_address;
		this.restaurant_phone = restaurant_phone;
		this.ratingDTO = ratingDTO;
	}

	

}
