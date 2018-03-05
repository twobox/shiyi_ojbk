<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="direction">
		<!-- 本页开发方向 -->
		<h1>README:</h1>
		<p>用户的登陆界面</p>
		
		<h1>shiyi_ojbk V1.0 要求：</h1>
		<p>①构建好登陆界面，实现登陆功能
		</p>
	</div>
	<!-- 分割线 -->
	<div id="apDiv1">
	  <form id="form1" name="form1" method="post" action="UserLogin">
	    <p align="center">用户 登陆</p>
	    <p align="center">
	      <label for="textfield">用户名：</label>
	      <input type="text" name="textid" id="textfield" />
	    </p>
	    <p align="center">
	      <label for="textfield2">密&nbsp;&nbsp;&nbsp;码：</label>
	      <input type="password" name="textPassword" id="textfield2" />
	    </p>
	    <p align="center">
	      <input type="submit" name="button" id="button" value="登录" />
	    </p>
	  </form>
	</div>
</body>
</html>