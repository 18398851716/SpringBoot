<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>星月超市</title>
<style type="text/css">
	form{margin-top:10px;}
	div{margin-top:8px;}
	.in{margin-right:10px;}
</style>
<script type="text/javascript">
//获取验证码
function getVerify(obj){
 obj.src = "./code?"+Math.random();
}
	
</script>
</head>
<body>	
    <center>
    <h1>超市管理系统登录</h1><br>
    <hr width="50%">
    <form action="login" method="post">
    	<div><label>账号：</label><input name="tel" height="30px" type="text"/><br></div>
    	<div><label>密码：</label><input name="pwd" height="30px" type="text"/><br></div>
    	<div>
	    	<label>验证码：</label>
	    	<input name="yzm" class="form-control" height="26px" type="text" id="verify_input" placeholder="请输入验证码" maxlength="4">
	    	<a href="javascript:void(0);" rel="external nofollow" title="点击更换验证码">
	   			<img id="imgVerify" src="./code" alt="更换验证码" height="30px" width="70px" onclick="getVerify(this);">
	   		</a><br></div>
    	<div><input class="in" type="submit" value="提交"><input class="in" type="reset" value="重置"></div>
    </form>
    </center>
</body>
</html>
