package com.pagarme.linx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long order_id;

@NotBlank
private String nameProduct;

@NotNull
private Double unitPrice;

@NotNull
@Max(value = 20, message = "the quantity should not greater than 20 ")
private Double quantity;

@NotNull
private String status;


public long getOrder_id() {
	return order_id;
}

public void setOrder_id(long order_id) {
	this.order_id = order_id;
}

public String getNameProduct() {
	return nameProduct;
}

public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}

public Double getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(Double unitPrice) {
	this.unitPrice = unitPrice;
}

public Double getQuantity() {
	return quantity;
}

public void setQuantity(Double quantity) {
	this.quantity = quantity;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



}

