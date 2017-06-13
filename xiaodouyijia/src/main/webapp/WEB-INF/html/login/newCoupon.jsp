<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

        ul a {
            color: #000;
        }

        li.active a {
            color: #A4C540;
        }

        table li a {
            color: #A4C540;
        }

        .nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {
            color: #fff;
            background-color: #A4C540;
        }
    </style>

    <script src="/resources/js/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="../newTop.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-3" style="padding-right: 0;position:relative;left: 2px">
                <ul class="list-group">
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toInformation">个人信息</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toAddress">收货地址</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0">我的订单</a>
                    </li>
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toNewCoupon?state=3">我的优惠券</a>
                    </li>
                    <li class="list-group-item"><a
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
                    <h3>我的优惠券</h3>
                    <table style="margin-left:auto;margin-right:auto;">
                        <tr>
                            <td>
                                <ul class="nav nav-pills navbar-left"
                                    style="border: 2px solid #A4C540;border-radius: 0.4em;">
                                    <li id="all-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewCoupon?state=3">全部优惠券</a>
                                    </li>
                                    <li id="usable-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewCoupon?state=0">可用优惠券</a>
                                    </li>
                                    <li id="unusable-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewCoupon?state=2">已用优惠券</a>
                                    </li>
                                    <li id="out-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewCoupon?state=1">过期优惠券</a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                    <div class="col-sm-12 table-border" style="margin-top: 20px;padding-top: 10px">
                        <c:forEach items="${userCoupons}" var="uc">
                            <div class="col-sm-4" style="text-align: center">
                                <c:if test="${uc.state==0}">
                                    <img src="/resources/image/coupon.png" class="img-responsive"
                                         style="display: inline-block;margin-bottom: 5px">
                                </c:if>
                                <c:if test="${uc.state!=0}">
                                    <img src="/resources/image/coupon2.png" class="img-responsive"
                                         style="display: inline-block;margin-bottom: 5px">
                                </c:if>
                                <c:if test="${uc.state==1}">
                                    <img src="/resources/image/out.png" class="coupon-img">
                                </c:if>
                                <c:if test="${uc.state==2}">
                                    <img src="/resources/image/unusable.png" class="coupon-img">
                                </c:if>
                                <br>
                                <strong><fmt:formatNumber value="${uc.discountpageVal/100}" type="number" pattern="#"/>元优惠券</strong>
                                <br>
                                <span>（满<fmt:formatNumber value="${uc.money/100}" type="number" pattern="#"/>可用）</span>
                            </div>
                        </c:forEach>
                    </div>
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
    $(function () {
        $("#forth_li").addClass("active");
        if (${state==3}) {
            $("#all-li").addClass("active");
        }
        if (${state==0}) {
            $("#usable-li").addClass("active");
        }
        if (${state==2}) {
            $("#unusable-li").addClass("active");
        }
        if (${state==1}) {
            $("#out-li").addClass("active");
        }
    });
</script>

</body>
</html>



