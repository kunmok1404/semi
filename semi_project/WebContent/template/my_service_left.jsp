<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="my_div">
	<div class="list_div">
		<ul class="list_menu">
			<li><h4>고객센터</h4></li>
			<li><a href="${pageContext.request.contextPath}/board/list.do">공지사항</a></li>
			<li><a href="${pageContext.request.contextPath}/board/listOne.do">1:1문의</a></li>
		</ul>
	</div>
</div>