<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- <link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
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
.btn {
	background-color: #512771;
	border: #512771;
	border-radius: 0px !important;
	float: none;
	height: 40px;
	width: 150px;
	margin-left: 10px;
	font-size: 14px;
	color: #fff;
	line-height: 34px;
	vertical-align: top;
}

input[type="text"]{
	height: 40px;
	width: 150px;
}

.idlabel {
	color: #514859;
	font-weight: 700;
	font-size: 14px;
	line-height: 10px;
	text-align: left;
	width: 5rem;
}

input[type="text"] {
	height: 40px;
	width: 300px;
	border: 1px solid lightgrey;
}

table {
	height: 640px;
	width: 650px;
}

td {
	padding-top: 10px;
	padding-left: 20px;
}

.addr input {
	margin-top: 10px;
}

h1 {
	color: #512771;
	padding-top: 3rem;
	padding-bottom: 3rem;
}

h4 {
	color: #512771;
	padding-left: 21rem;
	padding-top: 1rem;
}

.agree {
	background-color: #fff;
	position: center;
	width: 650px;
	margin-top: 1rem;
	text-align: left;
}

input[type='submit'] {
	background-color: #512771;
	color: white;
	margin-top: 2rem;
	margin-bottom: 2rem;
	width: 200px;
	height: 48px;
	border: 0px;
}

.select {
	margin-left: 2rem;
}

span {
	color: #949296;
	height: 40px;
	width: 150px;
}

.all {
	font-weight: 600;
}

.all-agree {
	margin-left: 1rem;
}

.birth-text>input {
	height: 37px;
	width: 80px;
	border: none;
	text-align: center;
}

.birth-text {
	border: lightgray 1px solid;
	width: 300px;
	height: 40px;
}
</style>

<body style="background-color: #f9f9f9">
	<div>
		<h1 align="center">회원가입</h1>
	</div>
	<form action="regist.do" method="post">
		<div align="center">
			<table style="background-color: #fff">
				<tbody>
					<tr>
						<td class="idlabel">아이디</td>
						<td><input type="text" name="id" value="" maxlength="16"
							placeholder="예:영어 숫자 15자이내" required> <a href=""> <span
								class="btn id-chk">중복확인</span>
						</a></td>
					</tr>

					<tr>
						<td class="idlabel">비밀번호</td>
						<td><input type="text" name="pwd" value maxlength="16"
							placeholder="비밀번호를 입력해주세요" required></td>
					</tr>

					<tr>
						<td class="idlabel">이름</td>
						<td><input type="text" name="name" placeholder="예:백컬리"
							required></td>
					</tr>

					<tr>
						<td class="idlabel">이메일</td>
						<td><input type="text" name="email" value maxlength="16"
							placeholder="예:back@kurly.com" required> <a href="">
								<span class="btn id-chk">중복확인</span>
						</a></td>
					</tr>
					
					<tr>
						<td class="idlabel">전화번호</td>
						<td><input type="text" name="phone" placeholder="'-'없이 숫자만입력해주세요"
							required></td>
					</tr>

					<tr>
						<td class="idlabel">생년월일</td>
						<td>
							<div class="birth-text">
								<input type="text" name="birth" value maxlength="4"
									placeholder="YYYY" required> <span>/</span> <input
									type="text" name="birth" value maxlength="2" placeholder="MM"
									required> <span>/</span> <input type="text"
									name="birth" value maxlength="2" placeholder="DD" required>
							</div>
						</td>
					</tr>

					<tr>
						<td class="idlabel">배송주소</td>
						<td class="addr"><input type="text" name="zip_code"
							placeholder="우편번호" readonly> <input type="button" value="우편번호 찾기"
							class="btn btn-addr" required><br> <input
							type="text" name="basic_addr" placeholder="주소" readonly><br> <input
							type="text" name="detail_addr" placeholder="상세주소"></td>
					</tr>
					
					<tr>
						<td class="idlabel">질문</td>
						<td>
						<select name="question">
							<option>자신의 보물 제1호는?</option>				
							<option>초등학교 이름은?</option>				
							<option>제일 친한 친구 이름은?</option>				
						</select>
						</td>
					</tr>
					
					<tr>
						<td class="idlabel">답변</td>
						<td><input type="text" name="answer" placeholder="답변"
							required></td>
					</tr>
				</tbody>
			</table>

			<div class="agree">
				<div class="all-agree">
					<input type="checkbox" id="name" class="all-chk"> <label
						for="name" class="all">전체동의</label><span>(필수)</span>
				</div>
				<div class="select">
					<input type="checkbox" id="name1" class="sub-chk" required>
					<label for="name1">이용약관</label> <a href="#"> >약관보기</a>
				</div>
				<div class="select">
					<input type="checkbox" id="name2" class="sub-chk" required>
					<label for="name2">개인정보처리방침</label><a href="#">>약관보기</a>
				</div>
				<div class="select">
					<input type="checkbox" id="name3" class="sub-chk" required>
					<label for="name3">본인은 만 14세 이상입니다</label>
				</div>
			</div>
			<input type="submit" value="가입하기">
		</div>
	</form>
</body>


<jsp:include page="/template/footer.jsp"></jsp:include>