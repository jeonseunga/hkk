<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Rsetting.jsp"%>
<script src="/HKK/HKK_receipe/receipe.js"></script>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<form name="deleteform">
	<input type="hidden" name="connum" value="${connum}">
	<input type="hidden" name="foodcode" value="${foodcode}">
</form>
	<c:if test="${result == 0}">
		<script type="text/javascript">
		<!--
			erroralert(deleteerror);
		//-->
		</script>
	</c:if>
	<c:if test="${result == -1}">
		<script type="text/javascript">
		<!--
			backalert(noiderror);
		//-->
		</script>
	</c:if>
	<c:if test="${result == 1}">
		<c:if test="${foodcode == 1}">
			<c:redirect url="category.do?foodcode=${foodcode}"/>
		</c:if>
		<c:if test="${foodcode == 2}">
			<c:redirect url="category.do?foodcode=${foodcode}"/>
		</c:if>
		<c:if test="${foodcode == 3}">
			<c:redirect url="category?foodcode=${foodcode}"/>
		</c:if>
		<c:if test="${foodcode == 4}">
			<c:redirect url="category.do?foodcode=${foodcode}"/>
		</c:if>
		<c:if test="${foodcode == 5}">
			<c:redirect url="category.do?foodcode=${foodcode}"/>
		</c:if>
	</c:if>
