<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<!--引用流行的响应式框架  Bootstrap  来美化它-->
<html>
	<title>表单</title>
	<body background="d.jpg">
		<!--设置背景图片-->
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
		<hr color="#FF6433">
		<form action="BorrowServlet" method="post" name="form1">
			<table align="center" valign="middle">
				<!--利用表格来使文本框对齐-->
				<caption>借阅图书</caption>
				<br>
				<tr>
					<td>借阅者帐号：</td>
					<td><input name="userid" class="form-control" type="text"
						id="userid" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
				<tr>
					<td>借阅图书账号：</td>
					<td><input name="bookid" class="form-control" type="text"
						id="bookid" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
					<td>图书名：</td>
					<td><input name="bookname" class="form-control" type="text"
						id="bookname" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input name="author" class="form-control" type="text"
						id="author" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input name="publisher" class="form-control" type="text"
						id="publisher" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
			</table>
			<br>

			<div class="row">
				<!--按钮使用了Bootstrap-->
				<input type="submit" class="btn btn-primary" name="borrow" 
					onclick="check()"  value="借阅">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-danger" name="reset" value="重置">
				<br>
			</div>

		</form>
	</center>
	<script type="text/javascript">
            function check(){
                if(form1.userid.value==""){   //判断用户名是否为空
                    alert("请输入用户账号！");
                    form1.userid.focus();
                    return;
              }else if(form1.bookid.value==""){
	            	alert("请输入图书号！");
	                form1.bookid.focus();
	                return;
              }else if(form1.bookname.value==""){
	            	alert("请输入图书名！");
	                form1.bookname.focus();
	                return;
              }else if(form1.author.value==""){
	            	alert("请输入作者！");
	                form1.author.focus();
	                return;
              }else if(form1.publisher.value==""){
	            	alert("请输入出版社！");
	                form1.publisher.focus();
	                return;
              }
            }
        </script>
</body>
</html>