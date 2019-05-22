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

    <title>My JSP 'deal_detail.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
    <script type="text/javascript" language="JavaScript">
        function back() {
            window.location.href="LoadServlet?action=dealBy";
        }
        function save(id) {
            var deal=document.getElementById("deal").value;
            var dealdate=document.getElementById("t3").value;
            var dealby=document.getElementById("dealby").value;
            if (deal.length<1){
                alert("服务处理不合格!");
                return;
            }
            window.location.href="LoadServlet?action=dealService&deal="+deal+"&dealby="+dealby+"&dealdate="+dealdate+"&sv_id="+id;
        }
    </script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="save('${ddService.sv_id}');">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td>${ddService.sv_id}</td>
        <th>服务类型</th>
        <td>${ddService.sv_type}</td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3">${ddService.sv_title}</td>
    </tr>
    <tr>
        <th>客户</th>
        <td>${ddService.sv_custname}</td>
        <th>状态</th>
        <td>已分配</td>
    </tr>
    <tr>
        <th>服务请求</th>
        <td colspan="3">${ddService.sv_request}<br></td>
    </tr>
    <tr>
        <th>创建人</th>
        <td>${ddService.sv_createby}</td>
        <th>创建时间</th>
        <td>${ddService.sv_createdate}</td>
    </tr>
</table>
<br/>
<table class="query_form_table" id="table3">
    <tr>
        <th>分配给</th>
        <td>${ddService.sv_dueto}</td>
        <th>分配时间</th>
        <td>${ddService.sv_duedate}</td>
    </tr>
</table>
<br/>
<table class="query_form_table" id="table1">
    <tr>
        <th>服务处理</th>
        <td colspan="3"><textarea rows="6" id="deal" cols="50"></textarea><span
                class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>处理人</th>
        <td><input name="T17" id="dealby" value="${user.userName}" readonly size="20"/><span
                class="red_star">*</span>
        </td>
        <th>处理时间</th>
        <td><input id="t3" name="T16" readonly size="20"/><span
                class="red_star">*</span>
        </td>
    </tr>
</table>
<br/>
<table disabled class="query_form_table" id="table2">
    <tr>
        <th>处理结果</th>
        <td><input name="T10" disabled size="20"/><span class="red_star">*</span>
        </td>
        <th>满意度</th>
        <td><select disabled name="D1">
            <option>请选择...</option>
            <option>☆☆☆☆☆</option>
            <option>☆☆☆☆</option>
            <option>☆☆☆</option>
            <option>☆☆</option>
            <option>☆</option>
        </select><span class="red_star">*</span>
        </td>
    </tr>
</table>
<script>
    var date = new Date();
    var Month=(date.getMonth() + 1);
    var Day=date.getDate();
    if(Month<9){
        Month="0"+Month;
    }
    if (Day<9){
        Day="0"+Day;
    }
    document.getElementById("t3").value = date.getFullYear() + "-" + Month + "-" + Day + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
</script>
</body>
</html>