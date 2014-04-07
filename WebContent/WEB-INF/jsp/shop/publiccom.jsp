<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布商品</title>
</head>
<body>
		<form method="post" action="/NetMall/shop/save/commodity" enctype="multipart/form-data">
			<input type="text" name="name"/>
			<input type="file" name="file"/>
			<input type="submit"/>
		</form>
</body>
</html>