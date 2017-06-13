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
    <link type="text/css" rel="stylesheet" href="/resources/css/sitelogo.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/cropper.min.css"/>
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
                    <div class="col-sm-12" style="text-align: center;margin-bottom: 20px">
                        <div id="avatar-modal">
                            <div class="">
                                <div class="modal-content">
                                    <form class="avatar-form">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="avatar-modal-label" style="color: #A4C540;">
                                                上传头像</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="avatar-body">
                                                <div class="avatar-upload">
                                                    <input class="avatar-src" name="avatar_src" type="hidden">
                                                    <input class="avatar-data" name="avatar_data" type="hidden">
                                                    <button class="btn btn-danger" type="button"
                                                            style="height: 35px;background-color: #A4C540"
                                                            onClick="$('input[id=avatarInput]').click();">请选择图片
                                                    </button>
                                                    <span id="avatar-name"></span>
                                                    <input class="avatar-input hide" id="avatarInput" name="avatar_file"
                                                           type="file"></div>
                                                <div class="row" style="padding-right: 10px">
                                                    <div class="col-md-9">
                                                        <div class="avatar-wrapper"></div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="avatar-preview preview-lg" id="imageHead"></div>
                                                    </div>
                                                </div>
                                                <div class="row avatar-btns" style="height: 35px;">
                                                    <div class="col-md-3">
                                                        <button class="btn btn-danger btn-block avatar-save fa fa-save"
                                                                type="button"
                                                                data-dismiss="modal" style="background-color: #A4C540">
                                                            保存修改
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <h3>推荐头像</h3>
                            <a href="${pageContext.request.contextPath}/login/uploadRecommendHead?img=father.jpg"
                               class="col-sm-3 mid-pic">
                                <img src="/resources/image/father.jpg" class="img-circle img-responsive">
                            </a>
                            <a href="${pageContext.request.contextPath}/login/uploadRecommendHead?img=mother.jpg"
                               class="col-sm-3 mid-pic">
                                <img src="/resources/image/mother.jpg" class="img-circle img-responsive">
                            </a>
                            <a href="${pageContext.request.contextPath}/login/uploadRecommendHead?img=brother.jpg"
                               class="col-sm-3 mid-pic">
                                <img src="/resources/image/brother.jpg" class="img-circle img-responsive">
                            </a>
                            <a href="${pageContext.request.contextPath}/login/uploadRecommendHead?img=sister.jpg"
                               class="col-sm-3 mid-pic">
                                <img src="/resources/image/sister.jpg" class="img-circle img-responsive">
                            </a>
                        </div>
                    </div>
                </ul>
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
                <p>正在上传</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="/resources/js/jquery.2.1.1.min.js"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/flat-ui.js"></script>
<script src="/resources/js/cropper.js"></script>
<script src="/resources/js/html2canvas.min.js"></script>
<script src="/resources/js/sitelogo.js"></script>
<script>
    $(function () {
        $(':radio').radiocheck();
        $("#forth_li").addClass("active");
    });
    //做个下简易的验证  大小 格式
    $('#avatarInput').on('change', function (e) {
        var filemaxsize = 2048;
        var target = $(e.target);
        var Size = target[0].files[0].size / 1024;
        if (Size > filemaxsize) {
            alert('图片大小不能超过2M!');
            $(".avatar-wrapper").childre().remove;
            return false;
        }
        if (!this.files[0].type.match(/image.*/)) {
            alert('不是图片文件!')
        } else {
            var filename = document.querySelector("#avatar-name");
            var teststr = document.querySelector("#avatarInput").value;
            testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的
            filename.innerHTML = testend;
        }

    });

    $(".avatar-save").on("click", function () {
        var img_lg = document.getElementById('imageHead');
        // 截图小的显示框内的内容
        html2canvas(img_lg, {
            allowTaint: true,
            taintTest: false,
            onrendered: function (canvas) {
                canvas.id = "mycanvas";
                //生成base64图片数据
                var dataUrl = canvas.toDataURL("image/png");
                var newImg = document.createElement("img");
                newImg.src = dataUrl;
                imagesAjax(dataUrl)
            }
        });
    });

    function imagesAjax(src) {
        $.ajax({
            url: "${pageContext.request.contextPath}/login/uploadHead",
            data: img = src.split(",")[1],
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            beforeSend: function () {
                $("#myModal3").modal("show");
            },
            success: function () {
                window.location.href = '${pageContext.request.contextPath}/login/toInformation';
            }
        })
    }

</script>

</body>
</html>

