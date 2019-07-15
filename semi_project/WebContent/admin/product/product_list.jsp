<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/product_left.jsp"></jsp:include>    

<script>
	$(function(){
		$(".ok").click(function(){
			var apply = confirm("승인하시겠습니까?");
			if(apply){
				var no = $(this).attr("data-pid");
				location.href="apply_product.do?no=" + no;
			}
		})
		$(".del").click(function(){
			var del = confirm("상품을 삭제하시겠습니까?");
			if(del){
				var p_id = $(this).attr("data-pid");
				location.href="delete_product.do?p_id=" + p_id;
			}
		})
	})
</script>
        <!-- 상품검색 시작 -->
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
        <!-- 상품검색 끝 -->

        <!-- 상품목록 시작 -->
	        <div class="row prd_list">
		        <div class="col-xs-12 table-responsive">
			        <table class="table table-bordered table-hover productList">
			            <thead>
			                <tr class="table-primary text-center">                 
			                    <th>상품코드</th>
			                    <th>상품명</th>
			                    <th>카테고리</th>
			                    <th>공급사</th>
			                    <th>기준판매가</th>
			                    <th>최종판매가</th>
			                    <th>승인상태</th>
			                    <th>판매상태</th>
			                    <th>상품등록일</th>
			                    <th>조작</th>
			                </tr>
			            </thead>
			            <tbody>
			            	<c:forEach var="rdto" items="${list}">
			                <tr class="text-center">
			                    <td>${rdto.p_id}</td>
			                    <td><a href="product_content.do?p_id=${rdto.p_id}">${rdto.p_name}</a></td>
			                    <td>${rdto.product_category_name}</td>
			                    <td>${rdto.m_name}</td>
			                    <td>${rdto.origin_price}원</td>
			                    <td>${rdto.last_price}원</td>
			                    <td>${rdto.apply_status}</td>
			                    <td>${rdto.sale_status}</td>
			                    <td>${rdto.regist_date}</td>
			                    <td>
			                    	<c:if test="${rdto.apply_status eq '승인대기'}">
			                    	<a type="button" class="btn btn-info btn-sm ok" href="#" data-pid="${rdto.p_id}">승인</a>
			                    	</c:if>
			                    	<a type="button" class="btn btn-danger btn-sm del" href="#" data-pid="${rdto.p_id}">삭제</a>
			                    </td>
			                </tr>
			                </c:forEach>
			            </tbody>
			        </table>
		        </div>
		    </div>
        </div>
        </section>
        <!-- 상품목록 끝 -->
</body>
</html>