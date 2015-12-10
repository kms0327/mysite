<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="navigation">
			<ul>
			<c:choose>
				<c:when test="${param.menu == 'main' }">
					<li class="selected"><a href="">안대혁</a></li>
					<li><a href="/mysite/gs?a=list">방명록</a></li>
					<li><a href="/mysite/board?a=list">게시판</a></li>
				</c:when>	
				<c:when test="${param.menu == 'guest' }">
					<li ><a href="">안대혁</a></li>
					<li class="selected"><a href="/mysite/gs?a=list" >방명록</a></li>
					<li><a href="/mysite/board?a=list">게시판</a></li>
				</c:when>	
				<c:when test="${param.menu == 'board' }">
					<li><a href="">안대혁</a></li>
					<li><a href="/mysite/gs?a=list">방명록</a></li>
					<li class="selected"><a href="/mysite/board?a=list">게시판</a></li>
				</c:when>	
			</c:choose>
			</ul>
		</div>