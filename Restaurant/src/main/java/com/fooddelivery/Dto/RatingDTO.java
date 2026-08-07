package com.fooddelivery.Dto;
 
public class RatingDTO {
    private Integer ratingId;
    private Integer restaurantId;
    private Integer rating;
    private String review;
 
    public Integer getRatingId() {
        return ratingId;
    }
 
    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }
 
 
    public Integer getRestaurantId() {
        return restaurantId;
    }
 
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
 
 
    public Integer getRating() {
        return rating;
    }
 
    public void setRating(Integer rating) {
        this.rating = rating;
    }
 
    public String getReview() {
        return review;
    }
 
    public void setReview(String review) {
        this.review = review;
    }
    
}