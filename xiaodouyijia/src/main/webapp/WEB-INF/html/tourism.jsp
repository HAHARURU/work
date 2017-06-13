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
    <title>小豆一家——亲子旅游</title>
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
        .nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {
            color: #fff;
            background-color: #ED683F;
        }

        .pagination li {
            margin-right: 0;
        }

        .pagination li.active > a, .pagination li.active > span, .pagination li.active > a:hover, .pagination li.active > span:hover, .pagination li.active > a:focus, .pagination li.active > span:focus {
            background-color: #ED683F;
        }
    </style>

    <script src="/resources/js/vendor/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="newTop.jsp" %>
<div style="height: 400px; width:100%;background-color: #ED683F;display:flex;justify-content:center;align-items:center">
    <table class="mid_table">
        <tr>
            <td>
                <div style="display:flex;justify-content:center;align-items:center">
                    <div class="col-sm-5 col-sm-offset-1">
                        <img class="img-responsive" id="robot-left" src="/resources/image/tourism_demo.jpg">
                    </div>
                    <div class="introduction_div col-sm-5" id="robot-right" style="opacity: 1">
                        <h2>亲子旅游</h2>
                        <span>亲子场馆、亲子酒店、户外活动、冬夏令营</span>
                        <br>
                        <span>发掘孩子的想象力、创造力、开拓力</span>
                        <br>
                        <span>疯抢价：<span style="font-size: 1.9em;letter-spacing: 4px">3999元</span></span>
                        <br>
                        <span>抢购就送<em style="font-size: 1.6em">小豆一号</em>机器人</span>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
<div class="container" style="margin-top: 40px;" id="introduction">
    <div class="row">
        <table style="margin-left:auto;margin-right:auto;">
            <tr>
                <td>
                    <ul class="nav nav-pills navbar-left" style="border: 2px solid #ED683F;border-radius: 0.4em;">
                        <li id="new-li"><a
                                href="${pageContext.request.contextPath}/index/toTourism?state=1&number=1&size=4">最新活动</a>
                        </li>
                        <li id="hot-li"><a
                                href="${pageContext.request.contextPath}/index/toTourism?state=2&number=1&size=4">最热活动</a>
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
        <c:forEach items="${tourismList}" var="tl">
            <div class="media tourism_listItem col-sm-12">
                <div class="pull-left" style="margin-right: 40px">
                    <img class="media-object" src="${tl.img}">
                </div>
                <div class="media-body">
                    <span class="tourism-span"><label class="tourism-color">活动内容：</label><span>${tl.pName}</span></span>
                    <span class="tourism-span"><label
                            class="tourism-color">活动日期：</label><span><fmt:formatDate value="${tl.startTime}" type="date"
                                                                                     pattern="yyyy-MM-dd"/></span></span>
                    <br>
                    <span class="tourism-span"><label
                            class="tourism-color">参加条件：</label><span></span>${tl.tbSysProductFun.pJoin}</span>
                    <span class="tourism-span"><label
                            class="tourism-color">注意事项：</label><span>${tl.buyNotice}</span></span>
                    <br>
                    <label class="tourism-color">活动详情：</label><span
                        id="hidden-text">${tl.tbSysProductFun.pFunStr}</span>
                    <br>
                    <label id="price${tl.pId}" class="tourism-color" style="font-size: 1.2em"></label>
                    <div class="pull-right">
                        <a class="button button-glow button-rounded button-caution buy_button order-button-t margin-right-i"
                           href="${pageContext.request.contextPath}/index/toTourismDetail?tid=${tl.pId}">
                            我要报名
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <table style="margin-left:auto;margin-right:auto">
            <tr>
                <td>
                    <ul id="example"></ul>
                </td>
            </tr>
        </table>
    </div>
</div>
<div class="col-sm-12"
     style="background-color:#ED683F;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap-paginator.js"></script>
<script src="/resources/js/flat-ui.min.js"></script>

<script>
    var mount = 1;
    $(function () {
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $("#second_li").addClass("active");
        $("#tourism-li").addClass("active");
        if (${state==1}) {
            $("#new-li").addClass("active");
        }
        if (${state==2}) {
            $("#hot-li").addClass("active");
        }
        var $t = $("#hidden-text").html().toString();
        if ($t.length > 76) {
            $("#hidden-text").html($t.substr(0, 76) + "...");
        }
        <c:forEach items="${tourismList}" var="tl">
        var adultPrice =${tl.pPrice/100.0};
        var childrenPrice =${tl.pPriceBoy/100.0};
        $("#price${tl.pId}").html("￥" + adultPrice + "/成人，￥" + childrenPrice + "/儿童");
        </c:forEach>
    });
    var options = {
        currentPage: ${number},
        totalPages: ${allPages},
        numberOfPages: 4,
        pageUrl: function (type, page, current) {
            return "${pageContext.request.contextPath}/index/toTourism?state=${state}&number=" + page + "&size=4";
        }
    };
    $('#example').bootstrapPaginator(options);
</script>
</body>
</html>

