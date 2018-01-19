<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="MKsetting.jsp"%>
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>

<c:if test="${result == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(RPeerror);
		//-->
	</script>
</c:if>

<c:if test="${result == 1 }">
	<c:redirect url="content.do?pageNum=${pageNum}&m_connum=${m_connum}&number=${number}"/>
</c:if>