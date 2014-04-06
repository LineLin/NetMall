<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<c:forEach items="${commodityList }" var="c" varStatus="status">
		${ c.name}/${c.price }  ${status.count}<hr/>
	</c:forEach>
</body>
</html>