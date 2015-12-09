package com.hanains.mysite.http.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null){
			HttpUtil.redirect(response, "/mysite/Main");
			return;
		}
		
		//logout
		session.removeAttribute("authUser");
		session.invalidate();//session id 재발급
		//logout 후 Main으로
		HttpUtil.redirect(response, "/mysite/Main");
	}

}
