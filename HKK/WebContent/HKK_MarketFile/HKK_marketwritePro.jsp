<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="MKsetting.jsp"%>
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>

<c:if test="${check == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(writeerror);
		//-->
	</script>
</c:if>

<c:if test="${check !=0 }">
	<c:redirect url="HKK_marketList.do"/>
</c:if>