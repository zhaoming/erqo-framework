<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" width="100%" border="1">
	<tr>
		<td>ID</td>
		<td>NAME</td>
	</tr>
<c:if test="${!empty books.list}">
	<c:forEach items="${books.list}" var="book">
	<tr>
		<td>${book.id}</td>
		<td>${book.book_name}</td>
	</tr>
	</c:forEach>
</c:if>
</table>
<pg:pager url="${ctx}/admin/bookList.action" 
	items="${books.total}" 
	maxIndexPages="10" 
	scope="request"
	isOffset=""
	maxPageItems="${pager.maxPageItems}"
	export="offset,currentPageNumber=pageNumber">
	<%@include file="/common/page.jsp"%>
</pg:pager> 
</body>
</html>