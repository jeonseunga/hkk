<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="REsetting.jsp"%>
<script src="/HKK/RecommendFile/recommendJS.js"></script>



<c:if test="${result == 0}">
	<script type="text/javascript">
			<!--
			erroralert(deleteerror);
			//-->
	</script>
	<meta http-equiv="refresh" content="0; url=RecommendList.do?pageNum=${pageNum}">
</c:if>

<c:if test="${result != 0}">
	<c:redirect url="RecommendList.do?pageNum=${pageNum}"/>
</c:if>









