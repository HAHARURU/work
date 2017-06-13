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
    .navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus {
        color: #A4C540;
        background-color: transparent;
    }
</style>
<div class="index_header">
    <div class="container">
        <div class="col-xs-12" style="font-size: 0.9em">
            <div class="pull-left">
                <span style="color: #A4C540;">欢迎来到小豆一家!</span>
                <shiro:guest>
                    <a href="${pageContext.request.contextPath}/index/toLogin">登录/</a>
                    <a href="${pageContext.request.contextPath}/index/toRegister">注册</a>
                </shiro:guest>
                <shiro:user>
                    <a href="${pageContext.request.contextPath}/login/toInformation"><shiro:principal
                            property="username"/></a>
                    <a href="${pageContext.request.contextPath}/login/toLogout">，[注销]</a>
                </shiro:user>
            </div>
            <div class="pull-right">
                <i class="fa fa-phone-square"></i>
                <span>0553-8292685</span>
            </div>
        </div>
    </div>
    <div style="border-bottom: 1px solid #CCCCCC;position: absolute;top: 27px;width: 100%;z-index: 10;"></div>
    <div class="container">
        <div class="col-sm-12">
            <nav class="navbar navbar-default" role="navigation"
                 style="background: #ffffff;margin-bottom: 0;display:flex;align-items:center;">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/index/toIndex"><img
                            src="${pageContext.request.contextPath}/resources/image/logo2.jpg"
                            class="img-responsive"
                            style="height: 53px;"></a>
                </div>
                <div class="col-md-offset-2 col-sm-6 col-lg-5">
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
                                <li id="robot-li"><a
                                        href="${pageContext.request.contextPath}/index/toRobot">智能小豆</a>
                                </li>
                                <li id="course-li"><a
                                        href="${pageContext.request.contextPath}/index/toCourse?number=1&size=9">早教课程</a>
                                </li>
                                <li id="tourism-li"><a
                                        href="${pageContext.request.contextPath}/index/toTourism?state=1&number=1&size=4">亲子旅游</a>
                                </li>
                            </ul>
                        </li>
                        <li id="firth_li"><a href="${pageContext.request.contextPath}/login/toShopCar"
                                             class="index-a">购物车</a></li>
                        <li id="forth_li"><a href="${pageContext.request.contextPath}/login/toInformation"
                                             class="index-a">个人中心</a></li>
                    </ul>
                </div>
                <a href="${pageContext.request.contextPath}/login/toSign"><img
                        src="${pageContext.request.contextPath}/resources/image/sign.jpg"></a>
                <a href="${pageContext.request.contextPath}/index/toParticipate"><img
                        src="${pageContext.request.contextPath}/resources/image/participate.jpg"></a>
            </nav>
        </div>
    </div>
</div>

