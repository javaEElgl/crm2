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

<title>My JSP 'linkman_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function savelink(){
		if(window.confirm("确认更改联系人信息？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>

	<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 编辑联系人</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="savelink()">保存</button>
	</div>
	<form id="form1" action="EditLinkServlet" method="post">
	<input name="cid" value="${c.ID }" style="display: none;"/>
	<input name="id" value="${l.ID }" style="display: none;"/>
	<table class="query_form_table" id="table1">
		<tr>
			<th>姓名</th>
			<td><input  name="linkname" value="${l.name }" size="20" /><span
				class="red_star">*</span>
			</td>
			<th>性别</th>
			<td><input type="radio" name="sex" id="sex" value="男" ${l.sex=="男" ?"checked":"" } />男 <input
				type="radio" name="sex" id="sex" value="女" ${l.sex=="女" ?"checked":"" }/>女</td>
		</tr>
		<tr>
			<th>职位</th>
			<td><input name="position" value="${l.postion }" size="20" /><span
				class="red_star">*</span>
			</td>
			<th>办公电话</th>
			<td><input name="tel" value="${l.tel }" size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>手机</th>
			<td><input name="phone" value="${l.phone }" size="20" />
			</td>
			<th>备注</th>
			<td><input name="memo" size="20" value="${l.memo }" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
