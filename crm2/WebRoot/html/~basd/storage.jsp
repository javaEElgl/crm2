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

<title>My JSP 'storage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
	<form action="StorageServlet">
		<input type="hidden" name="action" value="some">
		<div class="page_title">产品查询</div>
		<div class="button_bar">
			<button type="button" class="common_button" onclick="javascript:alert('库存信息');">帮助</button>
			<button class="common_button">查询</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>产品</th>
				<td><input name="product" /></td>
				<th>仓库</th>
				<td><input name="storagename" /></td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
		</table>
		</form>
		<br />
		<table class="data_list_table">
			<tr>
				<th>序号</th>
				<th>产品</th>
				<th>仓库</th>
				<th>货位</th>
				<th>件数</th>
				<th>备注</th>
			</tr>
			<c:forEach items="${list }" var="s">
				<tr>
					<td class="list_data_number">${s.p_id}</td>
					<td class="list_data_ltext">${s.p_name}</td>
					<td class="list_data_ltext">${s.p_storagename}</td>
					<td class="list_data_text">${s.p_ware}</td>
					<td class="list_data_number">${s.p_count}</td>
					<td class="list_data_ltext">${s.p_memo}</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="100" class="pager">
				<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="StorageServlet">第一页</a> <a
						href="StorageServlet?page_index=${pre }">上一页</a> <a
						href="StorageServlet?page_index=${next }">下一页</a> <a
						href="StorageServlet?page_index=${page_num }">最后一页</a> 转到<input
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
			window.location.href = "StorageServlet?page_index=" + page;
		}
	}
</script>
</html>
