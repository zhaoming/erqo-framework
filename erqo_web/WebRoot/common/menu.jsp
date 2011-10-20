<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
	<head>
		<%@ include file="/common/meta.jsp"%>
		<title>菜单</title>
		<script type="text/javascript" src="${ctx}/scripts/showmenu.js"></script>
		<link href="${ctx}/styles/style.css" rel="stylesheet" type="text/css" />
	</head>
<base target="mainFrame" />
<script type="text/javascript">
function linkTo(s) {
	if(s=='a'){
		parent.mainFrame.location = "${ctx}/pages/admin/ErqoBookTypeManage.jsp";	
	}
	if(s=='b'){
		parent.mainFrame.location = "${ctx}/pages/admin/addErqoBookType.jsp";
	}
	
}
</script>
	<body>
		<span style="cursor:pointer;" onclick="linkTo('a');">分类管理</span>
		<br/>
		<span style="cursor:pointer;" onclick="linkTo('b');">分类管理</span>
	</body>
</html>