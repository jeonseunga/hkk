<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="SCsetting.jsp"%>
<link rel="stylesheet" href="css/HKK_style.css">


<form method="post" action="HKK_scrapPro.do">
<input type="hidden" name="s_connum" value="${s_connum}">
<input type="hidden" name="s_img_path" value="${s_img_path}">
<input type="hidden" name="s_r_title" value="${s_r_title}">
<input type="hidden" name="s_r_id" value="${s_r_id}">
<input type="hidden" name="food_code" value="${food_code}">
	<table>
		<tr>
			<th>${msg_scrap_o}</th>
		</tr>
		<tr>
			<th colspan="2">
				<input class="button3" type="submit" value="${btn_ck}">
				<input class="button3" type="button" value="${btn_cancel}"  onclick="location='receipeView.do?food_connum=${s_connum}&foodcode=${food_code}'">
			</th>
		</tr>
	</table>
</form>
