<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>

<form method="post" name="QnAConForm" action="HKK_QnAcontentPWPro.do" onsubmit="return QnAConCk()">
<input type="hidden" name="q_connum" value="${q_connum}">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="number" value="${number}">
<c:if test="${find!=null }">
<input type="hidden" name="find" value="${find}">
<input type="hidden" name="findfind" value="${findfind}">
</c:if>
	<table>
		<tr>
			<th>${msg_con_pw}</th>
		</tr>
		<tr>
			<td>
				<input type="password" name="q_pw">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_ck}">
				<input class="inputbutton" type="button" value="${btn_cancel}"  onclick="location='HKK_QnAList.do'">
			</th>
		</tr>
	</table>
</form>

























    