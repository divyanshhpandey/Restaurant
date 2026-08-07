package com.fooddelivery.mapper;
import com.fooddelivery.Dto.restaurantDto;
import com.fooddelivery.entity.restaurantEntity;


public class restaurantMapper {

    public static restaurantDto convertToDto(restaurantDto dto, restaurantEntity entity) {
        dto.setRestaurantId(entity.getRestaurantId());
        dto.setRestaurant_address(entity.getRestaurant_address());
        dto.setRestaurant_phone(entity.getRestaurant_phone());
        dto.setRestaurantName(entity.getRestaurantName()); 
        return dto;
    }

    public static restaurantEntity convertToEntity(restaurantDto dto, restaurantEntity entity) {
        entity.setRestaurantId(dto.getRestaurantId());
        entity.setRestaurant_address(dto.getRestaurant_address());
        entity.setRestaurant_phone(dto.getRestaurant_phone());
        entity.setRestaurantName(dto.getRestaurantName());
        return entity;
    }
}