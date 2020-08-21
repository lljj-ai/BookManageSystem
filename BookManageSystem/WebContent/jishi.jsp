<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <input type="submit" value="倒计时" id="button"
      onClick="timedMsg()">
      <script type="text/javascript">
   var c=5;
    var t;
    function timedMsg()
    {
     document.getElementById('button').value="借书时间"+c+"秒";
     document.getElementById('button').disabled=true;
     if(c==0){
      clearTimeout(t);
      alert("您好，该还书了！");
      window.location.href="borrow.jsp";//为跳转地址
      }else{
        t=setTimeout('timedMsg()',1000);
      }
      c--;
      }
      </script>
     </body>
     </html>