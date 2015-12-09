package com.hanains.mysite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;
import com.hanains.mysite.http.action.guestbook.GuestListActionFactory;

@WebServlet("/gs")
public class guestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public guestbookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");
		ActionFactory actionFactory = new GuestListActionFactory();
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);
		/*
		if("delete".equals(actionName)){
			HttpUtil.forwading(request, response, "/WEB-INF/views/deleteform.jsp");
		}else if("insert".equals(actionName)){//완료
			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String message = request.getParameter("content");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			GuestBookDao dao = new GuestBookDao();
			dao.insert(vo);
			
			response.sendRedirect("/guestbook2/gs");
		}else if("del".equals(actionName)){
			request.setCharacterEncoding("UTF-8");

			String no = request.getParameter("no");
			String pass = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(Long.parseLong(no));
			vo.setPassword(pass);
			
			GuestBookDao dao = new GuestBookDao();

			dao.Delete(vo);
			
			response.sendRedirect("/guestbook2/gs");
			
		}else{
			//index(default action)
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.getList();
			//data setting
			request.setAttribute("list", list);
			//forwarding
			HttpUtil.forwading(request, response, "/WEB-INF/views/index.jsp");
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
