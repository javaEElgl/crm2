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

    <title>My JSP 'ser.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
</head>
<body>
<form action="ServiceByYearServlet">
    <div class="page_title">客户服务分析</div>
    <div class="button_bar">
        <button class="common_button" onclick="javascript:alert('客户服务分析');">帮助</button>
        <button class="common_button">查询</button>
    </div>
    <table class="query_form_table">
        <tr>
            <th>年份</th>
            <td><select name="year" id="year">
                <option value="all">全部</option>
            </select></td>
            <th>&nbsp;</th>
            <td>&nbsp;</td>
        </tr>
    </table>
    <br/>
    <table class="data_list_table">
        <tr>
            <th>编号</th>
            <th>条目</th>
            <th>服务数量</th>
        </tr>
        <%int i = 1;%>
        <c:forEach items="${service}" var="sv">
            <tr>
                <td class="list_data_number"><%=i++%>
                </td>
                <td class="list_data_text">${sv.sv_type}</td>
                <td class="list_data_number">${sv.sv_id}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
<script type="text/javascript">
	var date=new Date();
	var year=date.getFullYear();
	var datesel=document.getElementById("year");
	for(var i=year;i>=2000;i--){
		var op=new Option(i,i);
		datesel.add(op);
	}
</script>
</html>
