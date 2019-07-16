<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>비밀번호찾기</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script>
<c:if test="${param.error!=null}">
			alert('입력하신 정보가 일치하지 않습니다.');
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

.btn {
	background-color: #512771;
	border: #512771;
	border-radius: 0px;
	float: none;
	height: 80px;
	width: 150px;
	margin-left: 50px;
	font-size: 14px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
	margin-top: 1rem;
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
	height: 300px;
	padding-top: 2rem;
}

ul>li {
	padding-bottom: 1rem;
}

.ul>li {
	padding-bottom: 1.4rem;
}
</style>
</head>

<body style="background-color: #f9f9f9">
	<div align='center'>
		<h2>비밀번호찾기</h2>
	</div>
	<div class="content">
		<form action="find_pwd.do" method="post">
			<div class="login">
				<ul class="ul">
					<li><span>이름</span></li>
					<li><span>아이디</span></li>
					<li><span>가입 메일주소</span></li>
				</ul>
				<ul>
					<li><input type="text" name="name" required></li>
					<li><input type="text" name="id" required></li>
					<li><input type="text" name="email" required></li>
				</ul>
				<a href="find_pw.do"><button class="btn">확인</button></a>
			</div>
		</form>
	</div>
</body>

</html>