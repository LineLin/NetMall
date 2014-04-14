<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布商品</title>
</head>
<body>
		${errMsg}
		${successMsg}
		<form method="post" action="/NetMall/commodity/save" enctype="multipart/form-data">
			<select name="" id="plate1">
			</select>
			<div id="classification">
				<a onclick="createClassification();">添加分类</a>
			</div>
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
function createClassification(){
	var obj = document.getElementById("classification");
	var newnodeDiv = document.createElement("div");
	var id =  new Date().toTimeString().replace(/:/g,"").split(" ")[0];
	newnodeDiv.setAttribute("id",id);
	var cnode;
	cnode = document.createElement("input");
	cnode.setAttribute("name","count");
	cnode.setAttribute("type","text");
	cnode.setAttribute("value",1);
	cnode.setAttribute("hidden","true");
	newnodeDiv.appendChild(cnode);
	cnode = document.createElement("label");
	cnode.innerHTML = "种类：";
	newnodeDiv.appendChild(cnode);
	cnode = document.createElement("select");
	cnode.setAttribute("name","classitemId");
	DataIniter.fillClassitem(cnode);
	newnodeDiv.appendChild(cnode);
	newnodeDiv.appendChild(document.createElement("br"));
	createClassValue(newnodeDiv);
	cnode = document.createElement("a");
	cnode.setAttribute("href","#");
	cnode.innerHTML = "添加类型";
	cnode.setAttribute("onclick","createClassValue('"+id+"')");
	newnodeDiv.appendChild(cnode);
	obj.appendChild(newnodeDiv);
	
}
function createClassValue(obj){
	if(typeof obj == "string"){
		obj = document.getElementById(obj);
		var list = obj.getElementsByTagName("input");
		for(var i=0; i<list.length;i++){
			if(list[i].getAttribute("name") == "count"){
				list[i].setAttribute("value",parseInt(list[i].getAttribute("value"))+1);		
				break;
			}
		}
	}
	var node;
	node = document.createElement("div");
	obj.appendChild(node);
	node = document.createElement("label");
	node.innerHTML = '类型:';
	obj.appendChild(node);
	node = document.createElement("input");
	node.setAttribute("type","text");
	node.setAttribute("name","classValue");
	obj.appendChild(node);
	obj.appendChild(document.createElement("br"));
	node = document.createElement("label");
	node.innerHTML = '类型图片:';
	obj.appendChild(node);
	node = document.createElement("input");
	node.setAttribute("type","file");
	node.setAttribute("name","classValueImage");
	obj.appendChild(node);
}
var DataIniter = {
		plateUrl : "http://localhost:9000/NetMall/plate/getplates/level/1",
		classitemUrl : "http://localhost:9000/NetMall/commodity/getClassitem",
		plateList:{},
		classitemList:{},
		init : function(){
			 var xmlhttp = getXMLHttp();
			 xmlhttp.open("GET",DataIniter.plateUrl,true);
			 xmlhttp.send();
			 xmlhttp.onreadystatechange = function(){
				 if(xmlhttp.readyState==4 && xmlhttp.status==200){
					 DataIniter.plateList = JSON.parse(xmlhttp.responseText);
					 DataIniter.fillPlate();
				 }
			 };
			 var xmlhttp2 = getXMLHttp();
			 xmlhttp2.open("GET",DataIniter.classitemUrl,true);
			 xmlhttp2.send();
			 xmlhttp2.onreadystatechange = function(){
				 if(xmlhttp2.readyState == 4 && xmlhttp2.status == 200){
					 //console.log(xmlhttp.responseText);
					 DataIniter.classitemList = JSON.parse(xmlhttp2.responseText);
					 console.log(DataIniter.classitemList);
				 }
			 };
		},
		fillPlate: function(){
			 var node = document.getElementById("plate1");
			 for(x in DataIniter.plateList){
				 var newNode = document.createElement("option");
				 newNode.setAttribute("value",DataIniter.plateList[x].id);
				 newNode.innerHTML = DataIniter.plateList[x].name;
				 node.appendChild(newNode);
			 }
		},
		fillClassitem: function(node){
			
			for(x in DataIniter.classitemList){
				 var newNode = document.createElement("option");
				 newNode.setAttribute("value",DataIniter.classitemList[x].id);
				 newNode.innerHTML = DataIniter.classitemList[x].name;
				 node.appendChild(newNode);
			 }
		}
};
DataIniter.init();
</script>
</html>