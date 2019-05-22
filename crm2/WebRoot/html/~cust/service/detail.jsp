<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'detail.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td>${detailService.sv_id}</td>
        <th>服务类型</th>
        <td>${detailService.sv_type}</td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3">${detailService.sv_title}</td>
    </tr>
    <tr>
        <th>客户</th>
        <td>${detailService.sv_custname}</td>
        <th>状态</th>
        <td>已归档</td>
    </tr>
    <tr>
        <th>服务请求</th>
        <td colspan="3">${detailService.sv_request}</td>
    </tr>
    <tr>
        <th>创建人</th>
        <td>${detailService.sv_createby}</td>
        <th>创建时间</th>
        <td>${detailService.sv_createdate}</td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table3">
    <tr>
        <th>分配给</th>
        <td>${detailService.sv_dueto}</td>
        <th>分配时间</th>
        <td>${detailService.sv_duedate}</td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table1">
    <tr>
        <th>服务处理</th>
        <td colspan="3">${detailService.sv_deal}</td>
    </tr>
    <tr>
        <th>处理人</th>
        <td>${detailService.sv_dealby}</td>
        <th>处理时间</th>
        <td>${detailService.sv_dealdate}</td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table2">
    <tr>
        <th>处理结果</th>
        <td>${detailService.sv_result}</td>
        <th>满意度</th>
        <td>
            <c:forEach begin="${detailService.sv_satisfy}" end="5">
                <img src="images/star.jpg" class="star_pic" />
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>
