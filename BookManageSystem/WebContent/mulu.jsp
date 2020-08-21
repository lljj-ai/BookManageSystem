<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>my web</title>
</head>
<style> /*CSS样式*/
	h2 {
		font-size:40px;
		color:rgb(26, 100, 196);
	}
	a {
	    font-size:22px;
	    color:rgb(26, 100, 196);
	 }
	</style>
<body background="d.jpg">
	<h2>目录：</h2>
	<br>
	<a href="borrowcard.jsp" target="content">办理借书卡</a>
	<br>
	<a href="borrow.jsp" target="content">借阅图书</a>
	<br>
	<a href="displayborrow.jsp" target="content">已借图书</a>
	<br>
	<a href="return.jsp" target="content">归还图书</a>
	<br>
	<a href="displaybook.jsp" target="content">显示图书库</a>
</body>
</html>