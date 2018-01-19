<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="REsetting.jsp"%>
<script src="/HKK/RecommendFile/recommendJS.js"></script>

<c:if test="${replydel == 0 }">
		<script type="text/javascript">
		<!--
		erroralert(ReDelerror);
		//-->
		</script>
</c:if>
<c:if test="${replydel != 0 }">
		<c:redirect url="Recomcontent.do?pageNum=${pageNum}&r_connum=${r_connum}&number=${number+1}"/>
</c:if>









    