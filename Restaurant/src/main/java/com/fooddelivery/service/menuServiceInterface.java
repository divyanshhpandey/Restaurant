package com.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.Dto.menuDto;

@Service
public interface menuServiceInterface {

    String addMenuItem(menuDto dto);

    List<menuDto> getMenuByRestaurantId(Long restaurantId);

    boolean deleteItem(Long restaurantId, Long itemId);

    boolean updateItem(Long restaurantId, Long itemId, menuDto dto);
}
