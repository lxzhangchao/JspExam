package com.jikexueyuan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		hs.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/Exam1/index.jsp");
		rd.forward(request, response);
	}

}
