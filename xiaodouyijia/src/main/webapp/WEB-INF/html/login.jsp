<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/3/17
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>小豆一家</title>
    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">

    <script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
        });
        function wait() {
            if ($("#username").val() != "") {
                $("div#login_form").addClass("hidden");
                $("div#login_hidden").fadeIn(500);
                var h = document.body.clientHeight;
                $("#mid_div").css("height", h - 55);
                var ch = document.getElementById("contact-div").offsetHeight;
                $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
            } else {
                $("#myModal3").modal("show");
                return false;
            }
        }
        window.onresize = function () {
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
        };
        $(window).resize();
    </script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="menubar-hoverable img_div">
<%@include file="loginTop.jsp" %>
<div id="mid_div" class="col-sm-12">
    <div id="contact-div" class="col-sm-12" style="height: auto;display:flex;justify-content:center;align-items:center;">
        <div class="col-sm-6 col-lg-5" style="padding-left: 0">
            <img class="img-responsive" src="${pageContext.request.contextPath}/resources/image/login.png">
        </div>
        <div id="login_form" class="col-sm-4 col-lg-3">
            <p style="font-size: 1.5em">登&nbsp&nbsp录</p>
            <form role="form" method="post" action="${pageContext.request.contextPath}/index/validate"
                  style="text-align: center">
                <label style="color: red">${error}</label>
                <div class="input-group" style="margin-bottom: 30px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" id="username" class="form-control" placeholder="请输入用户名或手机号" name="username"
                           value="${username}">
                </div>
                <div class="input-group" style="margin-bottom: 10px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" id="password" class="form-control" placeholder="请输入密码" name="password"
                           value="${password}">
                </div>
                <div class="col-sm-12" style="font-size: 0.8em">
                    <div class="pull-left">
                        <input type="checkbox" name="rememberMe" data-toggle="checkbox" id="id1">记住密码?
                    </div>
                    <div class="pull-right">
                        <a href="${pageContext.request.contextPath}/index/toForgetPassword">忘记密码</a>
                    </div>
                </div>
                <input type="submit" class="button" value="登&nbsp&nbsp录" onclick="return wait()" style="margin-bottom: 10px">
                <a href="${pageContext.request.contextPath}/index/toRegister" style="color: #90c400;">注册</a>
            </form>
        </div>
        <div id="login_hidden" class="col-sm-4 col-lg-3" style="display: none">
            <p style="font-size: 1.5em">请稍等...</p>
            <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">用户名不能为空！</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: HARU--%>
  <%--Date: 2017/4/6--%>
  <%--Time: 8:54--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->--%>
<%--<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->--%>
<%--<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->--%>
<%--<!--[if gt IE 8]><!-->--%>
<%--<html class="no-js" lang="zh-CN"> <!--<![endif]-->--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
    <%--<link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>--%>
    <%--<title>小豆一家——智能小豆</title>--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="viewport" content="width=device-width">--%>

    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fullpage.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">--%>

    <%--<script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>--%>

    <%--<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="newTop.jsp" %>--%>
<%--<div class="col-sm-12" style="padding-right: 0;padding-left: 0">--%>
    <%--<div id="button-div" style="position: absolute;z-index: 10">--%>
        <%--<button class="button button-glow button-rounded button-caution buy_button order-button-c"--%>
                <%--style="margin-right: 40px">天猫购买--%>
        <%--</button>--%>
        <%--<button class="button button-glow button-rounded button-caution buy_button order-button-c">京东购买--%>
        <%--</button>--%>
    <%--</div>--%>
    <%--<img id="banner-img" class="img-responsive" src="${pageContext.request.contextPath}/resources/image/robot_demo.jpg">--%>
<%--</div>--%>
<%--<div class="col-sm-12" style="padding-left: 0;padding-right: 0">--%>
    <%--<img src="${pageContext.request.contextPath}/resources/image/robot_detail.jpg" class=" img-responsive"--%>
         <%--style="width: 100%">--%>
<%--</div>--%>
<%--<div class="col-sm-12"--%>
     <%--style="background-color:#2CB742;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">--%>
    <%--<span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>--%>
<%--</div>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/flat-ui.js"></script>--%>

<%--<script>--%>
    <%--$(function () {--%>
        <%--$("#second_li").addClass("active");--%>
        <%--$("#robot-li").addClass("active");--%>
        <%--var iw = document.getElementById("banner-img").offsetWidth;--%>
        <%--$("#button-div").css("left", iw / 3.8);--%>
        <%--var ih = document.getElementById("banner-img").offsetHeight;--%>
        <%--$("#button-div").css("bottom", ih / 12);--%>
    <%--});--%>

    <%--window.onresize = function () {--%>
        <%--var iw = document.getElementById("banner-img").offsetWidth;--%>
        <%--$("#button-div").css("left", iw / 3.8);--%>
        <%--var ih = document.getElementById("banner-img").offsetHeight;--%>
        <%--$("#button-div").css("bottom", ih / 12);--%>
    <%--};--%>
    <%--$(window).resize();--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


