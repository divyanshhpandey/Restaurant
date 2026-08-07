package com.fooddelivery.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.entity.menuEntity;

public interface menuRepo extends JpaRepository<menuEntity, Long>{

	List<menuEntity> findByRestaurantRestaurantId(Long restaurantId);

	Optional<menuEntity> findByItemIdAndRestaurantRestaurantId(Long itemId, Long restaurantId);

	

}
