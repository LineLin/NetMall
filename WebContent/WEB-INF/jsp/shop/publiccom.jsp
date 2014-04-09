<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布商品</title>
</head>
<body>
	 ${errMsg }
		<form method="post" action="/NetMall/shop/save/commodity" enctype="multipart/form-data">
			<select name="" id="plate1">
				<option value=""></option>
			</select>
			<input type="text" name="name"/>
			<input type="file" name="photo"/>
			<input type="submit"/>
		</form>
</body>
<script type="text/javascript">
function getXMLHttp(){
	var xmlhttp ;
	if(window.XMLHttpRequest){
		xmlhttp = new window.XMLHttpRequest();
	}else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
 var xmlhttp = getXMLHttp();
 xmlhttp.open("GET","http://localhost:9000/NetMall/plate/getplates/level/1",true);
 xmlhttp.send();
 xmlhttp.onreadystatechange = function(){
	 if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		 //console.log(xmlhttp.responseText);
		 var msg = JSON.parse(xmlhttp.responseText);
		 console.log(msg);
		 var node = document.getElementById("plate1");
		 for(x in msg){
			 var newNode = document.createElement("option");
			 newNode.setAttribute("value",msg[x].id);
			 newNode.innerHTML = msg[x].name;
			 node.appendChild(newNode);
		 }
	 }
 }
</script>
</html>