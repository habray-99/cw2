package com.controllers;

import com.databases.DatabasesConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class EditProductDAO
 */
public class EditProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabasesConnection dc;
	private Connection conn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductDAO() {
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String price = request.getParameter("price");
		String description = request.getParameter("desc");
		String stock = request.getParameter("stock");
		String catID = request.getParameter("catID");
		Part filePart = request.getPart("photo");
		String fileName = filePart.getSubmittedFileName();
		InputStream fileContent = filePart.getInputStream();

		// Save the file to disk
		File file = new File("../../../photos" + fileName);
		OutputStream out = new FileOutputStream(file);
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = fileContent.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.close();
		fileContent.close();
		String query = "update chothings.products set product_name = ?, price =?, product_desc =?, stock =?, photo =?, product_category_id =? where product_ID = ?";
		try {
			this.dc = new DatabasesConnection();
			this.conn = this.dc.getConnection();
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, description);
			ps.setString(4, stock);
			ps.setString(5, "../../../photos" + fileName);
			ps.setString(6, catID);
			ps.setString(7, id);
			ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
