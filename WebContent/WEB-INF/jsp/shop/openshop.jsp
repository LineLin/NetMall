<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开店申请</title>
</head>
<body>
	<div>
		<form action="/NetMall/shop/save" method="POST">
			<div>
				<label for="shopName">店名：</label>
				<input type="text" id="shopName" name="name" 
				placeholder="请输入商店名称，申请成功后不能修改"/>
			</div>
			<div>
				<input type="submit" value="提交"/>
			</div>
		</form>
	</div>
</body>
</html>