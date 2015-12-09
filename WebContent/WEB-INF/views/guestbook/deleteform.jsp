<%@ page contentType="text/html;charset=UTF-8" %>
<%
	String no = request.getParameter("no");
	String password = request.getParameter("pwd");
%>
<!doctype html>
<html>
<head>
<script type="text/javascript">
	function check(){
		if(document.check_form.ps.value != document.check_form.password.value){
			alert("비밀번호가 틀렸습니다");
			return false;
		}else{
			document.check_form.submit();
		}
	}
</script>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form name="check_form" method="post" action="/mysite/gs">
					<input type="hidden" name="a" value="del">
					<input type='hidden' name="ps" value="<%=password%>">
					<input type='hidden' name="no" value="<%=no%>">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="button" value="확인"  onclick="check()">
				</form>
				<a href="/mysite/gs">방명록 리스트</a>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>