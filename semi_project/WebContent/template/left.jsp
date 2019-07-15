<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="root" value="/"></c:url>
<!Doctype HTML>
<html>
<head>
<title></title>
<style>
.lnb {
width: 200px; /* 기본 메뉴 width 사이즈 */ margin: 0; padding: 0;
}
.lnb li {
list-style-type: none; /* 기본 리스트타입에 있는 내용을 보여주지 않게 처리 */
margin-bottom: 2px;
}

.b {

width: 60%;
padding: 0px 0;
text-indent: -40px;    /*왼쪽으로 붙이기   */

color: Black;
font: bold 20px "굴림";
background: white;

}

.lnb li a {
display: block; /* 원래 a태그는 inline이지만 마우스 선택 영역을 잡기 위하여 변경 */
width: 60%;
padding: 5px 0;
text-indent: 8px;
text-decoration: none;  /*밑줄 제거 */
color: Black;
font: bold 12px "굴림";
background: white;
border: 1px solid #aaa; /* 기본적인 border값을 준 후 테두리를 처리 */

}
.lnb li a:hover {
background: #ccc;
color: purple;
}
.lnb li.last a {
border: 1px solid red;
}
</style>
</head>
<body>
<ul class="lnb"  >
<li class="b">고객센터  </li> 
<li><a href="${root}board/list.do">공지사항  ></a></li>
<li><a href="URI">자주하는 질문     ></a></li>
<li><a href="${root}board/listOne.do">1:1 문의></a></li>

</ul>
</body>
</html>
