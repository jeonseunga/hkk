
<%@page import="java.sql.Timestamp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="NOsetting.jsp"%>

<link href="style.css" rel="stylesheet" type="text/css">

<script src="/TodayHkki/notice/script.js"></script>

<h2>${page_write}</h2>


<c:if test="${checkresult == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(noticecheck);
		//-->
		
	</script>
</c:if>


<c:if test="${result ==0 }">

	<script type="text/javascript">
		<!--
			erroralert(writeerror);
		//-->
		
	</script>
</c:if>
<c:if test="${result == 1 }">
	<c:redirect url="NoticeList.do"/>
</c:if>















