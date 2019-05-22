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

<title>My JSP 'product.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
	<form action="ProductServlet">
	<input type="hidden" value="some" name="action"/>
		<div class="page_title">产品查询</div>
		<div class="button_bar">
			<button type="button" class="common_button" onclick="javascript:alert('产品信息');">帮助</button>
			<button class="common_button">查询</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>名称</th>
				<td><input name="name" /></td>
				<th>型号</th>
				<td><input name="type" /></td>
				<th>批次</th>
				<td><input name="batch" /></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>型号</th>
			<th>等级/批次</th>
			<th>单位</th>
			<th>单价（元）</th>
			<th>备注</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td class="list_data_number">${p.p_id}</td>
				<td class="list_data_ltext">${p.p_name}</td>
				<td class="list_data_text">${p.p_type}</td>
				<td class="list_data_text">${p.p_batch}</td>
				<td class="list_data_text">${p.p_unit}</td>
				<td class="list_data_number">${p.p_price}</td>
				<td class="list_data_ltext">${p.p_memo}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="ProductServlet">第一页</a> <a
						href="ProductServlet?page_index=${pre }">上一页</a> <a
						href="ProductServlet?page_index=${next }">下一页</a> <a
						href="ProductServlet?page_index=${page_num }">最后一页</a> 转到<input
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
			window.location.href = "ProductServlet?page_index=" + page;
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