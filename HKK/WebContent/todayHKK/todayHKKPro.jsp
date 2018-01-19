<%@page import="java.sql.Timestamp"%>
<%@page import="todayhkk.TodayHKKDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2> 오늘의 한끼 pro </h2>

	<c:if test = "${result == 0}">
		<script type="text/javascript">
				<!--
				alert(inserterror);
				//-->
		</script>
		<meta http-equiv = "refresh" content="0; url=todayHKK.do">	
		<!-- insert실패 -->
	</c:if>
	
	<c:if test="${result == 1 }">
		<c:redirect url="todayHKK.do"/>
	</c:if>

