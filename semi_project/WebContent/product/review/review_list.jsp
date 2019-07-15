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
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function() {
		$('.list_after').css('display', 'none');
// 		$(".tab_menu").click(function() {
// 			if (window.location.hash == '#viewBeforeList') {
// 				$(this).children().eq(0).attr('class', "on");
// 				$(this).children().eq(1).attr('class', "");
// 				$('.list_after').css('display', 'none');
// 				$('.list_before').css('display', 'block');
// 			} else {
// 				$(this).children().eq(1).attr('class', "on");
// 				$(this).children().eq(0).attr('class', "");
// 				$('.list_after').css('display', 'block');
// 				$('.list_before').css('display', 'none');
// 			}
// 		})
		$(".tab_menu").find("a").click(function(){
			$(this).parents(".tab_menu").children("li").removeClass("on");
			$(this).parent("li").addClass("on");
			
			if($(this).attr("id") === "viewBeforeList"){
				$(".list_after").hide();
				$(".list_before").fadeIn();
			}
			else{
				$(".list_before").hide();
				$(".list_after").fadeIn();
			}
		});
		
	})
</script>
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

*, *::after, *::before {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.page_section {
	float: right;
	width: 820px;
}

.head_aticle {
	padding: 5px 0 s24px;
}

.head_aticle .tit {
	height: 42px;
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
	color: #514859;
}

.review_notice {
	font-size: 12px;
	color: #514859;
	line-height: 20px;
}

.tab_menu {
	overflow: hidden;
	padding-top: 30px;
}

.section_review .tab_menu li {
	float: left;
	width: 410px;
	height: 50px;
	background-color: #fff;
}

.section_review .tab_menu .on a {
	border-bottom: 2px solid #512772;
	font-weight: 700;
	color: #512772;
}

.section_review .tab_menu li:last-child a {
	border-left: 0 none;
}

.section_review .tab_menu a {
	display: block;
	overflow: hidden;
	width: 100%;
	height: 100%;
	border: 1px solid #dddfe1;
	font-size: 14px;
	color: #514859;
	line-height: 44px;
	text-align: center;
}

ol, ul {
	list-style-type: none;
}

.no_data {
	padding: 50px 0;
	font-size: 13px;
	color: #757575;
	text-align: center;
}

.section_review .list_before {
	padding-top: 10px;
}

.section_review .list_after li.no_data, .section_review .list_before .no_data
	{
	padding: 50px 0;
	border: 0 none;
}

.review_list th {
	padding: 20px 0;
	vertical-align: middle;
	font-size: 12px;
}

.review_list {
	border-top: 2px solid #56297a;
	border-bottom: 2px solid #56297a;
	font-size: 12px;
}

.review_list tr td {
	padding: 12px;
	border-top: 1px solid #e9e9e9;
	text-align: center;
	vertical-align: middle;
	word-wrap: break-word;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

tbody td a {
	color: #56297a;
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
			<div class="page_section section_review">
				<div class="head_aticle">
					<h2 class="tit">상품후기</h2>
				</div>
				<div id="reviewView">
					<div class="review_notice">
						<p>
							<b>후기 작성 시 100원을 적립해드립니다.</b>
						</p>
					</div>
					<ul class="tab_menu">
						<li class="on"><a id="viewBeforeList">작성가능 후기 <span>(개수)</span></a></li>
						<li class=""><a id="viewAfterList">작성완료 후기 <span>(개수)</span></a></li>
					</ul>
				</div>

				<div id="viewBeforeList" class="before_view">
					<ul class="list_before">
						<!-- <li class="no_data">
                            작성가능 후기 내역이 없습니다.
                        </li> -->
						<table width="100%" class="review_list">
							<thead>
								<tr style="text-align: center">
									<th>번호</th>
									<th>상품명</th>
									<th>카테고리</th>
									<th>구매일</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="50" nowrap="" align="center">1</td>
									<td style="padding-left: 10px; text-align: center; color: #999">
										<a href="#"><b>먹으면 힘이 솟는 마늘장아찌가 있다?</b></a>
									</td>
									<td width="100" nowrap="" align="center">음식</td>
									<td width="100" nowrap="" align="center">2019-07-10</td>
									<td width="100" nowrap="" align="center"><a href="review_write.do">작성가능</a></td>
								</tr>
							</tbody>
						</table>
					</ul>
				</div>

				<div id="viewAfterList" class="after_view">
					<ul class="list_after">
						<!-- <li class="no_data">
                            작성한 후기가 없습니다.
                        </li> -->
						<table width="100%" class="review_list">
							<thead>
								<tr style="text-align: center">
									<th>번호</th>
									<th>제목</th>
									<th>상품명</th>
									<th>등록일</th>
									<th>작성자</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="50" nowrap="" align="center">1</td>
									<td style="padding-left: 10px; text-align: center; color: #999">
										<a href="#"><b>먹으면 힘이 솟는 마늘장아찌가 있다?</b></a>
									</td>
									<td width="250" nowrap="" align="center">음식</td>
									<td width="100" nowrap="" align="center">2019-07-10</td>
									<td width="100" nowrap="" align="center">김지원</td>
								</tr>
							</tbody>
						</table>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>