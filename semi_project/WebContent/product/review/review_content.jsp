<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
.review_view {
	display: none;
	padding: 10px 10px 11px;
	border-top: 1px solid #e3e3e3;
}

.review_view .inner_review {
	width: 100%;
	padding: 20px 9px 9px;
	line-height: 25px;
}

.grade {
	text-align: right;
	color: #000;
	font-size: 18px;
	font-weight: 500;
}

.grade>span {
	color: #512772;
	font-size: 25px;
	font-weight: 700;
}

.bhs_button {
	margin-top: 5px;
	height: 35px;
	width: 40px;
	margin-left: 10px;
	border: 1px solid #512771;
	background-color: #512772;
	font-size: 13px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
}
</style>
<body>
	<div class="review_view" style="display: block;">
		<div class="inner_review">
			<div class="name_purchase">
				<strong class="name">[올프레쉬] 머스크 멜론</strong>
			</div>
			맛있어요
		</div>
		<div class="grade">
			평점 <span>5</span>점
		</div>
	</div>
	<a href="review_edit.do?r_id="><input type="button" class="bhs_button" value="수정"
		style="float: none;"></a>
	<a href="review_delete.do"><input type="button" class="bhs_button" value="삭제"
		style="float: none;"></a>
</body>
</html>