package com.fooddelivery.Dto;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderDto {
	private Long orderId;
    private Long customerId;
    private Long restaurantId;
    private Long deliveryDriverId;
    private Date orderDate;
    private String orderStatus;
    private List<OrderItemDto> orderItems;
    private RatingDTO rating;
    private Set<CouponDTO> coupons;
    
    public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}
	
	public Long getDeliveryDriverId() {
		return deliveryDriverId;
	}
	public void setDeliveryDriverId(Long deliveryDriverId) {
		this.deliveryDriverId = deliveryDriverId;
	}
	
	

	public RatingDTO getRating() {
		return rating;
	}
	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}

	
	public Set<CouponDTO> getCoupons() {
		return coupons;
	}
	public void setCoupons(Set<CouponDTO> coupons) {
		this.coupons = coupons;
	}
	
	
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", customerId=" + customerId + ", restaurantId=" + restaurantId
				+ ", deliveryDriverId=" + deliveryDriverId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderItems=" + orderItems + ", rating=" + rating + ", coupons=" + coupons + "]";
	}
	public OrderDto() {
		super();
	}
	
	
	public OrderDto(Long orderId, Long customerId, Long restaurantId, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public OrderDto(Long orderId, Long customerId, Long restaurantId, Date orderDate, String orderStatus,
			List<OrderItemDto> orderItems) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}
	public OrderDto(Long orderId, Long customerId, Long restaurantId, Long deliveryDriverId, Date orderDate,
			String orderStatus, List<OrderItemDto> orderItems) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryDriverId = deliveryDriverId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}
	public OrderDto(Long orderId, Long customerId, Long restaurantId, Long deliveryDriverId, Date orderDate,
			String orderStatus, List<OrderItemDto> orderItems, RatingDTO rating) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryDriverId = deliveryDriverId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
		this.rating = rating;
	}
	public OrderDto(Long orderId, Long customerId, Long restaurantId, Long deliveryDriverId, Date orderDate,
			String orderStatus, List<OrderItemDto> orderItems, RatingDTO rating, Set<CouponDTO> coupons) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryDriverId = deliveryDriverId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
		this.rating = rating;
		this.coupons = coupons;
	}
	
	
	  
	
	
}

