<%@ page import="java.util.List" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javaBean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>图书管理系统</title>
 <body background="d.jpg">	<!--设置背景图片-->
   <style> /*CSS样式*/
	td {
		color: antiquewhite;
	}
	
	caption, h1 {
		font-size: 44px;
		color:rgb(26, 100, 196);
	}
	</style>
	<center>
		<h1>图书管理系统</h1>
		<hr>
		<form action="" method="post" name="form1">
			<table align="center" valign="middle"  width = "1000" border = "1">
			    <tr>
			        <td align = "center" colspan = "7">
			            <h2>已借图书</h2>
				    </td>
				</tr>
				<tr>
			        <td>用户ID</td>
			        <td>图书ID</td>				
					<td>图书名称</td>
					<td>作者</td>
					<td>出版社</td>
					<td>借书时间</td>
					<td>还书时间</td>
				</tr>
				<%
				BookDao bookdao = new BookDao();
				// 获取图书信息集合
				List<Borrow> list = bookdao.showBorrow();
				// 判断集合是否有效
				if(list == null || list.size() < 1){
					out.print("没有数据！");
				}else{
					// 遍历图书集合中的数据
					for(Borrow book : list){
			%>
						<tr align="center" >
							<td><%=book.getUserid()%></td>
							<td><%=book.getBookid()%></td>
							<td><%=book.getBookname()%></td>
							<td><%=book.getAuthor()%></td>
							<td><%=book.getPublisher()%></td>
							<td><%=book.getBorrowtime()%></td>
							<td><%=book.getReturntime()%></td>
						</tr>	
<% 
}}
%>	
			</table>
			<br>
		</form>
	</center>
	</body>
</html>