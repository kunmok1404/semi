<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/client/header.jsp"></jsp:include>
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

.page_section {
	float: right;
	width: 820px;
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

.head_aticle {
	padding: 5px 0 24px;
}

.head_aticle .tit {
	height: 42px;
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
	color: #514859;
}

.boardWrite2 {
	table-layout: fixed;
	border-top: 2px solid #6A3664;
	line-height: 180%;
}

.boardWrite2 th {
	text-align: left;
	padding: 15px 15px;
	background: #f7f5f8;
	vertical-align: middle;
}

textarea {
	height: 30px;
	line-height: 25px;
	border: 1px solid #d9d9d9;
	color: #202020;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

.xans-board-write table th {
	width: 110px;
	padding: 15px 0 15px 20px;
	background-color: #F7F5F8;
	border-bottom: 1px solid #e8e8e8;
	text-align: left;
	font-weight: normal;
	vertical-align: middle;
	color: #4c4c4c;
	font-size: 12px;
}

.xans-board-write table td {
	width: auto;
	padding: 15px 0 15px 10px;
	height: 23px;
	border-top: 1px solid #e8e8e8;
	border-bottom: 1px solid #e8e8e8;
	vertical-align: middle;
	line-height: 20px;
}

.bhs_button {
	background-color: #795b8f;
	color: #fff;
	height: 42px;
	width: 150px;
	border: 0px;
	font-size: 13px;
}
</style>
<body>
	<jsp:include page="/template/mypage_top.jsp"></jsp:include>
	<div class="my_kurly">
		<jsp:include page="/template/my_div.jsp"></jsp:include>
		<div class="page_section section_qna">
			<div class="head_aticle">
				<h2 class="tit">후기 작성</h2>
			</div>

			<div class="xans-board-write">
				<form method="post" action="#" style="height: 100%;">
					<!-- <input type="hidden" name="" value=""> -->
					<table id="table_after" class="boardWrite2" width="100%">
						<colgroup>
							<col width="14%" align="right">
						</colgroup>
						<tbody>
							<tr>
								<th class="input_txt">제목</th>
								<td><input type="text" name="title" style="width: 100%"
									required="" value=""></td>
							</tr>
							<tr>
								<th class="input_txt">상품명</th>
								<td><input type="text" name="p_name"
									style="width: 100%; background-color: whitesmoke"
									value="상품명 들어갈 자리" readonly="readonly"></td>
							</tr>
							<tr>
								<th class="input_txt">평점</th>
								<td><select name="grade" required>
										<option>선택</option>
										<option>5점</option>
										<option>4점</option>
										<option>3점</option>
										<option>2점</option>
										<option>1점</option>
								</select></td>
							</tr>
							<tr>
								<th class="input_txt">내용</th>
								<td class="edit_area" style="position: relative;"><textarea
										name="content"
										style="width: 100%; height: 474px; resize: none;"
										class="editing_area" required=""></textarea></td>
							</tr>

						</tbody>
					</table>

					<table width="100%">
						<tbody>
							<tr>
								<td align="right" style="padding-top: 5px; border: none;">
									<input type="submit" class="bhs_button" value="등록"
									style="float: none;"> <a href="#"><input
										type="button" class="bhs_button" value="취소"
										style="float: none;"></a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

		</div>
	</div>
</body>
</html>