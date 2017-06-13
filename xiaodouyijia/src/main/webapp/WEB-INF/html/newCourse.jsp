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
    <title>小豆一家——早教课程</title>
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
            color: #EB9C37;
            background-color: #ffffff;
        }

        .pagination li.active > a, .pagination li.active > span, .pagination li.active > a:hover, .pagination li.active > span:hover, .pagination li.active > a:focus, .pagination li.active > span:focus {
            background-color: #EB9C37;
        }

        .pagination li {
            margin-right: 0;
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
<%@include file="newTop.jsp" %>
<div id="bar-div"
     style="height: 400px; width:100%;background-color: #EB9C37;display:flex;justify-content:center;align-items:center;">
    <table class="mid_table">
        <tr>
            <td>
                <div style="display:flex;justify-content:center;align-items:center;">
                    <div class="introduction_div2 col-sm-5" id="robot-right" style="opacity: 1">
                        <h2>全新全类的早教课程</h2>
                        <span>安全放心、智能学习、安全放心、智能学习</span>
                        <br>
                        <span>发掘孩子的想象力、创造力、开拓力</span>
                        <br>
                        <span>不发愁的早教课程</span>
                        <br>
                        <span>￥<span style="font-size: 1.9em;letter-spacing: 4px">3999</span></span>
                        <br>
                    </div>
                    <div class="col-sm-5">
                        <img class="img-responsive" id="robot-left" src="/resources/image/course_demo.jpg">
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>

<div class="container" id="fix-top" style="background-color: #ffffff">
    <div style="">
        <form id="fix-form" method="get" class="form-horizontal form-no-top"
              action="${pageContext.request.contextPath}/login/toBuy">
            <nav class="navbar" role="navigation">
                <ul class="nav nav-pills nav-justified">
                    <li><a href="#all" data-toggle="tab" onclick="changeKind('全部科目')">全部课程</a></li>
                    <li><a href="#work" data-toggle="tab" onclick="changeKind('生命科学')">美劳美艺</a></li>
                    <li><a href="#science" data-toggle="tab" onclick="changeKind('玩转数理')">生命科学</a></li>
                    <li><a href="#astronomy" data-toggle="tab" onclick="changeKind('趣味生活')">天文探索</a></li>
                    <li><a href="#chemistry" data-toggle="tab" onclick="changeKind('天文地理')">玩转化学</a></li>
                    <li><a href="#physics" data-toggle="tab" onclick="changeKind('奇趣物化')">物理实验</a></li>
                    <li><a href="#life" data-toggle="tab" onclick="changeKind('美劳美艺')">趣味生活</a></li>
                </ul>
            </nav>
            <div id="myTabContent" class="tab-content col-sm-12" style="color: #EB9C37;">
                <div class="tab-pane fade" id="all">
                    六大课程体系，培养孩子的语言能力、逻辑创造力、艺术能力、交往能力等
                </div>
                <div class="tab-pane fade" id="work">
                    透过科学的眼睛，发现生命的奥秘
                </div>
                <div class="tab-pane fade" id="science">
                    游戏中感知数学的美，体会物理的趣
                </div>
                <div class="tab-pane fade" id="astronomy">
                    生活中寻找趣味，趣味中快乐生活
                </div>
                <div class="tab-pane fade" id="chemistry">
                    探索宇宙放飞梦想，放眼山川找寻宝藏
                </div>
                <div class="tab-pane fade" id="physics">
                    是魔术还是科学？等你来寻找答案
                </div>
                <div class="tab-pane fade" id="life">
                    给灵巧的双手插上创意的翅膀
                </div>
            </div>
            <select class="form-control select select-warning select-block mbl" id="month-select"
                    style="margin-left: 10px;margin-top: 19px" onchange="return selectChange()">
                <option value="-1">选择月份</option>
            </select>
            <select class="form-control select select-warning select-block mbl margin-right-i" id="age-select"
                    style="margin-left: 10px;" onchange="return selectChange()">
                <option value="-1">选择年龄</option>
                <option value="3~6岁">3~6岁</option>
                <option value="6~8岁">6~8岁</option>
                <option value="8~10岁">8~10岁</option>
                <option value="10~12岁">10~12岁</option>
                <option value="全年龄">全年龄</option>
            </select>

            <%--<select class="form-control select select-warning select-block mbl" id="month-select"
                    style="margin-left: 10px;margin-top: 19px" onchange="return selectChange()">
                <option value="全选">选择月份</option>
            </select>
            <select class="form-control select select-warning select-block mbl margin-right-i" id="age-select"
                    style="margin-left: 10px;" onchange="return selectChange()">
                <option value="全选">选择年龄</option>
                <option value="3~6岁">3~6岁</option>
                <option value="6~8岁">6~8岁</option>
                <option value="8~10岁">8~10岁</option>
                <option value="10~12岁">10~12岁</option>
                <option value="全选">全年龄</option>
            </select>--%>

            <label>数量:</label>
            <div class="mount-div margin-right-i">
                <button class="button button-circle button-tiny" style="background-color:#EB9C37;color: #ffffff;"
                        disabled="disabled" id="plus-button" onclick="return plus()"><i class="fa fa-plus"></i></button>
                <label class="mount-label" style="color: #EB9C37;" id="mount-label">1</label>
                <button class="button button-circle button-tiny" style="background-color:#EB9C37;color: #ffffff;"
                        disabled="disabled" id="minus-button" onclick="return minus()"><i class="fa fa-minus"></i>
                </button>
            </div>
            <label>总价：</label><label id="price-label" class="margin-right-i" style="color: #EB9C37;">——</label>
            <div class="pull-right">
                <input type="hidden" id="kind-input" name="" value="-1">
                <%--<input type="hidden" id="kind-input" name="" value="全选">--%>
                <input type="hidden" id="mount-input" name="mount" value="1">
                <input type="hidden" id="id-input" name="pid" value="0">
                <input type="submit" id="buy-button"
                       class="button button-glow button-rounded button-caution buy_button order-button-c margin-right-i"
                       value="购买" disabled="disabled">
                <button id="shopCar-button" onclick="addShopCar()" type="button"
                        class="button button-glow button-rounded button-caution buy_button order-button-c margin-right-i"
                        disabled="disabled">
                    加入购物车
                </button>
            </div>
        </form>
    </div>
</div>
<div class="container" style="margin-top: 40px;" id="introduction">
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1" id="page-course">
            <c:forEach items="${videoList}" var="vl">
                <a href="${pageContext.request.contextPath}/index/toVideo?vid=${vl.vId}" class="col-sm-4"
                   style="padding-left: 0;padding-right: 0; text-align: center;margin-bottom: 20px">
                    <div class="col-xs-10 col-xs-offset-1" style="padding-left: 0;padding-right: 0">
                        <img src="${vl.vImg}" style="width: 100%" class="img-thumbnail">
                        <div class="txt" style="width: 100%;height: 100%">
                            <div class="middle-full"></div>
                            <img src="/resources/image/bo.png" class="action-img middle-item">
                            <span style="width: 100%">${vl.vTital}</span>
                        </div>
                    </div>
                </a>
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
</div>
<div class="col-sm-12"
     style="background-color:#EB9C37;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
<div id="sign_hidden" class="form_div col-sm-3 col-sm-offset-6 col-xs-12"
     style="text-align: center;display: none;color: #A4C540;padding-bottom: 20px">
    <h4 id="body-h">正在添加到购物车...</h4>
    <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">添加成功！</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/resize.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap-paginator.js"></script>
<script src="/resources/js/flat-ui.min.js"></script>

<script>
    var mount = 1;
    var price_All = 0;
    var stock = 0;
    var courseId = 0;
    var fix = false;
    var monthList;
    $(function () {
        $("#month-select").val(-1);
        $("#age-select").val(-1);
        $("#price-input").val(0);
        $("#kind-input").val(-1);
        $("#mount-input").val(1);
        /*$("#month-select").val("全选");
        $("#age-select").val("全选");
        $("#kind-input").val("全选");*/
        $("#id-input").val(0);

        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $("#second_li").addClass("active");
        $("#course-li").addClass("active");
    });
    window.onscroll = function () {
        var result = $(window).scrollTop() - $('#fix-top')[0].offsetTop;
        var h = document.getElementById("fix-top").offsetHeight + 40;
        if (result >= 0 && !fix) {
            $("#fix-top").addClass("navbar-fixed-top");
            $("#introduction").css("margin-top", h);
            $("#fix-form").css("box-shadow", "1px 1px 2px 2px #bbbbbb");
            fix = true;
        } else {
            var bh = $('#bar-div')[0].offsetTop;
            if ($(window).scrollTop() - bh <= 400) {
                $("#fix-top").removeClass("navbar-fixed-top");
                $("#introduction").css("margin-top", "40px");
                $("#fix-form").css("box-shadow", "none");
                fix = false;
            }
        }
    };

    $("#fix-top").resize(function () {
        if (fix) {
            var h = document.getElementById("fix-top").offsetHeight + 40;
            $("#introduction").css("margin-top", h);
        }
    });

    function changeKind(indexKind) {
        ajaxPage(1, indexKind, '-1', $("#age-select").val() + "");
//        ajaxPage(1, indexKind, '全选', $("#age-select").val() + "");
        $("#month-select").empty();
        $("#select2-chosen-1").html("请选择");
        $("#month-select").append('<option value="-1">请选择</option>');
//        $("#month-select").append('<option value="全选">请选择</option>');
        $('#kind-input').val(indexKind);
        $("#price-label").html("——");
        $("#price-input").val(0);
        $("#buy-button").attr("disabled", "disabled");
        $("#shopCar-button").attr("disabled", "disabled");
        $.each(monthList, function (index, ml) {
            var o = '<option value="' + ml + '">' + ml + '</option>';
            $("#month-select").append(o);
        });
        $("#plus-button").attr("disabled", "disabled");
        $("#minus-button").attr("disabled", "disabled");
        $(".mount-label").html("0");
        $("#mount-input").val(0);
    }

    function selectChange() {
        ajaxPage(1, $("#kind-input").val() + "", $("#month-select").val() + "", $("#age-select").val() + "");
        if ($("#age-select").val() != -1 && $("#month-select").val() != -1) {
//      if ($("#age-select").val() != "全选" && $("#month-select").val() != "全选") {
                $("#plus-button").attr("disabled", false);
            $("#buy-button").attr("disabled", false);
            $("#shopCar-button").attr("disabled", false);
            if (stock <= $("#mount-input").val()) {
                $("#plus-button").attr("disabled", "disabled");
                $(".mount-label").html(stock);
                $("#mount-input").val(stock);
                mount = stock;
            }
            if (stock == 0) {
                mount = 0;
                $(".mount-label").html(0);
                $("#mount-input").val(0);
                $("#plus-button").attr("disabled", "disabled");
                $("#minus-button").attr("disabled", "disabled");
                $("#buy-button").attr("disabled", "disabled");
                $("#shopCar-button").attr("disabled", "disabled");
            }
            if (stock > $("#mount-input").val()) {
                $(".mount-label").html(1);
                $("#mount-input").val(1);
            }
            var allPrice = price_All * mount;
            $("#price-label").html(allPrice);
        } else {
            price_All = 0;
            stock = 0;
            mount = 1;
            courseId = 0;
            $("#id-input").val(0);
            $(".mount-label").html(0);
            $("#mount-input").val(0);
            $("#price-label").html("——");
            $("#plus-button").attr("disabled", "disabled");
            $("#minus-button").attr("disabled", "disabled");
            $("#buy-button").attr("disabled", "disabled");
            $("#shopCar-button").attr("disabled", "disabled");
        }
        return false;
    }

    function addShopCar() {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/addShopCarAjax?mount="+$("#mount-input").val()+"&pid="+courseId,
            type: "POST",
            beforeSend: function () {
                $("#sign_hidden").modal("show");
            },
            success: function (data) {
                if (data == 1) {
                    $("#sign_hidden").modal("hide");
                    $("#myModal2").modal("show");
                }else{
                    window.location.href = '${pageContext.request.contextPath}/index/toLogin?url=/index/toCourse?number=1&size=9';
                }
            }
        });
    }

    function plus() {
        mount = $(".mount-label").html() * 1;
        mount++;
        $("#minus-button").attr("disabled", false);
        $(".mount-label").html(mount);
        $("#mount-input").val(mount);
        if ($("#month-select").val() != -1 && $("#age-select").val() != -1 && $("#kind-input").val() != 0) {
            $("#price-label").html(price_All * mount);
        }
        if (mount >= stock) {
            $("#plus-button").attr("disabled", "disabled");
        }
        return false;
    }
    function minus() {
        mount = $(".mount-label").html() * 1;
        mount--;
        $("#plus-button").attr("disabled", false);
        $(".mount-label").html(mount);
        $("#mount-input").val(mount);
        if ($("#month-select").val() != -1 && $("#age-select").val() != -1 && $("#kind-input").val() != 0) {
            $("#price-label").html(price_All * mount);
        }
        if (mount <= 1) {
            $("#minus-button").attr("disabled", "disabled");
        }
        return false;
    }

    var options = {
        totalPages: ${totalPages},
        numberOfPages: 9,
        onPageClicked: function (event, originalEvent, type, page) {
            ajaxPage(page, '-1', '-1', '-1');
//            ajaxPage(page, '全选', '全选', '全选');
        }
    };

    function ajaxPage(page, kind, month, age) {
        $.ajax({
            url: "${pageContext.request.contextPath}/index/toCourseAjax?number=" + page + "&size=9&kind=" + kind + "&month=" + month + "&age=" + age,
            type: "post",
            async: false,
            success: function (data) {
                $("#page-course").empty();
                price_All = data.price / 100.0;
                monthList = data.monthList;
                if (data.courseDetail != null) {
                    courseId = data.courseDetail.pId;
                    $("#id-input").val(courseId);
                    stock = data.courseDetail.tbRProductStock.pNum;
                }
                var options = {
                    totalPages: data.totalPages,
                    numberOfPages: 9,
                    onPageClicked: function (event, originalEvent, type, page) {
                        ajaxPage(page, kind, month, age);
                    }
                };
                $('#example').bootstrapPaginator("setOptions", options);
                $.each(data.videoList, function (index, cl) {
                    var ah = "${pageContext.request.contextPath}/index/toVideo?vid=" + cl.vId;
                    var html = '<a href="' + ah + '" class="col-sm-4" style="padding-left: 0;padding-right: 0; text-align: center;margin-bottom: 20px">' +//
                            '<div class="col-xs-10 col-xs-offset-1" style="padding-left: 0;padding-right: 0">' +//
                            '<img src="' + path + cl.vImg + '" style="width: 100%" class="img-thumbnail">' +//
                            '<div class="txt" style="width: 100%;height: 100%">' +//
                            '<div class="middle-full"></div>' +//
                            '<img src="/resources/image/bo.png" class="action-img middle-item">' +//
                            '<span style="width: 100%">' + cl.vTital + '</span>' +//
                            '</div>' +//
                            '</div>' +//
                            '</a>';
                    $("#page-course").append(html);
                })
            }
        })
    }
    $('#example').bootstrapPaginator(options);
</script>
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
    <%--<title>小豆一家——早教课程</title>--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="viewport" content="width=device-width">--%>

    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fullpage.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">--%>
    <%--<style type="text/css">--%>
        <%--.nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {--%>
            <%--color: #EB9C37;--%>
            <%--background-color: #ffffff;--%>
            <%--border: 1px solid #EB9C37;--%>
        <%--}--%>

        <%--.pagination li.active > a, .pagination li.active > span, .pagination li.active > a:hover, .pagination li.active > span:hover, .pagination li.active > a:focus, .pagination li.active > span:focus {--%>
            <%--background-color: #EB9C37;--%>
        <%--}--%>

        <%--.pagination li {--%>
            <%--margin-right: 0;--%>
        <%--}--%>
    <%--</style>--%>

    <%--<script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>--%>

    <%--<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@include file="newTop.jsp" %>--%>
<%--<div id="bar-div"--%>
     <%--style="height: 400px; width:100%;background-color: #EB9C37;display:flex;justify-content:center;align-items:center;">--%>
    <%--<table class="mid_table">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<div style="display:flex;justify-content:center;align-items:center;">--%>
                    <%--<div class="introduction_div2 col-sm-5" id="robot-right" style="opacity: 1">--%>
                        <%--<h2>小豆宝盒、早教课程</h2>--%>
                        <%--<span>玩得更好、学得更好、一起成长</span>--%>
                        <%--<br>--%>
                        <%--<span>让孩子在快乐中学习知识</span>--%>
                        <%--<br>--%>
                        <%--<span>￥<span style="font-size: 1.9em;letter-spacing: 4px">3999</span></span>--%>
                        <%--<div id="button-div" style="position: absolute;z-index: 10">--%>
                            <%--<a class="button button-glow button-caution buy_button course-button-c"--%>
                               <%--style="margin-right: 20px" href="#">天猫购买--%>
                            <%--</a>--%>
                            <%--<a class="button button-glow button-caution buy_button course-button-c"--%>
                               <%--href="#">京东购买--%>
                            <%--</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-5">--%>
                        <%--<img class="img-responsive" id="robot-left"--%>
                             <%--src="${pageContext.request.contextPath}/resources/image/course_demo.jpg">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>

<%--<div class="container" style="background-color: #ffffff;border-bottom: 2px solid #EB9C37">--%>
    <%--<form method="get" class="form-horizontal">--%>
        <%--<nav class="navbar" role="navigation" style="margin-bottom: 10px">--%>
            <%--<ul class="nav nav-pills nav-justified">--%>
                <%--<li><a href="#work" data-toggle="tab" onclick="changeKind('生命科学')">生命科学</a></li>--%>
                <%--<li><a href="#science" data-toggle="tab" onclick="changeKind('玩转数理')">玩转数理</a></li>--%>
                <%--<li><a href="#astronomy" data-toggle="tab" onclick="changeKind('趣味生活')">趣味生活</a></li>--%>
                <%--<li><a href="#chemistry" data-toggle="tab" onclick="changeKind('天文地理')">天文地理</a></li>--%>
                <%--<li><a href="#physics" data-toggle="tab" onclick="changeKind('奇趣物化')">奇趣物化</a></li>--%>
                <%--<li><a href="#life" data-toggle="tab" onclick="changeKind('美劳美艺')">美劳美艺</a></li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
        <%--<div class="col-sm-12">--%>
            <%--<div id="myTabContent" class="tab-content pull-left" style="color: #EB9C37;margin-top: 25px">--%>
                <%--<div class="tab-pane fade" id="work">--%>
                    <%--透过科学的眼睛，发现生命的奥秘--%>
                <%--</div>--%>
                <%--<div class="tab-pane fade" id="science">--%>
                    <%--游戏中感知数学的美，体会物理的趣--%>
                <%--</div>--%>
                <%--<div class="tab-pane fade" id="astronomy">--%>
                    <%--生活中寻找趣味，趣味中快乐生活--%>
                <%--</div>--%>
                <%--<div class="tab-pane fade" id="chemistry">--%>
                    <%--探索宇宙放飞梦想，放眼山川找寻宝藏--%>
                <%--</div>--%>
                <%--<div class="tab-pane fade" id="physics">--%>
                    <%--是魔术还是科学？等你来寻找答案--%>
                <%--</div>--%>
                <%--<div class="tab-pane fade" id="life">--%>
                    <%--给灵巧的双手插上创意的翅膀--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="pull-right">--%>
                <%--<input type="hidden" id="kind-input" name="" value="全选">--%>
                <%--<input type="hidden" id="id-input" name="pid" value="0">--%>
                <%--<select class="form-control select select-warning select-block mbl margin-right-i" id="age-select"--%>
                        <%--style="margin-left: 10px;" onchange="return selectChange()">--%>
                    <%--<option value="全选">年龄段</option>--%>
                    <%--<option value="3~6岁">3~6岁</option>--%>
                    <%--<option value="6~8岁">6~8岁</option>--%>
                    <%--<option value="8~10岁">8~10岁</option>--%>
                    <%--<option value="10~12岁">10~12岁</option>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>
<%--<div class="container" style="margin-top: 10px;" id="introduction">--%>
    <%--<div class="row">--%>
        <%--<div class="col-sm-10 col-sm-offset-1" id="page-course">--%>
            <%--<c:forEach items="${videoList}" var="vl">--%>
                <%--<a href="${pageContext.request.contextPath}/index/toVideo?vid=${vl.vId}" class="col-sm-4"--%>
                   <%--style="padding-left: 0;padding-right: 0; text-align: center;margin-bottom: 20px">--%>
                    <%--<div class="col-xs-10 col-xs-offset-1" style="padding-left: 0;padding-right: 0">--%>
                        <%--<img src="${pageContext.request.contextPath}${vl.vImg}" style="width: 100%"--%>
                             <%--class="img-thumbnail">--%>
                        <%--<div class="txt" style="width: 100%;height: 100%">--%>
                            <%--<div class="middle-full"></div>--%>
                            <%--<img src="${pageContext.request.contextPath}/resources/image/bo.png"--%>
                                 <%--class="action-img middle-item">--%>
                            <%--<span style="width: 100%">${vl.vTital}</span>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</a>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<table style="margin-left:auto;margin-right:auto;">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<ul id="example"></ul>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>
<%--<div class="col-sm-12"--%>
     <%--style="background-color:#EB9C37;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">--%>
    <%--<span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>--%>
<%--</div>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/resize.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/bootstrap-paginator.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/flat-ui.min.js"></script>--%>

<%--<script>--%>
    <%--var courseId = 0;--%>
    <%--var fix = false;--%>
    <%--$(function () {--%>
        <%--$("#month-select").val("全选");--%>
        <%--$("#kind-input").val("全选");--%>
        <%--$("#id-input").val(0);--%>

        <%--$("select").select2({dropdownCssClass: 'dropdown-inverse'});--%>
        <%--$("#second_li").addClass("active");--%>
        <%--$("#course-li").addClass("active");--%>
    <%--});--%>


    <%--function changeKind(indexKind) {--%>
        <%--ajaxPage(1, indexKind, '全选', $("#age-select").val() + "");--%>
        <%--$('#kind-input').val(indexKind);--%>
    <%--}--%>

    <%--function selectChange() {--%>
        <%--ajaxPage(1, $("#kind-input").val() + "", '全选', $("#age-select").val() + "");--%>
        <%--if ($("#age-select").val() != "全选") {--%>
        <%--}--%>
        <%--else {--%>
            <%--courseId = 0;--%>
            <%--$("#id-input").val(0);--%>
        <%--}--%>
        <%--return false;--%>
    <%--}--%>


    <%--var options = {--%>
        <%--totalPages: ${totalPages},--%>
        <%--numberOfPages: 9,--%>
        <%--onPageClicked: function (event, originalEvent, type, page) {--%>
            <%--ajaxPage(page, '全选', '全选', '全选');--%>
        <%--}--%>
    <%--};--%>

    <%--function ajaxPage(page, kind, month, age) {--%>
        <%--$.ajax({--%>
            <%--url: "${pageContext.request.contextPath}/index/toCourseAjax?number=" + page + "&size=9&kind=" + kind + "&month=" + month + "&age=" + age,--%>
            <%--type: "post",--%>
            <%--async: false,--%>
            <%--success: function (data) {--%>
                <%--$("#page-course").empty();--%>
                <%--if (data.courseDetail != null) {--%>
                    <%--courseId = data.courseDetail.pId;--%>
                    <%--$("#id-input").val(courseId);--%>
                <%--}--%>
                <%--var options = {--%>
                    <%--totalPages: data.totalPages,--%>
                    <%--numberOfPages: 9,--%>
                    <%--onPageClicked: function (event, originalEvent, type, page) {--%>
                        <%--ajaxPage(page, kind, month, age);--%>
                    <%--}--%>
                <%--};--%>
                <%--$('#example').bootstrapPaginator("setOptions", options);--%>
                <%--var path = '${pageContext.request.contextPath}';--%>
                <%--$.each(data.videoList, function (index, cl) {--%>
                    <%--var ah = "${pageContext.request.contextPath}/index/toVideo?vid=" + cl.vId;--%>
                    <%--var html = '<a href="' + ah + '" class="col-sm-4" style="padding-left: 0;padding-right: 0; text-align: center;margin-bottom: 20px">' +//--%>
                            <%--'<div class="col-xs-10 col-xs-offset-1" style="padding-left: 0;padding-right: 0">' +//--%>
                            <%--'<img src="' + path + cl.vImg + '" style="width: 100%" class="img-thumbnail">' +//--%>
                            <%--'<div class="txt" style="width: 100%;height: 100%">' +//--%>
                            <%--'<div class="middle-full"></div>' +//--%>
                            <%--'<img src="' + path + '/resources/image/bo.png" class="action-img middle-item">' +//--%>
                            <%--'<span style="width: 100%">' + cl.vTital + '</span>' +//--%>
                            <%--'</div>' +//--%>
                            <%--'</div>' +//--%>
                            <%--'</a>';--%>
                    <%--$("#page-course").append(html);--%>
                <%--})--%>
            <%--}--%>
        <%--})--%>
    <%--}--%>
    <%--$('#example').bootstrapPaginator(options);--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


