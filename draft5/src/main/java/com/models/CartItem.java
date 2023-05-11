package com.models;

public class CartItem {
	Products products;
	int quantity;
	int productId;
	private Thread product;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem() {
		this.products = products;
		this.quantity = quantity;
	}


	public CartItem(int quantity, int productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}

	public final int getProductId() {
		return productId;
	}

	public final void setProductId(int productId) {
		this.productId = productId;
	}

	public Thread getProduct() {
		return product;
	}

	public void setProduct(Thread product) {
		this.product = product;
	}
}
