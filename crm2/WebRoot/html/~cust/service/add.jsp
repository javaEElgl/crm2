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

    <title>My JSP 'add.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
    <script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
    
</head>
<body>
<form action="AddServlet" method="post">
    <div class="page_title">客户服务管理 > 服务创建</div>
    <div class="button_bar">
        <button class="common_button" onclick="help('');" type="button">帮助</button>
        <button class="common_button">保存</button>
    </div>
    <table class="query_form_table">
        <tr>
            <th>编号</th>
            <td><input disabled value="自动获取"/>
            </td>
            <th>服务类型</th>
            <td><select name="serviceType">
                <option>请选择...</option>
                <option value="咨询">咨询</option>
                <option value="投诉">投诉</option>
                <option value="建议">建议</option>
            </select><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>概要</th>
            <td colspan="3"><input size="53" name="title"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>客户</th>
            <td>
      			<select id="custname" name="custname"></select><span class="red_star">*</span>
            </td>
            <th>状态</th>
            <td>新创建</td>
        </tr>
        <tr>
            <th>服务请求</th>
            <td colspan="3"><textarea rows="6" name="request" cols="50"></textarea><span
                    class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>创建人</th>
            <td><input name="createby" value="${user.userName }" readonly size="20"/><span
                    class="red_star">*</span>
            </td>
            <th>创建时间</th>
            <td><input id="t1" name="createdate" readonly size="20"/><span
                    class="red_star">*</span>
            </td>
        </tr>
    </table>
    <br/>
    <table disabled class="query_form_table" id="table3">
        <tr>
            <th>分配给</th>
            <td><select disabled>
                <option>请选择...</option>
            </select> <span class="red_star">*</span>
            </td>
            <th>分配时间</th>
            <td><input id="t2" name="T18" disabled size="20"/><span
                    class="red_star">*</span>
            </td>
        </tr>
    </table>
    <br/>
    <table disabled class="query_form_table" id="table1">
        <tr>
            <th>服务处理</th>
            <td colspan="3"><textarea rows="6" disabled cols="50"></textarea><span
                    class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>处理人</th>
            <td><input name="T17" value="" disabled size="20"/><span
                    class="red_star">*</span>
            </td>
            <th>处理时间</th>
            <td><input id="t3" name="T16" disabled size="20"/><span
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
            <td><select name="D1" disabled>
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
</form>
<script>
	$.post("AjaxServlet1",function(data){
		var arr = JSON.parse(data);
		var sel=document.getElementById("custname");
		for(var i=0;i<arr.length;i++){
			sel.add(new Option(arr[i].name,arr[i].name));
		}
	});


    var date = new Date();
    var Month=(date.getMonth() + 1);
    var Day=date.getDate();
    if(Month<9){
        Month="0"+Month;
    }
    if (Day<9){
        Day="0"+Day;
    }
    document.getElementById("t1").value = date.getFullYear() + "-" + Month + "-" + Day + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
</script>
</body>
</html>
