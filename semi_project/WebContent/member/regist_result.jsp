<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/client/header.jsp"></jsp:include>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입완료</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" type="text/css"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script>
    </script>
    <style>
        .btn {
            background-color: #512771;
            border: #512771;
            border-radius: 0px;
            float: none;
            height: 50px;
            width: 150px;
            font-size: 14px;
            color: #fff;
            line-height: 34px;
            vertical-align: top;
        }

        .out {
            background-color: #f7f5f8;
            height: 300px;
            width: auto;
            margin-top: 5rem;
            padding-top: 5rem;
        }

        h3 {
            color: #512771;
        }
     
    </style>
</head>

<body style="background-color: #f9f9f9">
    <div class="out">
        <h3 style="text-align: center">회원가입이 완료되었습니다</h3>
        <br>
        <br>
        <div align='center'>
            <a href="${pageContext.request.contextPath}}"><button class="btn">메인화면</button></a>
        </div>
    </div>
</body>

<jsp:include page="/template/footer.jsp"></jsp:include>