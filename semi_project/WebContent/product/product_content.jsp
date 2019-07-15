<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/client/header.jsp"></jsp:include>

<body>
	<div class="container">
	<hr>
		<form>
		<table class="table table-bordered ssss">
			<tbody>
				<tr>
					<td rowspan="2">
					<img src="product_main_image.do?id=${pdto.p_id}"></td>
<%-- 					<img src="product_image.do?save_name=${vdto.save_name}"> --%>
					<td>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td class="productContentName" colspan="2">${pdto.p_name}</td>
								</tr>
								<tr>
									<td width="200" class="text-left">기준판매가격</td>
									<td class="text-left">${pdto.origin_price}원</td>
								</tr>
								<tr>
									<td width="200" class="text-left">할인가격</td>
									<td class="text-left disPrice">${pdto.getDis_price()}원</td>
								</tr>
							</tbody>
						</table><hr>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td width="200" class="text-left">판매단위</td>
									<td class="text-left">${pdto.unit}</td>
								</tr>
								<tr>
									<td width="200" class="text-left">중량/용량</td>
									<td class="text-left">${pdto.p_size}</td>
								</tr>
							</tbody>
						</table><hr>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td width="200" class="text-left">구매수량</td>
									<td class="text-left"><input type="number" name="number" min="1" value="1">개</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td width="200" class="text-left eee">총 상품금액 : </td>
									<td class="text-left"><h4>${pdto.getLast_price()}원</h4></td>
								</tr>
								<tr>
									<td colspan="2">
										<a href="#"><img src="<%=request.getContextPath()%>/image/cartplus.png" class="m-3 cartplus"></a>
										<a href="#" class="btn btn-danger rightbuy"><h5>바로구매</h5></a>
									</td>
								</tr>
							</tbody>
					</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<ul class="nav nav-tabs nav-tabs-primary">
						  <li class="nav-item">
						    <a class="nav-link active" data-toggle="tab" href="#qwe">상품설명</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" data-toggle="tab" href="#asd">고객후기
						    	<span class="badge badge-danger">3</span>
						    </a>
						  </li>
						</ul>
						<div class="tab-content">
						  <div class="tab-pane fade show active" id="qwe"><br><br>
						    <img src="product_content_image.do?id=${pdto.p_id}">
						  </div>
						  <div class="tab-pane fade" id="asd"><br><br>
						    <h4 class="text-left">김지민 : 맛있어요!!! 만족합니다~~ </h4>
						    <h4 class="text-left">김지원 : 배송 무엇? -_-? </h4>
						    <h4 class="text-left">정우근 : ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ </h4>
						  </div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
<jsp:include page="/template/client/footer.jsp"></jsp:include>