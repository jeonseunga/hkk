<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>

<c:if test="${result == 0 }">
	<script type="text/javascript">
		<!--
			erroralert(conpweerror);
		//-->
	</script>
</c:if>

<c:if test="${result !=0 }">
	<c:if test="${find == null }">
		<c:redirect url="HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}"/>
	</c:if>
	<c:if test="${find != null }">
		<c:redirect url="HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}&find=${find}&findfind=${findfind}"/>
	</c:if>
</c:if>