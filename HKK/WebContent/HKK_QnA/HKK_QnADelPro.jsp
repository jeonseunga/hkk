<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>

<c:if test="${result == 0}">
	<script type="text/javascript">
		<!--
		erroralert(deleteerror);
		//-->
	</script>
		<meta http-equiv="refresh" content="0; url=HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}">
</c:if>
<c:if test="${result == 1}">
		<c:redirect url="HKK_QnAList.do?pageNum=${pageNum}"/>
</c:if>










