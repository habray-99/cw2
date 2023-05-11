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

/**
 * Servlet implementation class DeleteCategory
 */
public class DeleteCategoryDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabasesConnection dc;
	private Connection conn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryDAO() {
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
		this.dc = new DatabasesConnection();
		this.conn = this.dc.getConnection();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query = "DELETE FROM chothings.product_category WHERE product_category_name=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, (id != null) ? id : "NULL");
			ps.executeQuery();

		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
