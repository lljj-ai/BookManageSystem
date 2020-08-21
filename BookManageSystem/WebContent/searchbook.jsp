<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="book" class="javaBean.Book" scope="session"/>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书查询</title>
		<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
		<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
		<meta name="author" content="yinqi">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/materialdesignicons.min.css" rel="stylesheet">
		<link href="css/style.min.css" rel="stylesheet">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/materialdesignicons.min.css" rel="stylesheet">
		<link href="css/style.min.css" rel="stylesheet">
	</head>
	<body>
		<table align="center" class="table table-bordered">
				<tr>
					<td>书号</td> <td><jsp:getProperty name="book" property="bookid"/></td>
				</tr>
				<tr>
					<td>书名</td><td><jsp:getProperty name="book" property="bookname"/></td>
				</tr>      
				<tr>
					<td>作者</td><td><jsp:getProperty name="book" property="author"/></td>
				</tr>
				<tr>
					<td>出版社</td><td><jsp:getProperty name="book" property="publisher"/></td>
				</tr>
				<tr>
					<td>现存量</td><td><jsp:getProperty name="book" property="currentcount"/></td>
				</tr>
				<tr>
					<td>库存量</td><td><jsp:getProperty name="book" property="count"/></td>
				</tr>
			</table>
	</body>
</html>