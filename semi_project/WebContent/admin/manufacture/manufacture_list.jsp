<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/manufacture_left.jsp"></jsp:include>    

<script>
	$(function(){
		$(".ok").click(function(){
			var apply = confirm("승인하시겠습니까?");
			if(apply){
				var id = $(this).attr("data-pid");
				location.href="apply_manufacture.do?id=" + id;
			}
		})
		$(".del").click(function(){
			var del = confirm("공급사를 삭제하시겠습니까?");
			if(del){
				var id = $(this).attr("data-pid");
				location.href="delete_manufacture.do?id=" + id;
			}
		})
	})
</script>
        <!-- 공급사검색 시작 -->
        <section>
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                        <h5>공급사 목록</h5><hr>
                </div>
            </div>
        
            
            <table class="table table-sm">
                <tbody>
                    <tr>
                       <td class="text-center menu">업체명</td>
                       <td>
                            <input type="text" name = "name">
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
                       <td class="text-center menu">계약기간</td>
                       <td class="input">
                            <input type="date"> ~ <input type="date">까지
                       </td> 
                       <td class="text-center menu">키워드검색</td> 
                       <td>
                            <select class="form-control-sm" id="select">
                                <option>대표자명</option>
                                <option>대표자전화번호</option>
                                <option>담당자명</option>
                                <option>담당자전화번호</option>
                                <option>업종</option>
                                <option>사업자번호</option>
                            </select>
                            <input type="text" name = "keyword">
                       </td> 
                    </tr>
                    <tr>
                       <td class="text-center menu">계약상태</td>
                       <td>
                            <select class="form-control-sm">
                                <option>전체</option>
                                <option>계약중</option>
                                <option>계약종료</option>
                            </select>
                       </td>
                    </tr>
                </tbody>
            </table>
            <button class="btn btn-primary search">검색</button><br><br>
        <!-- 공급사검색 끝 -->

        <!-- 공급사목록 시작 -->
	        <div class="row prd_list">
		        <div class="col-xs-12 table-responsive">
			        <table class="table table-bordered table-hover">
			            <thead>
			                <tr class="table-primary text-center">                 
			                    <th>코드</th>
			                    <th>공급사명</th>
			                    <th>업종</th>
			                    <th>사업자번호</th>
			                    <th>대표자명</th>
			                    <th>담당자명</th>
			                    <th>승인상태</th>
			                    <th>계약상태</th>
			                    <th>조작</th>
			                </tr>
			            </thead>
			            <tbody>
			            	<c:forEach var="mdto" items="${list}">
			                <tr class="text-center">
			                    <td>${mdto.id}</td>
			                    <td><a href="manufacture_content.do?id=${mdto.id}">${mdto.name}</a></td>
			                    <td>${mdto.type}</td>
			                    <td>${mdto.business_no}</td>
			                    <td>${mdto.ceo_name}</td>
			                    <td>${mdto.manager_name}</td>
			                    <td>${mdto.apply_status}</td>
			                    <td>${mdto.contract_status}</td>
			                    <td>
			                    	<c:if test="${mdto.apply_status eq '승인대기'}">
			                    	<a type="button" class="btn btn-info btn-sm ok" href="#" data-pid="${mdto.id}">승인</a>
			                    	</c:if>
			                    	<a type="button" class="btn btn-danger btn-sm del" href="#" data-pid="${mdto.id}">삭제</a>
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