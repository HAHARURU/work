<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/3/25
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="icon" href="/resources/image/title_logo.png" type="image/x-icon"/>
    <title>小豆一家</title>
    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="/resources/css/main2.css"/>

    <script src="/resources/js/jquery.2.1.1.min.js"></script>
    <script src="/resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="theme_color" style="margin-bottom: 10px">
    <a href="${pageContext.request.contextPath}/index/toIndex?age=1&cKind=1&cid=1" title="返回首页">
        <img class="img-responsive center-block" src="/resources/image/logo.jpg">
    </a>
</div>
<div class="col-sm-12" style="height: 700px;">
    <div class="media" style="display:flex;justify-content:center;align-items:center;">
        <div class="" style="text-align: center">
            <h1 class="text-color" style="font-size: 11em">准备中</h1>
            <span style="font-size: 2em">功能即将上线</span><br>
            <a href="${pageContext.request.contextPath}/index/toIndex?age=1&cKind=1&cid=1" style="font-size: 1.3em">返回首页</a>
        </div>
    </div>
</div>
<div class="col-sm-12"
     style="background-color:#A4C540;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
</body>
</html>
