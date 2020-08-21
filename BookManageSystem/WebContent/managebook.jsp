<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="javaBean.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>所有图书信息</title>
	<style> /*CSS样式*/
		td {
			color: antiquewhite;
		}
		
		caption, h1 {
			font-size: 44px;
			color:rgb(26, 100, 196);
		}
	</style>
</head>
<body background="d.jpg">
	 
	<form action = "booksearch.do" method = "post" name="form1">
		<center>
			请输入一个书号:<br>
			<table>
				<tr><td><input type = "text" name = "bookid" ></td></tr>
				<tr><td><input type = "submit" value = "查询" ></td></tr>
			</table>
		</center>
	</form>
	
	<table align="center" valign="middle" width = "500" border = "1">
		<tr align="center" bgcolor="white">
			<td align="center" colspan="8">
				<h2>所有图书信息</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td><b>图书ID</b></td>
			<td><b>图书名称</b></td>
			<td><b>作者</b></td>
			<td><b>出版商</b></td>
			<td><b>现存数量</b></td>
			<td><b>库存数量</b></td>
			<td><b>修改</b></td>
			<td><b>删除</b></td>
		</tr>
			<%
				BookDao bookdao = new BookDao();
				// 获取图书信息集合
				List<Book> list = bookdao.showBook();
				// 判断集合是否有效
				if(list == null || list.size() < 1){
					out.print("没有数据！");
				}else{
					// 遍历图书集合中的数据
					for(Book book : list){
			%>
						<tr align="center" bgcolor="white">
							<td><%=book.getBookid()%></td>
							<td><%=book.getBookname()%></td>
							<td><%=book.getAuthor()%></td>
							<td><%=book.getPublisher()%></td>
							<td><%=book.getCurrentcount()%></td>
							<td><%=book.getCount()%></td>
							<td>
								<form action="bookupdate.jsp?bookid=<%=book.getBookid()%>" method="post" >
									<input type="hidden" name="bookid" value="<%=book.getBookid()%>">
									<input type="submit" value="点击修改">
								</form>
							</td>
							<td>
								<form action="bookdelete.do?bookid=<%=book.getBookid()%>" method="post" >
									<input type="hidden" name="bookid" value="<%=book.getBookid()%>">
									<input type="submit" value="删除">
								</form>
							</td>
						</tr>
			<%
					}
				}
			%>
			<tr align="center" bgcolor="#e1ffc1">
				<td align="center" colspan="8">
					<a href="bookinsert.jsp">录入一本新的图书</a>
				</td>
			</tr>
	</table>

</body>
</html>