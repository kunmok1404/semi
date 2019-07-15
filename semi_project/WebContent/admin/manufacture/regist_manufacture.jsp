<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/manufacture_left.jsp"></jsp:include>     

<script>
$(function(){
	$("#applybtn").click(function(){
		var choice = $("#select").val();
		$("[name=apply]").val(choice);
		$("#applyText").text(choice);
	});
});
</script>

	<section>
        <div class="container">
            <h5>공급사 기본 정보</h5><hr>
            <form action="regist_manufacture.do" method="post">
            <table class="table table-bordered" id="manufacture">
                <tbody>
                    <tr>
                        <td class="table-light text-center prd_regist">공급사명</td>
                        <td colspan="3"><input type="text" class="form-control" name="name" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">업종</td>
                        <td colspan="3"><input type="text" class="form-control" name="type" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">사업자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="business_no" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">대표자명</td>
                        <td colspan="3"><input type="text" class="form-control" name="ceo_name" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">대표자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="ceo_phone" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">담당자명</td>
                        <td colspan="3"><input type="text" class="form-control" name="manager_name" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">담당자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="manager_phone" required></td>
                    </tr>
                    <tr>
                        <td colspan="4" class="text-center">
                            <input type="submit" class="btn btn-primary btn-lg" value="등록">
                            <a href="manufacture_list.do" class="btn btn-success btn-lg">목록</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            </form>
        </div>
    </section>

</body>
</html>