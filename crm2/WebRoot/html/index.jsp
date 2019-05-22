<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <frameset rows="10%,*,10%" frameborder="NO" noresize border="3" framespacing="0"> 
 <frame name="topFrame" frameborder="NO" scrolling="NO" noresize border="3" src="/crm2/html/top.jsp" >
 <frame name="mainFrame" noresize border="3" src="/crm2/html/index-ec.jsp">
 <frame src="/crm2/html/footer.jsp" name="top1Frame" frameborder="NO" scrolling="NO" noresize  marginwidth="0" marginheight="0" border="3" >
 </frameset>
 
</html>
