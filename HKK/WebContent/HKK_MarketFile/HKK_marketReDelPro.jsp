<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>
<%@ include file="MKsetting.jsp"%>

<c:if test="${replydel == 0 }">
		<script type="text/javascript">
		<!--
		erroralert(ReDelerror);
		//-->
		</script>
</c:if>
<c:if test="${replydel != 0 }">
		<c:redirect url="content.do?pageNum=${pageNum}&m_connum=${m_connum}&number=${number+1}"/>
</c:if>









    