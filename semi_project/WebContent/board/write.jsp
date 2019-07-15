<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>

<jsp:include page="/template/left.jsp"></jsp:include>

<h1>글 작성하기</h1>

<form action="write.do" method="post" class="form form-vertical">

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
		<tr>
			<td>
				<select name="head" >
					<option value="">선택하세요</option>
					<option>가격인상공지</option>
					<option>가격인하공지</option>
					<option>가격변경공지</option>
					<option>마켓컬리</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="title" placeholder="제목" required
						size="70">
			</td>
		</tr>
		<tr>
			<td>
				<textarea name="content" placeholder="내용" required
							rows="10" cols="100"></textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr align="right">
			<td><input type="submit" value="글 등록"></td>
		</tr>
	</tfoot>
</table>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>