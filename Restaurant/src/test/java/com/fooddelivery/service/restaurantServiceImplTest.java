package com.fooddelivery.service;

import com.fooddelivery.Dto.restaurantDto;
import com.fooddelivery.entity.restaurantEntity;
import com.fooddelivery.repo.restaurantRepo;
import com.fooddelivery.service.client.OrdersFeignClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class restaurantServiceImplTest {

    @Mock
    private restaurantRepo repo;

    @Mock
    private OrdersFeignClient ordersFeignClient;

    @InjectMocks
    private restaurantServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    // 1. Add Restaurant
    @Test
    void testAddRestaurant_Success() {
        restaurantDto dto = new restaurantDto(1L, "Domino's", "Pune", "1234567890");
        when(repo.save(any())).thenReturn(new restaurantEntity());
        String result = service.addRestaurant(dto);
        assertEquals("Restaurant Added Successfully, Thanks!", result);
    }

    // ❌ Add Restaurant - No mocking needed for error (mapped is static)

    // 2. Get Restaurant
    @Test
    void testGetRestaurant_Success() {
        restaurantEntity entity = new restaurantEntity(1L, "KFC", "Mumbai", "9876543210");
        when(repo.findById(1L)).thenReturn(Optional.of(entity));
        restaurantDto result = service.getRestaurant(1L);
        assertEquals("KFC", result.getRestaurantName());
    }

    @Test
    void testGetRestaurant_NotFound() {
        when(repo.findById(2L)).thenReturn(Optional.empty());

        // Expect a NullPointerException when entity is null
        assertThrows(NullPointerException.class, () -> {
            service.getRestaurant(2L);
        });
    }

    // 3. Fetch All Restaurants
    @Test
    void testFetchAll_Success() {
        restaurantEntity entity = new restaurantEntity(1L, "Subway", "Delhi", "1112223333");
        when(repo.findAll()).thenReturn(List.of(entity));
        List<restaurantDto> result = service.fetchAll();
        assertEquals(1, result.size());
    }

    @Test
    void testFetchAll_Empty() {
        when(repo.findAll()).thenReturn(new ArrayList<>());
        List<restaurantDto> result = service.fetchAll();
        assertTrue(result.isEmpty());
    }

    // 4. Delete Restaurant
    @Test
    void testDeleteRestaurant_Success() {
        when(repo.existsById(1L)).thenReturn(true);
        boolean result = service.deleteRestaurant(1L);
        assertTrue(result);
    }

    @Test
    void testDeleteRestaurant_NotFound() {
        when(repo.existsById(2L)).thenReturn(false);
        boolean result = service.deleteRestaurant(2L);
        assertFalse(result);
    }

    // 5. Update Restaurant
    @Test
    void testUpdateRestaurant_Success() {
        restaurantDto dto = new restaurantDto(1L, "Updated", "New Addr", "9999999999");
        restaurantEntity entity = new restaurantEntity(1L, "Old", "Old Addr", "8888888888");
        when(repo.findById(1L)).thenReturn(Optional.of(entity));
        boolean result = service.updateRestaurant(1L, dto);
        assertTrue(result);
    }

    @Test
    void testUpdateRestaurant_NotFound() {
        restaurantDto dto = new restaurantDto(2L, "Missing", "Nowhere", "0000000000");
        when(repo.findById(2L)).thenReturn(Optional.empty());
        boolean result = service.updateRestaurant(2L, dto);
        assertFalse(result);
    }

    // 6. Fetch Ratings
//    @Test
//    void testFetchRatings_Success() {
//        // ✅ Step 1: Create the object
//        RatingDTO rating = new RatingDTO();
//
//        // ✅ Step 2: Set values
//        rating.setRestaurantId(1L);
//        rating.setRating(5);
//        rating.setComment("Great!");
//
//        // ✅ Step 3: Put it in a list
//        List<RatingDTO> ratings = List.of(rating);
//
//        // ✅ Step 4: Mock the Feign client
//        when(ordersFeignClient.getRatingsByRestaurantId(1L)).thenReturn(ResponseEntity.ok(ratings));
//
//        // ✅ Step 5: Call the service method
//        ResponseEntity<List<RatingDTO>> response = service.fetchRatingsForRestaurant(1L);
//
//    @Test
//    void testFetchRatings_Empty() {
//        when(ordersFeignClient.getRatingsByRestaurantId(2L)).thenReturn(ResponseEntity.ok(new ArrayList<>()));
//        ResponseEntity<List<RatingDTO>> response = service.fetchRatingsForRestaurant(2L);
//        assertTrue(response.getBody().isEmpty());
//    }
}