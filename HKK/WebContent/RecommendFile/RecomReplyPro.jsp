<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="REsetting.jsp"%>
<script src="/HKK/RecommendFile/recommendJS.js"></script>

<c:if test="${result == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(writeerror);
		//-->
	</script>
</c:if>

<c:if test="${result == 1 }">
	<c:redirect url="Recomcontent.do?pageNum=${pageNum}&r_connum=${r_connum}&number=${number}"/>
</c:if>