<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>백컬리: 백종원의 레시피</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/admin.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min(flatly).css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/swiper.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common_semi.css">
<script src="<%=request.getContextPath()%>/js/swiper.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://kit.fontawesome.com/66600be694.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!--     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

<script>
// 	$(function() {
// 		$("#admin").click(function() {
// 			open("${pageContext.request.contextPath}/admin/index_admin.jsp");
// 		})
// 	})
</script>

</head>

<body>
	<div class="topEvent">
		<a href="#" class="top_message"> <strong> 지금 가입시 1000포인트
				적립! 가입하러가기~ </strong> <img
			src="<%=request.getContextPath()%>/image/money.png" class="money">
		</a>
	</div>
	<nav class="navbar navbar-expand-lg navbar-white bg-white static-top">
		<div class="container">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/index.jsp"> <img
				src="<%=request.getContextPath()%>/image/logo.jpg" class="mainLogo">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto topNav">

					<c:choose>
						<c:when test="${not empty sessionScope.id}">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/member/check_pw.do">나의정보</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/list.do">고객센터</a></li>
							
							<c:if test="${sessionScope.id eq 'admin'}">
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/main.do"
									id="admin">관리자</a>
							</c:if>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/member/regist.do">회원가입</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/member/login.do">로그인</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/list.do">고객센터</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
	</nav>
	<br>

	<div id="menu_area" class="menu-area">
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-light navbar-expand-md mainmenu">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav">
							<li class="dropdown mr-5"><a
								class="dropdown-toggle menulist"
								href="<%=request.getContextPath()%>/product/main_category.do"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> <img
									src="<%=request.getContextPath()%>/image/menu.png"
									class="menuList"> 카테고리
							</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<c:forEach var="item" items="${list}">
										<li class="text-center"><a
											href="<%=request.getContextPath()%>/product/product_cat_list.do?product_category_name=${item.name}">${item.name}</a></li>
									</c:forEach>
								</ul></li>
							<li class="mr-5"><a
								href="<%=request.getContextPath()%>/product/new_product.do"
								class="menulist">신상품 </a></li>
							<li class="mr-5"><a
								href="<%=request.getContextPath()%>/product/best_product.do"
								class="menulist">베스트</a></li>
							<li class="mr-3"><a
								href="<%=request.getContextPath()%>/product/sale_product.do"
								class="menulist">특가상품</a></li>
						</ul>
					</div>

					<form class="form-inline yyy">
						<input class="form-control mr-sm-2" type="search"
							placeholder="검색어를 입력하세요" aria-label="Search">
<!-- 						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button> -->
						<input type="submit" class="btn btn-outline-success my-2 my-sm-0" value="검색">
					</form>
					<a href="#"> <img
						src="<%=request.getContextPath()%>/image/cart.png" class="cart">
						<div class="badge badge-danger">4</div>
					</a>
				</nav>

			</div>
		</div>
	</div>
</body>

</html>