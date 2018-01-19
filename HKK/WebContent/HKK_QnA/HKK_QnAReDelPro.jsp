<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>
<%@ include file="Qsetting.jsp"%>

<c:if test="${replydel == 0 }">
	<script type="text/javascript">
		<!--
		erroralert(ReDelerror);
		//-->
	</script>
</c:if>

<c:if test="${replydel != 0 }">
		<c:redirect url="HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}"/>
</c:if>









    