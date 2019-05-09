<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script type="text/javascript">
function ss() {
    document.getElementById("img").src = "ValidateCode.jpg?" + Math.random();       
}
</script>
</head>
<body>
	<font color="red">${msg}</font><br/>
	<form action="/login" method="post" enctype="application/x-www-form-urlencoded">
		<sapn>姓&nbsp;&nbsp;&nbsp;名：</sapn>
			<input type="text" name="uid" placeholder="账户"/>
			<br/>
			<br/>
		<span>密&nbsp;&nbsp;&nbsp;码：</span>
			<input type="password" name="pwd" placeholder="密码"/>
			<br/>
			<p>
				<span>验&nbsp;证&nbsp;码: </span>
				<input type="text" name="yzm"/>
				<img id="img" src="ValidateCode.jpg" onclick="ss()"/>
			</p>
			<input type="submit" value="登录"/>
	</form>
</body>
</html>