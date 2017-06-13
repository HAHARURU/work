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
    <title>小豆一家——核对信息</title>
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
                    <h3 style="color: #000000;">核对信息</h3>
                </div>
                <div class="col-sm-offset-6">
                    <div class="col-sm-offset-9">
                        <a href="${pageContext.request.contextPath}/index/toIndex" style="color: #2CB742;">返回首页<i
                                class="fa fa-angle-double-right"></i></a>
                    </div>
                    <div class="progress" style="margin-top: 10px">
                        <div class="progress-bar" role="progressbar" aria-valuenow="60"
                             aria-valuemin="0" aria-valuemax="100" style="width: 33%;background-color: #A4C540">
                        </div>
                    </div>
                    <div class="col-sm-12 step-box">
                        <div class="col-sm-4 active-step"><em>1</em><br/><label>购物车</label></div>
                        <div class="col-sm-4"><em>2</em><br/><label>核对信息</label></div>
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
            <form id="check-form" role="form" method="post" action="${pageContext.request.contextPath}/login/toPay">
                <section class="check-section col-sm-12">
                    <h3>核对订单信息</h3>
                    <div class="col-sm-12 check-div addressDiv">
                        <header>
                            <label style="font-weight: 600">收货人信息</label>
                            <div class="pull-right">
                                <button type="button" class="btn btn-default" style="background-color: #A4C540;"
                                        onclick="editInfo()">修改地址
                                </button>
                                <button type="button" class="btn btn-default" style="background-color: #A4C540;"
                                        onclick="addInfo()">添加地址
                                </button>
                            </div>
                            <div id="address-part">
                                <c:if test="${addressList.size()>0}">
                                    <label class="radio default" for="radio0">
                                        <input type="radio" name="optionsRadios1" value="${addressList.get(0).id}"
                                               id="radio0"
                                               data-toggle="radio" checked="checked">
                                            ${addressList.get(0).receivedPerson}
                                        <span class="input-radio">${addressList.get(0).receivedPerson} ${addressList.get(0).proName}${addressList.get(0).cityName}${addressList.get(0).areaName} ${addressList.get(0).address} ${addressList.get(0).receivedPersonPhone}</span>
                                        <input type="hidden" class="aIndex" value="0">
                                    </label>
                                </c:if>
                                <a href="javascript:showMore()" id="showMore">查看更多<i
                                        class="fa fa-angle-double-down"></i></a>
                                <div class="hidden-div hidden">
                                    <c:forEach items="${addressList}" var="al" varStatus="vs" begin="1">
                                        <label class="radio" for="radio${vs.index}">
                                            <input type="radio" name="optionsRadios1" value="${al.id}"
                                                   id="radio${vs.index}"
                                                   data-toggle="radio">
                                                ${al.receivedPerson}
                                            <span class="input-radio">${al.receivedPerson} ${al.proName}${al.cityName}${al.areaName} ${al.area} ${al.receivedPersonPhone}</span>
                                            <input type="hidden" class="aIndex" value="${vs.index}">
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>
                        </header>
                    </div>
                    <h3>支付方式</h3>
                    <div class="col-sm-12 check-div">
                        <a class="pay-a col-sm-2" href="javascript:selectPayMethod(2)">支付宝</a>
                        <a class="pay-a col-sm-2" href="javascript:selectPayMethod(3)">微信</a>
                        <%--<a class="col-sm-2" href="javascript:showA()" id="showA">更多<i
                                class="fa fa-angle-double-right"></i></a>
                        <a class=" hidden hidden-a pay-a col-sm-2" href="javascript:selectPayMethod(4)">货到付款</a>
                        <a class=" hidden hidden-a pay-a col-sm-2" href="javascript:selectPayMethod(5)">货到付款</a>
                        <a class=" hidden hidden-a pay-a col-sm-2" href="javascript:selectPayMethod(6)">货到付款</a>--%>
                    </div>
                    <h3>商品清单</h3>
                    <div class="col-sm-12 check-div item-div">
                        <div class="table-responsive" style="border: 1px solid #D5E1D3;border-radius: 0.4em">
                            <table class="table table-hover" id="table-shopCar" style="width: 1070px">
                                <tbody>
                                <c:forEach items="${orderList}" var="scl" varStatus="vs">
                                    <tr>
                                        <td style="width: 300px">
                                            <div class="media">
                                                <img class="media-object pull-left" src="${scl.img}"
                                                     style="width: 60px">
                                                <div class="media-body">
                                                        ${scl.pName}
                                                </div>
                                            </div>
                                        </td>
                                        <c:if test="${scl.cPrice==null}">
                                            <td style="color: #D5E1D3;">
                                                ￥${scl.pPrice/100}
                                            </td>
                                        </c:if>
                                        <c:if test="${scl.cPrice!=null}">
                                            <td style="color: #D5E1D3;">
                                                ￥${scl.pPrice/100}/成人，￥${scl.cPrice/100}/儿童
                                            </td>
                                        </c:if>
                                        <td>
                                            <div class="mount-div">
                                                <c:if test="${scl.cPrice==null}">
                                                    <label class="mount-label" style="color: #2CB742;"
                                                           id="mount-label">X${scl.num}</label>
                                                </c:if>
                                                <c:if test="${scl.cPrice!=null}">
                                                    <label class="mount-label" style="color: #2CB742;"
                                                           id="mount-label">${scl.largMenNum}/成人，${scl.smallMenNum}/儿童</label>
                                                </c:if>
                                            </div>
                                        </td>
                                        <td>
                                            <c:if test="${scl.cPrice==null}">
                                                <label class="labelAll">￥${scl.pPrice*scl.num/100}</label>
                                            </c:if>
                                            <c:if test="${scl.cPrice!=null}">
                                                <label class="labelAll">￥${scl.pPrice*scl.largMenNum/100}/成人，￥${scl.cPrice*scl.smallMenNum/100}/儿童</label>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12 check-div price-div">
                        <div class="col-sm-12">
                            <span>优惠券抵用<label id="c_label" style="color: red;"></label></span>
                            <span>豆值抵用<label id="p_label" style="color: red;"></label></span>
                            <span>邀请码抵用<label id="i_label" style="color: red;"></label></span>
                            <span>合计<label id="sumTotal" style="color: red;"></label></span>
                            <span class="pull-right">应付金额：<label id="totalPrice"
                                                                 style="color: red;font-size: 1.2em"></label></span>
                            <br>
                        </div>
                        <div class="pull-right" style="text-align: right">
                            <c:if test="${addressList.size()>0}">
                            <span>
                                 <label>寄送至</label>
                                <span id="area-label">${addressList.get(0).proName}${addressList.get(0).cityName}${addressList.get(0).areaName}</span>
                                <span id="detail-label">${addressList.get(0).address}</span>
                                <label>收货人：</label><span
                                    id="consignee-label">${addressList.get(0).receivedPerson}</span>
                                <span id="phone-label">${addressList.get(0).receivedPersonPhone}</span>
                            </span>
                            </c:if>
                            <br>
                            <input type="hidden" id="totalPrice_input" name=totalPrice value="0">
                            <input type="hidden" id="payMethodId" name=payMethodId value="0">
                            <input type="hidden" id="addressId" name=addressId value="${addressList.get(0).addressId}">
                            <button type="submit" class="btn btn-danger" disabled="disabled" id="submitForm">提交订单
                            </button>
                        </div>
                    </div>
                </section>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12" style="padding-left: 0;padding-right: 0">
            <div class="modal-header col-sm-12" style="background-color: #A4C540;color: #000;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="modalLabel">收货地址</h4>
            </div>
            <div class="modal-body col-sm-12">
                <form class="form-horizontal col-sm-12" role="form" id="update_form">
                    <div class="form-group">
                        <label for="consignee" class="col-sm-3 control-label">收货人：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="consignee" name="receivedPerson">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="province" class="col-sm-3 control-label">所在地区：</label>
                        <div class="col-sm-9">
                            <div class="col-sm-4">
                                <select class="form-control select select-default select-block mbl margin-right-i"
                                        id="province" name="province" onchange="changeCity()">
                                    <option value="-1">请选择</option>
                                    <c:forEach items="${provinces}" var="p">
                                        <option value="${p.code}">${p.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <select class="form-control select select-default select-block mbl margin-right-i"
                                        id="city" name="city" onchange="changeArea()">
                                    <option value="-1">请选择</option>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <select class="form-control select select-default select-block mbl margin-right-i"
                                        id="area" name="area">
                                    <option value="-1">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addressDetail" class="col-sm-3 control-label">详细地址：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="addressDetail" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-3 control-label">手机：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="phone" name="receivedPersonPhone">
                        </div>
                    </div>
                    <div class="col-sm-6 col-sm-offset-3">
                        <div class="form-group pull-left">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-default" data-dismiss="modal"
                                        style="background-color: #A4C540;">
                                    取消
                                </button>
                            </div>
                        </div>
                        <div class="form-group pull-right">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-default" style="background-color: #A4C540;"
                                        onclick="return checkFormInfo()">
                                    提交
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-keyboard="false" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: #2CB742;">
                <i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i>
                <p>正在提交</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>

<script>
    var aIndex = -1;
    var aid = -1;
    var ps = 0;
    var show = false;
    var t = -1;
    var receivedPerson = "";
    var province = "";
    var city = "";
    var area = "";
    var address = "";
    var pid = 0;
    var cid = 0;
    var arid = 0;
    var receivedPersonPhone = "";
    $(document).ready(function () {
        $(':radio').radiocheck();
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $(".progress-bar").animate({width: '66%'}, "fast");
        $($(".step-box").find("div")[1]).addClass("active-step");
        $(":radio").change(function () {
            var ix = $(this).siblings(".aIndex").val() * 1;
            aid = ix;
            aIndex = $(this).val() * 1;
            <c:forEach items="${addressList}" var="al" varStatus="vs">
            var id =${vs.index};
            if (id == aid) {
                t = ${al.addressId};
                receivedPerson = '${al.receivedPerson}';
                province = '${al.proName}';
                pid = ${al.province};
                city = '${al.cityName}';
                cid = ${al.city};
                area = '${al.areaName}';
                aid = ${al.area};
                address = '${al.address}';
                receivedPersonPhone = ${al.receivedPersonPhone};
                $("#area-label").html('${al.proName}${al.cityName}${al.areaName}');
                $("#detail-label").html('${al.address}');
                $("#consignee-label").html('${al.receivedPerson}');
                $("#phone-label").html('${al.receivedPersonPhone}');
                $("#addressId").val(t);
            }
            </c:forEach>
        });
        var cv = 0;
        <c:if test="${coupon!=null}">
        cv =${coupon.discountpageVal/100};
        </c:if>
        var pv = 0;
        <c:if test="${point!=null&&point!=''}">
        pv = ${point/100};
        </c:if>
        var iv = 0;
        <c:if test="${invitation!=null&&invitation!=''}" >
        iv = 10;
        </c:if>
        $("#c_label").html('￥' + cv);
        $("#p_label").html('￥' + pv);
        $("#i_label").html('￥' + iv);
        $("#sumTotal").html('￥' + (cv + pv + iv));
        var tv =${order.totalFee/100};
        var ev =${order.expressFee/100};
        var tp = tv + ev - cv - pv - iv;
        var tpi = tv - cv - pv - iv;
        $("#totalPrice").html('￥' + tp.toFixed(2) + '（￥' + ev + '运费）');
        $("#totalPrice_input").val(tpi.toFixed(2) * 100);
    });
    function showMore() {
        $("#showMore").addClass("hidden");
        $(".hidden-div").removeClass("hidden");
        show = true;
    }

    function showA() {
        $("#showA").addClass("hidden");
        $(".hidden-a").removeClass("hidden");
    }

    function selectPayMethod(pmid) {
        ps = pmid;
        if ($(".default").size() > 0) {
            $("#submitForm").attr("disabled", false);
        }
        var aa = $(".pay-a")[pmid - 2];
        $(".pay-a").removeClass("active-pay");
        $(aa).addClass("active-pay");
        $("#payMethodId").val(ps);
    }

    function addInfo() {
        aid = -1;
        $("#consignee").val("");
        $("#select2-chosen-1").html("请选择");
        $("#province").val("请选择");
        $("#select2-chosen-2").html("请选择");
        $("#select2-chosen-3").html("请选择");
        $("#addressDetail").val("");
        $("#phone").val("");
        $('#myModal').modal('show');
    }
    function editInfo() {
        if (aid != -1) {
            $('#myModal').modal('show');
        }
    }
    $('#myModal').on('show.bs.modal', function () {
        if (aid != -1) {
            $("#update_form").append('<input type="hidden" id="id" name="aid" value="' + t + '">');
            $("#consignee").val(receivedPerson);
            $("#select2-chosen-1").html(province);
            $("#province").val(pid);
            $.ajax({
                url: "${pageContext.request.contextPath}/login/getCityAjax?pCode=" + pid,
                type: "GET",
                async: false,
                success: function (data) {
                    $.each(data, function (index, cl) {
                        $("#city").append("<option value='" + cl.code + "'>" + cl.name + "</option>");
                    })
                }
            });
            $("#select2-chosen-2").html(city);
            $("#city").val(cid);
            $.ajax({
                url: "${pageContext.request.contextPath}/login/getAreaAjax?cCode=" + cid,
                type: "GET",
                async: false,
                success: function (data) {
                    $.each(data, function (index, al) {
                        $("#area").append("<option value='" + al.code + "'>" + al.name + "</option>");
                    })
                }
            });
            $("#select2-chosen-3").html(area);
            $("#area").val(aid);
            $("#addressDetail").val(address);
            $("#phone").val(receivedPersonPhone);
        }
    });
    function changeCity() {
        var $p = $("#province");
        var pv = $p.val();
        $("#area").empty();
        $("#area").append('<option value="-1">请选择</option>');
        $("#city").empty();
        $("#city").append('<option value="-1">请选择</option>');
        $("#select2-chosen-2").html("请选择");
        $("#select2-chosen-3").html("请选择");
        if (pv != -1) {
            $.ajax({
                url: "${pageContext.request.contextPath}/login/getCityAjax?pCode=" + pv,
                type: "GET",
                success: function (data) {
                    $.each(data, function (index, cl) {
                        $("#city").append("<option value='" + cl.code + "'>" + cl.name + "</option>");
                    })
                }
            })
        }
    }
    function changeArea() {
        var $c = $("#city");
        var cv = $c.val();
        $("#area").empty();
        $("#area").append('<option value="-1">请选择</option>');
        $("#select2-chosen-3").html("请选择");
        if (cv != -1) {
            $.ajax({
                url: "${pageContext.request.contextPath}/login/getAreaAjax?cCode=" + cv,
                type: "GET",
                success: function (data) {
                    $.each(data, function (index, al) {
                        $("#area").append("<option value='" + al.code + "'>" + al.name + "</option>");
                    })
                }
            })
        }
    }

    function checkMobile(s) {
        var regu = /^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\d{8}$/;
        var re = new RegExp(regu);
        if (re.test(s)) {
            return true;
        } else {
            return false;
        }
    }

    function checkFormInfo() {
        if ($("#consignee").val() == "" || $("#province").val() == -1 || $("#city").val() == -1 || $("#area").val() == -1 || $("#addressDetail").val() == -1 || $("#phone").val() == "") {
            alert("请将信息填写完整！");
            return false;
        }
        else {
            if (!checkMobile($("#phone").val().toString())) {
                alert("手机格式不正确！");
                return false;
            }
            var pi = {
                        aid: aid,
                        receivedPerson: $("#consignee").val(),
                        province: $("#province").val(),
                        city: $("#city").val(),
                        area: $("#area").val(),
                        address: $("#addressDetail").val(),
                        receivedPersonPhone: $("#phone").val()
                    }
                    ;
            $.ajax({
                url: "${pageContext.request.contextPath}/login/addEditAddressAjax",
                data: JSON.stringify(pi),
                type: "POST",
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    refreshList(data);
                }
            });
            $('#myModal').modal('hide');
            return false;
        }
    }

    function refreshList(data) {
        $("#address-part").html("");
        var al = data[0];
        var html = '<label class="radio" for="radio0">' +//
                '<input type="radio" name="optionsRadios1" value="' + al.id + '"' +//
                'id="radio0" data-toggle="radio" checked="checked">' +//
                al.receivedPerson +//
                '<span class="input-radio">' + al.receivedPerson + ' ' + al.proName + al.cityName + al.areaName + ' ' + al.address + ' ' + al.receivedPersonPhone + '</span>' +//
                '<input type="hidden" class="aIndex" value="0">' +//
                '</label>';
        $("#address-part").append(html);
        $("#addressId").val(al.addressId);
        $("#address-part").append('<a href="javascript:showMore()" id="showMore">查看更多<i class="fa fa-angle-double-down"></i></a>');
        $("#address-part").append('<div class="hidden-div hidden"></div>');
        $.each(data, function (index, al) {
            var html1 = '<label class="radio default" for="radio' + index + '">' +//
                    '<input type="radio" name="optionsRadios1" value="' + al.id + '"' +//
                    'id="radio' + index + '"' +//
                    'data-toggle="radio">' +//
                    al.receivedPerson +//
                    '<span class="input-radio">' + al.receivedPerson + ' ' + al.proName + al.cityName + al.areaName + ' ' + al.address + ' ' + al.receivedPersonPhone + '</span>' +//
                    '<input type="hidden" class="aIndex" value="0">' +//
                    '</label>';
            if (index > 0) {
                $(".hidden-div").append(html1);
            }
        });
        $(':radio').radiocheck();
        if (show) {
            $("#showMore").addClass("hidden");
            $(".hidden-div").removeClass("hidden");
        }
        if ($(".active-pay").size() > 0) {
            $("#submitForm").attr("disabled", false);
        }
    }
</script>
</body>
</html>