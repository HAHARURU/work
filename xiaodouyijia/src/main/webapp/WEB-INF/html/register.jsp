<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: HARU--%>
<%--Date: 2017/3/17--%>
<%--Time: 21:40--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml"--%>
<%--lang="zh-CN">--%>
<%--<head>--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>--%>
<%--<link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
<%--<title>小豆一家</title>--%>
<%--<meta name="description" content="User login page"/>--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>--%>

<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>--%>
<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css"/>--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">--%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">--%>
<%--<style type="text/css">--%>
<%--.form-control[readonly] {--%>
<%--color: black;--%>
<%--}--%>

<%--.error {--%>
<%--color: red;--%>
<%--}--%>

<%--.img_div {--%>
<%--background: url("${pageContext.request.contextPath}/resources/image/bg_xk.jpg");--%>
<%--width: 100%;--%>
<%--height: 100%;--%>
<%--background-position: center;--%>
<%--background-size: 100%;--%>
<%--}--%>
<%--</style>--%>

<%--<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/flat-ui.js"></script>--%>
<%--<script>--%>
<%--var time = 60;--%>
<%--$().ready(function () {--%>
<%--$(':radio').radiocheck();--%>
<%--$("select").select2({dropdownCssClass: 'dropdown-inverse'});--%>
<%--if (${state==1}) {--%>
<%--$("#form1").removeClass("hidden");--%>
<%--}--%>
<%--if (${state==2}) {--%>
<%--$("#form2").removeClass("hidden");--%>
<%--}--%>
<%--if (${state==3}) {--%>
<%--$("#form3").removeClass("hidden");--%>
<%--}--%>
<%--if (${error!=null}&&--%>
<%--${error!=""})--%>
<%--{--%>
<%--$("#myModal2").modal("show");--%>
<%--}--%>

<%--var w = document.body.clientWidth;--%>
<%--var bw = document.getElementById("bottom_banner").offsetWidth;--%>
<%--$("#bottom_banner").css("left", (w - bw) / 2);--%>

<%--$("#form1").validate({--%>
<%--rules: {--%>
<%--phoneNumber: {--%>
<%--required: true,--%>
<%--digits: true--%>
<%--},--%>
<%--code: {--%>
<%--required: true,--%>
<%--digits: true--%>
<%--}--%>
<%--},--%>
<%--messages: {--%>
<%--phoneNumber: {--%>
<%--required: "必填",--%>
<%--digits: "手机号格式不正确"--%>
<%--},--%>
<%--code: {--%>
<%--required: "必填",--%>
<%--digits: "只能输入数字"--%>
<%--}--%>
<%--}--%>
<%--});--%>
<%--$("#form2").validate({--%>
<%--rules: {--%>
<%--cdName: {--%>
<%--required: true--%>
<%--}--%>
<%--},--%>

<%--messages: {--%>
<%--cdName: {--%>
<%--required: "必填"--%>
<%--}--%>
<%--}--%>
<%--});--%>
<%--});--%>

<%--function checkMobile(s) {--%>
<%--var regu = /^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\d{8}$/;--%>
<%--var re = new RegExp(regu);--%>
<%--if (re.test(s)) {--%>
<%--return true;--%>
<%--} else {--%>
<%--return false;--%>
<%--}--%>
<%--}--%>

<%--function getCode() {--%>
<%--if (!checkMobile($("#phoneNumber").val().toString())) {--%>
<%--alert("手机格式错误！");--%>
<%--return;--%>
<%--}--%>
<%--var time = setTimeout(changeTime, 1000);--%>

<%--$.ajax({--%>
<%--url: "${pageContext.request.contextPath}/index/getCode?phone=" + $("#phoneNumber").val(),--%>
<%--type: "get",--%>
<%--contentType: 'application/json;charset=utf-8',--%>
<%--success: function () {--%>
<%--clearTimeout(time);--%>
<%--}--%>
<%--})--%>
<%--}--%>
<%--function changeTime() {--%>
<%--if ($("#phoneNumber").val() != "") {--%>
<%--time--;--%>
<%--if (time <= 0) {--%>
<%--$("#get-code").attr("disabled", false);--%>
<%--$("#get-code").html("获取验证码");--%>
<%--} else {--%>
<%--$("#get-code").attr("disabled", true);--%>
<%--$("#get-code").html(time + "s后重新获取");--%>
<%--setTimeout(changeTime, 1000);--%>
<%--}--%>
<%--} else {--%>
<%--$("#error").html("先填写手机号");--%>
<%--}--%>

<%--}--%>
<%--window.onresize = function () {--%>
<%--var w = document.body.clientWidth;--%>
<%--var bw = document.getElementById("bottom_banner").offsetWidth;--%>
<%--$("#bottom_banner").css("left", (w - bw) / 2);--%>
<%--};--%>
<%--$(window).resize();--%>
<%--</script>--%>

<%--<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
<%--<!--[if lt IE 9]>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>--%>
<%--<![endif]-->--%>
<%--</head>--%>
<%--<body class="menubar-hoverable img_div">--%>
<%--<header id="header">--%>
<%--<div class="col-sm-2 col-sm-offset-1 logo_class">--%>
<%--<a href="${pageContext.request.contextPath}/index/toIndex?age=1&cKind=1&cid=1">--%>
<%--<img src="${pageContext.request.contextPath}/resources/image/logo.jpg" class="logo_class"--%>
<%--style="height: 50px;;">--%>
<%--</a>--%>
<%--</div>--%>
<%--<div class="col-sm-2 col-sm-offset-1 col-lg-offset-0 back_class">--%>
<%--<a href="${pageContext.request.contextPath}/index/toIndex?age=1&cKind=1&cid=1">返回首页</a>--%>
<%--</div>--%>
<%--</header>--%>
<%--<div>--%>
<%--<div id="login_form" class="form_div col-md-4 col-sm-offset-6 col-sm-5 col-lg-3 col-lg-offset-7">--%>
<%--<h4>注&nbsp&nbsp册</h4>--%>
<%--<form id="form1" class="hidden" role="form" method="post"--%>
<%--action="${pageContext.request.contextPath}/index/validateCode"--%>
<%--style="text-align: center">--%>
<%--<input type="hidden" name="forget" value="0">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>--%>
<%--<input type="text" class="form-control" placeholder="请输入手机号" id="phoneNumber" name="phoneNumber"--%>
<%--value="${phone}">--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="form-group">--%>
<%--<div class="col-sm-5">--%>
<%--<input type="text" class="form-control" id="code" name="code" value="${code}">--%>
<%--</div>--%>
<%--<div class="">--%>
<%--<button type="button" id="get-code" class="btn btn-default" style="background-color: #A4C540"--%>
<%--onclick="getCode()">--%>
<%--获取验证码--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--<input type="submit" class="button" value="下&nbsp;&nbsp;一&nbsp;&nbsp;步" style="margin-bottom: 20px">--%>
<%--</form>--%>
<%--<form id="form2" role="form" class="hidden" method="post"--%>
<%--action="${pageContext.request.contextPath}/index/toWriteChildren"--%>
<%--style="text-align: center">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>--%>
<%--<input type="text" class="form-control" placeholder="请输入孩子姓名" name="cdName">--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="fa fa-genderless" aria-hidden="true"></i></span>--%>
<%--<label class="radio" for="radio1" style="display: inline-block;margin-right: 10px">--%>
<%--<input type="radio" name="sex" value="男生" id="radio1"--%>
<%--data-toggle="radio" checked="checked">--%>
<%--<i class="fa  fa-mars" style="color: blue"></i>&nbsp;&nbsp;男生--%>
<%--</label>--%>
<%--<label class="radio" for="radio2" style="display: inline-block">--%>
<%--<input type="radio" name="sex" value="女生" id="radio2"--%>
<%--data-toggle="radio">--%>
<%--<i class="fa fa-venus" style="color: red"></i>&nbsp;&nbsp;女生--%>
<%--</label>--%>
<%--</div>--%>
<%--<select class="form-control select select-default select-block mbl margin-right-i" id="age" name="age">--%>
<%--<option value="3">3岁</option>--%>
<%--<option value="4">4岁</option>--%>
<%--<option value="5">5岁</option>--%>
<%--<option value="6">6岁</option>--%>
<%--<option value="7">7岁</option>--%>
<%--<option value="8">8岁</option>--%>
<%--<option value="9">9岁</option>--%>
<%--<option value="10">10岁</option>--%>
<%--<option value="11">11岁</option>--%>
<%--<option value="12">12岁</option>--%>
<%--</select>--%>
<%--<input type="submit" class="button" value="下&nbsp;&nbsp;一&nbsp;&nbsp;步" style="margin-bottom: 20px">--%>
<%--</form>--%>
<%--<form id="form3" role="form" class="hidden" method="post"--%>
<%--action="${pageContext.request.contextPath}/index/register"--%>
<%--style="text-align: center">--%>
<%--<label style="color: red">${error2}</label>--%>
<%--<input type="hidden" name="forget" value="0">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>--%>
<%--<input type="text" class="form-control" placeholder="请输入用户名" name="username" value="${username}">--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span></span>--%>
<%--<input type="password" class="form-control" placeholder="请输入密码" name="password" value="${password}">--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>--%>
<%--<input type="password" class="form-control" placeholder="确认密码" name="password2" value="${password2}">--%>
<%--</div>--%>
<%--<br>--%>
<%--<input type="submit" class="button" value="注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册" onclick="wait()"--%>
<%--style="margin-bottom: 20px">--%>
<%--</form>--%>
<%--</div>--%>
<%--<div id="login_hidden" class="form_div col-md-4 col-sm-offset-6 col-sm-5 col-lg-3 col-lg-offset-7"--%>
<%--style="text-align: center;display: none;color: #A4C540;padding-bottom: 20px">--%>
<%--<h4>请稍等...</h4>--%>
<%--<i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>--%>
<%--</div>--%>
<%--<div id="bottom_banner" style="text-align: center;">--%>
<%--<div id="" style="display: inline-block">--%>
<%--<a href="#">联系我们&nbsp|</a>--%>
<%--<a href="www.xiaodouwangluo.com">&nbsp小豆官网&nbsp|</a>--%>
<%--<a href="#">&nbsp产品介绍&nbsp|</a>--%>
<%--<a href="#">&nbsp产品功能&nbsp|</a>--%>
<%--<a href="#">&nbsp合作伙伴&nbsp|</a>--%>
<%--<a href="#">&nbsp版权声明&nbsp|</a>--%>
<%--<a href="#">&nbsp帮助中心</a>--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="" id="contact_div">--%>
<%--<span class="white_color">联系电话：0553-8292685</span>--%>
<%--<span class="white_color">邮箱：xdyj@xiaodouwangluo.com</span>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
<%--<div class="modal-dialog">--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-body" style="text-align: center;color: red;">${error}</div>--%>
<%--</div><!-- /.modal-content -->--%>
<%--</div><!-- /.modal -->--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
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

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">
    <style type="text/css">
        @font-face {
            font-family: 'iconfont';  /* project id 322358 */
            src: url('//at.alicdn.com/t/font_vdwe57ajgyom9529.eot');
            src: url('//at.alicdn.com/t/font_vdwe57ajgyom9529.eot?#iefix') format('embedded-opentype'),
            url('//at.alicdn.com/t/font_vdwe57ajgyom9529.woff') format('woff'),
            url('//at.alicdn.com/t/font_vdwe57ajgyom9529.ttf') format('truetype'),
            url('//at.alicdn.com/t/font_vdwe57ajgyom9529.svg#iconfont') format('svg');
        }

        .iconfontyyy {
            font-family: "iconfont" !important;
            font-size: 16px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }

        .form-control[readonly] {
            color: black;
        }

        .error {
            color: red;
        }

        .input-group-btn .btn {
            border: 1px solid #90c400;
        }
    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/flat-ui.js"></script>
    <script>
        var time = 60;
        $().ready(function () {
            $(':radio').radiocheck();
            if ('${sex}' != "") {
                if('${sex}'=='男生'){
                    $("#radio1").radiocheck('check') ;
                }
                if('${sex}'=='女生'){
                    $("#radio2").radiocheck('check') ;
                }
            }
            if ('${age}' != "") {
                $("#age").val('${age}');
            }
            if (${state==1}) {
                $("#form2").removeClass("hidden");
            }
            if (${state==2}) {
                $("#form2").removeClass("hidden");
            }
            if (${error!=null}&&
            ${error!=""})
            {
                $("#myModal2").modal("show");
            }

            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);

            $("#form1").validate({
                rules: {
                    phoneNumber: {
                        required: true,
                        digits: true
                    },
                    code: {
                        required: true,
                        digits: true
                    }
                },
                messages: {
                    phoneNumber: {
                        required: "必填",
                        digits: "手机号格式不正确"
                    },
                    code: {
                        required: "必填",
                        digits: "只能输入数字"
                    }
                }
            });
        });

        function checkMobile(s) {
            var regu = /^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\d{8}$/;
            var re = new RegExp(regu);
            if (re.test(s)) {
                return true;
            } else {
                return false;
            }
        }

        function getCode() {
            if (!checkMobile($("#phoneNumber").val().toString())) {
                alert("手机格式错误！");
                return;
            }
            var time = setTimeout(changeTime, 1000);

            $.ajax({
                url: "${pageContext.request.contextPath}/index/getCode?phone=" + $("#phoneNumber").val(),
                type: "get",
                contentType: 'application/json;charset=utf-8',
                async: false,
                success: function (data) {
                    if (data == 0) {
                        clearTimeout(time);
                        alert("获取失败！");
                    }
                }
            })
        }
        function changeTime() {
            if ($("#phoneNumber").val() != "") {
                time--;
                if (time <= 0) {
                    clearTimeout(time);
                    $("#get-code").attr("disabled", false);
                    $("#get-code").html("获取验证码");
                } else {
                    $("#get-code").attr("disabled", true);
                    $("#get-code").html(time + "s后重新获取");
                    setTimeout(changeTime, 1000);
                }
            } else {
                $("#error").html("先填写手机号");
            }

        }

        function wait() {
            $("div#login_form").addClass("hidden");
            $("div#login_hidden").fadeIn(500);
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
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
    <div id="contact-div" class="col-sm-12"
         style="height: auto;display:flex;justify-content:center;align-items:center;">
        <div class="col-sm-6 col-lg-5" style="padding-left: 0">
            <img class="img-responsive" src="${pageContext.request.contextPath}/resources/image/login.png">
        </div>
        <div id="login_form" class="col-sm-4 col-lg-3">
            <form id="form1" class="hidden" role="form" method="post"
                  action="${pageContext.request.contextPath}/index/validateCode" style="text-align: center">
                <p style="font-size: 1.5em">获取验证码</p>
                <input type="hidden" name="forget" value="0">
                <div class="input-group" style="margin-bottom: 30px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input type="text" class="form-control" placeholder="请输入手机号" id="phoneNumber" name="phoneNumber"
                           value="${phone}">
                </div>
                <div class="input-group" style="margin-bottom: 10px;">
                    <span class="input-group-addon"><i class="fa fa-comment"></i></span>
                    <input type="text" class="form-control" id="code" name="code" value="${code}">
                    <span class="input-group-btn">
                        <button type="button" id="get-code" class="btn btn-default" onclick="getCode()"
                                style="background-color: #90c400;border-top-right-radius: 0.6em;border-bottom-right-radius: 0.6em;">
                            获取验证码
                        </button>
                    </span>
                </div>
                <input type="submit" class="button" value="确&nbsp&nbsp定">
            </form>
            <form id="form2" class="hidden" role="form" method="post" style="text-align: center"
                  action="${pageContext.request.contextPath}/index/register">
                <p style="font-size: 1.5em">注册</p>
                <input type="hidden" name="forget" value="0">
                <div class="input-group" style="margin-bottom: 20px;">
                    <span class="input-group-addon"><i class="fa fa-child"></i></span>
                    <input type="text" class="form-control" placeholder="请输入豆宝姓名" name="cdName" value="${cdName}">
                </div>
                <div class="input-group">
                    <label class="radio" for="radio1" style="display: inline-block;margin-right: 30px">
                        <input type="radio" name="sex" value="男生" id="radio1"
                               data-toggle="radio" checked="checked">
                        <i class="fa  fa-mars" style="color: blue"></i>&nbsp;&nbsp;男生
                    </label>
                    <label class="radio" for="radio2" style="display: inline-block">
                        <input type="radio" name="sex" value="女生" id="radio2"
                               data-toggle="radio">
                        <i class="fa fa-venus" style="color: red"></i>&nbsp;&nbsp;女生
                    </label>
                </div>
                <div class="input-group" style="margin-bottom: 20px;">
                    <span class="input-group-addon"><i class="iconfontyyy">&#xe62b;</i></span>
                    <select class="form-control" id="age" name="age">
                        <option value="3">3岁</option>
                        <option value="4">4岁</option>
                        <option value="5">5岁</option>
                        <option value="6">6岁</option>
                        <option value="7">7岁</option>
                        <option value="8">8岁</option>
                        <option value="9">9岁</option>
                        <option value="10">10岁</option>
                        <option value="11">11岁</option>
                        <option value="12">12岁</option>
                    </select>
                </div>
                <div class="input-group" style="margin-bottom: 20px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" placeholder="请输入用户名" name="username" value="${username}">
                </div>
                <div class="input-group" style="margin-bottom: 20px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span></span>
                    <input type="password" class="form-control" placeholder="请输入密码" name="password" value="${password}">
                </div>
                <div class="input-group" style="margin-bottom: 10px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" class="form-control" placeholder="确认密码" name="password2"
                           value="${password2}">
                </div>
                <input type="submit" class="button" value="注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册" onclick="wait()"
                       style="margin-bottom: 10px">
                <a href="${pageContext.request.contextPath}/index/toLogin" style="color: #90c400">登录</a>
            </form>
        </div>
        <div id="login_hidden" class="col-sm-4 col-lg-3" style="display: none">
            <p style="font-size: 1.5em">请稍等...</p>
            <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">${error}</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>


