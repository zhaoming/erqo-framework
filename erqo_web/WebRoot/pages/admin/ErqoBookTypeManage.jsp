<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/meta.jsp" %>
<link href="${ctx}/styles/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/dhtmlxTree/dhtmlxtree.css">
<script type="text/javascript" src="${ctx}/scripts/dhtmlxTree/dhtmlxcommon.js"></script>
<script type="text/javascript" src="${ctx}/scripts/dhtmlxTree/dhtmlxtree.js"></script>
<script language="javascript" src="${ctx}/dwr/util.js"></script>
<script language="javascript" src="${ctx}/dwr/engine.js"></script>
<script language="javascript" src="${ctx}/dwr/interface/erqoBookTypeDwr.js"></script>
<title>Insert title here</title>
<style>
.tree {
	width: 250; 
	height: 100%; 
	background-color: #f5f5f5; 
	border: 1px solid Silver; 
	overflow: auto;
}
</style>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td>
			<div id="tree_book" class="tree"></div>
		</td>
		<td>
		</td>
	</tr>
</table>
<script type="text/javascript">
	tree=new dhtmlXTreeObject(document.getElementById('tree_book'),"100%","100%",-1);
	tree.setImagePath("${ctx}/scripts/dhtmlxTree/imgs/csh_bluebooks/");
	tree.enableCheckBoxes(0); //是否开启checkbox 1：开启;0:关闭
   	tree.enableSmartXMLParsing(true);
	tree.setXMLAutoLoading("${ctx}/admin/bookTypeTree.action");
	tree.loadXML("${ctx}/admin/bookTypeTree.action?id=-1");	
	tree.setOnClickHandler(tcall)
	function tcall(id){
		if(id==0){
			
			
		} else {
			dwr.util.useLoadingMessage("loading.....");
			erqoBookTypeDwr.getErqoBookTypeById(id,view);
		}
	}
	
	function view(btype){
		alert(btype.id);
	}
</script>
</body>
</html>