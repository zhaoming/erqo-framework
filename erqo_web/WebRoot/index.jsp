<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="author" content=""/>
<title>内容管理中心</title>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/showmenu.js"></script>
</head>
<body style="margin: 0px; padding:0px;" scroll="no">
<table border="0" cellPadding="0" cellSpacing="0" height="100%" width="100%" style="table-layout: fixed;">
	<tr>
		<td width="200" id="menu">
			<iframe frameborder="0" id="leftFrame" name="leftFrame" src="${ctx}/common/menu.jsp" scrolling="auto" style="height: 100%; visibility: inherit; width: 100%; z-index: 1;overflow: ;">
			</iframe>
		</td>
		<td width="8" bgcolor="#eeeeee" id="switch" onClick="menuSwitch();" style="font-size:11px; font-weight:bold; color:#333; cursor:pointer;" title="收起菜单">&lt;
		</td>
		<td>
			<iframe frameborder="0" id="mainFrame" name="mainFrame" src="${ctx}/mainMenu.jsp" scrolling="auto" style="height: 100%; visibility: inherit; width: 100%; z-index: 1;overflow: auto;">
			</iframe>
		</td>
	</tr>
</table>
</body>
</html>
