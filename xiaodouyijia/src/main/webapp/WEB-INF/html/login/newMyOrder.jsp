<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            color: #000;;
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

        .pagination li {
            margin-right: 0;
        }

        .pagination li.active > a, .pagination li.active > span, .pagination li.active > a:hover, .pagination li.active > span:hover, .pagination li.active > a:focus, .pagination li.active > span:focus {
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
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0">我的订单</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toNewCoupon?state=3">我的优惠券</a>
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
                <ul class="col-xs-12 ul-border">
                    <h3>我的订单</h3>
                    <table style="margin-left:auto;margin-right:auto;">
                        <tr>
                            <td>
                                <ul class="nav nav-pills navbar-left"
                                    style="border: 2px solid #A4C540;border-radius: 0.4em;">
                                    <li id="all-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0">全部订单</a>
                                    </li>
                                    <li id="no-pay-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=3">待付款</a>
                                    </li>
                                    <li id="pay-li"><a
                                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=4">已付款</a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                    <div id="orderContent" class="tab-content" style="margin-top: 20px">
                        <div class="tab-pane fade in active" id="all">
                            <c:forEach items="${orders}" var="o" varStatus="vs">
                                <div class="table-responsive table-border">
                                    <table class="table table-hover table-condensed" style="font-size: 1em">
                                        <thead>
                                        <tr style="background-color: #A4C540;color: #ffffff;">
                                            <th>订单号：${o.oNo}</th>
                                            <th colspan="2">交易日期：<fmt:formatDate value="${o.payTime}" type="date"
                                                                                 pattern="yyyy-MM-dd hh:mm:ss"/></th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${ordersItems.get(o.oId)}" var="ov">
                                            <tr>
                                                <td>
                                                    <div class="media"
                                                         style="display:flex;justify-content:center;align-items:center;">
                                                        <div class="pull-left">
                                                            <img class="media-object" src="${ov.img}"
                                                                 style="width: 60px">
                                                        </div>
                                                        <div class="media-body" style="width:200px">
                                                            <c:if test="${ov.pType==1}">
                                                                <a href="${pageContext.request.contextPath}/index/toRobot">${ov.pName}</a>
                                                            </c:if>
                                                            <c:if test="${ov.pType==2}">
                                                                <a href="${pageContext.request.contextPath}/index/toCourse?number=1&size=9">${ov.pName}</a>
                                                            </c:if>
                                                            <c:if test="${ov.pType==3}">
                                                                <a href="${pageContext.request.contextPath}/index/toTourismDetail?tid=${ov.pId}">${ov.pName}</a>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </td>
                                                <c:if test="${ov.pType==3}">
                                                    <td style="vertical-align:middle">
                                                        单价：￥${ov.pPrice/100}/成人，￥${ov.pPriceBoy/100}/儿童
                                                    </td>
                                                    <td style="vertical-align:middle">
                                                        数量：${ov.largMenNum}/成人，${ov.smallMenNum}/儿童
                                                    </td>
                                                </c:if>
                                                <c:if test="${ov.pType!=3}">
                                                    <td style="vertical-align:middle">
                                                        单价：￥${ov.pPrice/100}
                                                    </td>
                                                    <td style="vertical-align:middle">
                                                        数量：${ov.num}</td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <td>
                                                <c:if test="${o.oStates==3}">
                                                    <a class="btn btn-info"
                                                       href="${pageContext.request.contextPath}/login/toPay2?oid=${o.oId}">付款</a>
                                                    <a class="btn btn-danger"
                                                       href="${pageContext.request.contextPath}/login/cancelOrder?oid=${o.oId}&number=${currentPage}&size=4&state=${state}"
                                                       style="background-color: #e74c3c">取消订单</a>
                                                </c:if>
                                                <c:if test="${o.oStates==4}">
                                                    <strong>已付款</strong>
                                                </c:if>
                                            </td>
                                            <td colspan="2">总计：￥${o.totalFee/100}（运费<fmt:formatNumber
                                                    value="${o.expressFee/100}" type="number"
                                                    pattern="#"/>元）
                                            </td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <table style="margin-left:auto;margin-right:auto;">
                        <tr>
                            <td>
                                <ul id="example"></ul>
                            </td>
                        </tr>
                    </table>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/messages_zh.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap-paginator.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script>
    $(function () {
        $("#forth_li").addClass("active");
        if (${state==0}) {
            $("#all-li").addClass("active");
        }
        if (${state==3}) {
            $("#no-pay-li").addClass("active");
        }
        if (${state==4}) {
            $("#pay-li").addClass("active");
        }
        var options = {
            currentPage: ${currentPage},
            totalPages: ${totalPages},
            numberOfPages: 4,
            pageUrl: function (type, page, current) {
                return "${pageContext.request.contextPath}/login/toNewMyOrder?number=" + page + "&size=4&state=${state}";
            }
        };
        $('#example').bootstrapPaginator(options);
    });
</script>

</body>
</html>



