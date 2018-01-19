<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<h2>이기 다 무슨 일인겨~</h2>
	<c:if test="${result == 0}">
		<script type="text/javascript">
			//<!--
			document.write("안됐네 안됐어~");
			//-->
		</script>
		<meta http-equiv="reflesh" content="0; url=main.do">
	</c:if>
	<c:if test="${result == 1}">
		<c:redirect url="manage.do"/>
	</c:if>
<body>
</body>
</html>