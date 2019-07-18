<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/client/header.jsp"></jsp:include>

<jsp:include page="/template/my_service_left.jsp"></jsp:include>

<h1>1:1 문의</h1>

<form action="writeOne.do" method="post" class="form form-vertical">

<%-- 답글일 경우에는 parent 값을 전달 --%>
<%-- if(답글이라면){ --%>
<%-- <% if(request.getParameter("parent") != null){ %> --%>
<c:if test="${not empty param.parent }">
<%-- if(request.getParameterMap().containsKey("parent")){ --%>
	<input type="hidden" name="parent" 
					value="${param.parent }">
<%--<%}%>--%>
</c:if>
<table border="1" width="700" class="table">
	<tbody>
		<colgroup>
		<col width="100" >
		<col width="*" >
		</colgroup>
		<tr>
			<th rowspan="2">제목</th>
			<td>
				<select name="head" >
					<option value="">선택하세요</option>
					<option value="1" <c:if test="${bdto.serviceType eq 1}">selected</c:if>>배송지연/불만</option>
					<option value="2" <c:if test="${bdto.serviceType eq 2}">selected</c:if>>컬리패스(무료배송)</option>
					<option value="3" <c:if test="${bdto.serviceType eq 3}">selected</c:if>>반품문의</option>
					<option value="4" <c:if test="${bdto.serviceType eq 4}">selected</c:if>>A/S문의</option>
					<option value="5" <c:if test="${bdto.serviceType eq 5}">selected</c:if>>환불문의</option>
					<option value="6" <c:if test="${bdto.serviceType eq 6}">selected</c:if>>주문결제문의</option>
					<option value="7" <c:if test="${bdto.serviceType eq 7}">selected</c:if>>회원정보문의</option>
					<option value="8" <c:if test="${bdto.serviceType eq 8}">selected</c:if>>취소문의</option>
					<option value="9" <c:if test="${bdto.serviceType eq 9}">selected</c:if>>교환문의</option>
					<option value="10" <c:if test="${bdto.serviceType eq 10}">selected</c:if>>상품정보문의</option>
					<option value="11" <c:if test="${bdto.serviceType eq 11}">selected</c:if>>기타문의</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="title" placeholder="제목"  value="${bdto.serviceTitle}"
						size="70">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" placeholder="내용" required
							rows="10" cols="100"></textarea>
			</td>
		</tr>
	</tbody>
	<thead>
	</thead>
	<tfoot>
		<tr align="center">
			<td colspan="2"><input type="submit" value="저장"></td>
		</tr>
	</tfoot>
</table>
</form>

<jsp:include page="/template/client/footer.jsp"></jsp:include>