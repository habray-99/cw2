package com.controllers;

import com.databases.DatabasesConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteProductDAO
 */
public class DeleteProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabasesConnection dc;
	private Connection conn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductDAO() {
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
		String id = request.getParameter("id");
		String query = "delete from chothings.products where product_name =?";
		try {
			this.dc = new DatabasesConnection();
			this.conn = this.dc.getConnection();
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
