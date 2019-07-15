<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/client/header.jsp"></jsp:include>

<body><br>
	<div class="container">
		<div id="content">
			<div class="page_article">
				<div id="lnbMenu" class="lnb_menu">
					<div id="bnrCategory" class="bnr_category">
						<div class="thumb"></div>
						<a href="#none" class="link_event">페이지 이동</a>
					</div>
					<div class="inner_lnb">
						<div class="ico_cate">
							<span class="ico" style="display: block;">
								<img src="http://img-cf.kurly.com/shop/data/category/icon_fruit_active_pc@2x.1553068076.png">
							</span>
							<span class="tit">${cat}</span>
						</div>
						<ul class="list">
							<li class="mr-2">
								<a href="<%=request.getContextPath()%>/product/product_list.do">전체보기</a>
							</li>
							<c:forEach var="item" items="${list}">
                            	<li class="text-center mr-2"><a href="<%=request.getContextPath()%>/product/product_cat_list.do?product_category_name=${item.name}">${item.name}</a></li>
                            </c:forEach>
						</ul>
					</div><hr>
				</div>
				<div id="goodsList">
					<div class="list_goods">
						<ul class="list">
							<c:forEach var="pdto" items="${p_list}">
							<li>
								<div class="item">
									<div class="thumb">
										<a href="product_content.do?p_id=${pdto.p_id}"><img src="product_image.do?id=${pdto.p_id}"></img></a>
									</div>
									<a href="" class="info">
										<span class="name" id="p_name">
											<a href="product_content.do?p_id=${pdto.p_id}">${pdto.p_name}</a><hr>
										</span>	
										<span class="cost">
											<span class="dc">${pdto.origin_price}원</span>
											<span class="emph">-></span>
											<span class="price">${pdto.getLast_price()}원</span>
											<span class="disRate ml-3">${pdto.dis_rate}%</span>
										</span>
										<span class="desc">
											${pdto.p_title}
										</span>
									</a>
									<span class="tag" id="icon">
										<c:if test="${pdto.sale_yn eq '예'}">
										<span><img src="../image/sale.png"></span>
										</c:if>
										<c:if test="${pdto.new_yn eq '예'}">
                                        <span><img src="../image/new.png"></span>
                                        </c:if>
									</span>
								</div>
							</li>	
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/template/client/footer.jsp"></jsp:include>