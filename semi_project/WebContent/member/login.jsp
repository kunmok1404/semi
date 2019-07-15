<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/client/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="root" value="/"></c:url>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script>
<c:if test="${param.error!=null}">
alert('아이디 또는 패스워드가 틀립니다.');
</c:if>
</script>

<style>
h2 {
	padding-top: 3rem;
	padding-bottom: 3rem;
	color: #512771;
}

.login>ul {
	display: inline-table;
	list-style: none;
}

input[type="submit"] {
	background-color: #512771;
	border: #512771;
	border-radius: 0px;
	float: none;
	height: 70px;
	width: 150px;
	margin-left: 10px;
	font-size: 14px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
}

.login {
	height: 90px;
	width: 650px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5rem;
	border-bottom: #512771 1px solid;
}

.content {
	background-color: #f7f5f8;
	height: 318px;
	padding-top: 2rem;
}

ul>li {
	padding-bottom: 1rem;
}

.btn {
	background-color: #fff;
	border: #6A3664 solid 1px;
	height: 50px;
	width: 150px;
	margin-left: 10px;
	font-size: 14px;
	color: #6a3664;
	border-radius: 0px;
}
</style>
</head>

<body style="background-color: #f9f9f9">
	<div align='center'>
		<h2>로그인</h2>
	</div>
	<div class="content">
		<form action="login.do" method="post">
			<div class="login">
				<ul>
					<li><span>아이디</span></li>
					<li><span>비밀번호</span></li>
				</ul>
				<ul>
					<li><input type="text" name="id" required></li>
					<li><input type="password" name="pwd" required></li>
				</ul>
				<ul>
					<li><input type="submit" value="회원 로그인"
						class="btn btn-primary"></li>
				</ul>

			</div>
		</form>
		<div style="padding: 1rem"></div>
		<div align="center">
			<a href="${root}"><button class="btn">메인화면</button></a> <a
				href="find_id.do"><button class="btn">아이디찾기</button></a> <a
				href="find_pwd.do"><button class="btn">비밀번호찾기</button></a> <a
				href="regist.do"><button class="btn">회원가입</button></a>
		</div>
	</div>
</body>


