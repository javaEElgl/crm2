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

    <title>My JSP 'feedback_detail.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
    <script type="text/javascript" language="JavaScript">
        function save(id) {
            var result=document.getElementById("result").value;
            var option=document.getElementById("satisfy").value;
            if (result.length<1||option==0){
                alert("处理不完全!");
                return;
            }
            window.location.href="LoadServlet?action=feedBackService&sv_id="+id+"&result="+result+"&satisfy="+option;
        }
    </script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back('LoadServlet?action=feedBack');">返回</button>
    <button class="common_button" onclick="save('${fbService.sv_id}');">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td>${fbService.sv_id}</td>
        <th>服务类型</th>
        <td>${fbService.sv_type}</td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3">${fbService.sv_title}</td>
    </tr>
    <tr>
        <th>客户</th>
        <td>${fbService.sv_custname}</td>
        <th>状态</th>
        <td>已分配</td>
    </tr>
    <tr>
        <th>服务请求</th>
        <td colspan="3">${fbService.sv_request}<br></td>
    </tr>
    <tr>
        <th>创建人</th>
        <td>${fbService.sv_createby}</td>
        <th>创建时间</th>
        <td>${fbService.sv_createdate}</td>
    </tr>
</table>
<br/>
<table class="query_form_table" id="table3">
    <tr>
        <th>分配给</th>
        <td>${fbService.sv_dueto}</td>
        <th>分配时间</th>
        <td>${fbService.sv_duedate}</td>
    </tr>
</table>
<br/>
<table class="query_form_table" id="table1">
    <tr>
        <th>服务处理</th>
        <td colspan="3">${fbService.sv_deal}</td>
    </tr>
    <tr>
        <th>处理人</th>
        <td>${fbService.sv_dealby}</td>
        <th>处理时间</th>
        <td>${fbService.sv_dealdate}</td>
    </tr>
</table>
<br/>
<table class="query_form_table" id="table2">
    <tr>
        <th>处理结果</th>
        <td><input id="result" name="T10" size="20"/><span class="red_star">*</span>
        </td>
        <th>满意度</th>
        <td><select id="satisfy">
            <option value="0">请选择...</option>
            <option value="1">☆☆☆☆☆</option>
            <option value="2">☆☆☆☆</option>
            <option value="3">☆☆☆</option>
            <option value="4">☆☆</option>
            <option value="5">☆</option>
        </select><span class="red_star">*</span>
        </td>
    </tr>
</table>
</body>
</html>