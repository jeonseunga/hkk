<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/HKK/HKK_Scrap/scrapJS.js"></script>
<%@ include file="SCsetting.jsp"%>


<c:if test="${result == 0 }">
		<script type="text/javascript">
		<!--
		erroralert(SCeerror);
		//-->
		</script>
</c:if>
<c:if test="${result != 0 }">
	<form>
	<table>
		<tr>
			<th>${msg_scrap}</th>
		</tr>
		<tr>
			<td>
				<input type="button" value="${btn_ck}" onclick="location='HKK_scrapList.do'">
				<input type="button" value="${btn_cancel}" onclick="location='receipeView.do?food_connum=${s_connum}&foodcode=${foodcode}'">
			</td>
		</tr>
	</table>
	</form>
</c:if>









    