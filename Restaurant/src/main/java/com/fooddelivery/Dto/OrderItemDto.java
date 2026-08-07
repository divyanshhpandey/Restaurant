package com.fooddelivery.Dto;

public class OrderItemDto {
    private Long orderItemId;
    private Long itemId;
    private int quantity;
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItemDto() {
		super();
	}
	public OrderItemDto(Long orderItemId, Long orderId, Long itemId, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
    
	
    
}
