package com.fooddelivery.Dto;

import java.time.LocalDate;

public class CouponDTO {
    private Integer id;
    private String code;
    private Double discount;
    private LocalDate expiryDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "CouponDTO [id=" + id + ", code=" + code + ", discount=" + discount + ", expiryDate=" + expiryDate + "]";
	}
	public CouponDTO(Integer id, String code, Double discount, LocalDate expiryDate) {
		super();
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.expiryDate = expiryDate;
	}

	public CouponDTO() {
		super();
	}

}
