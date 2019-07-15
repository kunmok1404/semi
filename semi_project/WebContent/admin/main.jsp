<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/footer.jsp"></jsp:include>

<!-- 메인내용 시작 -->
     <div class="row">
         <div class="col-md-11 m-5">
         <table class="table table-borderless">
             <tbody>
                 <tr>
                     <td class="text-right"><i class="fas fa-gift fa-9x"></i></td>
                     <td>
                         <h4><strong class="qqq">상품 등록 현황</strong></h4><hr>
                         <h5>총상품등록 : ${p_count}건</h5>
                         <h5 class="text-info">승인완료 : ${p_applyOk}건</h5>
                         <h5 class="text-danger">승인대기 : ${p_applyOk - 1}건</h5>
                     </td>
                     <td class="text-right"><i class="fas fa-users fa-9x"></i></td>
                     <td>
                         <h4><strong class="qqq">회원 등록 현황</strong></h4><hr>
                         <h5>총누적회원 : 1000건</h5>
                         <h5 class="text-info">가입회원 : 900건</h5>
                         <h5 class="text-danger">탈퇴회원 : 100건</h5>
                     </td>
                     <td class="text-right"><i class="fas fa-bullhorn fa-9x"></i></td>
                     <td>
                         <h4><strong class="qqq">1:1문의 현황</strong></h4><hr>
                         <h5>총문의수 : 500건</h5>
                         <h5 class="text-info">답변완료 : 400건</h5>
                         <h5 class="text-danger">답변대기 : 100건</h5>
                     </td>
                 </tr>
             </tbody>
         </table><br>
         <h4><i class="fas fa-truck fa-2x"></i><strong class="www"> 오늘의 주문 현황</strong></h4>
         <table class="table table-bordered table-hover">
             <tbody>
                 <tr>
                     <td class="table-info">
                         <h5>상품준비중</h5>
                         <h4 class="text-right"><strong>4</strong></h4>
                     </td>
                     <td class="table-info">
                         <h5>배송중</h5>
                         <h4 class="text-right"><strong>3</strong></h4>
                     </td>
                     <td class="table-info">
                         <h5>배송완료</h5>
                         <h4 class="text-right"><strong>2</strong></h4>
                     </td>
                     <td class="table-info">
                         <h5>구매확정</h5>
                         <h4 class="text-right"><strong>11</strong></h4>
                     </td>
                     <td class="table-danger">
                         <h5>레시피 등록현황</h5>
                         <h4 class="text-right"><strong>20</strong></h4>
                     </td>
                 </tr>
                 <tr>
                     <td class="table-success">
                         <h5>취소</h5>
                         <h4 class="text-right"><strong>4</strong></h4>
                     </td>
                     <td class="table-success">
                         <h5>환불요청</h5>
                         <h4 class="text-right"><strong>3</strong></h4>
                     </td>
                     <td class="table-success">
                         <h5>교환요청</h5>
                         <h4 class="text-right"><strong>2</strong></h4>
                     </td>
                     <td class="table-success">
                         <h5>총주문건수</h5>
                         <h4 class="text-right"><strong>11</strong></h4>
                     </td>
                     <td class="table-danger">
                         <h5>상품후기</h5>
                         <h4 class="text-right"><strong>20</strong></h4>
                     </td>
                 </tr>
                 
             </tbody>
         </table>
         </div>
     </div>