<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'dict.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
	<form action="DictServlet">
	<input type="hidden" value="some" name="action">
		<div class="page_title">数据字典管理</div>
		<div class="button_bar">
			<button type="button" class="common_button"
				onclick="to('html/~basd/dict_add.jsp');">新建</button>
			<button class="common_button">查询</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>类别</th>
				<td><input name="type" /></td>
				<th>条目</th>
				<td><input name="item" /></td>
				<th>值</th>
				<td><input name="value" /></td>
			</tr>
		</table>
		</form>
		<br />
		<table class="data_list_table">
			<tr>
				<th>编号</th>
				<th>类别</th>
				<th>条目</th>
				<th>值</th>
				<th>是否可编辑</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="d">
				<tr>
					<td class="list_data_number">${d.d_id}</td>
					<td class="list_data_ltext">${d.d_type}</td>
					<td class="list_data_text">${d.d_item}</td>
					<td class="list_data_text">${d.d_value}</td>
					<td class="list_data_text">${d.p_isedit}</td>
					<td class="list_data_op"><c:if test="${d.p_isedit=='是'}">
							<img
								onclick="to('html/~basd/dict_edit.jsp?id=${d.d_id}&type=${d.d_type}&item=${d.d_item}&value=${d.d_value}');"
								title="编辑" src="images/bt_edit.gif" class="op_button" />
							<img onclick="warn('${d.d_id}')" title="删除"
								src="images/bt_del.gif" class="op_button" />
						</c:if> <c:if test="${d.p_isedit=='否'}">
							<img onclick="warn('${d.d_id}')" title="删除"
								src="images/bt_del.gif" class="op_button" />
						</c:if></td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="6" class="pager">
					<div class="pager">
						共${total}条记录 每页<input value="${row_num }" size="2"
							readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
						}页 <a href="DictServlet">第一页</a> <a
							href="DictServlet?page_index=${pre }">上一页</a> <a
							href="DictServlet?page_index=${next }">下一页</a> <a
							href="DictServlet?page_index=${page_num }">最后一页</a> 转到<input
							size="2" value="${page_index }" id="p1" />页
						<button width="20" onclick="gopage('${page_num}')">GO</button>
					</div></th>
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
			window.location.href = "DictServlet?page_index="+page;
		}
	}
	function warn(id) {
		if (confirm("确认删除此信息？")) {
			window.location.href = "DeleteDictServlet?id=" + id;
		} else {
			return;
		}
	}
</script>
</html>