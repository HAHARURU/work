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
    <title>小豆一家——支付</title>
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
        .error {
            color: red;
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
<%@include file="orderTop.jsp" %>
<div class="" style=" background-color: #ffffff;color: #CCCCCC;height: 53px;">
    <div class="container">
        <div class="col-sm-12">
            <nav class="navbar navbar-default" role="navigation"
                 style="background:  #ffffff;margin-bottom: 0">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/index/toIndex"><img src="/resources/image/logo.jpg"
                                                                                    class="img-responsive"
                                                                                    style="height: 53px;"></a>
                </div>
                <div class="col-sm-2">
                    <h3 style="color: #000000;">完成支付</h3>
                </div>
                <div class="col-sm-offset-6">
                    <div class="col-sm-offset-9">
                        <a href="${pageContext.request.contextPath}/index/toIndex" style="color: #2CB742;">返回首页<i
                                class="fa fa-angle-double-right"></i></a>
                    </div>
                    <div class="progress" style="margin-top: 10px">
                        <div class="progress-bar" role="progressbar" aria-valuenow="60"
                             aria-valuemin="0" aria-valuemax="100" style="width: 66%;background-color: #A4C540">
                        </div>
                    </div>
                    <div class="col-sm-12 step-box">
                        <div class="col-sm-4 active-step"><em>1</em><br/><label>购物车</label></div>
                        <div class="col-sm-4 active-step"><em>2</em><br/><label>核对信息</label></div>
                        <div class="col-sm-4"><em>3</em><br/><label>完成支付</label></div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <span>
                订单提交成功，请尽快支付！订单号：<strong>${requestInfo.get('orderId')}</strong><br>
                请您在24小时内完成支付，否则订单会自动取消。
            </span>
            <a href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0" class="pull-right"
               style="color: #A4C540;">
                我的订单<i class="fa fa-angle-double-right"></i>
            </a>
            <div class="col-sm-12 hidden" id="pay-div"
                 style="border: 1px solid #A4C540;border-radius: 0.4em;margin-top: 20px;padding-top: 7vh;padding-bottom: 7vh;display:flex;justify-content:center;align-items:center;">
                <div class="col-sm-4" style="text-align: center">
                    <img src="/resources/image/iphone.jpg" class="img-responsive" style="display: inline-block"/>
                </div>
                <div class="col-sm-4" style="text-align: center;">
                    <div id="qrCode-div"></div>
                    <br>
                    <c:if test="${requestInfo.get('payTypeCode')==21}">
                        <strong>微信</strong>
                    </c:if>
                    <c:if test="${requestInfo.get('payTypeCode')==22}">
                        <strong>支付宝</strong>
                    </c:if>
                </div>
                <div class="col-sm-4" style="text-align: center;">
                    <strong>应付的金额：</strong><br>
                    <strong style="color: red;font-size: 2.4vw">￥${(order.totalFee+order.expressFee)/100}</strong>
                </div>
            </div>
            <div id="success-div" class="col-sm-12"
                 style="border: 1px solid #A4C540;border-radius: 0.4em;padding-top: 10px;padding-bottom: 10px;height: 300px;margin-top: 20px;text-align: center">
                <h2 class="text-color">支付成功</h2>
                <span id="time" style="color: #000000;">5</span> 秒后跳转到首页...
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-keyboard="false" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: #2CB742;">
                <i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i>
                <p>正在支付</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script src="/resources/js/jquery.qrcode.js"></script>
<script src="/resources/js/qrcode.js"></script>

<script>
    $(document).ready(function () {
        $(".progress-bar").animate({width: '100%'}, "fast");
        $($(".step-box").find("div")[2]).addClass("active-step");
        var f =${finish};
        if (f == 1) {
            setTimeout(changeTime, 1000);
        } else {
            $("#pay-div").removeClass("hidden");
            $("#success-div").addClass("hidden");
            setInterval(function () {
                var pi = {
                    sign: '${requestInfo.get('sign')}',
                    mallCode: '${requestInfo.get('mallCode')}',
                    posCode: '${requestInfo.get('posCode')}',
                    orderId: '${requestInfo.get('orderId')}'
                };
                $.ajax({
                    url: "https://pay.tangchaogouwu.com/java/rest/payment/trade/payresult",
                    data: JSON.stringify(pi),
                    type: "POST",
                    contentType: 'application/json;charset=utf-8',
                    success: function (info) {
                        if (info.data.payStatus == 1) {
                            $("#pay-div").addClass("hidden");
                            $("#success-div").removeClass("hidden");
                            setTimeout(changeTime, 1000);
                        }
                    }

                });
            }, 1000);
            $("#qrCode-div").qrcode({
                width: 164,
                height: 164,
                text: '${requestInfo.get("qrCodeUrl")}'
            });
            $("table").css("margin-left", "auto");
            $("table").css("margin-right", "auto");
        }
    });

    function changeTime() {
        var time = parseInt($("span#time").text());
        time--;
        if (time <= 0) {
            window.location.href = '${pageContext.request.contextPath}/login/toFinishPay';
        } else {
            $("span#time").text(time);
            setTimeout(changeTime, 1000);
        }
    }

</script>
</body>
</html>

