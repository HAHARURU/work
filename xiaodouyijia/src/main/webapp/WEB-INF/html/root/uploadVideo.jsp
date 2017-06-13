<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>
    <title>小豆一家--Beans-park智能教育机器人,原创3~12岁分龄式STEM科学体系实验课程</title>
    <meta name="Keywords"
          content="小豆一家   Beanspark    stem  早教  教育品牌  教育机器人   智能机器人   手工 动手能力  诗歌  国学  服装设计   数学  物理   化学  生命科学  天文地理  趣味生活   场景教学  分龄课程  在线教育  亲子游  乐高  乐创  巧虎  鲨鱼公园 360机器人  学前教育   寓教于乐  小豆宝盒"/>
    <meta name="description"
          content="小豆一家推出国内首款智能早教机器人,针对4~12岁儿童对于事物的认知程度不同开发出美劳美艺、奇趣物化、玩转数理、生命科学、天文地理、趣味生活六大分龄课程体系,独创场景教学模式,还有小豆宝盒让儿童跟着手工视频一起做，让儿童在学习知识的同时也获得动手能力的提升。">
    <meta name="viewport" content="width=device-width">

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fullpage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">
    <style type="text/css">
        .form-control, .select2-search input[type="text"] {
            border: 1px solid #34495e;
        }

        .error {
            color: red;
        }

        .button-caution, .button-caution-flat {
            background-color: #34495e;
            border-color: #34495e;
        }

        .button-caution:hover, .button-caution:focus, .button-caution-flat:hover, .button-caution-flat:focus {
            background-color: #A4C540;
            border-color: #A4C540;
        }

        .select-success .select2-choice {
            background-color: #34495e;
        }

        .select-success .select2-choice:hover, .select-success .select2-choice.hover, .select-success .select2-choice:focus, .select-success .select2-choice:active {
            background-color: #A4C540;
            border-color: #A4C540;
        }

        #success {
            line-height: 30px;
            height: 30px;
            margin: 20px 0 0 0;
        }
    </style>

    <script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="appbar.jsp" %>
<!-- Begin page content -->
<input type="hidden" id="domain" value="http://oqy6b34es.bkt.clouddn.com/">
<input type="hidden" id="uptoken_url" value="uptoken">
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="main col-md-10 col-md-offset-2">
            <div class="page-header">
                <h2>外部视频</h2>
            </div>
            <form role="form" method="post" id="upload_form">
                <input type="hidden" name="vourl" id="vourl">
                <input type="hidden" name="voduration" id="voduration">
                <div class="form-group">
                    <label for="voName">视频名</label>
                    <input type="text" class="form-control" id="voName" name="voName">
                </div>
                <div class="input-group">
                    <select class="select select-success select-block mbl" id="pKind" name="pKind"
                            onchange="return selectChange()" style="margin-right: 10px">
                        <option value="">选择一级种类</option>
                        <c:forEach items="${fKind}" var="fks">
                            <option value="${fks.kid}">${fks.kname}</option>
                        </c:forEach>
                    </select>
                    <select class="select select-success select-block mbl" id="cKind" name="cKind"
                            style="margin-left: 10px" onchange="return selectChange2()">
                        <option value="">选择二级种类</option>
                    </select>
                </div>
            </form>
            <div class="col-md-12">
                <div id="container">
                    <button class="button button-caution btn-lg  pull-right" id="pickfiles" href="#" disabled="disabled">
                        <i class="fa fa-plus"></i>
                        <span>选择视频</span>
                    </button>
                </div>
            </div>
            <div style="display:none" id="success" class="col-md-12">
                <div class="alert-success">
                    上传成功！
                </div>
            </div>
            <div class="col-md-12 ">
                <table class="table table-striped table-hover text-left" style="margin-top:40px;display:none">
                    <thead>
                    <tr>
                        <th class="col-md-4">视频名</th>
                        <th class="col-md-2">大小</th>
                        <th class="col-md-6">描述</th>
                    </tr>
                    </thead>
                    <tbody id="fsUploadProgress">
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fullpage.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sidebar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flat-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/moxie.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plupload.dev.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/zh_CN.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/qiniu.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/up.js"></script>

<script>
    $(function () {
        $("#pKind").val("");
        $("#cKind").val("");
        $("#uploadVideo").addClass("active");
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
        $.validator.addMethod("containBlank",
                function (value, element, param) {
                    return value.indexOf(" ") == -1;
                },
                "不能包含空格"
        );

        $("#upload_form").validate({
            rules: {
                voName: {
                    containBlank: "#voName"
                }

            }
        });
    });

    function selectChange() {
        $("#pickfiles").attr("disabled", "disabled");
        var fkid = $("#pKind").val();
        $("#cKind").empty();
        $("#cKind").append('<option value="">选择二级种类</option>');
        $("#select2-chosen-2").html("选择二级种类");
        $.ajax({
            url: "${pageContext.request.contextPath}/root/changeKindAjax?fkid=" + fkid,
            type: "post",
            success: function (data) {
                $.each(data, function (index, cl) {
                    $("#cKind").append("<option value='" + cl.kid + "'>" + cl.kname + "</option>");
                })
            }
        })
    }

    function selectChange2() {
        var ckid = $("#cKind").val();
        if (ckid != "") {
            $("#pickfiles").attr("disabled", false);
        }
    }

</script>
</body>
</html>

