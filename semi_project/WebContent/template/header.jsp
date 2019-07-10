<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>백컬리: 백종원의 레시피</title>
    <style>
        @font-face {
            font-family: Binggrae;
            src: url("../font/Binggrae.ttf");
        }

        .text-center {
            background-color: blueviolet;
        }

        .text-center>h5>.top_message {
            color: black	;
            text-decoration: none;
        }

        body {
            padding: 0px;
            margin-top: 0px;
        }

        .menulist {
            color: black;
            font-size: 1.5rem;
        }

        .navbar-brand{
            margin-left: 40%
        }
        .navbar-nav li{
            margin-bottom: 40px;
        }
        .nav-link{
            color: black;
            font-size: 0.8rem;
        }
        .dropdown-menu li{
            margin-bottom: 10px;
        }
        
        img{
        	width: 200;
        }

    </style>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
        id="bootstrap-css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body>
    <div class="text-center">
        <h5><a href="#" class="top_message">지금 가입시 1000포인트 적립</a></h5>
    </div>
    <nav class="navbar navbar-expand-lg navbar-white bg-white static-top">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img src="../img/logo.jpg" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">고객센터</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="menu_area" class="menu-area">
        <div class="container">
            <div class="row">
                <nav class="navbar navbar-light navbar-expand-md mainmenu">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="dropdown mr-5">
                                <a class="dropdown-toggle menulist" href="#" id="navbarDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">카테고리</a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a href="#">상품분류1</a></li>
                                    <li><a href="#">상품분류2</a></li>
                                    <li><a href="#">상품분류3</a></li>
                                </ul>
                            </li>
                            <li class="mr-5"><a href="#" class="menulist">신상품 </a></li>
                            <li class="mr-5"><a href="#" class="menulist">베스트</a></li>
                            <li class="mr-3"><a href="#" class="menulist">이벤트</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</body>

</html>