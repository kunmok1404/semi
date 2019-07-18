<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/product_left.jsp"></jsp:include>    

<script>
	$(function(){
		$("#point").click(function(){
			var id = $(this).attr("data-id");
			var point = $(this).attr("data-point");
			$("input[name=id]").val(id);
			$("input[name=current_Point]").val(point);
		})
// 		$("#modal-form").submit(function(e){
// 			e.preventDefault();
// 			var apply = confirm("진행하시겠습니까?");
// 			if(apply){
// 				var point = $("input[name=point]").val();
// 				var reason = $("input[name=reason]").val();
// 				var id = $("input[name=id]").val();
// // 				location.href="charge_point.do?id=" + id +"&point="+point + "&reason="+reason;
// 				console.log($("#modal-form").get(0));
// 				$("#modal-form").get(0).submit();
// 			}
// 		})
		$(".del").click(function(){
			var del = confirm("해당 회원을 탈퇴처리 하시겠습니까?");
			if(del){
				var id = $(this).attr("data-pid");
				location.href="delete_member.do?id=" + id;
			}
		})
	})
</script>
        <!-- 회원검색 시작 -->
        <section>
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                        <h5>상품 목록</h5><hr>
                </div>
            </div>
        
            
            <table class="table table-sm productList">
                <tbody>
                    <tr>
                       <td class="text-center menu">카테고리</td>
                       <td>
                            <select class="form-control-sm">
                                <option>유제품</option>
                                <option>고기</option>
                                <option>야채</option>
                                <option>채소</option>
                                <option>통조림</option>
                            </select>
                       </td> 
                       <td class="text-center menu">승인여부</td> 
                       <td>
                            <select class="form-control-sm" id="select">
                                <option>전체</option>
                                <option>승인대기</option>
                                <option>승인완료</option>
                            </select>
                       </td> 
                    </tr>
                    <tr>
                       <td class="text-center menu">상품등록일</td>
                       <td class="input">
                            <input type="date"> ~ <input type="date">까지
                       </td> 
                       <td class="text-center menu">키워드검색</td> 
                       <td>
                            <select class="form-control-sm" id="select">
                                <option>상품명</option>
                                <option>상품코드</option>
                                <option>업체명</option>
                            </select>
                            <input type="text" name = "keyword">
                       </td> 
                    </tr>
                    <tr>
                       <td class="text-center menu">판매상태</td>
                       <td>
                            <select class="form-control-sm">
                                <option>전체</option>
                                <option>판매중</option>
                                <option>판매중지</option>
                            </select>
                       </td>
                    </tr>
                </tbody>
            </table>
            <button class="btn btn-primary search">검색</button><br><br>
        <!-- 회원검색 끝 -->

        <!-- 회원목록 시작 -->
	        <div class="row prd_list">
		        <div class="col-xs-12 table-responsive">
			        <table class="table table-bordered table-hover productList">
			            <thead>
			                <tr class="table-primary text-center">                 
			                    <th>회원번호</th>
			                    <th>아이디</th>
			                    <th>이름</th>
			                    <th>이메일</th>
			                    <th>전화번호</th>
			                    <th>가입일</th>
			                    <th>최종접속일</th>
			                    <th>회원분류</th>
			                    <th>등급</th>
			                    <th>조작</th>
			                </tr>
			            </thead>
			            <tbody>
			            	<c:forEach var="item" items="${mlist}">
			                <tr class="text-center">
			                    <td>${item.no}</td>
			                    <td><a href="member_content.do?id=${item.id}">${item.id}</a></td>
			                    <td>${item.name}</td>
			                    <td>${item.email}</td>
			                    <td>${item.phone}</td>
			                    <td>${item.join_date}</td>
			                    <td>${item.login_date}</td>
			                    <td>${item.status}</td>
			                    <td>${item.grade}</td>
			                    <td>
			                    	<a type="button" class="btn btn-danger btn-sm del" href="#" data-pid="${item.id}">탈퇴</a>
<%-- 			                       	<a type="button" class="btn btn-success btn-sm point" href="#" data-pid="${item.id}">포인트</a> --%>
		                        
		                        	<span id="applyText">${vdto.m_name}</span>
		                            <a id="point" type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#apply" data-id="${item.id}" data-point="${item.current_point}">
		                                포인트                               
		                            </a>
		                   		
			                </tr>
			                </c:forEach>
			            </tbody>
			        </table>
		        </div>
		    </div>
        </div>
        
        <!-- 포인트 모달 시작-->
        <form id="modal-form" action="charge_point.do" method="post">
        <input type="hidden" name="id">
        <input type="hidden" name="current_Point">
        <div class="modal" id="apply">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                <!-- 모달 헤더 -->
                <div class="modal-header">
                    <h4 class="modal-title">포인트 관리</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 모달 바디 -->
                <div class="modal-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr class="text-center">
                                <td class="table-secondary" width=30%;>포인트 금액</td>
                                <td>
                                    <div class="form-group">
                                        <input type="number" name="point" class="form-control" placeholder="금액을 입력하세요."><br>
                                        <textarea rows="7" cols="" name="reason" class="form-control" placeholder="사유를 입력하세요."></textarea>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 모달 푸터 -->
                <div class="modal-footer">
                    <button type="submit" id="submit" class="btn btn-primary">확인</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                </div>
                </div>
            </div>
        </div>
        </form>
        <!-- 포인트 모달 끝 -->
        
        </section>
        <!-- 회원목록 끝 -->
</body>
</html>