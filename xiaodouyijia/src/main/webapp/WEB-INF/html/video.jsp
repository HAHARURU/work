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
    <link rel="stylesheet" href="/resources/css/jquery.mCustomScrollbar.css">
    <style type="text/css">
        .list-group-item {
            text-align: center;
            padding-bottom: 0;
            background-color: #EB9C37;
        }

        a.list-group-item:hover, a.list-group-item:active, a.list-group-item:focus {
            background-color: #ED683F;
        }

        .list-group-item h5 {
            margin-top: 5px;
            margin-bottom: 0;
        }

        .vjs-play-control > div:before, .vjs-play-control > div:after {
            color: #EB9C37;
        }

        .vjs-play-control:hover > div.vjs-control-content:after, .vjs-play-control:hover > div.vjs-control-content:before {
            color: #ED683F;
        }

        .vjs-play-progress {
            background: #EB9C37;
        }

        .vjs-seek-handle {
            background-color: #EB9C37;
        }

        .vjs-seek-handle:hover, .vjs-seek-handle:focus, .vjs-seek-handle:active {
            background-color: #ED683F;
        }

        .vjs-mute-control > div {
            color: #EB9C37;
            opacity: 0.5;
        }

        .vjs-mute-control:hover > div {
            color: #EB9C37;
            opacity: 1;
        }

        .vjs-fullscreen-control > div {
            color: #EB9C37;
            opacity: 0.5;
        }

        .vjs-fullscreen-control:hover > div {
            color: #EB9C37;
            opacity: 1;
        }

        @media (min-width: 768px) {
            #hidden-list {
                height: 298px;
            }
        }

        @media (min-width: 992px) {
            #hidden-list {
                height: 391px;
            }
        }

        @media (min-width: 1200px) {
            #hidden-list {
                height: 476px;
            }
        }

        .mCSB_scrollTools .mCSB_dragger .mCSB_dragger_bar {
            background: rgba(164, 197, 64, 0.75);
        }

        .mCSB_scrollTools .mCSB_dragger:hover .mCSB_dragger_bar {
            background: rgba(164, 197, 64, 0.85);
        }

        .mCSB_scrollTools .mCSB_dragger:active .mCSB_dragger_bar,
        .mCSB_scrollTools .mCSB_dragger.mCSB_dragger_onDrag .mCSB_dragger_bar {
            background: rgba(164, 197, 64, 0.9);
        }

        .mCSB_container {
            margin-right: 15px;
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
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <a href="${pageContext.request.contextPath}/index/toIndex">首页&nbsp;&nbsp;</a><i
                class="fa fa-angle-double-right"></i><a
                href="${pageContext.request.contextPath}/index/toCourse?number=1&size=9">&nbsp;&nbsp;早教课程</a>
            <h3 style="color: #EB9C37;">${videoDetail.vTital}</h3>
            <div class="video-div col-sm-12">
                <div class="col-sm-9" id="play-div" style="">
                    <video class="video-js video-style" preload="auto" data-setup="{}">
                        <source src="/file/video/${videoDetail.vName}" type="video/mp4">
                        <%--<source src="${videoDetail.vName}" type="video/mp4">--%>
                    </video>
                    <button id="show-button" class="btn ip-button pull-right hidden" onclick="showList()"><i
                            class="fa fa-angle-double-left fa-2x" style="color: #EB9C37;"></i></button>
                </div>
                <div class="col-sm-3" id="list-div" style="">
                    <button id="hidden-button" class="btn op-button" onclick="hiddenList()"><i
                            class="fa fa-angle-double-right fa-2x" style="color: #EB9C37;"></i></button>
                    <h4 class="fix"
                        style="text-align: center;background-color: #A4C540;margin-top: 0;margin-bottom: 0;padding-top: 10px;padding-bottom: 10px">
                        推荐视频</h4>
                    <div id="hidden-list" style="display: inline-block;margin-top: 39px">
                        <c:forEach items="${videoList}" var="vl" varStatus="vs">
                            <a class="list-group-item"
                               href="${pageContext.request.contextPath}/index/toVideo?vid=${vl.vId}">
                                <img src="${vl.vImg}" class="img-thumbnail img-responsive">
                                <h5>${vl.vTital}</h5>
                                <label>${timeList.get(vs.index)}分钟</label>
                                <%--<label>${vl.duration}分钟</label>--%>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 col-sm-offset-1">
                <img src="/resources/image/introduction.jpg" class="img-responsive" style="width: 100%">
            </div>
            <div class="col-sm-10 col-sm-offset-1">
                <img src="/resources/image/step_img.jpg" class="img-responsive" style="width: 100%">
            </div>
        </div>
    </div>
</div>

<div class="col-sm-12"
     style="background-color:#EB9C37;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/resize.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/video.js"></script>
<script src="/resources/js/flat-ui.min.js"></script>
<script src="/resources/js/jquery.mCustomScrollbar.js"></script>
<script>
    videojs.options.flash.swf = "{pageContext.request.contextPath}/resources/js/video-js.swf"
</script>

<script>
    $(function () {
        $("#second_li").addClass("active");
        $("#course-li").addClass("active");
        $("#hidden-list").mCustomScrollbar();
    });

    function hiddenList() {
        $("#list-div").animate({left: 500}, "normal", function () {
            $("#list-div").addClass("hidden");
            $("#play-div").removeClass("col-sm-9");
            $("#play-div").addClass("col-sm-12");
            $("#show-button").removeClass("hidden");
        });
    }

    function showList() {
        $("#play-div").removeClass("col-sm-12");
        $("#play-div").addClass("col-sm-9");
        $("#list-div").removeClass("hidden");
        $("#list-div").animate({left: 0}, "normal", function () {
            $("#show-button").addClass("hidden");
        });
    }

    $("#hidden-button").on("mouseenter", function () {
        $("#hidden-button").animate({opacity: '1'}, "fast");
    });

    $("#hidden-button").on("mouseleave", function () {
        $("#hidden-button").animate({opacity: '0'}, "fast");
    });

    $("#show-button").on("mouseenter", function () {
        $("#show-button").animate({opacity: '1'}, "fast");
    });

    $("#show-button").on("mouseleave", function () {
        $("#show-button").animate({opacity: '0'}, "fast");
    });

</script>
</body>
</html>



