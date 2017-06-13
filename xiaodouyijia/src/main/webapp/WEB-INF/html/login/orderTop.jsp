<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div style=" background-color: #ffffff;color: #CCCCCC;height: 30px;">
    <div class="container">
        <div class="col-xs-12" style="border-bottom: 1px solid #CCCCCC;">
            <div class="pull-left">
                欢迎来到小豆一家!
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
                <span>客服电话：123-456-789</span>
            </div>
        </div>
    </div>
</div>

