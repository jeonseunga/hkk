<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%>

<form method="post" action="HKK_QnAReDelPro.do">
<input type="hidden" name="q_connum" value="${q_connum}">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="number" value="${number}">
<input type="hidden" name="q_renum" value="${q_renum}">
	<table>
		<tr>
			<th>${msg_reply_x}</th>
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_ck}">
				<input class="inputbutton" type="button" value="${btn_cancel}"  onclick="location='HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${q_connum}&number=${number+1}'">
			</th>
		</tr>
	</table>
</form>

























    