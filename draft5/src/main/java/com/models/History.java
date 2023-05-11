package com.models;

public class History {
    int order_id;
    int product_id;
    int quantity;

    String hashing_pw;

    public History() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getHashing_pw() {
        return hashing_pw;
    }

    public void setHashing_pw(String hashing_pw) {
        this.hashing_pw = hashing_pw;
    }
}
