<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="SCsetting.jsp"%>

<form method="post" action="HKK_scrapDelPro.do">
<input type="hidden" name="s_renum" value="${s_renum}">
	<table>
		<tr>
			<th>${msg_scrap_x}</th>
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_ck}">
				<input class="inputbutton" type="button" value="${btn_cancel}"  onclick="location='HKK_scrapList.do'">
			</th>
		</tr>
	</table>
</form>