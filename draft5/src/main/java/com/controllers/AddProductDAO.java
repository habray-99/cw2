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
import java.util.Optional;

import static java.lang.String.valueOf;

/**
 * Servlet implementation class AddProductDAO
 */
public class AddProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabasesConnection dc;
	private Connection conn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductDAO() {
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
		response.setContentType("text/html");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("desc");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int catID = Integer.parseInt(request.getParameter("catID"));
		Part filePart = request.getPart("photo");
		String fileName = filePart.getSubmittedFileName();
		InputStream fileContent = filePart.getInputStream();

		// Save the file to disk
		File file = new File("..\\..\\..\\webapp\\views\\photos" + fileName);
		OutputStream out = new FileOutputStream(file);
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = fileContent.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.close();
		fileContent.close();
		String query = "insert into chothings.products (product_ID, product_name, price, product_desc, stock, photo, product_category_id) value (?,?,?,?,?,?,?)";
		try {
			this.dc = new DatabasesConnection();
			this.conn = this.dc.getConnection();
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Optional.ofNullable(id).<String>map(i -> String.valueOf(i)).orElse(null));
			ps.setString(2, name);
			ps.setString(3, valueOf(price));
			ps.setString(4, description);
			ps.setString(5, valueOf(stock));
			ps.setString(6, fileName);
			ps.setString(7, valueOf(catID));
			ps.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
