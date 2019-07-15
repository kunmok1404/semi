<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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

.page_section {
	float: right;
	width: 820px;
}

.page_section .head_aticle {
	padding: 5px 0 24px;
}

.head_aticle .tit {
	height: 42px;
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
	color: #514859;
}

.tit_sub {
	padding-left: 8px;
	font-size: 12px;
}

.point_header {
	overflow: hidden;
	height: 100px;
	border: 1px solid #ddd;
}

.point_header .point_view {
	float: left;
	width: 409px;
	border-right: 1px solid #ddd;
}

.point_header .tit {
	float: left;
	padding: 38px 0 0 60px;
	font-size: 14px;
	color: #000;
	line-height: 20px;
}

.point_header .subject {
	float: left;
	padding: 29px 0 0 60px;
	font-size: 14px;
	color: #000;
	line-height: 20px;
}

.point_header .num {
	float: right;
	width: 200px;
	padding: 34px 58px 36px 0;
	font-size: 20px;
	line-height: 30px;
	font-weight: 700;
	color: #512772;
	text-align: right;
}

.point_header .point {
	float: right;
	width: 260px;
	padding: 34px 59px 36px 0;
	font-size: 20px;
	line-height: 30px;
	font-weight: 700;
	color: #512772;
	text-align: right;
}

.section_point .info {
	padding-left: 20px;
	text-align: left;
}

.section_point .point {
	font-weight: 700;
	color: #56297a;
}

.section_point td {
	padding-top: 16px;
	padding-bottom: 16px;
	font-size: 14px;
	color: #000;
	line-height: 20px;
	text-align: center;
}

.tbl_type1 {
	margin-top: 40px;
}

.tbl {
	width: 100%;
}

thead {
	display: table-header-group;
	vertical-align: middle;
	border-color: inherit;
	text-align: center;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

th.info {
	padding-left: 20px;
	text-align: left;
}

.tbl_type1 th {
	padding: 20px 0;
	border-top: 2px solid #512772;
	font-weight: 700;
	font-size: 14px;
	line-height: 20px;
	color: #4c4c4c;
	letter-spacing: -0.3px;
}

.no_data {
	padding: 50px 0;
	font-size: 13px;
	color: #757575;
	text-align: center;
}

th {
	display: table-cell;
	vertical-align: inherit;
	font-weight: bold;
	text-align: -internal-center;
}

/* .section_point tr:first-child td {
            border-top: 2px solid #ddd;
        } */
.tbl tbody {
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
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

.bhs_button {
	margin-top: 5px;
	height: 40px;
	width: 100px;
	margin-left: 10px;
	border: 1px solid #512771;
	background-color: #512772;
	font-size: 14px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
}

.charge {
	font-size: 12px;
}

.charge tr td {
	padding: 12px;
	text-align: center;
	vertical-align: middle;
	word-wrap: break-word;
}
</style>
<body>
	<jsp:include page="/template/mypage_top.jsp"></jsp:include>
	<div class="my_kurly">
		<jsp:include page="/template/my_div.jsp"></jsp:include>
		<div class="section_info">
			<div class="page_section section_point">
				<div class="head_aticle">
					<h2 class="tit">
						지갑 <span class="tit_sub">보유하고 계신 포인트의 내역을 한 눈에 확인 하실 수
							있습니다.</span>
					</h2>
				</div>
				<div id="viewPointList">
					<div class="point_header">
						<div class="point_view">
							<h3 class="tit">현재 포인트</h3>
							<strong class="point">${pdto.currentPoint} <span
								class="won">원</span></strong>
						</div>
						<span class="disappear"> <span class="subject no_day">
								총 사용 포인트 </span> <span class="num">??? 원</span>
						</span>
					</div>
					<table class="tbl tbl_type1">
						<colgroup>
							<col style="width: 120px;">
							<col style="width: auto;">
							<col style="width: 122px;">
							<col style="width: 140px;">
						</colgroup>
						<thead>
							<tr>
								<th>날짜</th>
								<th class="info">내용</th>
								<th>구분</th>
								<th>금액</th>
							</tr>
						</thead>
						<tbody>
								<c:choose>
									<c:when test="${pList!=null }">
										<c:forEach var="pdt" items="${pList}">
										<tr>
											<td>${pdt.useDate }</td>
											<td class="info"><a class="link">${pdt.reason}</a></td>
											<td><span>${pdt.useType }</span></td>
											<td class="point">${pdt.point}원</td>
										</tr>
									</c:forEach>
									</c:when>

									<c:otherwise>	
										<td colspan="4" class="no_data">적립금 내역이 존재하지 않습니다.</td>
									</c:otherwise>
								</c:choose>
						</tbody>
					</table>
					<!---->
				</div>

			</div>
			<button type="button" class="bhs_button" data-toggle="modal"
				data-target="#myModal">충전</button>
		</div>
	</div>

	<!-- Modal -->
	<form action="charge.do" method="post">
		<input type="hidden" name="currentpoint" value="${pdto.currentPoint}" >
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">충전하기</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table class="charge">
							<tbody>
								<tr>
									<td>충전금액</td>
									<td><input type="text" name="point"
										placeholder="충전금액을 입력하세요.">원</td>
								</tr>
								<tr>
									<td>결제방식</td>
									<td><input type="radio" name="card">신용카드&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="moeny">계좌이체</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
						<input type="submit" class="btn btn-primary" value="충전">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>