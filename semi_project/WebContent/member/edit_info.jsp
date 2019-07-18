<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/client/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function() {
		$(".btn-addr").click(findAddress);

		$(".all-chk").change(function() {
			console.log("?");
			if ($(this).is(":checked")) {
				$(".sub-chk").prop("checked", true);
			} else {
				$(".sub-chk").prop("checked", false);
			}	
		});

		$(".sub-chk").change(function() {
			if (!$(this).is(":checked")) {
				$(".all-chk").prop("checked", false);
			}
		})
	})

	function findAddress() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다
				}
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				//document.querySelector('input[name=postcode]').value = data.zonecode;
				//document.querySelector("input[name=basicaddr]").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				//document.querySelector("input[name=detailaddr]").focus();

				// 이 코드는 jquery.js를 먼저 불러온 경우만 사용 가능
				$("input[name=zip_code").val(data.zonecode);
				$("input[name=basic_addr]").val(addr);
				$("input[name=detail_addr]").focus();
			}
		}).open();
	}
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

.section_myinfo {
	float: right;
	width: 820px;
}

*, *::after, *::before {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.head_article {
	border: 5px 0 24px;
}

.head_article .tit {
	height: 42px;
	font-weight: 700;
	font-size: 24px;
	line-height: 36px;
	color: #514859;
}

.field_head {
	margin-top: -3px;
	padding-top: 0;
	padding: 12px 0 10px;
}

.field_head .tit {
	float: left;
	font-weight: 700;
	font-size: 20px;
	color: #514859;
	line-height: 28px;
}

.boardWrite {
	padding: 0 20px 12px;
	border-top: 2px solid #6a3664;
	border-bottom: 1px solid #dddfe1;
	font-size: 11px;
	color: #747474;
	line-height: 20px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

.boardWrite .memberCols1 {
	width: 149px;
	padding: 30px 0 0 29px;
	font-weight: 700;
	font-size: 14px;
	color: #514859;
	line-height: 20px;
	vertical-align: top;
}

.boardWrite .memberCols2 {
	padding: 20px 0 0 0;
	border-top: 0 none;
	font-size: 0;
	vertical-align: top;
	text-align: left;
}

.boardWrite .memberCols2 .inp_read {
	background-color: #f9f9f9;
}

.boardWrite input[type="text"], .boardWrite input[type="password"],
	select {
	width: 300px;
	height: 40px;
	padding: 0 9px;
	border: 1px solid #dddfe1;
	font-size: 14px;
	color: #000;
	line-height: 20px;
}

a {
	background-color: transparent;
	text-decoration: none;
	color: inherit;
}

.bhs_button.active {
	border: 1px solid #512772;
	background-color: #fff;
	color: #512772;
}

.bhs_button {
	float: none;
	height: 40px;
	width: 150px;
	margin-left: 10px;
	border: 1px solid #512771;
	background-color: #512772;
	font-size: 14px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
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

		<div class="section_myinfo">
			<div class="head_aticle">
				<h2 class="tit">개인 정보 수정</h2>
			</div>

			<div class="member_join">
				<div class="">
					<form method="post" action="edit_info.do">
						<div class="field_head">
							<h3 class="tit">기본정보</h3>
							<br>
						</div>
						<div class="boardWrite">
							<table class="tbl_comm">
								<tbody>
									<tr>
										<td class="memberCols1">아이디</td>
										<td class="memberCols2"><input type="text" name="m_id"
											value="${sessionScope.id}" readonly="" class="inp_read"></td>
									</tr>
									<tr>
										<td class="memberCols1">새 비밀번호</td>
										<td class="memberCols2"><input type="password"
											name="newPassword" id="newPassword" maxlength="16"
											class="reg_pw">
											<input type='hidden' name = "password" value="${mdto.pwd }">
											</td>
									</tr>
									<tr>
										<td class="memberCols1">새 비밀번호 확인</td>
										<td class="memberCols2"><input type="password"
											name="confirmPassword" id="confirmPassword" maxlength="16"
											class="confirm_pw"></td>
									</tr>
									<tr>
										<td class="memberCols1">이름</td>
										<td class="memberCols2"><input type="text" name="name"
											value="${mdto.name}" readonly="" placeholder="예: 김컬리"
											class="inp_read"></td>
									</tr>
									<tr>
										<td class="memberCols1">이메일</td>
										<td class="memberCols2"><input type="text" name="email"
											value="${mdto.email}" size="30" required=""
											placeholder="예: baekkurly@kurly.com"></td>
									</tr>
									<tr class="mobile">
										<td class="memberCols1">휴대폰</td>
										<td class="memberCols2">
											<div class="phone_num">
												<input type="text" value="${mdto.phone}" pattern="[0-9]*"
													name="phone" placeholder="'-' 없이 숫자만 입력해주세요." class="inp">
											</div>
										</td>
									</tr>
									<tr>
										<td class="memberCols1">생년월일</td>
										<td class="memberCols2"><input type="text" name="birth"
											maxlength="4" value="${mdto.birth}" class="inp_read"
											readonly=""></td>
									</tr>

									<tr>
										<td class="memberCols1">배송주소</td>
										<td class="memberCols2"><input type="text"
											name="zip_code" placeholder="우편번호" value="${mdto.zipCode }"readonly> <input
											type="button" value="우편번호 찾기" class="bhs_button btn-addr"
											required><br> <input type="text"
											name="basic_addr" placeholder="주소" value="${mdto.basicAddr }" readonly><br>
											<input type="text" name="detail_addr" value="${mdto.detailAddr }"placeholder="상세주소"></td>
									</tr>

									<tr>
										<td class="memberCols1">질문</td>
										<td class="memberCols2"><select name="question" value="${mdto.question }">
												<option>자신의 보물 제1호는?</option>
												<option>초등학교 이름은?</option>
												<option>제일 친한 친구 이름은?</option>
										</select></td>
									</tr>

									<tr>
										<td class="memberCols1">답변</td>
										<td class="memberCols2"><input type="text" name="answer"
											value="${mdto.answer }" required></td>
									</tr>
								</tbody>
							</table>
						</div>

						<div style="text-align: center; float: left; margin-top: 20px; margin-left: 20%;">
							<span class="noline"><a href="#"><span
									class="bhs_button active" style="float: left;">취소</span></a></span> <a
								href="#"><span class="bhs_button active"
								style="float: left;">탈퇴하기</span></a> <span class="noline"><input
								type="submit" class="bhs_button" value="회원정보수정"
								style="float: none; max-width: none;"></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>