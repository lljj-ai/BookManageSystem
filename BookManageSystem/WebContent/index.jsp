<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
 
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<!--引用流行的响应式框架  Bootstrap  来美化它-->

<html>
    <title >图书管理系统</title>
    <body background="d.jpg">  <!--设置背景图片-->
    <jsp:include page="header.jsp"></jsp:include>
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
        <h1>中北大学</h1>
        <form action="docheck" method="post" name="form1">
           <table align="center" valign="middle">     <!--利用表格来使文本框对齐-->
               <caption>账户登录</caption>
               <hr color="#FF6433">
             <tr>
                <td>用户帐号：</td> <!--利用空格来使文字对齐---->
                <td><input name="userid" class="form-control" type="text"
                    id="UserID4" maxlength="20" placeholder="必填"></td>
            </tr>
             <tr>
                <td>密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                <td><input name="password" class="form-control" type="password" 
                    id="password" size="20" maxlength="20" placeholder="必填"></td>
             </tr>
             <tr>
             <td>身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：</td>
             <td>
                 <select name="select" class="form-control" id="id">
                     <option value="user">用户</option>
                     <option value="manager">管理员</option>
                 </select>
            </td>  
        </table><br>
         
            <div class="row">
                <!--按钮使用了Bootstrap-->
                    <input type="submit" class="btn btn-primary" name="submit"  onclick="check()" value="登录">&nbsp;&nbsp;&nbsp;
                    <input type="reset" class="btn btn-danger" name="reset" value="重置"> 
            </div>
        
        </form><br>
              点击此处<a href="userregister.jsp">注册</a>
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
            }
        }
        </script>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

<!-- http://localhost:8080/BookManageSystem/index.jsp -->