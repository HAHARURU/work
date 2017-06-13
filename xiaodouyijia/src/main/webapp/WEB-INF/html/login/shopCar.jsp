<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>小豆一家——购物车</title>
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
                    <h3 style="color: #000000;">购物车</h3>
                </div>
                <div class="col-sm-offset-6">
                    <div class="col-sm-offset-9">
                        <a href="${pageContext.request.contextPath}/index/toIndex" style="color: #2CB742;">返回首页<i
                                class="fa fa-angle-double-right"></i></a>
                    </div>
                    <div class="progress" style="margin-top: 10px">
                        <div class="progress-bar" role="progressbar" aria-valuenow="60"
                             aria-valuemin="0" aria-valuemax="100" style="width: 0;background-color: #A4C540">
                        </div>
                    </div>
                    <div class="col-sm-12 step-box">
                        <div class="col-sm-4"><em>1</em><br/><label>购物车</label></div>
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
            <form id="shopCar-form" action="${pageContext.request.contextPath}/login/toCheckOrder" method="post">
                <div class="table-responsive" style="border: 1px solid #D5E1D3;border-radius: 0.4em">
                    <table class="table table-hover" id="table-shopCar" style="width: 1138px">
                        <thead>
                        <tr style="background-color: #D5E1D3;height: 40px">
                            <th>
                                <label class="checkbox" for="checkAll">
                                    <input type="checkbox" value="" id="checkAll" data-toggle="checkbox">
                                    全选
                                </label>
                            </th>
                            <th style="line-height: 40px">商品</th>
                            <th style="line-height: 40px">单价</th>
                            <th style="line-height: 40px">数量</th>
                            <th style="line-height: 40px">小计</th>
                            <th style="line-height: 40px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${shopCarList.size()>0}">
                            <c:forEach items="${shopCarList}" var="scl" varStatus="vs">
                                <tr>
                                    <td>
                                        <label class="checkbox" for="id${scl.id}">
                                            <input type="checkbox" value="${scl.id}" name="itemId"
                                                   data-toggle="checkbox"
                                                   id="id${scl.id}">
                                        </label>
                                    </td>
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
                                                <button class="button button-circle button-tiny plus"
                                                        style="background-color:#2CB742;color: #ffffff;"
                                                        id="plus-button1"
                                                        <c:if test="${scl.pNum==0}">
                                                            disabled="disabled"
                                                        </c:if>
                                                        onclick="return plus(this)"><i
                                                        class="fa fa-plus"></i>
                                                </button>
                                                <label class="mount-label" style="color: #2CB742;"
                                                       id="mount-label">${scl.num}</label>
                                                <button class="button button-circle button-tiny minus"
                                                        style="background-color:#2CB742;color: #ffffff;"
                                                        <c:if test="${scl.num==1}">
                                                            disabled="disabled"
                                                        </c:if>
                                                        id="minus-button1"
                                                        onclick="return minus(this)">
                                                    <i
                                                            class="fa fa-minus"></i>
                                                </button>
                                            </c:if>
                                            <c:if test="${scl.cPrice!=null}">
                                                <label class="mount-label" style="color: #2CB742;"
                                                       id="mount-label">${scl.largMenNum}/成人，${scl.smallMenNum}/儿童</label>
                                            </c:if>
                                            <input type="hidden" name="mount" value="${scl.pNum}"
                                                   id="mount${scl.id}">
                                            <input class="mountRequest" type="hidden" value="${scl.num}"
                                                   id="mount${scl.id}">
                                            <input type="hidden" name="priceItem" value="${scl.pPrice/100}"
                                                   id="price${scl.id}">
                                            <input class="itemIdHidden" type="hidden" value="${scl.id}"
                                                   id="itemId${scl.id}">
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
                                    <td>
                                        <i class="fa fa-trash" onclick="modelShow(this,${scl.id})"></i>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${shopCarList.size()<=0}">
                            <tr>
                                <td colspan="6">
                                    <div style="text-align: center">
                                        <img class="media-object" src="/resources/image/shopCar_empty.jpg"
                                             style="display: inline-block;margin-top:10px;margin-bottom: 20px"><br>
                                        <span style="color:#2CB742">购物车里什么也没有</span>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                <div class="pull-left">
                    <button id="shopCar-button" type="button"
                            class="button button-glow button-rounded button-caution buy_button order-button margin-right-i"
                            disabled="disabled" data-toggle="modal" data-target="#myModal">
                        删除选中
                    </button>
                </div>
                <div class="pull-left" style="display:flex;align-items:center;width: 600px">
                    <select class="form-control select select-success select-block mbl margin-right-i col-sm-3"
                            id="coupon-select" style="background-color:#2CB742;" name="couponId" onchange="return selectCoupon()">
                        <option value="-1">优惠券</option>
                        <c:forEach items="${coupon}" var="cl">
                            <option value="${cl.id}"><fmt:formatNumber value="${cl.discountpageVal/100}" type="number"
                                                                         pattern="#"/>元优惠券
                            </option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="couponId" value="0">
                    <div class="col-sm-3">
                        <input type="text" id="invitation" class="form-control" name="invitation"
                               style="display: inline-block" placeholder="邀请码" onchange="return checkInvitation()">
                    </div>
                    <div class="col-sm-3">
                        <input type="number" id="point" class="form-control" name="point" style="display: inline-block">
                    </div>
                    <label style="color: #2CB742">豆值：${point}</label>
                </div>
                <div class="pull-right">
                    <div class="pull-left" style="margin-right: 10px;margin-top: 15px">
                        <label>总计：￥</label><label id="allPrice" style="color: #2CB742;font-size: 1.1em">0</label>
                    </div>
                    <input type="submit" id="buy-button" style="margin-top: 19px"
                           class="button button-glow button-rounded button-caution buy_button order-button margin-right-i pull-right"
                           value="提交订单" disabled="disabled">
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="color: red;">操作提示！</h4>
            </div>
            <div class="modal-body">确认删除选中的吗？</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" onclick="return deleteAll()">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2" style="color: red;">操作提示！</h4>
            </div>
            <div class="modal-body">确认删除此项吗？</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" onclick="return deleteItem(null,0)">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-keyboard="false" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: #2CB742;">
                <i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i>
                <p>正在删除</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">邀请码错误！</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>

<script>
    var mount = 1;
    var all = 0;
    var save = 0;
    var total = 0;
    var thp = null;
    var idp = 0;
    $(document).ready(function () {
        $(':checkbox').radiocheck("uncheck");
        $("#coupon-select").val(-1);
        $("#buy-button").attr("disabled", "disabled");

        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $(':checkbox').radiocheck();
        $(".progress-bar").animate({width: '33%'}, "fast");
        $($(".step-box").find("div")[0]).addClass("active-step");
        $("#checkAll").change(function () {
            $(".mountRequest").removeAttr("name");
            $(".itemIdHidden").removeAttr("name");
            if ($("#checkAll").is(":checked")) {
                $(".mountRequest").attr("name", "mountRequest");
                $(".itemIdHidden").attr("name", "itemIdHidden");
                total = 0;
                $(".labelAll").each(function () {
                    var it = $(this).html().toString();
                    if (it.split("/").length > 1) {
                        var ts = it.split("/");
                        for (var j = 0; j < ts.length; j++) {
                            if (j != 2) {
                                total += ts[j].split("￥")[1] * 1;
                            }
                        }
                    } else {
                        total += it.substr(1, it.length) * 1;
                    }
                });
                $("[name=itemId]").radiocheck("check");
                all = $("tr").size() - 1;
            } else {
                total = 0;
                $("[name=itemId]").radiocheck("uncheck");
                all = 0;
            }
            $("#allPrice").html(total);
        });

        $("[name=itemId]").change(function () {
            var t = this;
            var tl = $(t).parents("tr").find(".labelAll").html().toString();
            if ($(t).is(":checked")) {
                all++;
                total += tl.substr(1, tl.length) * 1;
                $(t).parents("tr").find(".mountRequest").attr("name", "mountRequest");
                $(t).parents("tr").find(".itemIdHidden").attr("name", "itemIdHidden");
            } else {
                all--;
                total -= tl.substr(1, tl.length) * 1;
                $(t).parents("tr").find(".mountRequest").removeAttr("name");
                $(t).parents("tr").find(".itemIdHidden").removeAttr("name");
            }
            $("#allPrice").html(total);
            if (all == $("tr").size() - 1) {
                $("#checkAll").radiocheck("check");
            } else {
                $("#checkAll").radiocheck("uncheck");
            }
        });

        $(":checkbox").change(function () {
            $(":checkbox").each(function () {
                if ($(this).is(":checked")) {
                    $("#buy-button").attr("disabled", false);
                    $("#shopCar-button").attr("disabled", false);
                }
            });
            if (all == 0) {
                $("#buy-button").attr("disabled", "disabled");
                $("#shopCar-button").attr("disabled", "disabled");
            }
        });
        $("#shopCar-form").validate({
            rules: {
                point: {
                    digits: true,
                    min: 0,
                    max: ${point}
                }
            },
            messages: {
                point: {
                    digits: "只能是整值",
                    min: "不允许输入负值",
                    max: "您的豆值不够"
                }
            }
        });

        var oid =${oid};
        if (oid == 0) {
            $(':checkbox').radiocheck("disable");
        }
        ;

        $('#myModal4').on('hide.bs.modal', function () {
            $("#invitation").val("");
        })

    });

    function modelShow(th, itemId) {
        thp = th;
        idp = itemId;
        $("#myModal2").modal("show");
    }

    function selectCoupon(){
        console.log($("#coupon-select").val());
    }

    function checkInvitation() {
        var iv = $("#invitation").val().toString().replace(/(^\s*)|(\s*$)/g, "");
        if (iv == null || iv == "") {
            return false;
        } else {
            $.ajax({
                url: "${pageContext.request.contextPath}/login/invitationAjax",
                type: "POST",
                data: "invitation=" + iv,
                success: function (data) {
                    if (data == 1) {
                        $(".modal-body").html("邀请码错误！");
                        $("#myModal4").modal("show");
                        return false;
                    }
                    if (data == 2) {
                        $(".modal-body").html("邀请码过期！");
                        $("#myModal4").modal("show");
                        return false;
                    }
                    if (data == 3) {
                        $(".modal-body").html("邀请码已使用！");
                        $("#myModal4").modal("show");
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    function plus(th) {
        mount = $(th).next().html();
        mount++;
        $(th).siblings(".mountRequest").val(mount);
        var kz = $(th).siblings("[name=mount]").val() * 1;
        kz--;
        $(th).siblings("[name=mount]").val(kz);
        $(th).siblings(".minus").attr("disabled", false);
        $(th).next().html(mount);
        var p = $(th).siblings("[name=priceItem]").val();
        $(th).parent().parent().next().children(".labelAll").html("￥" + p * mount);
        if (kz == 0) {
            $(th).attr("disabled", "disabled");
        }
        if ($(th).parents("tr").find("[type=checkbox]").is(":checked")) {
            total += p;
        }
        $("#allPrice").html(total);
        return false;
    }

    function minus(th) {
        mount = $(th).siblings(".mount-label").html();
        mount--;
        $(th).siblings("[name=mountRequest]").val(mount);
        $(th).siblings(".plus").attr("disabled", false);
        $(th).siblings(".mount-label").html(mount);
        var p = $(th).siblings("[name=priceItem]").val();
        $(th).parent().parent().next().children(".labelAll").html("￥" + p * mount * 1.0);
        if (mount == 1) {
            $(th).attr("disabled", "disabled");
        }
        if ($(th).parents("tr").find("[type=checkbox]").is(":checked")) {
            total -= p;
        }
        $("#allPrice").html(total);
        return false;
    }

    function deleteItem(th, id) {
        if (th == null) {
            th = thp;
        }
        if (id == 0) {
            id = idp;
        }
        $("#myModal2").modal("hide");
        $.ajax({
            url: "${pageContext.request.contextPath}/login/deleteItem?itemId=" + id,
            type: "post",
            date: "",
            contentType: 'application/json;charset=utf-8',
            beforeSend: function () {
                $("#myModal3").modal("show");
            },
            success: function (data) {
                if (data == 1) {
                    $(th).parents("tr").remove();
                    if ($("tr").size() == 1) {
                        $("#checkAll").radiocheck("uncheck");
                        var html = '<tr>' +//
                                '<td colspan="6">' +//
                                '<div style="text-align: center">' +//
                                '<img class="media-object" src="/resources/image/shopCar_empty.jpg" style="display: inline-block;margin-top:10px;margin-bottom: 20px"><br>' +//
                                '<span style="color:#2CB742">购物车里什么也没有</span>' +//
                                '</div>' +//
                                '</td>' +//
                                '</tr>';
                        $("tbody").append(html);
                        $("#checkAll").radiocheck('disable');
                    }
                    if ($(th).parents("tr").find("[type=checkbox]").is(":checked")) {
                        var di = $(th).parents("tr").find(".labelAll").html().toString();
                        total -= di.substr(1, di.length);
                        all--;
                    }
                    if (all == 0) {
                        $("#buy-button").attr("disabled", "disabled");
                        $("#shopCar-button").attr("disabled", "disabled");
                    }
                    $("#allPrice").html(total);
                    $("#myModal3").modal("hide");
                    return false;
                }
            }
        })
    }

    function deleteAll() {
        $("#myModal").modal("hide");
        $("[name=itemId]").each(function () {
            if ($(this).is(":checked")) {
                deleteItem($(this).parents("tr").find(".fa-trash"), $(this).parents("tr").find("[name=itemIdHidden]").val());
            }
        });
        return false;
    }
</script>
</body>
</html>

