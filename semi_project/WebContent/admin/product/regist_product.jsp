<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/product_left.jsp"></jsp:include>  

<script>
$(function(){
	$("#applybtn").click(function(){
		var choice = $("#select").val();
		$("[name=apply]").val(choice);
		$("#applyText").text(choice);
	});
	 ClassicEditor
     .create( document.querySelector( '#editor' ) )
     .catch( error => {
         console.error( error );
     } )
	// 할인가격, 최종가격 자동계산
	 $("input[name=origin_price], input[name=dis_rate]").blur(function(){
		 var origin_price = parseInt($("input[name=origin_price]").val()); //기준판매가
		 var dis_rate = parseInt($("input[name=dis_rate]").val());	// 할인율
		 var dis_price = origin_price * ((dis_rate)/100);	// 할인가 : 기준가 * 할인율
		 var last_price = origin_price - dis_price;	// 최종판매가 : 기준판매가 - 할인가
		 console.log(dis_price);
		 $("#dis_price").text(dis_price+"원");  //화면에 찍기
		 $("#last_price").text(last_price+"원");//화면에 찍기
		 $("input[name=dis_rate]").val(dis_rate); // input에 할인율 입력
	 })
});
</script>

	<section>
        <div class="container">
            <h5>상품 기본 정보</h5><hr>
            <form action="regist_product.do" method="post" enctype="multipart/form-data">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td class="table-light text-center prd_regist">카테고리</td>
                        <td colspan="3">
                            <div class="form-group">
                                <label for="category"></label>
                                <select class="form-control" id="category" name="category" required>
                                	<c:forEach var="cdto" items="${list}">
                                    <option>${cdto.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">상품명</td>
                        <td colspan="3"><input type="text" class="form-control" name="name" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">상품요약정보</td>
                        <td colspan="3"><input type="text" class="form-control" name="title" value="${vdto.p_title}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">공급사</td>
                        <td colspan="3">
                        	<input type="hidden" name="apply" required>
                        	<span id="applyText"></span>
                            <a class="btn btn-secondary" data-toggle="modal" data-target="#apply">
                                업체찾기                               
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">용량/규격</td>
                        <td colspan="3"><input type="text" class="form-control" name="size" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">단위</td>
                        <td colspan="3"><input type="text" class="form-control" name="unit" required></td>
                    </tr>
<!--                     <tr> -->
<!--                         <td class="table-light text-center prd_regist">매칭레시피</td> -->
<!--                         <td colspan="3"> -->
<!--                             <a href="#" class="btn btn-secondary">레시피찾기</a> -->
<!--                         </td> -->
<!--                     </tr> -->
                    <tr>
                        <td class="table-light text-center prd_regist">공급가격</td>
                        <td><input type="number" class="form-control" name="apply_price" required></td>
                        <td class="table-light text-center prd_regist">기준판매가격</td>
                        <td><input type="number" class="form-control" name="origin_price" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">할인율</td>
                        <td><input type="number" class="form-control" name="dis_rate" value="${vdto.dis_rate}" required>%</td>
                        <td class="table-light text-center prd_regist">할인가격</td>
                        <td id="dis_price">${vdto.getDis_price()}원</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">최종판매가</td>
                        <td id="last_price">${vdto.getLast_price()}원</td>
                        <td class="table-light text-center prd_regist">배송비</td>
                        <td><input type="number" class="form-control" name="delv_price" value="${vdto.bsc_delv_price}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">배송업체</td>
                        <td>
                            <div class="form-group">
                                <label for="delv"></label>
                                <select class="form-control" id="delv" name="delv_corp_name" required>
                                	<option>CJ대한통운</option>
                                    <option>한진택배</option>
                                    <option>현대</option>
                                    <option>로젠</option>
                                    <option>우체국</option>
                                </select>
                            </div>
                        </td>
                        <td class="table-light text-center prd_regist">재고</td>
                        <td><input type="number" class="form-control" name="stock" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">신상품여부</td>
                        <td>
                            <div class="form-group">
                                <label for="delv"></label>
                                <select class="form-control" id="delv" name="new_yn" required>
                                	<option>예</option>
                                    <option selected>아니오</option>
                                </select>
                            </div>
                        </td>
                        <td class="table-light text-center prd_regist">특가상품여부</td>
                        <td>
                            <div class="form-group">
                                <label for="delv"></label>
                                <select class="form-control" id="delv" name="sale_yn" required>
                                	<option>예</option>
                                    <option selected>아니오</option>
                                </select>
                            </div>
                        </td>
                    </tr>  
                    <tr>
                        <td colspan="4"><br><h5>상품 이미지 정보</h5><hr></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">상품 대표 이미지</td>
                        <td colspan="3"><input type="file" name="f_main"></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">상품 목록 이미지</td>
                        <td colspan="3"><input type="file" name="f_list"></td>
                    </tr>
                    <tr class="img">
                        <td class="table-light text-center prd_regist">상품 상세 이미지</td>
                        <td colspan="3">
                            <h4>상품 상세 정보</h4>
                            <input type="file" name="f_content">
                            <textarea name="content" id="editor">
                                &lt;p&gt;상품 상세정보를 입력하세요.&lt;/p&gt;
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" class="text-center">
                            <input type="submit" class="btn btn-primary btn-lg" value="등록">
                            <a href="product_list.do" class="btn btn-success btn-lg">목록</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            </form>
        </div>
        
        <!-- 공급사 찾기 모달 시작-->
        <div class="modal" id="apply">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                <!-- 모달 헤더 -->
                <div class="modal-header">
                    <h4 class="modal-title">공급사 찾기</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 모달 바디 -->
                <div class="modal-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr class="text-center">
                                <td class="table-secondary" width=30%;>공급사</td>
                                <td>
                                    <div class="form-group">
                                        <label for="category"></label>
                                        <select class="form-control" id="select">
                                            <c:forEach var="item" items="${mlist}">
                                            <option>${item.name}</option>
                                         	</c:forEach>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 모달 푸터 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal" id="applybtn">확인</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                </div>
                </div>
            </div>
        </div>
        <!-- 공급사 찾기 모달 끝 -->
    </section>

</body>
</html>