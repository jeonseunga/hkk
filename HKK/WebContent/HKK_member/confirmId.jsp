<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<%@ include file = "Joinsetting.jsp"%>
<script src = "${project}/HKK_member/HKK_member.js"></script>

<h2 align = "Center"> ${page_confirm}</h2>

<c:if test="${result == 0}">


	<div class="form-group" style="text-align: center;">
 				<th> ${id}${msg_id_o}</th>
 				
 			</div>
		<div class="form-group" style="text-align: center;">
		<input style="align:center;" class="btn btn-success" type="button" value="${btn_ok}" onclick="setid('${id}')">
		</div>

	
</c:if>

<c:if test="${result ==1 }">
		<body onload="confirmfocus()">
			<form name = "confirmform" method="post" 
				action="confirmId.do"  onsubmit = "return confirmcheck()">
			
				<table align = "center">
					<tr>
						<th colspan="2" class = "line">
							<span>${id}</span>${msg_id_x}
						</th>
					</tr>
					<tr>
						<th class = "line">${str_id}</th>
							<td>
								<input class="input" type="text"  name = "id" maxlength="15">
							</td>
					</tr>
					<tr>
						<th colspan="2">
							<input class="btn btn-success" type="submit" value="${btn_ok}">
							<input class="btn btn-success"  type= "button" value= "${btn_ok_cancel}" onclick="self.close()">
						</th>
					</tr>
				</table>
				</form>
		</body>
</c:if>











