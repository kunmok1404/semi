<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/client/header.jsp"></jsp:include>
    <script>
        $(function(){
            var swiper1 = new Swiper(".swiper1", {
                direction: 'horizontal',
                loop: true,
    
                pagination: {
                el: '.swiper-pagination',
                type:'bullets',
                clickable:true,
                },

                navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
                },
    
                effect:'slide',
    
                slidesPerGroup:1,//넘어가는 장수
                slidesPerView:1,//표시할 장수
                loopFillGroupWithBlank:false,//장수가 맞지 않을 때 처리 여부        
            });
        });
    </script>
</head>
<body><br>
        <!-- 메인이미지 컨테이너 -->
        <div class="swiper-container swiper1">
            <!-- Additional required wrapper -->
            <div class="swiper-wrapper">
                <!-- Slides -->
                <div class="swiper-slide main1">
                    <a href="<%=request.getContextPath()%>/product/product_cat_list.do?product_category_name=과일/견과/쌀"><img src="<%=request.getContextPath()%>/image/main1.png"></a>
                </div>
                <div class="swiper-slide main1">
                    <a href="<%=request.getContextPath()%>/product/product_cat_list.do?product_category_name=간편식"><img src="<%=request.getContextPath()%>/image/main2.png"></a>
                </div>
                <div class="swiper-slide main1">
                    <a href="<%=request.getContextPath()%>/product/product_cat_list.do?product_category_name=채소"><img src="<%=request.getContextPath()%>/image/main3.png"></a>
                </div>
            </div>
            <!-- 메인이미지 페이지 -->
            <div class="swiper-pagination"></div>
        
            <!-- 메인이미지 버튼 -->
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
        
            <!-- If we need scrollbar -->
            <div class="swiper-scrollbar"></div>
        </div><!-- 메인 이미지 컨테이너 끝 -->
        
        <!--베스트상품 텍스트 -->
        <h2 class="event1_text">베스트 상품</h2>

        <!-- 베스트상품 이벤트 테이블 -->
        <table class="table table-borderless">
            <tbody>
                <tr>
                    <td>
	           			<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=56"><img src="<%=request.getContextPath()%>/image/cherry.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        싱싱한 체리 한 송이 어때요?
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
                      	<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=134"><img src="<%=request.getContextPath()%>/image/mara.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        원조 중국식 마라탕면!
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
						<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=40"><img src="<%=request.getContextPath()%>/image/abocado.jpg"></a>
	                    <br><br>
	                    <table class="table table-borderless">
	                        <tbody>
	                            <tr>
	                                <td class="text-center recipe">
	                                   자연의 보물~ 아보카도!
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                    </td>
                </tr>
            </tbody>
        </table>
        <!-- 레시피 테이블 끝-->

        <!--이벤트1텍스트 -->
        <h2 class="event1_text">이런 상품 어때요?</h2>
        
        <!-- 상품목록 테이블 -->
        <table class="table table-borderless">
            <tbody>
                <tr>
                    <td>
	           			<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=106"><img src="<%=request.getContextPath()%>/image/this1.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        간편 간식 브리또!
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
                      	<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=130"><img src="<%=request.getContextPath()%>/image/this2.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        완전 맛나 병 샐러드~
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
						<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=142"><img src="<%=request.getContextPath()%>/image/this3.jpg"></a>
	                    <br><br>
	                    <table class="table table-borderless">
	                        <tbody>
	                            <tr>
	                                <td class="text-center recipe">
	                                   차돌 묵은지 볶음밥^_^*
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                    </td>
                </tr>
            </tbody>
        </table>
        <!-- 상품목록 테이블 끝-->

        <!--이벤트2텍스트 -->
        <h2 class="event1_text">MD 추천!</h2>

        <!-- 레시피 이벤트 테이블 -->
        <table class="table table-borderless">
            <tbody>
                <tr>
                    <td>
	           			<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=82"><img src="<%=request.getContextPath()%>/image/md1.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        무농약 친환경 콩나물
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
                      	<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=98"><img src="<%=request.getContextPath()%>/image/md2.jpg"></a>
						<br><br>
                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td class="text-center recipe">
                                        파프리카 한잔
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    <td>
						<a href="<%=request.getContextPath()%>/product/product_content.do?p_id=122"><img src="<%=request.getContextPath()%>/image/md3.jpg"></a>
	                    <br><br>
	                    <table class="table table-borderless">
	                        <tbody>
	                            <tr>
	                                <td class="text-center recipe">
	                                   리얼 미니 군고구마ㅋ
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                    </td>
                </tr>
            </tbody>
        </table>
        <!-- 레시피 테이블 끝-->
	</body>
    <jsp:include page="/template/client/footer.jsp"></jsp:include>
    