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
    <link rel="stylesheet" href="/resources/css/bootstrap-datetimepicker.css">
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

        .radio {
            display: inline-block;
            margin-right: 20px;
        }

        .error {
            color: red;
        }

        .form-control[readonly] {
            color: #000000;
        }

        #hidden-a {
            opacity: 0;
            background-color: rgba(0, 0, 0, 0.4);
            position: absolute;
            bottom: 0;
            border-radius: 50%;
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
                    <li class="list-group-item active"><a href="${pageContext.request.contextPath}/login/toInformation">个人信息</a>
                    </li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/login/toAddress">收货地址</a>
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
                <ul class="col-sm-12 ul-border">
                    <div class="col-sm-9" style="padding-right: 0">
                        <form class="form-horizontal" role="form" id="update_form" method="post"
                              action="${pageContext.request.contextPath}/login/updateInfo">
                            <div class="form-group col-sm-12">
                                <label for="account" class="col-sm-4 control-label">账号：</label>
                                <div class="input-group col-sm-8">
                                    <input type="text" class="form-control" id="account" readonly="readonly"
                                           value="${user.uid}" style=" border-radius: 6px;">
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label for="username" class="col-sm-4 control-label">用户名：</label>
                                <div class="input-group col-sm-8">
                                    <input type="text" class="form-control" id="username" name="username"
                                           value="${user.username}" style=" border-radius: 6px;">
                                    <label style="color: red">${errorUsername}</label>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <strong class="col-sm-offset-7">孩子信息</strong>
                            </div>
                            <input type="hidden" name="sex" id="sex-input" value="">
                            <input type="hidden" name="cid" value="${children.id}">
                            <div class="form-group col-sm-12">
                                <label class="col-sm-4 control-label">性别：</label>
                                <div class="input-group col-sm-8">
                                    <label class="radio" for="radio1">
                                        <input type="radio" id="radio1" name="sex" data-toggle="radio" value="男生">
                                        男生
                                    </label>
                                    <label class="radio" for="radio2">
                                        <input type="radio" id="radio2" name="sex" data-toggle="radio" value="女生">
                                        女生
                                    </label>
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label for="childrenName" class="col-sm-4 control-label">姓名：</label>
                                <div class="input-group col-sm-8">
                                    <input type="text" class="form-control" id="childrenName" name="uBoyName"
                                           value="${children.uBoyName}" style=" border-radius: 6px;">
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label for="age" class="col-sm-4 control-label">年龄：</label>
                                <div class="input-group col-sm-8">
                                    <input type="text" class="form-control" id="age" readonly="readonly"
                                           value="${children.age}" style=" border-radius: 6px;">
                                </div>
                            </div>
                            <div class="form-group col-sm-12 ">
                                <label for="bi" class="col-sm-4 control-label">出生日期：</label>
                                <div class="input-group date form_date col-sm-8" data-date=""
                                     data-date-format="dd MM yyyy" data-link-field="dtp_input2"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" size="16" type="text" value="${birthdayDate}" readonly
                                           name="bi" id="bi">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" name="birthdayDate" id="dtp_input2" value="${birthdayDate}"/><br/>
                            </div>
                            <div class="form-group col-sm-12">
                                <div class="col-sm-offset-4 col-sm-8">
                                    <button type="submit" class="btn btn-default" style="background-color: #A4C540;">
                                        修改
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div id="login_hidden" style="text-align: center;display: none;color: #A4C540">
                            <h4>请稍等...</h4>
                            <i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i>
                        </div>
                    </div>
                    <div class="col-sm-3" style="margin-bottom: 10px;">
                        <img src="${user.img}" id="edit-head" class="img-responsive img-circle"
                             style="display: inline-block;width: 110px">
                        <div class="txt-img" id="hidden-a" style="text-align: center">
                            <a href="${pageContext.request.contextPath}/login/toUploadHead"
                               class="txt-a" id="txt-a" style="color: white;display: inline-block">修改头像</a>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <dl class="dl-horizontal">
                            <dt>密码：</dt>
                            <dd style="margin-bottom: 10px">
                                <input type="password" class="form-control" id="password" readonly="readonly"
                                       value="${user.password}" style="width: 80%;display: inline-block">
                                <a href="${pageContext.request.contextPath}/login/toUploadByMessage?kind=1"
                                   style="color: #A4C540">修改</a>
                            </dd>
                            <dt>手机：</dt>
                            <dd style="margin-bottom: 10px">
                                <input type="text" class="form-control" id="phone" readonly="readonly" value="${phone}"
                                       style="width: 80%;display: inline-block">
                                <a href="${pageContext.request.contextPath}/login/toUploadByMessage?kind=2"
                                   style="color: #A4C540">修改</a>
                            </dd>
                            <dt>邮箱：</dt>
                            <dd style="margin-bottom: 10px">
                                <input type="text" class="form-control" id="mail" readonly="readonly"
                                       value="${mail}"
                                       style="width: 80%;display: inline-block">
                                <a href="${pageContext.request.contextPath}/login/toUploadByMessage?kind=3"
                                   style="color: #A4C540">修改</a>
                            </dd>
                        </dl>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js"></script>
<script src="/resources/js/messages_zh.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script src="/resources/js/bootstrap-datetimepicker.min.js"></script>
<script src="/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $().ready(function () {
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        $.validator.addMethod("containBlank",
                function (value, element, param) {
                    return value.indexOf(" ") == -1;
                },
                "用户名不能包含空格"
        );
        $("#update_form").validate({
            rules: {
                username: {
                    required: true,
                    containBlank: "#password"
                },
                childrenName: {
                    required: true
                },
                bi: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: "必填"
                },
                childrenName: {
                    required: "必填"
                },
                bi: {
                    required: "必填"
                }
            },
            errorPlacement: function (error, element) {
                $(element).closest("form").find("div[for='" + element.attr("id") + "']").after(error);
                $("label.error").addClass("col-sm-offset-4");
            }
        });
    });
    $(function () {
        $(':radio').radiocheck();
        $("#forth_li").addClass("active");
        var sex = '${children.sex}';
        if (sex == "男生") {
            $("#radio1").attr("checked", "checked");
        }
        if (sex == "女生") {
            $("#radio2").attr("checked", "checked");
        }
    });
    function wait() {
        $("form#update_form").addClass("hidden");
        $("div#login_hidden").fadeIn(500);
    }

    window.onresize = function () {
        var ih = document.getElementById("edit-head").offsetHeight;
        var ah = document.getElementById("txt-a").offsetHeight;
        var iw = document.getElementById("edit-head").offsetWidth;
        $(".txt-img").css("width", iw);
        $(".txt-img").css("height", ih);
        $(".txt-a").css("margin-top", (ih - ah) / 2);
    };
    $(window).resize();

    $("#hidden-a").on("mouseenter", function () {
        $("#hidden-a").animate({opacity: '1'}, "fast");
    });

    $("#hidden-a").on("mouseleave", function () {
        $("#hidden-a").animate({opacity: '0'}, "fast");
    });
</script>

</body>
</html>



