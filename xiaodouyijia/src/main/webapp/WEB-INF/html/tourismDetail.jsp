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

        .row {
            margin-top: 0;
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
<div class="container" id="introduction">
    <div class="row">
        <div class="col-sm-12">
            <div class="media" style="display:flex;justify-content:center;align-items:center;">
                <div class="pull-left" style="margin-right: 20px">
                    <img class="media-object" src="${tourismDetail.img}">
                </div>
                <div class="media-body">
                    <label style="font-size: 1.1em">${tourismDetail.pName}</label>
                    <br>
                    <label class="tourism-color" id="priceLabel" style="font-size: 1.2em"></label>
                    <br>
                    <label class="tourism-color">产品特色：</label><span>${tourismDetail.tbSysProductFun.pPre}</span><br>
                    <label class="tourism-color">活动时间：</label><span><fmt:formatDate value="${tourismDetail.startTime}" type="date"
                                                                                    pattern="yyyy-MM-dd"/></span><br>
                    <label class="tourism-color">参加条件：</label><span>${tourismDetail.tbSysProductFun.pJoin}</span><br>
                    <label class="tourism-color">注意事项：</label><span></span>${tourismDetail.buyNotice}<br>
                    <label class="tourism-color">活动详情：</label><span id="fix-span"
                                                                    style="">${tourismDetail.tbSysProductFun.pFunStr}</span><br>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="fix-div">
    <div class="row">
        <div class="col-sm-12">
            <div style="height: 84px;background-color: #ffffff">
                <form id="fix-form" method="get" class="form-horizontal" style="border: 2px solid #ED683F;"
                      action="${pageContext.request.contextPath}/login/toBuy">
                    <select class="form-control select select-danger select-block mbl margin-right-i" id="adult-select"
                            style="margin-left: 10px;" onchange="return selectAdult()" name="mount">
                        <option value="0">成人</option>
                        <option value="1">1位</option>
                        <option value="2">2位</option>
                        <option value="3">3位</option>
                        <option value="4">4位</option>
                    </select>
                    <select class="form-control select select-danger select-block mbl margin-right-i"
                            id="children-select"
                            style="margin-left: 10px;" onchange="return selectChildren()" name="mount2">
                        <option value="0">豆宝</option>
                        <option value="1">1位</option>
                        <option value="2">2位</option>
                        <option value="3">3位</option>
                        <option value="4">4位</option>
                    </select>
                    <label>总价：</label><label id="price-label" class="margin-right-i" style="color: #ED683F;">——</label>
                    <div class="pull-right">
                        <input type="hidden" id="id-input" name="pid" value="${tourismDetail.pId}">
                        <input type="submit" id="buy-button"
                               class="button button-glow button-rounded button-caution buy_button order-button-t margin-right-i"
                               value="购买" disabled="disabled">
                        <button id="shopCar-button" onclick="addShopCar()" type="button"
                                class="button button-glow button-rounded button-caution buy_button order-button-t margin-right-i"
                                disabled="disabled">
                            加入购物车
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container" id="detail-div">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-12">
                <div class="col-sm-2">
                    <label class="flag-label">
                        <i class="fa fa-flag fa-2x"></i><br>
                        <span>活动特色</span>
                    </label>
                </div>
                <div class="col-sm-10">
                    <img src="${tourismDetail.img1}" class="img-responsive">
                </div>
            </div>
            <div class="col-sm-12" style="margin-top: 30px">
                <div class="col-sm-2">
                    <label class="flag-label">
                        <i class="fa fa-flag fa-2x"></i><br>
                        <span>行程介绍</span>
                    </label>
                </div>
                <div class="col-sm-10">
                    <img src="${tourismDetail.img2}" class="img-responsive">
                </div>
            </div>
            <div class="col-sm-12" style="margin-top: 30px">
                <div class="col-sm-2">
                    <label class="flag-label">
                        <i class="fa fa-flag fa-2x"></i><br>
                        <span>费用介绍</span>
                    </label>
                </div>
                <div class="col-sm-10">
                    <img src="${tourismDetail.img3}" class="img-responsive">
                </div>
            </div>
        </div>
    </div>
</div>
<div class="col-sm-12"
     style="background-color:#ED683F;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
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
    var fix = false;
    var down = 6;
    var up = 458;
    var adultPrice;
    var childrenPrice;
    $(function () {
        $("#adult-select").val(0);
        $("#children-select").val(0);

        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $("#second_li").addClass("active");
        $("#tourism-li").addClass("active");
        adultPrice =${tourismDetail.pPrice/100.0};
        childrenPrice =${tourismDetail.pPriceBoy/100.0};
        $("#priceLabel").html("￥" + adultPrice + "/成人，￥" + childrenPrice + "/儿童");
    });
    function selectAdult() {
        var $as = $("#adult-select");
        if ($as.val() == 0) {
            $("#price-label").html("——");
            $("#price-input").val(0);
            $("#buy-button").attr("disabled", "disabled");
            $("#shopCar-button").attr("disabled", "disabled");
        } else {
            if ($("#children-select").val() != 0) {
                var priceAll = adultPrice * $as.val() + childrenPrice * $("#children-select").val();
                $("#price-label").html(priceAll);
                $("#price-input").val(priceAll);
                $("#buy-button").attr("disabled", false);
                $("#shopCar-button").attr("disabled", false);
            }
        }
        return false;
    }

    function addShopCar() {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/addShopCarAjax?mount="+ $("#adult-select").val() + "&mount2=" + $("#children-select").val() + "&pid=${tourismDetail.pId}",
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            beforeSend: function () {
                $("#sign_hidden").modal("show");
            },
            success: function (data) {
                if (data == 1) {
                    $("#sign_hidden").modal("hide");
                    $("#myModal2").modal("show");
                }else{
                    window.location.href = '${pageContext.request.contextPath}/index/toLogin?url=toTourismDetail?tid=${tourismDetail.pId}';
                }
            }
        });
    }

    function selectChildren() {
        var $cs = $("#children-select");
        if ($cs.val() == 0) {
            $("#price-label").html("——");
            $("#price-input").val(0);
            $("#buy-button").attr("disabled", "disabled");
            $("#shopCar-button").attr("disabled", "disabled");
        } else {
            if ($("#adult-select").val() != 0) {
                var priceAll = adultPrice * $cs.val() + childrenPrice * $("#children-select").val();
                $("#price-label").html(priceAll);
                $("#price-input").val(priceAll);
                $("#buy-button").attr("disabled", false);
                $("#shopCar-button").attr("disabled", false);
            }
        }
        return false;
    }
    window.onscroll = function () {
        var td = document.getElementById("introduction");
        var h = td.offsetHeight;
        var result = $(window).scrollTop() - ($('#introduction')[0].offsetTop + h);
//        console.log(result);
        if (result >= 0 && !fix) {
            $("#fix-div").addClass("navbar-fixed-top");
            $("#fix-form").css("box-shadow", "1px 1px 2px 2px #bbbbbb");
            $("#detail-div").css("margin-top", "124px");
            fix = true;
        } else {
            if (result <= 0) {
                $("#fix-div").removeClass("navbar-fixed-top");
                $("#fix-form").css("box-shadow", "none");
                $("#detail-div").css("margin-top", "0");
                fix = false;
            }
        }
    };
</script>
</body>
</html>

