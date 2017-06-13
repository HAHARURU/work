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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">
    <style type="text/css">
        .list-group-item.active, .list-group-item.active:focus, .list-group-item.active:hover {
            background-color: #ffffff;
            border-top: #34495e 2px solid;
            border-left: #34495e 2px solid;
            border-bottom: #34495e 2px solid;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px;
            border-top-right-radius: 0;
            border-right: none;
        }

        .nav-pills > li.active > a, .nav-pills > li.active > a:focus, .nav-pills > li.active > a:hover {
            color: #fff;
            background-color: #34495e;
        }

        .pagination li {
            margin-right: 0;
        }

        .pagination li.active > a, .pagination li.active > span, .pagination li.active > a:hover, .pagination li.active > span:hover, .pagination li.active > a:focus, .pagination li.active > span:focus {
            background-color: #34495e;
        }

        .table-border {
            border: 2px solid #34495e;
            margin-bottom: 20px;
            border-radius: 0.4em;
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
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="main col-md-10 col-md-offset-2">
            <div class="page-header">
                <h2>反馈列表</h2>
            </div>
            <div>
                <div class="table-responsive table-border">
                    <table class="table table-hover table-condensed">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>联系方式</th>
                            <th>反馈时间</th>
                        </tr>
                        </thead>
                        <tbody id="tr-body">
                        <c:forEach items="${feedbackList}" var="fl">
                            <tr>
                                <td style="border-top: none">${fl.username}</td>
                                <td style="border-top: none">${fl.contactway}</td>
                                <td style="border-top: none">
                                    <fmt:formatDate value="${fl.uploadtime}" type="date"
                                                    pattern="yyyy-MM-dd hh:mm:ss"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" style="border-top: none"><strong>反馈意见：</strong>${fl.suggestion}</td>
                            </tr>
                            <tr><td style="border-top: 2px solid #898d90;"></td></tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <table style="margin-left:auto;margin-right:auto;">
                    <tr>
                        <td>
                            <ul id="example"></ul>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-paginator.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sidebar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flat-ui.min.js"></script>
<script>
    $(function () {
        $("#feedback").addClass("active");
        var options = {
            totalPages: ${totalPages},
            currentPage: ${currentPage},
            numberOfPages: 5,
            pageUrl: function (type, page, current) {
                return "${pageContext.request.contextPath}/root/toFeedback?page=" + page + "&size=20";
            }
        };
        $('#example').bootstrapPaginator(options);
    })
</script>
</body>
</html>

