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

        a {
            color: #000000;
        }

        .active a {
            color: #A4C540;
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
                    <li class="list-group-item active"><a
                            href="${pageContext.request.contextPath}/login/toAddress">收货地址</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toNewMyOrder?number=1&size=4&state=0">我的订单</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toNewCoupon?state=3">我的优惠券</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toNewMyCourse">课程进度</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toMyPoint?number=1&size=5&state=3">我的豆值</a>
                    </li>
                    <li class="list-group-item"><a
                            href="${pageContext.request.contextPath}/login/toMyInvitation?number=1&size=10">我的邀请码</a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-9" style="padding-left: 0">
                <ul class="col-xs-12 ul-border">
                    <button class="btn btn-default" style="background-color: #A4C540;margin-bottom: 10px" id="add"
                            onclick="addAddress()">
                        添加收货地址
                    </button>
                    <c:forEach items="${addressList}" var="al" varStatus="vs">
                        <div class="address-div col-sm-12" id="address1"
                                <c:if test="${al.defaultAddress}">
                                    style="box-shadow: 1px 1px 5px 5px #ddd;"
                                </c:if>
                        >
                            <div class="modal-header">
                                <button type="button" class="close"
                                        onclick="deleteAddress(${al.addressId},${vs.index})">&times;</button>
                                <h2 class="modal-title" id="myModalLabel">${al.receivedPerson}</h2>
                            </div>
                            <dl class="dl-horizontal">
                                <dt>收货人：</dt>
                                <dd>${al.receivedPerson}</dd>
                                <dt>收货地址：</dt>
                                <dd>${al.proName}${al.cityName}${al.areaName}</dd>
                                <dt>详细地址：</dt>
                                <dd>${al.address}</dd>
                                <dt>联系方式：</dt>
                                <dd>${al.receivedPersonPhone}</dd>
                            </dl>
                            <div class="pull-right">
                                <button class="btn btn-default" style="background-color: #A4C540;"
                                        <c:if test="${al.defaultAddress}">
                                            disabled="disabled"
                                        </c:if>
                                        onclick="setDefault(${al.addressId})">
                                    设为默认
                                </button>
                                <button class="btn btn-default" style="background-color: #A4C540;"
                                        onclick="editAddress('${al.receivedPerson}','${al.province}','${al.proName}','${al.city}','${al.cityName}','${al.area}','${al.areaName}','${al.address}','${al.receivedPersonPhone}',${al.addressId},${vs.index})">
                                    编辑
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </ul>
            </div>
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
                <form class="form-horizontal col-sm-12" role="form" id="update_form" method="post"
                      action="${pageContext.request.contextPath}/login/toAddAddress">
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
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script>
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

    $(function () {
        $("#forth_li").addClass("active");
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
    });

    function addAddress() {
        t = -1;
        $("#consignee").val("");
        $("#select2-chosen-1").html("请选择");
        $("#province").val("请选择");
        $("#select2-chosen-2").html("请选择");
        $("#select2-chosen-3").html("请选择");
        $("#addressDetail").val("");
        $("#phone").val("");
        $("#update_form").attr("action", "${pageContext.request.contextPath}/login/toAddAddress");
        $('#myModal').modal('show');
    }

    function setDefault(aid) {
        window.location.href = '${pageContext.request.contextPath}/login/toSetDefault?aid=' + aid;
    }

    function editAddress(rp, pc, pn, cc, cn, ac, an, ad, rpp, adid, index) {
        t = adid;
        receivedPerson = rp;
        province = pn;
        pid = pc;
        city = cn;
        cid = cc;
        area = an;
        aid = ac;
        address = ad;
        receivedPersonPhone = rpp;
        $("#update_form").attr("action", "${pageContext.request.contextPath}/login/toEditAddress");
        $('#myModal').modal('show');
    }
    $('#myModal').on('show.bs.modal', function () {
        if (t != -1) {
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

    function deleteAddress(t, index) {
        window.location.href = '${pageContext.request.contextPath}/login/toDeleteAddress?aid=' + t + '&index=' + index;
    }

    function checkFormInfo() {
        if ($("#consignee").val() == "" || $("#province").val() == -1 || $("#city").val() == -1 || $("#area").val() == -1 || $("#addressDetail").val() == -1 || $("#phone").val() == "") {
            alert("请将信息填写完整！");
            return false;
        } else {
            if (!checkMobile($("#phone").val().toString())) {
                alert("手机格式不正确！");
                return false;
            }
            return true;
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
</script>

</body>
</html>