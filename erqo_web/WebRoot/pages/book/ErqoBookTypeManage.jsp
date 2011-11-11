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
		<td valign="top">
			<table border="1" width="600" align="left">
				<tr colspan="3"><td><input type="text" name="b_id" id="b_id"/><input type="text" name="b_layer" id="b_layer"/></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="b_name" id="b_name"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" value="add" onclick="add();"/></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script type="text/javascript">
	tree=new dhtmlXTreeObject(document.getElementById('tree_book'),"100%","100%",-1);
	tree.setImagePath("${ctx}/scripts/dhtmlxTree/imgs/csh_bluebooks/");
	tree.enableCheckBoxes(0); //是否开启checkbox 1：开启;0:关闭
   	tree.enableSmartXMLParsing(true);
	tree.setXMLAutoLoading("${ctx}/bookManage/bookTypeTree.action");
	tree.loadXML("${ctx}/bookManage/bookTypeTree.action?id=-1");	
	tree.setOnClickHandler(tcall)
	function tcall(id){
		$('b_id').value='';
		$('b_name').value='';
		$('b_layer').value='';
		if(id=='0'){
			$('b_id').value=id;
			$('b_layer').value=0;
		} else {
			dwr.util.useLoadingMessage("loading.....");
			erqoBookTypeDwr.getErqoBookTypeById(id,view);
		}
	}
	
	function view(btype){
		$('b_id').value=btype.id;
		$('b_name').value=btype.name;
		$('b_layer').value=btype.layer;
	}
	
	function add(){
		if(tree.getSelectedItemId()!=null && tree.getSelectedItemId()!=''){
			var name_item = $('b_name').value;
			var id_item = $('b_id').value;
			var layer_item = $('b_layer').value;
			
			var t = {name:name_item,state:1,parent_id:id_item,layer:layer_item+1}
			
			erqoBookTypeDwr.addErqoBookType(t,function t3(v){
							if(v.id!=0 && v.id!=null){
								tree.insertNewItem(id_item,v.id,name_item); 
								tree.setUserData(v.id,'code',v.code);
								tree.setUserData(v.id,'layer',v.layer);
								alert("添加操作成功!!!");
							}else{
								alert('添加操作失败,名称或编码已存在!!!');
							}
						});
			
		} else {
			alert('请选择相应节点!!!');
			return;
		}	
	}
</script>
</body>
</html>