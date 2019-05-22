<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function delcust(id){
		$.post("AjaxDelCustServlet",{"id":id},function(data){
			if(data=="yes"){
				if(confirm("确认删除此客户？")){
					window.location.href="DeleteCustServlet?id="+id;
				}else{
					return ;
				}
			}else{
				alert("与此客户存在交易情况，不允许删除！");
				return ;
			}
		});
	}
</script>
</head>
<body>
	<div class="page_title">客户信息管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('显示所有的客户信息')">帮助</button>
		<button class="common_button"
			onclick="to('AddCustServlet?action=before');">新建</button>
		<button class="common_button" onclick="javascript:document.getElementById('form1').submit();">查询</button>
	</div>
	<form id="form1" action="AllCustServlet" >
	<input type="hidden" name="action" value="some" />
	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td><input id="no" name="no"/></td>
			<th>名称</th>
			<td><input name="cname" id="cname"/></td>
			<th>地区</th>
			<td><select name="region" id="region">
					<option value="">全部</option>
					<c:forEach items="${alist}" var="a">
						<option value="${a.d_item }">${a.d_item }</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<th>客户经理</th>
			<td><input id="manager" name="manager"/></td>
			<th>客户等级</th>
			<td><select id="level" name="level">
					<option value="">全部</option>
					<c:forEach items="${glist}" var="g">
						<option value="${g.d_item }">${g.d_item }</option>
					</c:forEach>
			</select>
			</td>
			<th></th>
			<td></td>
		</tr>
	</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>序号</th>
			<th>客户编号</th>
			<th>名称</th>
			<th>地区</th>
			<th>客户经理</th>
			<th>客户等级</th>
			<th>操作</th>
		</tr>
		<% int i=((Integer)(request.getAttribute("page_index"))-1)*(Integer)(request.getAttribute("row_num")); %>
		<c:forEach items="${list }" var="l">
			<tr>
				<td class="list_data_number"><%=++i%></td>
				<td class="list_data_text">${l.no }</td>
				<td class="list_data_ltext">${l.name }</td>
				<td class="list_data_text">${l.region }</td>
				<td class="list_data_text">${l.manager }</td>
				<td class="list_data_text">${l.level }</td>
				<td class="list_data_op"><img
					onclick="to('EditCustServlet?action=before&id=${l.ID}');"
					title="编辑" src="images/bt_edit.gif" class="op_button" /> <img
					onclick="to('AllLinkServlet?id=${l.ID}');" title="联系人"
					src="images/bt_linkman.gif" class="op_button" /> <img
					onclick="to('AllActivitiesServlet?id=${l.ID}');" title="交往记录"
					src="images/bt_acti.gif" class="op_button" /> <img
					onclick="to('AllOrdersServlet?id=${l.ID}');" title="历史订单"
					src="images/bt_orders.gif" class="op_button" /> <%
 	if(((ArrayList<Integer>)request.getAttribute("slist")).get(i-1)==1){
 %> <img title="流失管理" src="images/bt_relay.gif" class="op_button"
					onclick="warn('${l.ID}')" /> <%
 	}
 %>
 		<img onclick="delcust('${l.ID}');" 
 		title="删除" src="images/bt_del.gif" class="op_button" /></td>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="AllCustServlet">第一页</a> <a
						href="AllCustServlet?page_index=${pre }">上一页</a> <a
						href="AllCustServlet?page_index=${next }">下一页</a> <a
						href="AllCustServlet?page_index=${page_num }">最后一页</a> 转到<input
						size="2" value="${page_index }" id="p1" />页
					<button width="20" onclick="gopage('${page_num}')">GO</button>
				</div>
			</th>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function gopage(num) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "AllCustServlet?page_index=" + page;
		}
	}
	function warn(id) {
		if(confirm("确认跳转流管理？")){
			window.location.href = "RelayServlet1?id=" + id;
		}else{
			return;
		}
	}
</script>
</html>
