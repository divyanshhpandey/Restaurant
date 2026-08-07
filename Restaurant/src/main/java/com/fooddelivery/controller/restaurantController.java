package com.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fooddelivery.Dto.RatingDTO;
import com.fooddelivery.Dto.menuDto;
import com.fooddelivery.Dto.restaurantDto;
import com.fooddelivery.constants.Constants_File;
import com.fooddelivery.Dto.ResponseDto;
import com.fooddelivery.service.client.OrdersFeignClient;
import com.fooddelivery.service.menuServiceInterface;
import com.fooddelivery.service.restaurantServiceInterface;

@RestController
@RequestMapping("/api/restaurants")
public class restaurantController {

    @Autowired
    private restaurantServiceInterface restservice;

    @Autowired
    private menuServiceInterface menuservice;

    @Autowired
    private OrdersFeignClient ordersFeignClient;
    
    @PostMapping("/addMenu/{restaurantId}")
    public ResponseEntity<ResponseDto> addMenuItem(@PathVariable Long restaurantId, @RequestBody menuDto dto) {
        if (!restaurantId.equals(dto.getRestaurantId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(Constants_File.STATUS_400, "The Restaurant ID is not correct."));
        }

        menuservice.addMenuItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants_File.STATUS_201, "Item successfully added inside the menu of a restaurant."));
    }

    @GetMapping("/fetchItems/{restaurantId}")
    public ResponseEntity<List<menuDto>> getMenu(@PathVariable Long restaurantId) {
        List<menuDto> menu = menuservice.getMenuByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(menu);
    }

    @DeleteMapping("/deleteItem/{restaurantId}/{itemId}")
    public ResponseEntity<ResponseDto> deleteItem(@PathVariable Long restaurantId, @PathVariable Long itemId) {
    	
        boolean isDeleted = menuservice.deleteItem(restaurantId, itemId);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(Constants_File.STATUS_200, "Item successfully removed from the restaurant's menu."));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, Constants_File.MESSAGE_417_DELETE));
        }
    }

    @PutMapping("/updateItem/{restaurantId}/{itemId}")
    public ResponseEntity<ResponseDto> updateItem(@PathVariable Long restaurantId,@PathVariable Long itemId ,@RequestBody menuDto dto) {
        if(!restaurantId.equals(dto.getRestaurantId())) {
        	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, "Restaurant Id which you have mentioned is not correct."));
        }
        if(!itemId.equals(dto.getItemId())) {
        	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, "Item Id which you have mentioned is not correct."));
        }
        
        boolean isUpdated = menuservice.updateItem(restaurantId,itemId,dto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(Constants_File.STATUS_200, "Item Updated successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, Constants_File.MESSAGE_417_UPDATE));
        }
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<ResponseDto> addRestaurant(@RequestBody restaurantDto dto) {
        restservice.addRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants_File.STATUS_201, "Restaurant Added successfully !"));
    }

    @GetMapping("/fetchById/{restaurantId}")
    public ResponseEntity<restaurantDto> getRestaurant(@PathVariable Long restaurantId) {
        restaurantDto dto = restservice.getRestaurant(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<restaurantDto>> fetchAll() {
        List<restaurantDto> restaurants = restservice.fetchAll();
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @DeleteMapping("/deleteById/{restaurantId}")
    public ResponseEntity<ResponseDto> deleteRestaurant(@PathVariable Long restaurantId) {
        boolean isDeleted = restservice.deleteRestaurant(restaurantId);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(Constants_File.STATUS_200, "Restaurant deleted successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, Constants_File.MESSAGE_417_DELETE));
        }
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<ResponseDto> updateRestaurant(@PathVariable Long restaurantId, @RequestBody restaurantDto dto) {
        boolean isUpdated = restservice.updateRestaurant(restaurantId, dto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(Constants_File.STATUS_200, "Details of the restaurant updated successfully!"));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(Constants_File.STATUS_417, Constants_File.MESSAGE_417_UPDATE));
        }
    }
    

   @GetMapping("/{restaurantId}/reviews")
   	public ResponseEntity<List<RatingDTO>> getRatings(@PathVariable Long restaurantId) {
	   List<RatingDTO> ratings = ordersFeignClient.getRatingsByRestaurantId(restaurantId).getBody();
    return ResponseEntity.ok(ratings);
}


}