package com.controllers;

import com.databases.DatabasesConnection;
import com.models.CartItem;
import com.models.Order;
import com.models.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class Add2OrderDAO
 */
public class Add2OrderDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabasesConnection dc;
	private Connection conn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Add2OrderDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		Order order = new Order();
		String userID = String.valueOf(session.getAttribute("userID"));

		for (CartItem cartItem : cart) {
			try {
				this.dc = new DatabasesConnection();
				this.conn = this.dc.getConnection();
				Class.forName("com.mysql.cj.jdbc.Driver");
				String query = "insert into chothings.orders (customer_id, total_price) VALUE (?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, userID);
//				ps.setString(2, );
//				cartItem.getProduct().getPrice
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
