<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
	<script type="text/javascript" src="<%=basePath%>resources/js/table.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/global.css">
	
	<script type="text/javascript">
		window.onload=function(){
	        altRows('alternatecolor');
	    }
	</script>
  </head>
  	
  <body>
  <div class="container">
  <!-- 测试默认登录页： -->
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
  
   <form method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
  	<table width="100%" class="altrowstable" id="alternatecolor">
        <tr>
        	<td width="20%"><label for="username">账号:</label></td>
        	<td><input type="text" name="j_username" size="30" id="username" /> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="password">密码:</label></td>
        	<td><input type="password" name="j_password" size="30" id="password" /> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="remeberMe">记住我:</label></td>
        	<td><input type="checkbox" name="_spring_security_remember_me" size="30" id="remeberMe" /> </td>
        </tr>
        <tr>
        	<td></td>
        	<td><input type="submit" name="submit" value="提交"/></td>
        </tr>
      </table>	
  	</form>
  </div>
  </body>
</html>
