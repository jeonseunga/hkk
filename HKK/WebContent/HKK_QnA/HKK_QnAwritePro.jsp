<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>

<c:if test="${result == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(writeerror);
		//-->
	</script>
</c:if>

<c:if test="${result !=0 }">
	<c:redirect url="HKK_QnAList.do"/>
</c:if>