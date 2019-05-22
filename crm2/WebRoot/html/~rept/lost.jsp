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

    <title>My JSP 'lost.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
</head>
<body>
<form action="LostByConditionServlet">
    <div class="page_title">客户流失分析</div>
    <div class="button_bar">
        <button class="common_button">查询</button>
    </div>
    <table class="query_form_table" border="0" cellPadding="3"
           cellSpacing="0">
        <tr>
            <th>客户名称</th>
            <td><input type="text" name="item.lstCustName" value="">
            </td>
            <th>客户经理</th>

            <td><input type="text" name="item.lstCustManagerName" value="">
            </td>

        </tr>
    </table>
    <br/>
    <table class="data_list_table">
        <tr>
            <th height="28">编号</th>
            <th height="28">年份</th>
            <th height="28">客户</th>
            <th height="28">客户经理</th>
            <th height="28">流失原因</th>
        </tr>
        <%int i = 1;%>
        <c:forEach items="${lost}" var="l">
            <tr>
                <td class="list_data_number" height="27"><%=i++%>
                </td>
                <td class="list_data_text" height="27">${l.lost_lostdate}</td>
                <td class="list_data_text" height="27">${l.lost_customer}</td>
                <td class="list_data_text" height="27">${l.lost_manager}</td>
                <td class="list_data_ltext" height="27">${l.lost_reason}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
