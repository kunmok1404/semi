<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>관리자</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min(flatly).css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/12.2.0/classic/ckeditor.js"></script>
    <script src="https://kit.fontawesome.com/66600be694.js"></script>
    <script>
        $(function(){
            $("div ul li a").click(function(){
                var $this = $(this);
                $this.closest("ul").find("li").removeClass("active");
                $this.closest("li").addClass("active");
            })
            $("aside ul li a").click(function(){
                var $this = $(this);
                $this.closest("ul").find("li").removeClass("active");
                $this.closest("li").addClass("active");
            })
            $("#shop").click(function(){
            	open("${pageContext.request.contextPath}/index.jsp");
            })
        })
    </script>
</head>
<body>
	<!-- 상단네비바 시작 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/main.do">
            <img src="<%=request.getContextPath()%>/image/logo.jpg" class="adminLogo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto nav-menu">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/member/member_list.do">회원관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/product/product_list.do">상품관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">레시피관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/manufacture/manufacture_list.do">공급사관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">주문관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">고객센터</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">포인트관리</a>
                </li>
            </ul>
            <span class="user text-white m-3">
                ${sessionScope.id}님 안녕하세요!
            </span>
            <span class="last_login text-white m-3">
                최종접속일자 : ${memdto.loginDate}
            </span>
            <a href="${pageContext.request.contextPath}/member/logout.do" class="text-body btn btn-light m-2">로그아웃</a>
            <a class="text-body btn btn-light" id="shop">쇼핑몰</a>
        </div>
    </nav>
    <!-- 상단네비바 끝 -->