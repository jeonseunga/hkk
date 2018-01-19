
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file = "Joinsetting.jsp"%>
<script src = "${project}/HKK_member/HKK_member.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 align="center"> ${str_email_auth} </h2>


<c:if test="${result == 0}">

<h2>${str_email_cancel}</h2>
		
</c:if>


	
<c:if test="${result == 1 }">
<form name="sendemailform">
			<input type="hidden" name="authnum" value="${authNum}">
			<!-- 부모창에서 써야됨 비교해야 되니까 emailnum = insertform.value -->
			
			<div class="form-group" style="text-align: center;">
 				<th>${str_email_success}</th>
 				
 			</div>
			
		
			
			<div class="form-group" style="text-align: center;">
			
				
			<input class="btn btn-success" type="button" value="${btn_ok}" onclick="setAuthNum()">
						
			</div>			
					
			
			
					
			
		
		</form>
</c:if>
		


