<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/product_left.jsp"></jsp:include>  

<script>
$(function(){
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
	<section>
        <div class="container">
            <h5>회원 정보</h5><hr>
            <form action="member_content.do" method="post">    
            <input type="hidden" name="id" value="${mdto.id}">
            <input type="hidden" name="pw" value="${mdto.pwd}">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td class="table-light text-center prd_regist">아이디</td>
                        <td colspan="3">${mdto.id}</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">새 비밀번호</td>
                        <td colspan="3">
                        	<input type="password" class="form-control" 
                        		name="newPassword" id="newPassword">
                        </td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">이름</td>
                        <td colspan="3">${mdto.name}</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">포인트</td>
                        <td colspan="3">${pdto.currentPoint}</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">이메일</td>
                        <td colspan="3"><input type="text" class="form-control" name="email" value="${mdto.email}"></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">휴대폰</td>
                        <td colspan="3"><input type="text" class="form-control" name="phone" value="${mdto.phone}"
                         placeholder="'-' 없이 숫자만 입력해주세요."></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">생년월일</td>
                        <td><input type="number" class="form-control" name="birth" maxlength="4" value="${mdto.birth}"></td>
                    </tr>
                    <tr>
						<td class="table-light text-center prd_regist">배송주소</td>
						<td colspan="3">
							<input type="text" name="zip_code" placeholder="우편번호" value="${mdto.zipCode }"readonly> 
							<input type="button" value="우편번호 찾기" class="bhs_button btn-addr" required><br> 
							<input type="text" name="basic_addr" placeholder="주소" value="${mdto.basicAddr }" readonly><br>
							<input type="text" name="detail_addr" value="${mdto.detailAddr }"placeholder="상세주소">
						</td>
					</tr>
					<tr>
						<td class="table-light text-center prd_regist">질문</td>
						<td colspan="3"><select name="question" value="${mdto.question }" class="form-control">
								<option>자신의 보물 제1호는?</option>
								<option>초등학교 이름은?</option>
								<option>제일 친한 친구 이름은?</option>
						</select></td>
					</tr>
					<tr>
						<td class="table-light text-center prd_regist">답변</td>
						<td><input type="text" name="answer" value="${mdto.answer}" class="form-control" required></td>
					</tr>
					<tr>
                        <td colspan="4" class="text-center">
                            <input type="submit" class="btn btn-primary btn-lg" value="수정">
                            <a href="member_list.do" class="btn btn-success btn-lg">목록</a>
                        </td>
                    </tr>
			  	</tbody>
			 </table>
			 </form>        
       </div> 
       
    </section>

</body>
</html>