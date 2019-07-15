﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<i id=gi>공지사항</i>

<form class="form" action="list.do" method="get">
<div style="margin-left: 600px; border: 0px;">
<input type="hidden"  name="type" value="title+content"/>
<input type="search" name="keyword" placeholder="제목 + 내용" required>

<input type="submit" value="검색">
</div>
</form>

<br>
<!-- 표 -->
<table class="table  table-hover" width="800">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>번호</th>
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<!-- 게시글 -->
	<tbody align="center">
		<c:forEach var="bdto" items="${p.list}">
		<tr>
			<td>${bdto.no}</td>
			<td class="text-left">
			
				<%-- 차수(depth)만큼 띄어쓰기 진행 --%>
				<c:forEach var="i" begin="1" end="${bdto.depth}">
					&nbsp;&nbsp;
				</c:forEach>
				
				<%-- 답변글만 아이콘 추가 --%>
				<c:if test="${bdto.depth > 0}">
				<img src="../image/reply.png" width="30" height="20">
				</c:if>
			
				<%-- 말머리는 있을 때에만 [] 를 붙여서 출력한다. --%>
				<c:if test="${not empty bdto.head}">
				[${bdto.head}] 
				</c:if>
				
				<%-- content.do로 가기 위해 no를 첨부한다 --%>
				<a href="content.do?no=${bdto.no}">
					${bdto.title}
				</a>
				
			</td>
			<td>${bdto.writer}</td>
			<td>${bdto.auto}</td>
			<td>${bdto.read}</td>
		</tr>
		</c:forEach>
	</tbody>
	<!-- 글쓰기 버튼 -->
	<tfoot>
		<tr>
			<td colspan="8" align="right">
			<c:if test="${grade eq 'VIP' }">
				<a href="write.do">글쓰기</a>
			</c:if>
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



