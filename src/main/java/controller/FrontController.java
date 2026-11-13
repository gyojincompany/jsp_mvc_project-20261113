package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.MemberDao;
import dto.MemberDto;


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
		} else if(command.equals("/login.do")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if(command.equals("/loginSuccess.do")) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			
		} else if(command.equals("/memberJoinAction.do")) {
			//DB에 회원가입
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			MemberDao dao = new MemberDao();
			int result = dao.insertMember(userid, userpw, username, email); //회원가입 메소드 호출
			//성공여부 확인->result값이 1이면 성공, 0이면 실패
			if(result == 1) { //참->가입성공
				request.setAttribute("userid", userid);
				request.setAttribute("userpw", userpw);
				request.getRequestDispatcher("/login.do").forward(request, response);
			} else {
				response.sendRedirect("memberJoin.do");
			} 
		} else if(command.equals("/loginAction.do")) {
			//로그인 확인 메소드 호출
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			
			MemberDao dao = new MemberDao();
			MemberDto mdto = dao.login(userid, userpw); //1이면 로그인성공, 0이면 실패
			
			if(mdto != null) { //참이면 -> 로그인 성공 진행시킴
				HttpSession session = null; //세션 선언
				session = request.getSession(); //세션 초기화
				session.setAttribute("loginId", userid); 
				//로그인 성공처리->세션에 로그인한 유저의 아이디 올리기
				request.setAttribute("memberDto", mdto);
				request.getRequestDispatcher("/loginSuccess.do").forward(request, response);
			} else {
				response.sendRedirect("login.do");
				//로그인 실패 시 로그인 화면으로 다시 이동
			}
			
		}
	}

}
