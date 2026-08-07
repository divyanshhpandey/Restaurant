package com.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.Dto.restaurantDto;

@Service
public interface restaurantServiceInterface {

	String addRestaurant(restaurantDto dto);

	restaurantDto getRestaurant(Long restaurantId);

	List<restaurantDto> fetchAll();

	boolean deleteRestaurant(Long restaurantId);

	boolean updateRestaurant(Long restaurantId, restaurantDto dto);
}
