<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="managerregister.do" method="post" align="center">
			<table>
	       		<tr>
	        		<td>姓名:</td>
	        		<td><input type="text" name="managername"></td>
	        	</tr>
	        	<tr>
	        		<td>密码:</td>
	        		<td><input type="password" name="password"></td>
	        	</tr>
	        	<tr>
	        		<td>联系方式:</td>
	        		<td><input type="text" name="phonenum"></td>
	        	</tr>
	        	<tr>
	        		<td><input type="submit" value="提交"></td>
	        		<td><input type="reset" value="重置"></td>
	        	</tr>
	        	<tr><td><a href="index.jsp">点击此处返回</a></td></tr>
       		</table>     
		</form>
	</body>
</html>