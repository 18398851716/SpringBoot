<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.kgc.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<h1>主页欢迎您</h1>
	<form id="myform" action="/message.jsp" method="post">
		姓名：<span id="name">${user.name}</span><input type="submit" value="开始聊天" />
	</form>
	<script>
	    document.getElementById('myform').onsubmit=function()
	    {
	    	return fun();
	    }
	    function fun()
	    {
	    	if(document.getElementById('name').value=="")
	    		return false;
	    	return true;
	    }
	</script>
</body>
</html>