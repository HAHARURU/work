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

        .vmc-centered {
            padding: 10px 0;
        }

        .vmc-centered img {
            transition: all 0.3s ease;
        }

        .vmc-centered .vmc_active .carousel-div {
            box-shadow: 1px 1px 5px 5px #ddd;
        }

        @media (min-width: 1200px) {
            .ticket-img {
                position: relative;
                bottom: 25px
            }

            .carousel-div div {
                top: 25px;
            }
        }

        @media (max-width: 1199px) {
            .carousel-div {
                padding-top: 10px;
            }

            .carousel-div div {
                margin-bottom: 10px;
            }
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
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toMyPoint?number=1&size=5&state=3">我的豆值</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toMyInvitation?number=1&size=10">我的邀请码</a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-9" style="padding-left: 0">
                <ul class="col-sm-12 ul-border">
                    <span>可用豆值&nbsp;<label style="color: #A4C540;font-size: 1.3em">${myPoint}&nbsp;</label>个&nbsp;&nbsp;&nbsp;&nbsp;<label
                            id="year-label"></label>将过期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    <a href="${pageContext.request.contextPath}/login/toSign" class="btn btn-success"
                       style="background-color: #A4C540;">签到</a>
                    <div class="col-sm-12" style="margin-bottom: 10px">
                        <table style="margin-left:auto;margin-right:auto;">
                            <tr>
                                <td>
                                    <ul class="nav nav-pills navbar-left"
                                        style="border: 2px solid #A4C540;border-radius: 0.4em;">
                                        <li id="all-li"><a
                                                href="javascript:ajaxPage(1,3)">豆值明细</a>
                                        </li>
                                        <li id="get-li"><a
                                                href="javascript:ajaxPage(1,1)">收入豆值</a>
                                        </li>
                                        <li id="pay-li"><a
                                                href="javascript:ajaxPage(1,0)">支出豆值</a>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                        </table>
                        <div id="orderContent" class="tab-content" style="margin-top: 20px">
                            <div class="tab-pane fade in active" id="all">
                                <div class="table-responsive table-border">
                                    <table class="table table-hover table-condensed" style="font-size: 1em">
                                        <thead>
                                        <tr style="background-color: #A4C540;color: #ffffff;">
                                            <th>日期</th>
                                            <th>收入/支出</th>
                                            <th>详细说明</th>
                                        </tr>
                                        </thead>
                                        <tbody id="tr-body">
                                        <c:forEach items="${pointList}" var="pl">
                                            <tr>
                                                <td><fmt:formatDate value="${pl.syscreated}" type="date"
                                                                    pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                <td>
                                                    <c:if test="${pl.incomePay==1}">
                                                        +
                                                    </c:if>
                                                    <c:if test="${pl.incomePay==0}">
                                                        -
                                                    </c:if>
                                                        ${pl.action}
                                                </td>
                                                <td>${pl.describebean}</td>
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
                    </div>
                    <div class="col-sm-12 table-border" style="margin-bottom: 40px;padding-left: 0;padding-right: 0">
                        <header style="background-color: #A4C540;padding-left: 10px;padding-right: 10px;color: #ffffff;">
                            <label>豆值兑换</label>
                        </header>
                        <div class="col-sm-12" style="padding-top: 10px;padding-bottom: 10px">
                            <ul class="vmcarousel-centered vmc-centered">
                                <c:forEach items="${couponList}" var="cl">
                                    <li>
                                        <div class="carousel-div">
                                            <img class="img-responsive ticket-img"
                                                 src="/resources/image/ticket-demo.jpg"
                                                 style="display: inline-block;margin-left: 20px;">
                                            <div>
                                                <label style="font-size: 1.5em;color: #A4C540;">￥<fmt:formatNumber
                                                        value="${cl.discountpageVal/100}" type="number"
                                                        pattern="#"/></label><br>
                                                <label>满<fmt:formatNumber value="${cl.money/100}" type="number"
                                                                          pattern="#"/>可用</label><br>
                                                <button class="btn btn-default"
                                                        style="background-color: #A4C540;width: 125px"
                                                        onclick="exchange(${cl.pointVal},${cl.dpId})"
                                                        <c:if test="${myPoint<cl.pointVal}">
                                                            disabled="disabled"
                                                        </c:if>
                                                >
                                                    <fmt:formatNumber value="${cl.pointVal}" type="number" pattern="#"/>豆值兑换
                                                </button>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-12 table-border" style="margin-bottom: 10px;padding-left: 0;padding-right: 0">
                        <header style="background-color: #A4C540;padding-left: 10px;padding-right: 10px;color: #ffffff;">
                            <label>豆值使用常见说明</label>
                        </header>
                        <div class="col-sm-12">
                            <strong>1、豆值的有效期</strong><br>
                            <span>
                                豆值的有效期为一年，即从从获得豆值的本年到年底，逾期自动作废（如若交易在使用豆值有效期之外发生退款，该部分豆值不予退还）。
                            </span><br>
                            <strong>2、豆值的兑换比例</strong><br>
                            <span>
                                豆值和人民币的兑换比例为100:1，即100个豆值相当于人民币1元。
                            </span><br>
                            <strong>3、豆值任何获取</strong><br>
                            <span>用户在小豆进行购物、签到和注册等活动都可以获得豆值。</span>
                        </div>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body" style="color: #A4C540;">兑换成功！！</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color: #A4C540;">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-keyboard="false" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: #2CB742;">
                <i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i>
                <p>兑换中...</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/messages_zh.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap-paginator.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script src="/resources/js/jquery.vm-carousel.js"></script>
<script>
    var s = 3;
    var numberC = 1;
    $().ready(function () {
        $("#forth_li").addClass("active");
        $("#all-li").addClass("active");
        $('.vmcarousel-centered').vmcarousel({
            centered: true,
            start_item: 1,
            autoplay: false,
            infinite: false
        });
        var date = new Date();
        $("#year-label").html(date.getFullYear() + "年12月31号");
        $("#all-li").removeClass("active");
        $("#get-li").removeClass("active");
        $("#pay-li").removeClass("active");
        if (${state == 3}) {
            $("#all-li").addClass("active");
        }
        if (${state== 1}) {
            $("#get-li").addClass("active");
        }
        if (${state== 0}) {
            $("#pay-li").addClass("active");
        }
    });
    $(function () {
        var options = {
            currentPage:${currentPage},
            totalPages: ${totalPages},
            numberOfPages: 5,
            onPageClicked: function (event, originalEvent, type, page) {
                ajaxPage(page, s);
            }
        };
        $('#example').bootstrapPaginator(options);
    });
    function ajaxPage(page, state) {
        var pi = {
            number: page,
            size: 5,
            state: state
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/login/myPointAjax",
            data: JSON.stringify(pi),
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                s = state;
                $("#all-li").removeClass("active");
                $("#get-li").removeClass("active");
                $("#pay-li").removeClass("active");
                if (state == 3) {
                    $("#all-li").addClass("active");
                }
                if (state == 1) {
                    $("#get-li").addClass("active");
                }
                if (state == 0) {
                    $("#pay-li").addClass("active");
                }
                $("#tr-body").empty();
                var options = {
                    currentPage:page,
                    totalPages: data.totalPages,
                    numberOfPages: 5,
                    onPageClicked: function (event, originalEvent, type, page) {
                        ajaxPage(page, s);
                    }
                };
                numberC = page;
                $('#example').bootstrapPaginator("setOptions", options);
                $.each(data.pointList, function (index, pl) {
                    var v;
                    if (pl.incomePay == 1) {
                        v = '+' + pl.action;
                    }
                    if (pl.incomePay == 0) {
                        v = '-' + pl.action;
                    }
                    var html = '<tr>' +//
                            '<td>' + formatDateTime(pl.syscreated) + '</td>' +//
                            '<td>' + v + '</td>' +//
                            '<td>' + pl.describebean + '</td>' +//
                            '</tr>';
                    $("#tr-body").append(html);
                })
            }
        });
    }

    function formatDateTime(inputTime) {
        var date = new Date(inputTime);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var h = date.getHours();
        h = h < 10 ? ('0' + h) : h;
        var minute = date.getMinutes();
        var second = date.getSeconds();
        minute = minute < 10 ? ('0' + minute) : minute;
        second = second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
    }

    function exchange(pv, id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/exchangePointAjax?pv=" + pv + "&dpid=" + id,
            type: "GET",
            beforeSend: function () {
                $("#myModal3").modal("show");
            },
            success: function (data) {
                $("#myModal3").modal("hide");
                if (data == 1) {
                    $("#myModal").modal("show");
                    $('#myModal').on('hide.bs.modal', function () {
                        window.location.href = '${pageContext.request.contextPath}/login/toMyPoint?number=' + numberC + '&size=5&state=' + s
                    })
                }
            }
        })
    }
</script>

</body>
</html>



