<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/styles/style.css" type="text/css"></link>
<title>Insert title here</title>
</head>
   <body>
       <table width="100%" border="1" align="center" cellpadding="1" cellspacing="1">
           <tr>
              <td colspan="2" width="100%" bgcolor="#80ff80">
                  <tiles:insertAttribute name="header" />
              </td>
           </tr>
           <tr>
              <td width="200" bgcolor="#ffffff">
                  <tiles:insertAttribute name="menu" />
              </td>
              <td bgcolor="#ff80c0">
                  <tiles:insertAttribute name="body" />
              </td>
           </tr>
           <tr>
              <td colspan="2" bgcolor="#00ff40">
                  <tiles:insertAttribute name="footer" />
              </td>
           </tr>
       </table>
    </body> 
</html>