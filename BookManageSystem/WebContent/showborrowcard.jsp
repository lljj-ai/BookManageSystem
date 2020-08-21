<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="javaBean.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有图书信息</title>
<style type="text/css">
	form{margin: 0px;}
	td{font-size: 12px;}
	h2{margin: 2px}
</style>
</head>
<body>
	 
	<table align="center" width="450" border="1" height="170" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
		<tr align="center" bgcolor="white">
			<td align="center" colspan="8">
				<h2>所有用户和借书卡信息</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td><b>用户ID</b></td>
			<td><b>借书卡号</b></td>
			<td><b>用户名</b></td>
		</tr>
			<%
				ManagerDao managerdao = new ManagerDao();
				// 获取图书信息集合
				List<Borrowcard> list = managerdao.showUserBookCard();
				// 判断集合是否有效
				if(list == null || list.size() < 1){
					out.print("没有数据！");
				}else{
					// 遍历图书集合中的数据
					for(Borrowcard borrowcard : list){
			%>
						<tr align="center" bgcolor="white">
							<td><%=borrowcard.getUserid()%></td>
							<td><%=borrowcard.getCardid()%></td>
							<td><%=borrowcard.getUsername()%></td>
						</tr>
			<%
					}
				}
			%>
	</table>

</body>
</html>