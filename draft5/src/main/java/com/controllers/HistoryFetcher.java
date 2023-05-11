package com.controllers;

import com.databases.DatabasesConnection;
import com.models.CartItem;
import com.models.History;
import com.models.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryFetcher extends DatabasesConnection {
    public List<History> fetchHistory(){
        List<History> history = new ArrayList<>();
        History history1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = getConnection();
            String query = "select * from chothings.cart";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                history1 = new History();
                history1.setOrder_id(rs.getInt("order_id"));
                history1.setProduct_id(Integer.parseInt(rs.getString("product_id")));
                history1.setQuantity(Integer.parseInt(rs.getString("quantity")));
                history1.setHashing_pw(rs.getString("hashing_pw"));
                history.add(history1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return history;
    }
}
