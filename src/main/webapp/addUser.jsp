<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
<style type="text/css">

@keyframes myfirst
{
    0%   {background:url("../img/1.jpg");}
    34%  {background:url("../img/2.jpg");}
    67%  {background:url("../img/3.jpg");}
    100% {background:url("../img/1.jpg");}
}
.form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
/*阴影*/
.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
input[type="text"],input[type="password"]{padding-left:26px;}
.checkbox{padding-left:21px;}</style>
</head>
<body>

    <form action="${pageContext.request.contextPath }/user/addUser" method="post">
        <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">注册</h3>
                <div class="col-md-9">
                    <div class="form-group">
      
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="您的泊革" id="username" name="userName" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group col-md-offset-9">
                            
                    </div>
                    <div class="form-group col-md-offset-9">
                      
                        <button type="submit" class="btn btn-success pull-right" name="submit">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </div></form>
</body>
</html>
