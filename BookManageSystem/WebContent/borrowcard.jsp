<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<!--引用流行的响应式框架  Bootstrap  来美化它-->

<html>
<title>图书管理系统</title>
	<body background="d.jpg">
		<!--设置背景图片-->
		<style> /*CSS样式*/
	td {
		color: antiquewhite;
	}
	
	caption, h1 {
		font-size: 44px;
		color: rgb(26, 100, 196);;
	}
</style>
	<center>
		<h1>图书管理系统</h1>
		<hr color="#FF6433">
		<form action="BorrowCard" method="post" name="form1">
			<table align="center" valign="middle">
				<!--利用表格来使文本框对齐-->
				<caption>办理借书卡</caption>
				<br>
				<tr>
					<td style="color: antiquewhite">用户账号：</td>
					<!--利用空格来使文字对齐---->
					<td><input name="userid" class="form-control" type="text"
						id="userid" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input name="username" class="form-control" type="text"
						id="username" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
			</table>
			<br>

			<div class="row">
				<!--按钮使用了Bootstrap-->
				<input type="submit" class="btn btn-primary" name="submit"
					onclick="check()" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-danger" name="reset" value="重置">
				<br>
			</div>

		</form>
	</center>
	<script type="text/javascript">
            function check(){
                if(form1.username.value==""){   //判断用户名是否为空
                    alert("请输入用户账号！");
                    form1.username.focus();
                    return;
                }else if(form1.userid.value==""){  //判断密码是否为空
                    alert("请输入用户名！");
                    form1.pwd.focus();
                    return;
            }
        }
        </script>
</body>
</html>