package com.controllers;

import com.databases.DatabasesConnection;
import com.models.ProductCategory;
import com.models.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class P_C_Getter extends DatabasesConnection {
	public P_C_Getter() {
    }


    /**
     * This function retrieves a list of products from a MySQL database and returns them as an
     * ArrayList of Products objects.
     * 
     * @return An ArrayList of Products.
     */
    public ArrayList<Products> getProducts() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getConnection();


        ArrayList<Products> products = new ArrayList<Products>();
        String query = "select * from chothings.products";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Products products1 = new Products();
                products1.setProduct_id(rs.getInt("product_id"));
                products1.setProduct_name(rs.getString("product_name"));
                products1.setProduct_price(Double.parseDouble(rs.getString("price")));
                products1.setProduct_description(rs.getString("product_desc"));
                products1.setStock(Integer.parseInt(rs.getString("stock")));
                products1.setProduct_photo(rs.getString("photo"));
                
                System.out.println("testing for photo ");
                System.out.println(products1.getProduct_photo());
                System.out.println(products1.getProduct_name());
                products1.setCategory_id(rs.getShort("product_category_id"));
                products.add(products1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Products getProductByID(int id) throws SQLException, ClassNotFoundException {
        Products products;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = getConnection();
            String query = "select * from chothings.products where product_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            products = new Products();
            products.setProduct_id(rs.getInt("product_id"));
            products.setProduct_name(rs.getString("product_name"));
            products.setProduct_price(Double.parseDouble(rs.getString("price")));
            products.setProduct_description(rs.getString("product_desc"));
            products.setStock(Integer.parseInt(rs.getString("stock")));
            products.setProduct_photo(rs.getString("photo"));
            products.setCategory_id(rs.getInt("product_category_id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    /**
     * This Java function retrieves all product categories from a MySQL database and returns them as an
     * ArrayList of ProductCategory objects.
     * 
     * @return An ArrayList of ProductCategory objects.
     */
    public ArrayList<ProductCategory> getProductCategories() throws ClassNotFoundException {
        ArrayList <ProductCategory> productCategoryArrayList = new ArrayList<ProductCategory>();
        String query = "select * from chothings.product_category";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProductCategory ProductCategory = new ProductCategory();
                ProductCategory.setProduct_category_id(rs.getInt("product_category_id"));
                ProductCategory.setProduct_category_name(rs.getString("product_category_name"));
                productCategoryArrayList.add(ProductCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productCategoryArrayList;
    }
}
