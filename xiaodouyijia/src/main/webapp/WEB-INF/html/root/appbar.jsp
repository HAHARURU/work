<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<nav role="navigation" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle toggle-left hidden-md hidden-lg" data-toggle="sidebar"
                    data-target=".sidebar-left">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <button data-target="#bs-example-navbar-collapse-15" data-toggle="collapse" class="navbar-toggle collapsed"
                    type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/root/toUploadVideo" class="navbar-brand">小豆一家</a>
        </div>
        <div id="bs-example-navbar-collapse-15" class="navbar-collapse collapse" style="height: 2px;">
            <p class="navbar-text navbar-right">
                <a href="${pageContext.request.contextPath}/login/toInformation" style="color:#f3ce00"><shiro:principal property="username"/></a>
                <a class="navbar-link" href="${pageContext.request.contextPath}/login/toLogout">
                    <i class="fa fa-power-off" style="color: red"></i>
                </a>
            </p>
        </div>
    </div>
</nav>
