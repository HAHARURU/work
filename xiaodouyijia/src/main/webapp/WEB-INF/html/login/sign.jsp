<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <title>小豆一家——签到</title>
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
        .pic-day {
            text-align: center;
            margin-top: 0;
            margin-bottom: 0;
        }

        .pic-text {
            display: inline-block;
            position: relative;
            left: 58%;
        }

        @media (min-width: 768px) {
            #img-div {
                top: -50px;
            }

            .pic-p {
                margin-top: 0;
                margin-bottom: 0;
                font-size: 1.4vw;
                -webkit-transform-origin-x: 0;
                -webkit-transform: scale(0.90);
                line-height: 1.2vw;
            }

            .pic-label {
                font-size: 2.4vw;
                -webkit-transform-origin-x: 0;
                -webkit-transform: scale(0.90);
            }

            .pic-p label, .pic-day label {
                line-height: 1.2vw;
            }
        }

        @media (min-width: 992px) {
            #img-div {
                top: -60px;
            }

            .pic-p {
                margin-top: 0;
                margin-bottom: 0;
                font-size: 1.4vw;
                -webkit-transform-origin-x: 0;
                -webkit-transform: scale(0.90);
                line-height: 1.2vw;
            }

            .pic-mid {
                margin-bottom: 0.2vw;
            }

            .pic-label {
                font-size: 2.4vw;
                -webkit-transform-origin-x: 0;
                -webkit-transform: scale(0.90);
            }

            .pic-p label, .pic-day label {
                line-height: 2.0vw;
            }

            .user_label {
                font-size: 1.6vw;
            }
        }

        @media (min-width: 1200px) {
            #img-div {
                top: -70px;
            }
        }

        table label {
            margin-bottom: 0;
            line-height: 1.8em;
        }

        #table-calendar td {
            color: white;
            border-bottom: solid 1px #ffffff;
            border-right: solid 1px #ffffff;
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
<img id="sign-pic" src="/resources/image/sign_demo.jpg" class="img-responsive" style="width: 100%">
<div class="pic-text">
    <p class="pic-p" style="color: #9ECDDD">
        亲爱的
        <shiro:user>
            <label class="user_label" style="color: red"><shiro:principal property="username"/></label>
        </shiro:user>
        ，你好
    </p>
    <p class="pic-p pic-mid" style="color: #768C9A;">成功签到</p>
    <p class="pic-day">
        <label class="pic-label" style="color: #768C9A;font-weight: 600">${signHistory.get("successDay")}</label>
        <label class="label-day" style="color: #768C9A;">天</label>
    </p>
</div>
<div id="img-div" class="container" style="position: relative;">
    <div class="row" style="margin-top: 0;margin-bottom: 0">
        <div class="col-sm-9">
            <label>当前日期：<label id="current-day"></label>&nbsp;&nbsp;&nbsp;&nbsp;已连续签到
                <label id="day-times" style="color:red">${signHistory.get("continuity")}</label>天</label>
            <c:if test="${signHistory.get('todayIsSign')==0}">
                <button class="button button-glow button-rounded button-caution buy_button order-button pull-right"
                        onclick="sign()">点我签到
                </button>
            </c:if>
            <c:if test="${signHistory.get('todayIsSign')==1}">
                <button class="button button-glow button-rounded button-caution buy_button order-button pull-right"
                        disabled="disabled">已签到
                </button>
            </c:if>
            <img src="/resources/image/calendar.png" class="img-responsive" id="calendar-img">
            <table class="col-sm-7" id="table-calendar" style="position: absolute;text-align: center;margin-left: 20px">
                <tr class="ca-tr">
                    <td><label style="font-size: 1.6vw">周日</label></td>
                    <td><label style="font-size: 1.6vw">周一</label></td>
                    <td><label style="font-size: 1.6vw">周二</label></td>
                    <td><label style="font-size: 1.6vw">周三</label></td>
                    <td><label style="font-size: 1.6vw">周四</label></td>
                    <td><label style="font-size: 1.6vw">周五</label></td>
                    <td><label style="font-size: 1.6vw">周六</label></td>
                </tr>
                <c:forEach items="${months}" var="ms" varStatus="vs">
                    <tr class="ca-tr h-tr">
                        <c:forEach items="${ms}" var="mw" varStatus="mi">
                            <c:if test="${mw!=0}">
                                <td style="color: white">
                                    <label style="font-size: 1.8vw">${mw}</label>
                                    <c:if test="${signHistory.get('signHistory')[vs.index][mi.index]==1}">
                                        <img src="/resources/image/signned.png" class="img-responsive"
                                             style="display: inline-block;">
                                    </c:if>
                                </td>
                            </c:if>
                            <c:if test="${mw==0}">
                                <td style="color: white">
                                    <label style="font-size: 1.8vw"></label>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="tree-div" class="col-sm-3" style="position: relative">
            <img id="tree-img" src="/resources/image/tree.png" class="img-responsive">
             <p
                    <c:if test="${signHistory.get('anotherBeanVal')==0}">
                        class="hidden"
                    </c:if>
                    id="val-div"
                    style="position:absolute;text-align: center;color: #ffffff;background-color: #A4C540;opacity:0.9;border-radius: 50%;width: 100px;height: 100px;">
                <label style="display: block;">点击收取</label>
                ${signHistory.get("anotherBeanVal")}豆值
            </p>
        </div>
    </div>
</div>
<div class="col-sm-12"
     style="background-color:#A4C540;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
<div id="sign_hidden" class="form_div col-sm-3 col-sm-offset-6 col-xs-12"
     style="text-align: center;display: none;color: #A4C540;padding-bottom: 20px">
    <h4 id="body-h">正在签到...</h4>
    <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">签到成功！</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>

<script>
    var date = new Date();
    $(function () {
        var ct = $("#table-calendar tr");
        $.each(ct, function (index, ml) {
            if (index == $("#table-calendar tr").size() - 1) {
                $($(ml).find("td")).css("border-bottom", "none");
            }
            $($(ml).find("td")[6]).css("border-right", "none");
        });
        var ph = document.getElementById("sign-pic").offsetHeight;
        $(".pic-text").css("bottom", ph * 0.37);
        $("#current-day").html(date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日");
        var tdh = $("#table-calendar tr.h-tr td").height();
        var hh = (document.getElementById("calendar-img").offsetHeight - document.getElementById("table-calendar").offsetHeight) / 2 - 10;
        $(".s-td").css("height", tdh);
        $("#table-calendar").css("bottom", hh);
        $("#signed-table").css("bottom", hh);
        var th = $("#tree-div").height() / 2;
        $("#val-div").css("bottom", th);
        var av =${signHistory.get('anotherBeanVal')};
        if (av != 0) {
            $("#tree-img").bind("click", function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/login/collectionAjax",
                    type: "GET",
                    contentType: 'application/json;charset=utf-8',
                    beforeSend: function () {
                        $("#body-h").html("正在收取...");
                        $("#sign_hidden").modal("show");
                    },
                    success: function (data) {
                        if (data == 1) {
                            $("#sign_hidden").modal("hide");
                            $(".modal-body").html("收取成功！");
                            $("#myModal2").modal("show");
                            $('#myModal2').on('hide.bs.modal', function () {
                                document.location.reload();
                            })
                        }
                    }
                });
            });
        }
    })

    function sign() {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/signAjax",
            type: "GET",
            contentType: 'application/json;charset=utf-8',
            beforeSend: function () {
                $("#body-h").html("正在签到...");
                $("#sign_hidden").modal("show");
            },
            success: function (data) {
                if (data == 1) {
                    $("#sign_hidden").modal("hide");
                    $(".modal-body").html("签到成功！");
                    $("#myModal2").modal("show");
                    $('#myModal2').on('hide.bs.modal', function () {
                        document.location.reload();
                    })
                }
            }
        });
    }

    window.onresize = function () {
        var ph = document.getElementById("sign-pic").offsetHeight;
        $(".pic-text").css("bottom", ph * 0.37);
        $("#current-day").html(date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日");
        var tdh = $("#table-calendar tr.h-tr td").height();
        var hh = (document.getElementById("calendar-img").offsetHeight - document.getElementById("table-calendar").offsetHeight) / 2 - 10;
        $(".s-td").css("height", tdh);
        $("#table-calendar").css("bottom", hh);
        $("#signed-table").css("bottom", hh);
        var th = $("#tree-div").height() / 2;
        $("#val-div").css("bottom", th);
    };
    $(window).resize();
</script>
</body>
</html>

