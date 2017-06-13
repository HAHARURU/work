<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/6/1
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .active {
        background-color: #34495e;
    }

    .active a {
        color: #ffffff;
    }

    .nav > li > a:focus, .nav > li > a:hover {
        background-color: #666;
    }
</style>
<div class="col-xs-7 col-sm-3 col-md-2 sidebar sidebar-left sidebar-animate sidebar-md-show"
     style="padding-left: 0;padding-right: 0">
    <ul class="nav navbar-stacked">
        <li id="uploadVideo"><a href="${pageContext.request.contextPath}/root/toUploadVideo">外部视频</a></li>
        <li id="editKind"><a href="${pageContext.request.contextPath}/root/toEditKind">修改种类</a></li>
        <li id="courseVideo"><a href="${pageContext.request.contextPath}/root/toCourseVideo">课程视频</a></li>
        <li id="feedback"><a href="${pageContext.request.contextPath}/root/toFeedback?page=1&size=20">反馈列表</a></li>
    </ul>
</div>
