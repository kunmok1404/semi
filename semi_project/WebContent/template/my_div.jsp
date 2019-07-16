<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="my_div">
	<h2 class="menu_title">마이컬리</h2>
	<div class="list_div">
		<ul class="list_menu">
			<li><a href="#">주문 내역</a></li>
			<li><a href="${pageContext.request.contextPath}/point/balance.do">지갑</a></li>
			<li><a href="${pageContext.request.contextPath}/product/review/review_list.do">상품후기</a></li>
			<li class=""><a href="${pageContext.request.contextPath}/member/check_pw.do">개인 정보 수정</a></li>
		</ul>
	</div>
</div>