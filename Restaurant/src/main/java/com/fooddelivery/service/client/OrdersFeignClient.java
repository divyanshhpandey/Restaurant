package com.fooddelivery.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.fooddelivery.Dto.OrderDto;
import com.fooddelivery.Dto.RatingDTO;


@FeignClient(name = "orders")
public interface OrdersFeignClient {

	
	@GetMapping(value = "/api/ratings/{restaurantId}/reviews")
	public ResponseEntity<List<RatingDTO>> getRatingsByRestaurantId(@PathVariable Long restaurantId);
	
}
