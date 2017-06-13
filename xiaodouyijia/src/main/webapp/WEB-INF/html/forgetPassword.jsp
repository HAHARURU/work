<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/3/17
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>小豆一家</title>
    <meta name="description" content="User login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">
    <style type="text/css">
        .error {
            color: red;
        }
        .input-group-btn .btn {
            border: 1px solid #90c400;
        }
    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/flat-ui.js"></script>
    <script>
        var time = 60;
        $().ready(function () {
            if (${state==1}) {
                $("#form1").removeClass("hidden");
            }
            if (${state==2}) {
                $("#form2").removeClass("hidden");
            }
            if (${error!=null}&&
            ${error!=""})
            {
                $("#myModal2").modal("show");
            }

            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);

            $("#form1").validate({
                rules: {
                    phoneNumber: {
                        required: true,
                        digits: true
                    },
                    code: {
                        required: true,
                        digits: true
                    }
                },
                messages: {
                    phoneNumber: {
                        required: "必填",
                        digits: "手机号格式不正确"
                    },
                    code: {
                        required: "必填",
                        digits: "只能输入数字"
                    }
                }
            });

        });

        function checkMobile(s) {
            var regu = /^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\d{8}$/;
            var re = new RegExp(regu);
            if (re.test(s)) {
                return true;
            } else {
                return false;
            }
        }

        function getCode() {
            if (!checkMobile($("#phoneNumber").val().toString())) {
                alert("手机格式错误！");
                return;
            }
            var time = setTimeout(changeTime, 1000);

            $.ajax({
                url: "${pageContext.request.contextPath}/index/getCode?phone=" + $("#phoneNumber").val(),
                type: "get",
                contentType: 'application/json;charset=utf-8',
                async: false,
                success: function (data) {
                    if (data == 0) {
                        clearTimeout(time);
                        alert("获取失败！");
                    }
                }
            })
        }
        function changeTime() {
            if ($("#phoneNumber").val() != "") {
                time--;
                if (time <= 0) {
                    clearTimeout(time);
                    $("#get-code").attr("disabled", false);
                    $("#get-code").html("获取验证码");
                } else {
                    $("#get-code").attr("disabled", true);
                    $("#get-code").html(time + "s后重新获取");
                    setTimeout(changeTime, 1000);
                }
            } else {
                $("#error").html("先填写手机号");
            }
        }
        function wait() {
            $("div#login_form").addClass("hidden");
            $("div#login_hidden").fadeIn(500);
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
        }
        window.onresize = function () {
            var h = document.body.clientHeight;
            $("#mid_div").css("height", h - 55);
            var ch = document.getElementById("contact-div").offsetHeight;
            $("#contact-div").css("margin-top", (h - 55 - ch) / 2);
        };
        $(window).resize();
    </script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="menubar-hoverable img_div">
<%@include file="loginTop.jsp" %>
<div id="mid_div" class="col-sm-12">
    <div id="contact-div" class="col-sm-12"
         style="height: auto;display:flex;justify-content:center;align-items:center;">
        <div class="col-sm-6 col-lg-5" style="padding-left: 0">
            <img class="img-responsive" src="${pageContext.request.contextPath}/resources/image/login.png">
        </div>
        <div id="login_form" class="col-sm-4 col-lg-3">
            <form id="form1" class="hidden" role="form" method="post"
                  action="${pageContext.request.contextPath}/index/validateCode" style="text-align: center">
                <p style="font-size: 1.5em">获取验证码</p>
                <input type="hidden" name="forget" value="1">
                <div class="input-group" style="margin-bottom: 30px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input type="text" class="form-control" placeholder="请输入手机号" id="phoneNumber" name="phoneNumber"
                           value="${phone}">
                </div>
                <div class="input-group" style="margin-bottom: 10px;">
                    <span class="input-group-addon"><i class="fa fa-comment"></i></span>
                    <input type="text" class="form-control" id="code" name="code" value="${code}">
                    <span class="input-group-btn">
                        <button type="button" id="get-code" class="btn btn-default" onclick="getCode()"
                                style="background-color: #90c400;border-top-right-radius: 0.6em;border-bottom-right-radius: 0.6em;">
                            获取验证码
                        </button>
                    </span>
                </div>

                <input type="submit" class="button" value="确&nbsp&nbsp定">
            </form>
            <form id="form2" class="hidden" role="form" method="post"
                  action="${pageContext.request.contextPath}/index/register" style="text-align: center">
                <p style="font-size: 1.5em">找回密码</p>
                <input type="hidden" name="forget" value="1">
                <div class="input-group" style="margin-bottom: 30px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" class="form-control" placeholder="请输入新密码" name="password"
                           value="${password}">
                </div>
                <div class="input-group" style="margin-bottom: 10px;">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input type="password" class="form-control" placeholder="确认密码" name="password2"
                           value="${password2}">
                </div>
                <input type="submit" class="button" value="确&nbsp&nbsp定" onclick="return wait()">
            </form>
        </div>
        <div id="login_hidden" class="col-sm-4 col-lg-3" style="display: none">
            <p style="font-size: 1.5em">请稍等...</p>
            <i class="fa fa-refresh fa-spin fa-3x fa-fw"></i>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;">${error}</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>

