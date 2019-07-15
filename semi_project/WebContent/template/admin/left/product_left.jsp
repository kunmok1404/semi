<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <!-- 상품관리 왼쪽사이드메뉴 시작 -->
        <aside>
	        <ul class="list-group list-group-flush">
	               <li class="list-group-item">
	               		<a href="<%=request.getContextPath()%>/admin/product/product_list.do">
                    		상품 목록
                		</a>
	               </li>
	               <li class="list-group-item">
	               		<a href="<%=request.getContextPath()%>/admin/product/regist_product.do">
                    		상품 등록
                		</a>
	               </li>
	               <li class="list-group-item">
	               		<a href="<%=request.getContextPath()%>/admin/product/select_cat.do">
                    		카테고리 관리
                		</a>
	               </li>
	               <li class="list-group-item">
	               		<a href="#">
                    		배송 설정
                		</a>
	               </li>
	        </ul>
    	</aside>
        <!-- 상품관리 왼쪽사이드메뉴 끝 -->