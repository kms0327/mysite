package com.hanains.mysite.http.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String password = request.getParameter("pwd");
		
		request.setAttribute("no", no);
		request.setAttribute("password", password);
		
		HttpUtil.forwarding(request, response, "/WEB-INF/views/guestbook/deleteform.jsp");
		
	}

}
