<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/client/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="root" value="/"></c:url>


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>비밀번호찾기</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script>
	
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
	text-align: center;
	margin-left: 7rem;
}

.btn {
	background-color: #512771;
	border: #512771;
	border-radius: 0px;
	float: none;
	height: 40px;
	width: 150px;
	margin-top: 30px;
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
}

.content {
	background-color: #f7f5f8;
	height: 400px;
	padding-top: 1rem;
	padding-bottom: 1rem;
}

ul>li {
	padding-bottom: 1rem;
	margin-left: auto;
}

span {
	margin-left: auto;
	margin-right: auto;
	font-size: 1.2rem;
}
</style>
</head>

<body style="background-color: #f9f9f9">
	<div align='center'>
		<h2>비밀번호찾기</h2>
	</div>
	<div class="content">
		<div class="login">

			<ul>
				<li><span>고객님의 비밀번호 찾기가 완료되었습니다</span></li>
				<hr>
				<li><span>${subpw }</span></li>
				<hr>
				<a href="${root}"><button class="btn">메인화면</button></a>
				<a href="login.do"><button class="btn">로그인</button></a>
			</ul>

		</div>
	</div>
</body>

</html>