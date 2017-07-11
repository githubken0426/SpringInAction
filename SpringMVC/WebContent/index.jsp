<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% String basePath = application.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function submit(){
		$.ajax({
			url:"http://localhost:8089/SpringMVC/v1/open/json/find",
			type:"POST",
			contentType:"application/json;charset=utf-8",
			dataType:'json',
			data:JSON.stringify({'id':'S001','ownerId':'A1002','nickname':'abc'}),
			success:function(data){
				console.log(data);
			}
		});
	}
</script>
</head>
<body>
	<!-- <a href="javascript:void(0);" onclick="submit()">提交</a> -->
	<div style="margin-top:150px;">
		${mode}
		${request}
		${session}
		${ModelAndView}
		<p>list页面便利</p>
		<c:forEach  items="${listValue}" var="ele" varStatus="index">
			<li>下标：${index.index},元素：${ele}</li>
		</c:forEach>
	</div>
</body>
</html>