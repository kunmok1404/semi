<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/template/client/header.jsp"></jsp:include>

<c:if test="${param.error!=null}">
			alert('비밀번호가 틀립니다.');
</c:if>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
.my_div {
	float: left;
	width: 200px;
}

.list_div {
	border: 1px solid #dcdbde;
	border-bottom: none;
}

.menu_title {
	padding: 0 0 30px 2px;
	font-weight: 700;
	font-size: 28px;
	line-height: 41px;
}

ol, ul {
	list-style-type: none;
}

.list_menu li {
	border-bottom: 1px solid #dcdbde;
}

.list_menu a {
	display: block;
	padding: 16px 0 16px 19px;
	background-size: 6px 10px;
	font-size: 12px;
	color: #514859;
	line-height: 18px;
}

.my_kurly {
	padding-top: 70px;
	width: 1050px;
	margin: 0 auto;
}

.list_menu {
	padding-left: 0px;
}

.section_info {
	float: right;
	width: 820px;
}

*, *::after, *::before {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.head_article {
	padding: 5px 0 24px;
}

.head_article .tit {
	height: 42px;
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
	color: #514859;
}

.conf_pw {
	padding: 38px 0 24px;
	border-top: 2px solid #512772;
}

.conf_pw .tit {
	padding: 20px 0px;
	text-align: center;
}

.field_pw {
	padding: 33px 0;
	border: 2px solid #ddd;
	text-align: center;
}

.tit_id, .tit_pw {
	padding: 10px 0 10px;
	font-size: 13px;
	line-height: 18px;
	font-weight: 700;
	color: #000;
}

.txt_id {
	font-size: 13px;
	line-height: 18px;
	font-weight: 700;
	color: #512772;
}

.inp_pw {
	width: 120px;
	height: 34px;
	padding: 0 10px;
	border: 1px solid #514859;
	font-size: 12px;
	color: #000;
	line-height: 32px;
}

.group_btn {
	overflow: hidden;
	width: 100%;
	text-align: center;
	padding-top: 20px;
}

.inner_groupbtn {
	display: inline-block;
}

.btn_positive {
	border: 1px solid #56297a;
	background-color: #795b8f;
	color: #fff;
}

.btn_submit {
	overflow: hidden;
	float: left;
	width: 150px;
	height: 42px;
	font-size: 13px;
	line-height: 40px;
	text-align: center;
	border-radius: 0px;
}

.mypage_top {
	width: 100%;
	padding: 50px 0;
	margin-bottom: -20px;
	background-color: #f7f7f7;
}

.page_aticle {
	width: 1050px;
	margin: 0 auto;
}
</style>
<body>
	<jsp:include page="/template/mypage_top.jsp"></jsp:include>
	<div class="my_kurly">
		<jsp:include page="/template/my_div.jsp"></jsp:include>
		<div class="section_info">
			<div class="head_article">
				<h2 class="tit">개인 정보 수정</h2>
			</div>
			<div class="conf_pw">
				<form method="post" action="check_pw.do">
					<div class="tit">
						<img src="${pageContext.request.contextPath}/image/check_pw.PNG">
					</div>
					<div class="field_pw">
						<div class="tit_id">아이디</div>
						<span class="txt_id">${sessionScope.id}</span>
						<div class="tit_pw">비밀번호</div>
						<div>
							<!-- <input type="hidden" name="mode" id="mode" value="confirmPassword"> -->
							<input type="password" name="confirm_password"
								id="confirm_password" class="inp_pw">
						</div>
					</div>
					<div class="group_btn" style="text-align: center">
						<span class="inner_groupbtn">
							<button type="submit" class="btn_submit btn_positive">확인</button>
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>