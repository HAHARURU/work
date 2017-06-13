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
    <title>小豆一家——预约报名</title>
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

        @media (min-width: 768px) {
            .div1 {
                bottom: 175px;
            }

            .in-div {
                height: 195px;
            }

            .div2 {
                bottom: 270px;
            }

            .fo-div {
                height: 320px;
            }

            .select2-container {
                margin-top: 10px;
                margin-bottom: 10px;
            }
        }

        @media (min-width: 992px) {
            .div1 {
                bottom: 180px;
            }

            .in-div {
                height: 200px;
            }

        }

        @media (min-width: 1200px) {
            .div1 {
                bottom: 200px;
            }

            .in-div {
                height: 250px;
            }

            .div2 {
                bottom: 320px;
            }

            .fo-div {
                height: 400px;
            }

            .select2-container {
                margin-top: 30px;
                margin-bottom: 40px;
            }
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
<img src="/resources/image/participate_top.jpg" class="img-responsive" style="width: 100%;">
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 in-div">
                <img src="/resources/image/in_bg.png" class="img-responsive">
                <div class="float-div div1">
                    <dl class="dl-horizontal">
                        <dt>
                        <h3>活动说明</h3></dt>
                        <dd></dd>
                        <dt>活动要求：</dt>
                        <dd>个人和团体均可报名参加，年龄限制3~12岁</dd>
                        <dt>活动时间：</dt>
                        <dd>周六周日（团体报名时间不限）</dd>
                        <dt>咨询电话：</dt>
                        <dd>0550-8274685</dd>
                    </dl>
                </div>
            </div>
            <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 fo-div">
                <img src="/resources/image/ap_bg.png" class="img-responsive">
                <div class="float-div div2 col-sm-12">
                    <form id="update_form" class="col-sm-12" role="form" method="post">
                        <div class="form-group">
                            <h3 class="col-sm-offset-1 control-label" style="margin-top: 0">预约报名</h3>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">豆宝姓名：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">豆宝性别：</label>
                            <div class="col-sm-7">
                                <label class="radio" for="radio1" style="display: inline-block;margin-right: 10px">
                                    <input type="radio" name="sex" value="男生" id="radio1"
                                           data-toggle="radio" checked="checked">
                                    <i class="fa  fa-mars" style="color: blue"></i>&nbsp;&nbsp;男生
                                </label>
                                <label class="radio" for="radio2" style="display: inline-block">
                                    <input type="radio" name="sex" value="女生" id="radio2"
                                           data-toggle="radio">
                                    <i class="fa fa-venus" style="color: red"></i>&nbsp;&nbsp;女生
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">联系方式：</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="phone" name="phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="province" class="col-sm-3 control-label">所在地区：</label>
                            <div class="col-sm-7">
                                <div class="col-sm-4">
                                    <select class="form-control select select-default select-block mbl margin-right-i"
                                            id="province" name="province" onchange="changeCity()">
                                        <option value="-1">请选择</option>
                                        <c:forEach items="${provinces}" var="p">
                                            <option value="${p.code}">${p.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-offset-2 col-sm-4">
                                    <select class="form-control select select-default select-block mbl margin-right-i"
                                            id="city" name="city">
                                        <option value="-1">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="button" class="col-sm-5 btn btn-default"
                                        style="background-color: #A4C540;font-size: 1.1em"
                                        onclick="checkFormInfo()">
                                    提&nbsp;&nbsp;&nbsp;&nbsp;交
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="col-sm-12"
     style="background-color:#A4C540;color: #ffffff;text-align: center;font-size: 0.7em;height: 30px;margin-top: 20px">
    <span style="line-height: 30px">版权所有：安徽小豆网络科技有限公司</span>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center;color: red;"></div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>

<script>
    $(function () {
        $(':radio').radiocheck();
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $("#select2-chosen-1").html("请选择");
        $("#province").val("请选择");
        $("#select2-chosen-2").html("请选择");
    });
    function changeCity() {
        var $p = $("#province");
        var pv = $p.val();
        $("#area").empty();
        $("#area").append('<option value="-1">请选择</option>');
        $("#city").empty();
        $("#city").append('<option value="-1">请选择</option>');
        $("#select2-chosen-2").html("请选择");
        if (pv != -1) {
            $.ajax({
                url: "${pageContext.request.contextPath}/index/getCityAjax?pCode=" + pv,
                type: "GET",
                success: function (data) {
                    $.each(data, function (index, cl) {
                        $("#city").append("<option value='" + cl.code + "'>" + cl.name + "</option>");
                    })
                }
            })
        }
    }
    function checkFormInfo() {
        if ($("#name").val() == "" || $("#province").val() == -1 || $("#city").val() == -1 || $("#phone").val() == "") {
            $(".modal-body").html("请将信息填写完整");
            $("#myModal2").modal("show");
        } else {
            if (validateNumber($("#phone").val().toString())) {
                $(".modal-body").html("手机格式不正确");
                $("#myModal2").modal("show");
            }
            var r = $("[name=sex]");
            var s;
            for (var i = 0; i < r.length; i++) {
                if (r[i].checked) {
                    s = r[i].value;
                }
            }
            var pi = {
                name: $("#name").val(),
                sex: s,
                province: $("#province").val(),
                city: $("#city").val(),
                phone: $("#phone").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/index/submitParticipateAjax",
                data: JSON.stringify(pi),
                type: "POST",
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    if (data == 1) {
                        $(".modal-body").html("预约成功！");
                        $("#myModal2").modal("show");
                        $('#myModal2').on('hide.bs.modal', function () {
                            document.location.reload();
                        })
                    }
                }
            });
        }
    }

    function validateNumber(v) {
        var regu = /^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\d{8}$/;
        var re = new RegExp(regu);
        if (re.test(v)) {
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>

