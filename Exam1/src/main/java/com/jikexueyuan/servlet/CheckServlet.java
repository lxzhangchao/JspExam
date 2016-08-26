package com.jikexueyuan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jikexueyuan.entity.User;
import com.jikexueyuan.service.CheckUserService;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku=new CheckUserService();

	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		RequestDispatcher rd=null;
		String forward=null;
		if (uname==null) {
			request.setAttribute("msg","用户名为空，请重新登陆！");
			rd=request.getRequestDispatcher("/Exam1/login.jsp");
			rd.forward(request, response);
		} else {
			User user=new User();
			user.setFirst_name(uname);
			boolean bool =cku.check(user);
			if (bool) {
				forward="/Exam1/index.jsp";
			} else {
				request.setAttribute("msg","用户名输入错误，请重新输入！");
				forward="/Exam1/login.jsp";
			}
			rd=request.getRequestDispatcher(forward);
			rd.forward(request,response);
		}
	}
}
