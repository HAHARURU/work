<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .index_header {
        height: 55px;
    }
    .navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus {
        color: #A4C540;
        background-color: transparent;
    }
    .navbar-default .navbar-nav > li > a {
        color: #90c400;
        background-color: #ffffff;
    }
    .navbar-default .navbar-nav > .dropdown > a .caret {
        border-top-color: #90c400;
        border-bottom-color: #90c400;
    }
</style>
<div class="index_header">
    <div class="container" style="padding-left: 0;padding-right: 0">
        <div class="col-sm-12">
            <nav class="navbar navbar-default" role="navigation" style="background: #ffffff;margin-bottom: 0;display:flex;align-items:center;">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/index/toIndex"><img src="${pageContext.request.contextPath}/resources/image/logo2.jpg" class="img-responsive" style="height: 53px;"></a>
                </div>
                <div class="col-md-offset-2 col-sm-10 col-lg-6">
                    <ul class="nav navbar-nav" id="ul2">
                        <li class="" id="first_li"><a
                                href="${pageContext.request.contextPath}/index/toIndex"
                                class="index-a">首页</a>
                        </li>
                        <li class="dropdown" id="second_li">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="product-a">
                                产品中心 <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" style="margin-top: 0">
                                <li id="robot-li"><a href="${pageContext.request.contextPath}/index/toRobot">智能小豆</a></li>
                                <li id="course-li"><a href="${pageContext.request.contextPath}/index/toCourse?number=1&size=9">早教课程</a></li>
                                <li id="tourism-li"><a href="${pageContext.request.contextPath}/index/toTourism?state=1&number=1&size=4">亲子旅游</a></li>
                            </ul>
                        </li>
                        <li id="forth_li"><a href="${pageContext.request.contextPath}/login/toInformation" class="index-a">个人中心</a></li>
                        <li id="sixth_li"><a href="${pageContext.request.contextPath}/login/toSign" class="index-a">签到</a></li>
                        <li id="seventh_li"><a href="${pageContext.request.contextPath}/index/toParticipate" class="index-a">免费报名</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>

