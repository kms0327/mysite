<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.hanains.mysite.dao.GuestBookDao" %>
<%@ page import="com.hanains.mysite.vo.GuestBookVo" %>
<%@ page import="java.util.List" %>
<% 
	GuestBookDao dao = new GuestBookDao();
	List<GuestBookVo> list = dao.getList();
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/gs" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				
				<ul>
					<%
						int countTotal = list.size();
						int index = 0;
						for(GuestBookVo vo : list)	{
					%>
					<li>
					<form action="/mysite/gs" method="post">
						<table>
							<tr>
								<td><%=countTotal-index++ %></td>
								<td><%=vo.getName() %></td>
								<td><%=vo.getDate() %></td>
								<td><input type="submit" value="삭제"></td>
							</tr>
							<tr>
								<td colspan=4><%=vo.getMessage() %><br></td>
							</tr>
						</table>
						<input type="hidden" name="a" value="delete">
						<input type='hidden' name="no" value="<%=vo.getNo() %>"> 
						<input type='hidden' name="pwd" value="<%=vo.getPassword() %>">
						<br>
						</form>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>