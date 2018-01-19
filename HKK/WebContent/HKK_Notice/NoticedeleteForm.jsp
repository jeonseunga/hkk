<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="NOsetting.jsp"%>

<link href="${project }board/style.css" rel="stylesheet" type="text/css">


<script src="${project }board/script.js"></script>





<h2>${page_modify}</h2>



<body onload="passwdfocus()">
	<form method="post" action="deletePro.do"
		name="deleteform" onsubmit="return passwdcheck()">
		
		<input type="hidden" name="num" value="${num}"> <!-- num은 modifyform에서 쓸게 아니라 view에서 쓰기위해 받은거임 view에서 num을 받음 -->
		<input type="hidden" name="pageNum" value="${pageNum}"> <!-- 다음페이지로 넘기기 위해 pageNum까지넘김 -->
	
		<table>
			<tr>
				<th colspan="2">
					${msg_passwd}
				</th>
			</tr>
			<tr>
					<th>${str_passwd }</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="12">
					</td>
					
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_del }">
					<input class="inputbutton" type="button" value="${btn_del_cancel }"
					onclick="location='list.do?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form>
</body>