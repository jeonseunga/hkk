<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Rsetting.jsp"%>
	<c:if test="${replydel == 0 }">
		<script type="text/javascript">
		<!--
			erroralert(writeerror);
		//-->
		</script>
	</c:if>
	<c:if test="${replydel == 1 }">
	<c:redirect url="receipeView.do?food_connum=${food_r_connum}&food_code=${food_r_code}"/>
	</c:if>