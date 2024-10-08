package com.servlets;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete_marks")
public class delete_marks extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));

		DAO dao = new DAO(DBConnect.getConn());
		boolean f = dao.delete_marks(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("suc", "Student Marks Deleted Successfully...");
			resp.sendRedirect("marks.jsp");

		} else {
			session.setAttribute("err", "Something Wrong on Server...");
			resp.sendRedirect("marks.jsp");

		}
		
		
		
	}
	
}
