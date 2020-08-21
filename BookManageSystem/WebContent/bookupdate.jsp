<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书修改界面</title>
	</head>
	<body>
		<center><h3>请输入修改后图书信息：</h3></center>
		<form action="bookupdate.do?bookid=<%=Integer.parseInt(request.getParameter("bookid"))%>" method="post">
			//<input type="hidden" name="bookid" value="<%=Integer.parseInt(request.getParameter("bookid"))%>">
			<table align="center">
				<tr>
					<td>图书名称:</td> <td><input type="text" name="bookname" ></td>
				</tr>     
				<tr>
					<td>作者名:</td><td><input type="text" name="author" ></td>
				</tr>
				<tr>
					<td>出版社:</td><td><input type="text" name="publisher" ></td>
				</tr>
				<tr>
					<td>现存量:</td><td><input type="text" name="currentcount" ></td>
				</tr>
				<tr>
					<td>库存量:</td><td><input type="text" name="count"></td>
				</tr> 
				<tr>
					<td><input type="submit" value="确定" ></td>
				    <td><input type="reset" value="重置" ></td>
				</tr>
			</table>
		</form>
		<center><a href = "managebook.jsp">返回</a></center>
	</body>
</html>