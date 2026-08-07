package com.fooddelivery.mapper;

import com.fooddelivery.Dto.menuDto;
import com.fooddelivery.entity.menuEntity;
import com.fooddelivery.entity.restaurantEntity;

public class menuMapper {

	public static menuDto convertToDto(menuDto dto, menuEntity entity) {
		dto.setItemId(entity.getItemId());
		dto.setItemName(entity.getItemName());
		dto.setItemDescription(entity.getItemDescription());
		dto.setItemPrice(entity.getItemPrice());

		if (entity.getRestaurant() != null) {
			dto.setRestaurantId(entity.getRestaurant().getRestaurantId());
		}

		return dto;
	}

	public static menuEntity toMenuEntity(menuDto dto, restaurantEntity restaurant) {
		return new menuEntity(dto.getItemId(), dto.getItemName(), dto.getItemDescription(), dto.getItemPrice(),
				restaurant);
	}
}
