<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/3/17
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>小豆一家</title>
    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>
    <style type="text/css">

    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(document).ready(function () {
                var h = document.body.clientHeight;
                $("#mid_div").css("height", h - 55);
            });
            setTimeout(changeTime, 1000);
        });
        function changeTime() {
            var time = parseInt($("span#time").text());
            time--;
            if (time <= 0) {
                window.location.href = '${pageContext.request.contextPath}/index/toLogin';
            } else {
                $("span#time").text(time);
                setTimeout(changeTime, 1000);
            }
        }
        window.onresize = function () {
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
        };
        $(window).resize();
    </script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="img_div">
<%@include file="loginTop.jsp" %>
<div id="mid_div" class="col-sm-12">
    <div class="col-sm-2 col-sm-offset-5 col-xs-12"
         style="background: #ffffff;border-radius: 1em;position: absolute;top: 40%;text-align: center">
        <img src="${pageContext.request.contextPath}/resources/image/logo2.jpg" class="img-responsive"
             style="width: 100%;">
        <br>
        <span class="text-color">成功，<span id="time" style="color: #90c400;">5</span> 秒后跳转到登录页面...</span>
    </div>
</div>
</body>
</html>

