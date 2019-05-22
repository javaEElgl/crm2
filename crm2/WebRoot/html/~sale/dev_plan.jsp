<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>My JSP 'dev_plan.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
		function saveplan(pid,sid){
			var todo=document.getElementById("todo"+pid).value;
			if(todo==""){
				alert("计划项不能为空！");
				return;
			}
			if(confirm("确认更改计划内容？")){
				window.location.href="SavePlanServlet?id="+pid+"&sid="+sid+"&todo="+todo;
			}else{
				return;
			}
		}
		function delplan(pid,sid){
			if(confirm("确认删除此计划？")){
				window.location.href="DeletePlanServlet?id="+pid+"&sid="+sid;
			}else{
				return;
			}
		}
		function showtime(){
			var date=new Date();
			document.getElementById("t1").value=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		}
		function executeplan(id,status){
			 if(status=='2'){
				alert('该任务还没有制定计划');
			}
			 else{
				window.location.href="DevExecuteServlet?id="+id;
			}
		}
</script>
</head>
<body>
	<div class="page_title">客户开发计划 &gt; 制定计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('制定客户开发计划');" type="button">帮助</button>
		<button class="common_button" onclick="executeplan('${sale.id}','${sale.status }');">执行计划</button>
		<button class="common_button" onclick="to('DevServlet')" type="button">返回</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td></td>
			<th>机会来源</th>
			<td>${sale.source }</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${sale.name}</td>
			<th>成功机率（%）</th>
			<td>&nbsp;${sale.rate }</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${sale.title }</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${sale.contact }</td>
			<th>联系人电话</th>
			<td>${sale.phone}</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${sale.desc }</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${sale.createName}</td>
			<th>创建时间</th>
			<td>${sale.createTime }</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${sale.dueName }</td>
			<th>指派时间</th>
			<td>${sale.dueTime }</td>
		</tr>
	</table>
	<br/>
	<table class="data_list_table" id="table1">
		<tr>
			<th width="150px">日期</th>
			<th height="31">计划项</th>
		</tr>
			<c:forEach items="${sale.plan }" var="p">
			<tr>
				<td class="list_data_text" height="24">${p.date }</td>
				<td class="list_data_ltext" height="24"><input size="50"
				value="${p.todo }" id="todo${p.id }"/>
				<button class="common_button" onclick="saveplan('${p.id}','${sale.id }');" type="button">保存</button>
				<button class="common_button" onclick="delplan('${p.id}','${sale.id }')">删除</button>
				</td>
			</tr>
			</c:forEach>
	</table>
	
	<div class="button_bar">
		<button class="common_button" type="button" onclick="savp()">保存</button>
	</div>
	<form action="AddPlanServlet" method="post" id="form2">
	<input type="text" value="${sale.id }" name="id" style="display: none;"/>
	<table class="query_form_table" id="table2">
		<tr>
			<th>日期</th>
			<td><input name="date" id="t1" type="date"/><span class="red_star">*</span>
			</td>
			<th>计划项</th>
			<td><input size="50" name="todo" id="todo" /><span class="red_star">*</span>
			</td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
	function savp(){
		var todo=document.getElementById("todo").value;
		if(todo==""){
			alert("计划项不能为空！");
			return;
		}
		if(confirm("确认进行此计划？")){
			document.getElementById("form2").submit();
		}else{
			return ;
		}
	}
</script>
</html>
