<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page_aticle mypage_top">
	<div class="mypagetop_user">
		<div class="inner_mypagetop">
			<div class="grade_user">
				<div class="grade_bnenfit">
					<div class="user">
						<strong class="name">${mdto.name}</strong> <span class="txt">님</span>
					</div>
					<a href="#">${mdto.grade}등급</a>
				</div>
			</div>
		</div>
		<br>
		<ul class="list_mypage">
			<li class="user_reserve">
				<div class="link">
					<div class="tit">포인트</div>
					<a href="#" class="info"> ${pdto.currentPoint} 원 </a>
				</div>
			</li>
		</ul>
	</div>
</div>