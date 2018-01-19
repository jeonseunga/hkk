<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="MKsetting.jsp"%>
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>


<c:if test="${result == 0}">
	<script type="text/javascript">
			<!--
				alert(deleteerror);
			//-->
	</script>
	<meta http-equiv="refresh" content="0; url=HKK_marketList.do?pageNum=${pageNum}">
</c:if>

<c:if test="${result != 0}">
	<c:redirect url="HKK_marketList.do?pageNum=${pageNum}"/>
</c:if>










