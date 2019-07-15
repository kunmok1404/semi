<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/admin/header.jsp"></jsp:include>

<jsp:include page="/template/admin/left/manufacture_left.jsp"></jsp:include>     

	<section>
        <div class="container">
            <h5>공급사 기본 정보</h5><hr>
            <form action="update_manufacture.do" method="post">
            <input type="hidden" name="id" value="${mdto.id}">
            <table class="table table-bordered" id="manufacture">
                <tbody>
                    <tr>
                        <td class="table-light text-center prd_regist">공급사명</td>
                        <td colspan="3"><input type="text" class="form-control" name="name" value="${mdto.name}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">공급사코드</td>
                        <td colspan="3">${mdto.id}</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">업종</td>
                        <td colspan="3"><input type="text" class="form-control" name="type" value="${mdto.type}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">사업자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="business_no" value="${mdto.business_no}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">대표자명</td>
                        <td colspan="3"><input type="text" class="form-control" name="ceo_name" value="${mdto.ceo_name}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">대표자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="ceo_phone" value="${mdto.ceo_phone}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">담당자명</td>
                        <td colspan="3"><input type="text" class="form-control" name="manager_name" value="${mdto.manager_name}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center prd_regist">담당자번호</td>
                        <td colspan="3"><input type="text" class="form-control" name="manager_phone" value="${mdto.manager_phone}" required></td>
                    </tr>
                    <tr>
                        <td class="table-light text-center">계약일</td>
                        <td class="jjj">${mdto.contract_date}</td>
                        <td class="table-light text-center confinish">계약 종료일</td>
						<td >${mdto.con_finish_date}</td>
                    </tr>
                    <tr>
                        <td class="table-light text-center">승인상태</td>
                        <td class="jjj">
                        	${mdto.apply_status}
                        </td>
                        <td class="table-light text-center confinish">계약상태</td>
                        <td >
                            <div class="form-group">
                                <label for="sale"></label>
                                <select class="form-control" id="sale" name="contract_status">
                                	<option ${mdto.contract_status eq "미계약"?"selected":""}>미계약</option>
                                	<option ${mdto.contract_status eq "계약중"?"selected":""}>계약중</option>
                                    <option ${mdto.contract_status eq "계약중지"?"selected":""}>계약중지</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" class="text-center">
                            <input type="submit" class="btn btn-primary btn-lg" value="수정">
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