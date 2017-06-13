<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-CN"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="icon" href="/resources/image/title_logo.png" type="image/x-icon"/>
    <title>小豆一家——个人中心</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/flat-ui.css">
    <link rel="stylesheet" href="/resources/css/jquery.fullpage.css">
    <link rel="stylesheet" href="/resources/css/buttons.css">
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/main2.css">
    <style type="text/css">
        .list-group-item.active, .list-group-item.active:focus, .list-group-item.active:hover {
            background-color: #ffffff;
            border-top: #A4C540 2px solid;
            border-left: #A4C540 2px solid;
            border-bottom: #A4C540 2px solid;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px;
            border-top-right-radius: 0;
            border-right: none;
        }

        a {
            color: #000000;
        }

        .active a {
            color: #A4C540;
        }

    </style>

    <script src="/resources/js/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body onresize="changeEm()">
<%@include file="../newTop.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-3" style="padding-right: 0;position:relative;left: 2px">
                <ul class="list-group">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toInformation">个人信息</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toAddress">收货地址</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0">我的订单</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toNewCoupon?state=3">我的优惠券</a>
                    </li>
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toNewMyCourse">课程进度</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toMyPoint?number=1&size=5&state=3">我的豆值</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toMyInvitation?number=1&size=10">我的邀请码</a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-9" style="padding-left: 0">
                <ul class="col-sm-12 ul-border">
                    <h3>课程进度</h3>
                    <c:forEach items="${materialList}" var="ml">
                        <div class="col-sm-12 table-border" style="padding-left: 0;padding-right: 0">
                            <header style="background-color: #A4C540;padding-left: 10px;padding-right: 10px">
                                <label>课程名：${ml.pName}</label>
                                <label class="pull-right">订单号：${ml.oNo}</label>
                            </header>
                            <div class="col-sm-12">
                                <h4 style="color: #A4C540;">课程进度：</h4>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="60"
                                         id="order-course-id-pg${ml.id}"
                                         aria-valuemin="0" aria-valuemax="100"
                                         style="width: 0;background-color: #A4C540">
                                    </div>
                                </div>
                                <div class="col-sm-12 step-box" id="order-course-id-n${ml.id}">
                                </div>
                                <label class="pull-right" style="color: #A4C540;">（每月一份课程）</label>
                            </div>
                        </div>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/messages_zh.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script>
    $().ready(function () {
        <c:forEach items="${materialList}" var="jsml">
        var cn = ${jsml.courseNum};
        var vn = ${jsml.sendNum};
        var j = 0;
        var per = vn / cn * 100;
        var pw = $(".progress").width();
        var ew = pw / (cn + 1);
        $("#order-course-id-pg${jsml.id}").css("width", 0);
        $("#order-course-id-pg${jsml.id}").css("width", per + "%");
        $("#order-course-id-n${jsml.id}").empty();
        for (var i = 0; i < cn; i++) {
            j++;
            var l = ew * (i + 1);
            $("#order-course-id-n${jsml.id}").append('<em class="em${jsml.id}" style="display:inline-block;position: absolute;top:5px;left: ' + (l - 11) + 'px">' + (i + 1) + '</em>');
        }
        for (var k = 0; k < vn; k++) {
            $($("em.em${jsml.id}")[k]).css("background-color", "#A4C540");
        }
        </c:forEach>

    });
    $(function () {
        $("#forth_li").addClass("active");
    });
    function changeEm() {
        <c:forEach items="${materialList}" var="jsml">
        var cn = ${jsml.courseNum};
        var vn = ${jsml.sendNum};
        var j = 0;
        var per = vn / cn * 100;
        var pw = $(".progress").width();
        var ew = pw / (cn + 1);
        $("#order-course-id-pg${jsml.id}").css("width", 0);
        $("#order-course-id-pg${jsml.id}").css("width", per + "%");
        $("#order-course-id-n${jsml.id}").empty();
        for (var i = 0; i < cn; i++) {
            j++;
            var l = ew * (i + 1);
            $("#order-course-id-n${jsml.id}").append('<em class="em${jsml.id}" style="display:inline-block;position: absolute;top:5px;left: ' + (l - 11) + 'px">' + (i + 1) + '</em>');
        }
        for (var k = 0; k < vn; k++) {
            $($("em.em${jsml.id}")[k]).css("background-color", "#A4C540");
        }
        </c:forEach>
    }
</script>

</body>
</html>



