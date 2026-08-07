package com.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddelivery.Dto.RatingDTO;
import com.fooddelivery.Dto.restaurantDto;
import com.fooddelivery.entity.restaurantEntity;
import com.fooddelivery.mapper.restaurantMapper;
import com.fooddelivery.repo.restaurantRepo;
import com.fooddelivery.service.client.OrdersFeignClient;

@Service
public class restaurantServiceImpl implements restaurantServiceInterface {

    @Autowired
    private restaurantRepo repo;
    

    @Autowired
       private OrdersFeignClient ordersFeignClient;

       public ResponseEntity<List<RatingDTO>> fetchRatingsForRestaurant(Long restaurantId) {
           return ordersFeignClient.getRatingsByRestaurantId(restaurantId);
       }
 


    @Override
    public String addRestaurant(restaurantDto dto) {
        restaurantEntity entity = restaurantMapper.convertToEntity(dto, new restaurantEntity());
        repo.save(entity);
        return "Restaurant Added Successfully, Thanks!";
    }

    @Override
    public restaurantDto getRestaurant(Long restaurantId) {
        restaurantEntity entity = repo.findById(restaurantId).orElse(null);
        return restaurantMapper.convertToDto(new restaurantDto(), entity);
    }

    @Override
    public List<restaurantDto> fetchAll() {
        List<restaurantEntity> entities = repo.findAll();
        List<restaurantDto> dtoList = new ArrayList<>();

        for (restaurantEntity entity : entities) {
            restaurantDto dto = restaurantMapper.convertToDto(new restaurantDto(), entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public boolean deleteRestaurant(Long restaurantId) {
        if (repo.existsById(restaurantId)) {
            repo.deleteById(restaurantId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRestaurant(Long restaurantId, restaurantDto dto) {
        restaurantEntity entity = repo.findById(restaurantId).orElse(null);
        if (entity != null) {
            entity.setRestaurant_address(dto.getRestaurant_address());
            entity.setRestaurantName(dto.getRestaurantName());
            entity.setRestaurant_phone(dto.getRestaurant_phone());
            repo.save(entity);
            return true;
        }
        return false;
    }
}