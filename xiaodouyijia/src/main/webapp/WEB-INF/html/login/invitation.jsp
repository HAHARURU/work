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
    <link rel="stylesheet" href="/resources/css/jquery.vm-carousel.css">
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
                    <li class="list-group-item"><a
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
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toMyInvitation?number=1&size=10">我的邀请码</a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-9" style="padding-left: 0">
                <ul class="col-sm-12 ul-border">
                    <div id="orderContent" class="tab-content" style="margin-top: 20px">
                        <div class="tab-pane fade in active" id="all">
                            <div class="table-responsive table-border">
                                <table class="table table-hover table-condensed" style="font-size: 1em">
                                    <thead>
                                    <tr style="background-color: #A4C540;color: #ffffff;">
                                        <th>邀请码</th>
                                        <th>获取日期</th>
                                        <th>可用天数</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tr-body">
                                    <c:forEach items="${invitationList}" var="il">
                                        <tr>
                                            <td>${il.rcode}</td>
                                            <td>
                                                <fmt:formatDate value="${il.syscreated}" type="date"
                                                                pattern="yyyy-MM-dd"/>
                                            </td>
                                            <td>${il.durationDay}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <table style="margin-left:auto;margin-right:auto;">
                        <tr>
                            <td>
                                <ul id="example"></ul>
                            </td>
                        </tr>
                    </table>
                    <p>
                        什么是邀请码？<br>
                        邀请码是在小豆一家购买产品满1000元即可获得的一组特定号码，可在购买产品时享受优惠。
                        如何使用邀请码？<br>
                        1、凡在小豆一家注册的用户，即可使用邀请码，且只能使用一次；<br>
                        2、在小豆一家购买产品就可以享受邀请码的优惠；<br>
                        3、邀请好友使用时，请正确填写推荐人的邀请码。被推荐人完成购买，推荐人就可以享受随机的豆值奖励；<br>
                        4、邀请码使用期限为一个月。
                    </p>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap-paginator.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script>
    $().ready(function () {
        $("#forth_li").addClass("active");
        var options = {
            totalPages: ${totalPages},
            currentPage: ${currentPage},
            numberOfPages: 5,
            pageUrl: function (type, page, current) {
                return "${pageContext.request.contextPath}/login/toMyInvitation?number=" + page + "&size=10";
            }
        };
        $('#example').bootstrapPaginator(options);
    });
</script>

</body>
</html>



