<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<form action="ReturnServlet" method="post" name="form2">
			<table align="center" valign="middle">
				<!--利用表格来使文本框对齐-->
				<caption>归还图书</caption>
				<br>
				<tr>
					<td>图书号：</td>
					<td><input name="bookid" class="form-control" type="text"
						id="bookid" size="30" maxlength="20" placeholder="必填"></td>
				</tr>
			</table>
			<br>
			<div class="row">
				<!--按钮使用了Bootstrap-->
				<input type="submit" class="btn btn-primary" name="return" id="return"
					onclick="check()" value="归还">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-danger" name="reset" value="重置">
				<br>
			</div>

		</form>
	</center>
	<script type="text/javascript">
            function check(){
                if(form2.bookname.value==""){   //判断用户名是否为空
                    alert("请输入图书名！");
                    form1.bookname.focus();
                    return;
            }
        }
        </script>
</body>
</html>