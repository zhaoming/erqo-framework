<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${ctx}/j_spring_security_check" method="post">
			<table>
				<tr>
					<td>
						Username:
					</td>
					<td>
						<input type="text" name="j_username" />
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type="password" name="j_password" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input name="submit" type="submit" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>