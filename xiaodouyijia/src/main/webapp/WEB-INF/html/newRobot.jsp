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
    <title>小豆一家——智能小豆</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/flat-ui.css">
    <link rel="stylesheet" href="/resources/css/jquery.fullpage.css">
    <link rel="stylesheet" href="/resources/css/buttons.css">
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/main2.css">

    <script src="/resources/js/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="newTop.jsp" %>
<div style="height: 400px; width:100%;background-color: #2CB742;display:flex;justify-content:center;align-items:center;">
    <table class="mid_table">
        <tr>
            <td>
                <div style="display:flex;justify-content:center;align-items:center;">
                    <div class="col-sm-5 col-sm-offset-1">
                        <img class="img-responsive" id="robot-left" src="/resources/image/robot_demo.jpg">
                    </div>
                    <div class="introduction_div col-sm-5" id="robot-right" style="opacity: 1">
                        <h2>第一代健康智能机器人</h2>
                        <span>安全放心、智能学习、安全放心、智能学习</span>
                        <br>
                        <span>提升孩子想象力、创造力、开拓力</span>
                        <br>
                        <span>我们把快乐带回家</span>
                        <br>
                        <span>￥<span style="font-size: 1.9em;letter-spacing: 4px">3999</span></span>
                        <br>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
<div class="container" id="fix-top" style="height: 82px;background-color: #ffffff">
    <div style="height: 65px;">
        <form id="fix-form" method="get" class="form-horizontal form-no-top"
              action="${pageContext.request.contextPath}/login/toBuy">
            <select class="form-control select select-success select-block mbl margin-right-i" id="sex-select"
                    style="margin-left: 10px;background-color:#2CB742;" onchange="return selectSex()">
                <option value="-1">选择款式</option>
                <option value="男生版">男生版</option>
                <option value="女生版">女生版</option>
            </select>
            <label>数量:</label>
            <div class="mount-div margin-right-i">
                <button class="button button-circle button-tiny" style="background-color:#2CB742;color: #ffffff;"
                        id="plus-button" onclick="return plus()" disabled="disabled"><i class="fa fa-plus"></i></button>
                <label class="mount-label" style="color: #2CB742;" id="mount-label">1</label>
                <button class="button button-circle button-tiny" style="background-color:#2CB742;color: #ffffff;"
                        disabled="disabled" id="minus-button" onclick="return minus()"><i class="fa fa-minus"></i>
                </button>
            </div>
            <label>总价：</label><label id="price-label" class="margin-right-i" style="color: #2CB742;">——</label>
            <div class="pull-right">
                <input type="hidden" id="mount-input" name="mount" value="1">
                <input type="hidden" id="id-input" name="pid" value="0">
                <input type="submit" id="buy-button"
                       class="button button-glow button-rounded button-caution buy_button order-button margin-right-i"
                       value="购买" disabled="disabled">
                <button id="shopCar-button" onclick="addShopCar()" type="button"
                        class="button button-glow button-rounded button-caution buy_button order-button margin-right-i"
                        disabled="disabled">
                    加入购物车
                </button>
            </div>
        </form>
    </div>
</div>
<div class="container" style="margin-top: 40px;" id="introduction">
    <%--<div class="col-sm-10 col-sm-offset-1">
        <img src="/resources/image/robot_detail.jpg" class=" img-responsive" style="width: 100%">
    </div>--%>
    <div class="top-introduction">
        <div style="text-align: center">
            <h2 style="color: #2CB742;">贴心功能</h2>
            <span>快乐你我他、妈妈育儿的好帮手</span>
        </div>
        <div class="col-sm-12" style="display:flex;justify-content:center;align-items:center;">
            <div class="left-introduction col-sm-4">
                <div class="margin-bottom-div col-sm-12"
                     style="display:flex;justify-content:center;align-items:center;">
                    <p class="col-sm-10">wsad scsac sc 时时彩是城市刹车。阿萨是初三，啊擦爱上，是单纯从市场市场市场，谁才是，按时参数，撒擦拭，爱上初三，三，三大城市的，，刹车</p>
                    <span class="badge col-sm-1">1</span>
                </div>
                <div class="col-sm-12" style="display:flex;justify-content:center;align-items:center;">
                    <p class="col-sm-10">wsad scsac sc 时时彩是城市刹车。阿萨是初三，啊擦爱上，是单纯从市场市场市场，谁才是，按时参数，撒擦拭，爱上初三，三，三大城市的，，刹车</p>
                    <span class="badge col-sm-1">3</span>
                </div>
            </div>
            <div class="col-sm-4" style="text-align: center;">
                <img src="/resources/image/robot.jpg" style="">
            </div>
            <div class="right-introduction col-sm-4">
                <div class="margin-bottom-div col-sm-12"
                     style="display:flex;justify-content:center;align-items:center;">
                    <span class="badge col-sm-1">2</span>
                    <p class="col-sm-10">wsad scsac sc 时时彩是城市刹车。阿萨是初三，啊擦爱上，是单纯从市场市场市场，谁才是，按时参数，撒擦拭，爱上初三，三，三大城市的，，刹车</p>
                </div>
                <div class="col-sm-12" style="display:flex;justify-content:center;align-items:center;">
                    <span class="badge col-sm-1">4</span>
                    <p class="col-sm-10">wsad scsac sc 时时彩是城市刹车。阿萨是初三，啊擦爱上，是单纯从市场市场市场，谁才是，按时参数，撒擦拭，爱上初三，三，三大城市的，，刹车</p>
                </div>
            </div>
        </div>
    </div>
    <div class="introduction-title col-sm-12">
        <div class="col-sm-6">
            <h2>成长陪伴</h2>
            <span>全方位陪伴设计，让孩子时刻感受到爱</span>
        </div>
        <div class="col-sm-6">
            <div class="row" style="margin-top: 0;margin-bottom: 0">
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-microphone fa-3x border-icon"></i>
                    <p>语音互动</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-users fa-3x border-icon"></i>
                    <p>远程陪伴</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-comment fa-3x border-icon"></i>
                    <p>主动交流</p>
                </div>
            </div>
        </div>
    </div>
    <img src="/resources/image/accompany.jpg" class="img-responsive">
    <div class="introduction-title col-sm-12">
        <div class="col-sm-6">
            <h2>成长教育</h2>
            <span>全新教育理念，早教育儿两手抓</span>
        </div>
        <div class="col-sm-6">
            <div class="row" style="margin-top: 0;margin-bottom: 0">
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-video-camera fa-3x border-icon"></i>
                    <p>早教视频</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-mortar-board fa-3x border-icon"></i>
                    <p>知识库</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-gratipay fa-3x border-icon"></i>
                    <p>贴心推荐</p>
                </div>
            </div>
        </div>
    </div>
    <img src="/resources/image/education.jpg" class="img-responsive">
    <div class="introduction-title col-sm-12">
        <div class="col-sm-6">
            <h2>成长记录</h2>
            <span>记录宝宝每个珍贵的成长瞬间</span>
        </div>
        <div class="col-sm-6">
            <div class="row" style="margin-top: 0;margin-bottom: 0">
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-signal fa-3x border-icon"></i>
                    <p>成长记录</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-mortar-board fa-3x border-icon"></i>
                    <p>知识库</p>
                </div>
                <div class="col-sm-4 div-horizontal">
                    <p></p>
                    <i class="fa fa-puzzle-piece fa-3x border-icon"></i>
                    <p>智力游戏</p>
                </div>
            </div>
        </div>
    </div>
    <img src="/resources/image/record.jpg" class="img-responsive">
</div>
<div class="col-sm-12"
     style="background-color:#2CB742;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
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
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>

<script>
    var mount = 1;
    var price_All = 0;
    var stock = 0;
    var robotId = 0;
    $(function () {
        $("#sex-select").val(-1);
        $("#mount-input").val(1);
        $("#id-input").val(0);

        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $("#second_li").addClass("active");
        $("#robot-li").addClass("active");
    });
    window.onscroll = function () {
        var t = document.documentElement.scrollTop || document.body.scrollTop;
        if (t > 483) {
            $("#fix-top").addClass("navbar-fixed-top");
            $("#fix-form").css("box-shadow", "1px 1px 2px 2px #bbbbbb");
            $("#introduction").css("margin-top", "120px");
        } else {
            $("#fix-top").removeClass("navbar-fixed-top");
            $("#fix-form").css("box-shadow", "none");
            $("#introduction").css("margin-top", "40px");
        }
    };
    function selectSex() {
        var $ss = $("#sex-select");
        if ($ss.val() == -1) {
            price_All = 0;
            stock = 0;
            mount = 1;
            robotId = 0;
            $("#id-input").val(0);
            $(".mount-label").html(0);
            $("#mount-input").val(0);
            $("#price-label").html("——");
            $("#plus-button").attr("disabled", "disabled");
            $("#minus-button").attr("disabled", "disabled");
            $("#buy-button").attr("disabled", "disabled");
            $("#shopCar-button").attr("disabled", "disabled");
        } else {
            $("#plus-button").attr("disabled", false);
            <c:forEach items="${robotDemoList}" var="rl">
            var sex = '${rl.pSex}';
            if (sex == $ss.val()) {
                price_All = ${rl.pPrice / 100.0};
                robotId = ${rl.pId};
                $("#id-input").val(robotId);
            }
            </c:forEach>
            <c:forEach items="${robotStockMap}" var="rsm">
            var rsex = '${rsm.key}';
            if (rsex == robotId) {
                stock = ${rsm.value};
            }
            </c:forEach>
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
            var allPrice = price_All * mount;
            $("#price-label").html(allPrice);
        }
        return false;
    }

    function addShopCar() {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/addShopCarAjax?mount=" + $("#mount-input").val() + "&pid=" + robotId,
            type: "POST",
            beforeSend: function () {
                $("#sign_hidden").modal("show");
            },
            success: function (data) {
                if (data == 1) {
                    $("#sign_hidden").modal("hide");
                    $("#myModal2").modal("show");
                    return false;
                } else {
                    window.location.href = '${pageContext.request.contextPath}/index/toLogin?url=/index/toRobot';
                }
            }
        });
        return false;
    }

    function plus() {
        mount = $(".mount-label").html() * 1;
        mount++;
        $("#minus-button").attr("disabled", false);
        $(".mount-label").html(mount);
        $("#mount-input").val(mount);
        if ($("#sex-select").val() != -1) {
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
        if ($("#sex-select").val() != -1) {
            $("#price-label").html(price_All * mount);
        }
        if (mount <= 1) {
            $("#minus-button").attr("disabled", "disabled");
        }
        return false;
    }
</script>
</body>
</html>

