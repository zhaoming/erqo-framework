<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/scripts/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/artDialog/artDialog.js"></script>
<link href="${ctx}/scripts/artDialog/skins/default.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="a">
aaa
</div>
<script type="text/javascript">
$('#a').click(aj);

function abc(){
art.dialog('简单愉悦的接口，强大的表现力，优雅的内部实现');
}

function aj(){

	var t = {'tv.id':1,'tv.name':'casper','tv.age':0}
	$.ajax({
		type:'POST',
		url:'${ctx}/test.action',
		data:t,
		success:function(data){
		
			alert(data.name);
		},
		dataType:'json',
	});
}

function sc(data){
	alert(data.success);
}
</script>
</body>
</html>