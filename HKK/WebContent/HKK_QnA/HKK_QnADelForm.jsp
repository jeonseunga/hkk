<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>
	
<form method="post" name="QnADelForm" action="HKK_QnADelPro.do" onsubmit="return QnADelCk()">
<input type="hidden" name="q_connum" value="${q_connum}">
<input type="hidden" name="pageNum" value="${pageNum}">
	<table>
		<tr>
			<th>${msg_con_x}</th>
		</tr>
		<tr>
			<td>
				<input type="password" name="q_pw">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_ck}">
				<input class="inputbutton" type="button" value="${btn_cancel}"  onclick="location='HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}'">
			</th>
		</tr>
	</table>
</form>

























    