<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/product_left.jsp"></jsp:include>  

<script>
	$(function(){
		$(".submit").click(function(e){
			var obj = {};
			$("input[name=cat_name]").each(function(i,d){
				obj[$(this).val()] = $(this).parent().next().children().val();
			})
			console.log(obj);
			console.log(JSON.parse(JSON.stringify(obj)));
			$.ajax({
				url : "edit_category.do",
				data : JSON.parse(JSON.stringify(obj)),
			    success : function(resp){
			    	if(resp == "Y"){
			    		alert("수정이 완료되었습니다.")
			    	}
			    }
			})
		})
		
		// 삭제버튼 클릭시 데이터 삭제
		$(".del").click(function(){
			$.ajax({
				url : "delete_category.do",
				data : {
					name:$(this).parent().parent().children().children().val()
				},
			    success : function(resp){
			    	if(resp == "Y"){
			    		alert("삭제가 완료되었습니다.")
			    	}
			    }
			})
		})
		
		//프로그램 시작시 템플릿 백업 후 삭제
		var template = $(".template").clone();
		$(".template").remove();
		
		$(".add").click(function(){
			//신규 추가하는 버튼에 적용할 이벤트
			var new_template = template.clone();
			new_template.find(".del").click(function(){
				$(this).parents("tr").remove();
			});
			$(".input").last().after(new_template);
		})
		
		//처음 표시되는 버튼에 적용할 이벤트
		$(".del").click(function(){
			$(this).parents("tr").remove();
		})
	})
</script>

        <!-- 카테고리 관리 시작 -->
      <section>
        <div class="container">
        	<h5>카테고리 관리</h5><hr>
            <table class="table table-hamburg table-hover text-center">
                <thead>
                    <tr class="cat_head table-primary">
                        <td>카테고리명</td>
                        <td>노출순서</td>
                        <td>카테고리코드</td>
                    </tr>
                </thead>
                <tbody class="input">
                	<c:forEach var="cdto" items="${list}">
                    <tr>
                        <td><input type="text" name="cat_name" value="${cdto.name}" required></td>
                        <td><input type="text" name="sort_no" value="${cdto.sort_seq}" required></td>
                        <td>${cdto.id}</td>
                        <td><button class="btn_delete btn-block btn-secondary del">-삭제</button></td>
                    </tr>
                    </c:forEach>
                    <!-- 템플릿 -->
					<tr class="template">
                        <td><input type="text" name="cat_name" required></td>
                        <td><input type="text" name="sort_no" required></td>
                        <td></td>
                        <td><button class="btn_delete btn-block btn-secondary del">-삭제</button></td>
                    </tr>
                </tbody>
                <tfoot>
                	<tr>
                        <td colspan="3"><button class="btn_plus btn-primary add">+추가</button></td>
                        <td><button class="btn btn-info btn-block submit">등록</button></td>
                    </tr>
                </tfoot>
            </table>
        </div>
      </section>
        <!-- 카테고리 관리 끝 -->
</body>
</html>