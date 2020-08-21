<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<!--引用流行的响应式框架  Bootstrap  来美化它-->

<html>
<title>中北大学综合实训平台</title>
 <body background="d.jpg">	<!--设置背景图片-->
   <style> /*CSS样式*/
	td {
		color: antiquewhite;
	}
	
	caption, h1 {
		font-size: 44px;
		color: rgb(37, 134, 224);
	}
	</style>
	<center>
		<h1>中北大学综合实训平台</h1>
		<form action="RegisterUserServlet" method="post" name="form1">
			<table align="center" valign="middle">
				<!--利用表格来使文本框对齐-->
				<caption>用户注册</caption>
				<br>
				<hr color="#FF6433">
				<tr>
					<td style="color: antiquewhite">用&nbsp&nbsp户&nbsp名：</td>
					<!--利用空格来使文字对齐---->
					<td><input name="username" class="form-control" type="text"
						id="UserName4" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
					<td>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</td>
					<td><input name="password" class="form-control" type="password"
						id="pwd" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
				<tr>
				<td>联系方式：</td>
				<td><input name="phonenum" class="form-control" type="text"
					id="text" size="20" maxlength="20" placeholder="必填"></td>
				</tr>
			</table>
			<br>

			<div class="row">
				<!--按钮使用了Bootstrap-->
				<input type="submit" class="btn btn-primary" name="submit"
					onclick="check()" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-danger" name="reset" value="重置">
			</div>

		</form>
	</center>
	<script type="text/javascript">
            function check(){
                if(form1.username.value==""){   //判断用户名是否为空
                    alert("请输入用户名！");
                    form1.username.focus();
                    return;
                }else if(form1.pwd.value==""){  //判断密码是否为空
                    alert("请输入密码！");
                    form1.pwd.focus();
                    return;
                }else if(form1.number.value==""){  //判断密码是否为空
                    alert("请输入联系方式！");
                    form1.number.focus();
                    return;
            }
        }
        </script>
</body>
</html>