<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<!--引用流行的响应式框架  Bootstrap  来美化它-->

<html>
    <title >图书管理系统</title>
    <body background="d.jpg">  <!--设置背景图片-->
        <style>    /*CSS样式*/
            td{
                color:rgb(245, 245, 230);
            }
            caption,h1{
                font-size: 44px;
                color:rgb(26, 100, 196);
            } 
        </style>
        <center>
        <h1>图书管理系统</h1>
        <form action="" method="post" name="form1">
           <table align="center" valign="middle">     <!--利用表格来使文本框对齐-->
                 <caption> 请输入图书信息 </caption>
                 <hr color="#FF6433">
	             <tr>  <!--利用空格来使文字对齐---->
	                <td>图书名称：</td>
	                <td><input name="bookname" class="form-control" type="text" 
	                    id="bookname" size="20" maxlength="20" placeholder="必填"></td>
	             </tr>
	             <tr>
	                <td>作者名：</td>
	                <td><input name="author" class="form-control" type="text" 
	                    id="author" size="20" maxlength="20" placeholder="必填"></td>
	             </tr>
	             <tr>
	                <td>出版社：</td>
	                <td><input name="publisher" class="form-control" type="text" 
	                    id="pbulisher" size="20" maxlength="20" placeholder="必填"></td>
	             </tr>
	             <tr>
	                <td>现存数量：</td>
	                <td><input name="currentcount" class="form-control" type="text" 
	                    id="currentcount" size="20" maxlength="20" placeholder="必填"></td>
	             </tr>
	             <tr>
	                <td>库存数量：</td>
	                <td><input name="count" class="form-control" type="text" 
	                    id="count" size="20" maxlength="20" placeholder="必填"></td>
	             </tr>
             
        	</table><br>
         
            <div class="row">
                <!--按钮使用了Bootstrap-->
                    <input type="submit" class="btn btn-primary" name="submit"  onclick="check()" value="确定">&nbsp;&nbsp;&nbsp;
                    <input type="reset" class="btn btn-danger" name="reset" value="重置"> 
            </div>
        
        </form><br>
        <a href = "managebook.jsp">返回</a>
        </center>
        <script type="text/javascript">
            function check(){
                if(form1.bookid.value==""){   //判断用户名是否为空
                    alert("请输入图书编号！");
                    form1.bookid.focus();
                    return;
                }else if(form1.bookname.value==""){  //判断密码是否为空
                    alert("请输入图书名称！");
                    form1.bookname.focus();
                    return;
                }else if(form1.bookcount.value==""){  //判断密码是否为空
                    alert("请输入图书数量！");
                    form1.bookcount.focus();
                    return;
                }else if(form1.author.value==""){  //判断密码是否为空
                    alert("请输入作者！");
                    form1.author.focus();
                    return;
                }else if(form1.publisher.value==""){  //判断密码是否为空
                    alert("请输入出版社！");
                    form1.publisher.focus();
                    return;
                }
            }
        </script>
    </body>
</html>