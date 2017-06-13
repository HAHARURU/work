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
                <ul class="col-xs-12 ul-border">
                    <c:if test="${kind==1}">
                        <h3>修改密码</h3>
                    </c:if>
                    <c:if test="${kind==2}">
                        <h3>修改手机</h3>
                    </c:if>
                    <c:if test="${kind==3}">
                        <h3>修改邮箱</h3>
                    </c:if>
                    <div class="col-sm-12">
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" aria-valuenow="60"
                                 aria-valuemin="0" aria-valuemax="100" style="width: 33%;background-color: #A4C540">
                            </div>
                        </div>
                        <div class="col-sm-12 step-box">
                            <div class="col-sm-4 active-step"><em>1</em><br/><label>验证身份</label></div>
                            <div class="col-sm-4"><em>2</em><br/><label>修改信息</label></div>
                            <div class="col-sm-4"><em>3</em><br/><label>完成</label></div>
                        </div>
                    </div>
                    <form class="form-horizontal" role="form" id="update_form1" method="post"
                          action="${pageContext.request.contextPath}/login/validateInfo?kind=${kind}">
                        <c:if test="${kind==1}">
                            <div class="form-group">
                                <label for="password" class="col-xs-3 control-label">新密码：</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password2" class="col-xs-3 control-label">确认密码：</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control" id="password2" name="password2">
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${kind==2}">
                            <div class="form-group">
                                <label for="phone" class="col-xs-3 control-label">新手机：</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control" id="phone" name="phone">
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${kind==3}">
                            <div class="form-group">
                                <label for="mail" class="col-xs-3 control-label">新邮箱：</label>
                                <div class="col-xs-5">
                                    <input type="email" class="form-control" id="mail" name="mail">
                                </div>
                            </div>
                        </c:if>
                        <div class="form-group">
                            <div class="col-xs-offset-3 col-xs-9">
                                <button type="submit" class="btn btn-default" style="background-color: #A4C540;">
                                    提交
                                </button>
                            </div>
                        </div>
                    </form>
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
<script>
    $().ready(function () {
        $(".progress-bar").animate({width: '66%'}, "fast");
        $($(".step-box").find("div")[1]).addClass("active-step");
        $.validator.addMethod("containBlank",
                function (value, element, param) {
                    return value.indexOf(" ") == -1;
                },
                "密码不能包含空格"
        );
        $("#update_form1").validate({
            rules: {
                password: {
                    required: true,
                    containBlank: "#password"
                },
                password2: {
                    required: true,
                    containBlank: "#password2",
                    equalTo: "#password"
                },
                phone: {
                    required: true,
                    digits: true
                },
                mail: {
                    required: true,
                    email: true
                }
            },
            messages: {
                password: {
                    required: "必填"
                },
                password2: {
                    required: "必填",
                    equalTo: "两次密码不相同"
                },
                phone: {
                    required: "必填",
                    digits: "只能输入数字"
                },
                mail: {
                    required: "必填",
                    email: "邮箱格式不正确"
                }
            }
        });
    });
    $(function () {
        $("#forth_li").addClass("active");
    });
</script>

</body>
</html>



