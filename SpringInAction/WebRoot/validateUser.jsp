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
    
    <title>用户注册</title>
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
  <!--  -->
   <sf:form method="post" modelAttribute="user" enctype="multipart/form-data" 
   			action="${pageContext.request.contextPath}/create/saveUser">
   	<fieldset>
  	<table width="100%" class="altrowstable" id="alternatecolor">
        <tr>
        	<td width="20%"><label for="account">账号:</label></td>
        	<td><sf:input path="account" size="30" id="account" /> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="password">密码:</label></td>
        	<td><sf:password path="password" size="30" id="password" /> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="realName">真实姓名:</label></td>
        	<td><sf:input path="realName" size="30" id="realName" />
        		<br/> 
        		<sf:errors path="realName" cssClass="error"></sf:errors>
        	</td>
        </tr>
        <tr>
        	<td>用户头像</td>
        	<td><input type="file" name="profilePhoto"/> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="comments">备注:</label></td>
        	<td><sf:textarea path="comments" id="comments" /> </td>
        </tr>
        <tr>
        	<td width="20%"><label for="email">邮箱:</label></td>
        	<td><sf:input path="email" id="email" /><br/>
        	<sf:errors path="email" cssClass="error"></sf:errors>
        	 </td>
        </tr>
        <tr>
        	<td>显示所有错误</td>
        	<td><!-- 使用delimiter分隔符分隔多个错误信息.如果显示所有的错误信息，只需要将path设置为* -->
        		<sf:errors path="*" delimiter="*" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
        	<td></td>
        	<td><sf:button >提&nbsp;交</sf:button></td>
        </tr>
      </table>	
      </fieldset>
  	</sf:form>
  </div>
  </body>
</html>
