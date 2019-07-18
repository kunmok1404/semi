<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>


<jsp:include page="/template/left.jsp"></jsp:include>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(function(){
		//댓글 수정을 누르면 .reply-content와 .reply-edit를 교대로 보여줌
		$(".reply-edit").hide();
		
		//수정 버튼
		$(".reply-edit-btn").click(function(e){
			e.preventDefault();
			$(this).parent().prevAll(".reply-content").toggle();
			$(this).parent().prevAll(".reply-edit").toggle();
			if($(this).text() == "수정")
				$(this).text("취소");
			else
				$(this).text("수정");
		});
		
		//댓글 삭제 버튼 : 정말 삭제할 것인지 확인창 출력 후 처리
		$(".reply-delete-btn").click(function(e) {
			e.preventDefault();
			
			var choice = window.confirm("정말 삭제하시겠습니까?");
			if(choice){
				//원래 목적지(href 속성에 적혀있는 주소)로 이동을 시켜준다
				//이동 명령 : location.href = "주소";
				//이동 명령 : $(location).attr("href", "주소");
				var url = $(this).attr("href");
				$(location).attr("href", url);
			}
		});
	});
</script>

<h1>1:1 문의</h1>

<table class="table" width="700">
	<tbody class="text-left">
		<colgroup>
			<col width="200" >
			<col width="*" >
		</colgroup>
		<tr>
			<th rowspan="2">제목</th>
			<td align="left">
				<c:choose>
						<c:when test="${bdto.serviceType eq 1}">
							배송지연/불만
						</c:when>
						<c:when test="${bdto.serviceType eq 2}">
							컬리패스(무료배송)
						</c:when>
						<c:when test="${bdto.serviceType eq 3}">
							반품문의
						</c:when>
						<c:when test="${bdto.serviceType eq 4}">
							A/S문의
						</c:when>
						<c:when test="${bdto.serviceType eq 5}">
							환불문의
						</c:when>
						<c:when test="${bdto.serviceType eq 6}">
							주문결제문의
						</c:when>
						<c:when test="${bdto.serviceType eq 7}">
							회원정보문의
						</c:when>
						<c:when test="${bdto.serviceType eq 8}">
							취소문의
						</c:when>
						<c:when test="${bdto.serviceType eq 9}">
							교환문의
						</c:when>
						<c:when test="${bdto.serviceType eq 10}">
							상품정보문의
						</c:when>
						<c:when test="${bdto.serviceType eq 11}">
							기타문의
						</c:when>
						<c:otherwise>
						</c:otherwise>
						</c:choose>
			</td>
		</tr>
		<tr>
			<td align="left">
				${bdto.serviceTitle}
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content"  readonly="readonly" style="border: 0px;"
							rows="10" cols="100">${bdto.serviceContent}</textarea>
			</td>
		</tr>
		<%-- 댓글 목록 표시영역 --%>
		<c:if test="${grade eq '관리자' }">
		<%-- 댓글 입력 영역 --%>
		<tr>
			<th>답변</th>
			<td align="center">
				<form class="form form-vertical-line" action="commentsOne.do" method="post">
					<input type="hidden" name="serviceNo" value="${bdto.serviceNo}">
					<textarea name="serviceContent" rows="4" cols="100" required placeholder="댓글 입력">${bdto.answerContent}</textarea>
					<input type="submit" value="등록">
				</form>
			</td>
		</tr>
		</c:if>
		<c:if test="${not empty bdto.answerContent and grade ne '관리자'}">
		<%-- 댓글 입력 영역 --%>
		<tr>
			<th>답변</th>
			<td align="right">
					<textarea name="serviceContent" rows="4" cols="100"  style="border: 0px;" readonly="readonly">${bdto.answerContent}</textarea>
			</td>
		</tr>
		<tr>
			<th>답변일</th>
			<td align="left">
				${bdto.answerRgDt}
			</td>
		</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right">
				<a href="deleteOne.do?no=${bdto.serviceNo}">삭제</a>
				<a href="listOne.do">목록</a>
			</td>
		</tr>
	</tfoot>
</table>







