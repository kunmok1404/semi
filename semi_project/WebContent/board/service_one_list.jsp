<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<i id=gi style="margin-right: 700px;">1:1문의</i>

<!-- <form class="form" action="list.do" method="get"> -->
<!-- <div style="margin-left: 600px; border: 0px;"> -->
<!-- <input type="hidden"  name="type" value="title+content"/> -->
<!-- <input type="search" name="keyword" placeholder="제목 + 내용" required> -->

<!-- <input type="submit" value="검색"> -->
<!-- </div> -->
<!-- </form> -->

<br>
<!-- 표 -->
<table class="table  table-hover" width="800">
	<colgroup>
	<col width="10%">
	<col width="10%">
	<col width="*">
	<col width="10%">
	<col width="15%">
	<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>카테고리</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>답변상태</th>
		</tr>
	</thead>
	<!-- 게시글 -->
	<tbody align="center">
		<c:choose>
		<c:when test="${empty p.list }">
			<td colspan="6">1:1문의 내역이 존재하지않습니다.</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="bdto" items="${p.list}" varStatus="num">
				<tr>
					<td>${bdto.rn}</td>
					<td>
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
					<td class="text-left">
						<a href="contentOne.do?no=${bdto.serviceNo}">
							${bdto.serviceTitle}
						</a>
					</td>
					<td>${bdto.serviceWriter}</td>
					<td>${bdto.registDate}</td>
					<td>${bdto.answerStatus}</td>
					</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</tbody>
	<!-- 글쓰기 버튼 -->
	<tfoot>
		<tr>
			<td colspan="8" align="right">
				<a href="writeOne.do">글쓰기</a>
			</td>
		</tr>
	</tfoot>
</table>

<!-- 네비게이션 + 검색창 -->

<div class="empty"></div>



<div class="empty"></div>

<ul class="navigator">
	<%-- 이전 구간 링크 --%>
	<c:if test="${not p.isFirstBlock()}">
	<li><a href="list.do?${p.getPrevBlock()}">&lt;&lt;</a></li>
	</c:if>
	
	<%-- 이전 페이지 링크(pno - 1) --%>
	<c:if test="${not p.isFirstPage()}">
	<li><a href="list.do?${p.getPrevPage()}">&lt;</a></li>
	</c:if>
	
	<%-- 페이지 출력 --%>
	<c:forEach var="i" begin="${p.startBlock}" end="${p.endBlock}">
		<c:choose>
			<c:when test="${p.isCurrentPage(i)}">
				<li class="active">${i}</li>
			</c:when>
			<c:otherwise>
				<li><a href="list.do?${p.getPage(i)}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<%-- 다음 페이지 링크(pno + 1) --%>
	<c:if test="${not p.isLastPage()}">
		<li><a href="list.do?${p.getNextPage()}">&gt;</a></li>
	</c:if>
	
	<%-- 다음 구간 --%>
	<c:if test="${not p.isLastBlock()}">
		<li><a href="list.do?${p.getNextBlock()}">&gt;&gt;</a></li>
	</c:if>
</ul>



