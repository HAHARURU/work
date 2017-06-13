<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>小豆一家</title>
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
        #fp-nav ul li a span, .fp-slidesNav ul li a span {
            background: #ffffff;
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
<div id="section_main">
    <div class="section" id="section1">
        <img class="img-responsive section_pic" src="/resources/image/new_bg.jpg">
        <div style="position: absolute;width: 100%;top: 0">
            <%@include file="newTop.jsp" %>
        </div>
        <table class="mid_table">
            <tr>
                <td>
                    <div class="section_mid">
                        <p style="color: #ffffff;font-size: 5vw;margin-bottom: 0;letter-spacing: 7px;font-weight: lighter">
                            小豆之家&nbsp;&nbsp;&nbsp;快乐成长</p>
                        <p style="color:#416C8F;font-size: 2vw;">来小豆一家找快乐的知识</p>
                        <div class="col-sm-12" style="margin-bottom: 5vh">
                            <a class="col-sm-4" href="${pageContext.request.contextPath}/index/toRobot">
                                <button class="button button-glow button-rounded button-caution a_button">智能小豆</button>
                            </a>
                            <a class="col-sm-4"
                               href="${pageContext.request.contextPath}/index/toCourse?number=1&size=9">
                                <button class="button button-glow button-rounded button-caution a_button">早教课程</button>
                            </a>
                            <a class="col-sm-4"
                               href="${pageContext.request.contextPath}/index/toTourism?state=1&number=1&size=4">
                                <button class="button button-glow button-rounded button-caution a_button">亲子旅游</button>
                            </a>
                        </div>
                        <span style="color: #ffffff;font-size: 1.5vw">关注微信公众号</span>
                        <br>
                        <img src="/resources/image/code.png" style="margin-top: 10px;width: 10vw">
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="section" id="section2" style="background-color: #2CB742">
        <table class="mid_table">
            <tr>
                <td>
                    <div style="display:flex;justify-content:center;align-items:center;">
                        <div class="col-sm-6  col-sm-offset-1">
                            <img class="td_img img-responsive" id="robot-left" src="/resources/image/robot_demo.jpg"
                                 style="width: 100vh">
                        </div>
                        <div class="introduction_div col-sm-6" id="robot-right">
                            <h2 style="font-size: 5vh">小豆智能儿童早教机器人</h2>
                            <span style="font-size: 3vh">陪伴、学习、交流、智能、健康、成长</span>
                            <br>
                            <span style="font-size: 3vh">为孩子量身打造</span>
                            <br>
                            <span style="font-size: 3vh">价格：<span
                                    style="font-size: 5vh;letter-spacing: 4px">3999元</span></span>
                            <br>
                            <button class="button button-glow button-rounded button-caution buy_button"
                                    onclick="gotoRobot()">查看详情
                            </button>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="section" id="section3" style="background-color: #EB9C37">
        <table class="mid_table">
            <tr>
                <td>
                    <div class="col-sm-12" style="display:flex;justify-content:center;align-items:center;">
                        <div class="introduction_div2 col-sm-6 col-sm-offset-1" id="course-right"
                             style="text-align: left">
                            <h2 style="font-size: 5vh">小豆宝盒、早教课程</h2>
                            <span style="font-size: 3vh">玩得更好、学得更好、一起成长</span>
                            <br>
                            <span style="font-size: 3vh">让孩子在快乐中学习知识</span>
                            <br>
                            <span style="font-size: 3vh">价格：<span
                                    style="font-size: 5vh;letter-spacing: 4px">3999元</span></span>
                            <br>
                            <button class="button button-glow button-rounded button-caution buy_button"
                                    onclick="gotoCourse()">查看详情
                            </button>
                        </div>
                        <div class="col-sm-6">
                            <img class="td_img2 img-responsive" id="course-left" src="/resources/image/course_demo.jpg"
                                 style="width: 80vh">
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="section" id="section4" style="background-color: #ED683F">
        <table class="mid_table">
            <tr>
                <td>
                    <div class="col-sm-12" style="display:flex;justify-content:center;align-items:center;">
                        <div class="col-sm-6  col-sm-offset-1">
                            <img class="td_img img-responsive" id="tourism-left"
                                 src="/resources/image/tourism_demo.jpg" style="width: 100vh">
                        </div>
                        <div class="introduction_div col-sm-6" id="tourism-right">
                            <h2 style="font-size: 5vh">亲子旅游</h2>
                            <span style="font-size: 3vh">家庭总动员、科技、冒险、探索</span>
                            <br>
                            <span style="font-size: 3vh">孩子的健康成长之旅</span>
                            <br>
                            <span style="font-size: 3vh">价格：<span
                                    style="font-size: 5vh;letter-spacing: 4px">3999元</span></span>
                            <br>
                            <button class=" button button-glow button-rounded button-caution buy_button"
                                    onclick="gotoTourism()">查看详情
                            </button>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <div class="col-sm-12"
             style="background-color:#285373;color: #939496;text-align: center;font-size: 0.7em;height: 30px;position: absolute;bottom: 0">
            <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
        </div>
    </div>
</div>
<div id="myAlert" class="alert alert-success" style="text-align: center">
    <img src="${pageContext.request.contextPath}/resources/image/alert.jpg"
         style="position:absolute;top:-90px;left: 20%;">
    <p style="margin-left: 90px;margin-right: 90px;color: #ffffff;text-align: center;display: inline-block">
        关注公共号，音频、故事<br>更多信息等着你！</p>
    <img src="/resources/image/code.png" style="height:100px">
    <a href="#" class="close" style="opacity: 1">&times;</a>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="/resources/js/jquery.fullpage.min.js"></script>

<script>
    var first = true;
    $(function () {
        $("#first_li").addClass("active");
        $('#section_main').fullpage({
            navigation: true,
            afterLoad: function (anchorLink, index) {
                if (first && index != 1) {
                    first = false;
                    $("#myAlert").animate({opacity: '1'}, "slow");
                }
                if (index == 1) {
                    $("#myAlert").animate({opacity: '0'}, "slow");
                    first = true;
                }
                switch (index) {
                    case 2:
                        $("#robot-left").animate({right: '0'}, "normal");
                        $("#robot-right").animate({opacity: '1'}, "normal");
                        break;
                    case 3:
                        $("#course-left").animate({left: '0'}, "normal");
                        $("#course-right").animate({opacity: '1'}, "normal");
                        break;
                    case 4:
                        $("#tourism-left").animate({right: '0'}, "normal");
                        $("#tourism-right").animate({opacity: '1'}, "normal");
                        break;
                }
            },
            onLeave: function (anchorLink, index) {
                switch (index) {
                    case 2:
                        $("#robot-left").css("right", "1000px");
                        $("#robot-right").css("opacity", "0");
                        break;
                    case 3:
                        $("#course-left").css("left", "1000px");
                        $("#course-right").css("opacity", "0");
                        break;
                    case 4:
                        $("#tourism-left").css("right", "1000px");
                        $("#tourism-right").css("opacity", "0");
                        break;
                }
            }
        });
        $("a.close").click(function () {
            $("#myAlert").animate({opacity: '0'}, "slow");
        })
    });

    function gotoRobot() {
        window.location.href = '${pageContext.request.contextPath}/index/toRobot';
    }
    function gotoCourse() {
        window.location.href = '${pageContext.request.contextPath}/index/toCourse?number=1&size=9';
    }
    function gotoTourism() {
        window.location.href = '${pageContext.request.contextPath}/index/toTourism?state=1&number=1&size=4';
    }
</script>
</body>
</html>

