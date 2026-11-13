package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		String context = request.getContextPath();
		
		String command = uri.substring(context.length());
		
		request.setCharacterEncoding("utf-8");
		
		if(command.equals("/memberJoin.do")) {
			request.getRequestDispatcher("memberJoin.jsp").forward(request, response);
		} else if(command.equals("/memberJoinAction.do")) {
			//DB에 회원가입
			
		}
	}

}
