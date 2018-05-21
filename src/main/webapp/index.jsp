<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login" method="post">
	userName:<input type="text" name="userName" value="${user.userName }"/><br/>
	password:<input type="password" name="password" value="${user.password }"><br/>
	<input type="submit" value="login"/><font color="red">${errorMsg }</font>
</form>


<div>
   <p class="small">评论区</p>
   <textarea id="texthelpblock" class="form-control" rows="3">
   </textarea>
   <p class="text-right"><button type="button" class="btn btn-primary btn-xs">提交评论</button></p>
</div>
</body>
</html>
  