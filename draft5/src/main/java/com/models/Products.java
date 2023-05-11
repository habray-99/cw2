/**
 * The Products class defines the properties and methods of a product object in a Java program.
 */
package com.models;

public class Products {
    int product_id;
    String product_name;
    double product_price;
    String product_description;
    int stock;
    String product_photo;
    int category_id;
    private Object Products;

    public Products() {
    }

//    public com.models.Products getProduct() {
//        return Products;
//    }
    public String getProduct_id() {
        return String.valueOf(product_id);
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public  String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return String.valueOf(product_price);
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getStock() {
        return String.valueOf(stock);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(String product_photo) {
        this.product_photo = product_photo;
    }

    public String getCategory_id() {
        return String.valueOf(category_id);
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }


}
