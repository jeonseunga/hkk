<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="SCsetting.jsp"%>
<script src="/HKK/HKK_Scrap/scrapJS.js"></script>

<c:if test="${result == 0}">
	<script type="text/javascript">
		<!--
		alert(SCDelerror);
		//-->
	</script>
	<meta http-equiv="refresh" content="0; url=HKK_scrapList.do">
</c:if>

<c:if test="${result == 1}">
	<c:redirect url="HKK_scrapList.do"/>
</c:if>









