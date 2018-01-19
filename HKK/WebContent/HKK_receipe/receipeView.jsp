<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="Rsetting.jsp"%>

<script src="/HKK/HKK_receipe/receipe.js"></script>
<link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">

<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>


<body>
<jsp:include page="../HKK_menu.jsp" flush="false"/>
	
	<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
		
			<div class="text-logo"><img src="/HKK/images/receipe.png" width="140" height="auto" 
			style="margin-left: 41%;"></div>

		</div>
	</div>
	
	<br>
	<br>
	
	<div align = "center">
	<form method="post" action="HKK_receipeReplyPro.do?food_r_connum=${food_connum}&food_r_code=${writeDto.food_code}"
	 	name="ViewForm" onsubmit="return Viewcheck()">
		<table width = "900px">
			<tr>
	            <th colspan="3"  class="line">
	               ${writeDto.food_title}
	            </th>
	         </tr>
	         <tr>
	            <th class="line">
	               ${str_writer} : ${writeDto.food_id}
	            </th>
	            <th class="line">
	               ${str_reg_date} : <fmt:formatDate value="${writeDto.food_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
	            </th>
	            <th class="line">
	               ${str_readcount} ${writeDto.food_readcount}
	            </th>
	         </tr>
	        
			<c:if test="${contentlist[0].food_video_path != null && contentlist[0].food_video_path.length() == 11}">
			<tr>
				<th class="line" colspan="3"><br></th>
			</tr>
			<tr>
				<th colspan="3">
					<div id="player"></div>
					    <script>
					      var tag = document.createElement('script');
					
					      tag.src = "https://www.youtube.com/iframe_api";
					      var firstScriptTag = document.getElementsByTagName('script')[0];
					      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
					
					      var player;
					      function onYouTubeIframeAPIReady() {
					        player = new YT.Player('player', {
					          height: '360',
					          width: '640',
					          videoId: '${contentlist[0].food_video_path}',
					          events: {
					            'onReady': onPlayerReady,
					            'onStateChange': onPlayerStateChange
					          }
					        });
					      }
					
					      function onPlayerReady(event) {
					        event.target.playVideo();
					      }
					
					      var done = false;
					      function onPlayerStateChange(event) {
					          done = true;
					      }
					      function stopVideo() {
					        player.stopVideo();
					      }
					    </script>
				</th>
			</tr>
			<tr>
				<th colspan="3"><br><br></th>
			</tr>
			</c:if>
			<c:forEach var="content" items="${contentlist}">
				<tr>
					<th class="line">
						<img src="${imgpath}${content.food_image_path}" onerror="this.style.display='none'" alt='' border="0" style="width:250px; height:auto;">
					</th>
					<th colspan="2" class="line">
						<pre>${content.food_content}</pre>
					</th>
				</tr>
			</c:forEach>
			<tr>
				<td class="line" colspan="3" align="right">
					<input class="button3" type="button" value="${btn_write_view}" onclick="location='category.do?foodcode=${writeDto.food_code}'">
					<input class="button3" type="button" value="${btn_scrap}" onclick="scrap('${food_connum}','${contentlist[0].food_image_path}','${writeDto.food_title}','${writeDto.food_id}','${writeDto.food_code}')">
					<input class="button3" type="button" value="${btn_write_delete}" onclick="confirmDelete(${food_connum},${writeDto.food_code})">
				</td>
			</tr>
			</table>
			<br>
			<br>
			<table width = "900px">
			<tr>
				<th class="line" colspan="3">
					<input class = "textbox" type="text" name="r_reply_content">
				</th>
				<th class="line">
       	 			<input class="button3" type="submit" value="${btn_Reply}">
				</th>
			</tr>
			<c:if test="${checkreply == 1 }">
				<tr>
					<th class="line">${str_writer}</th>
					<th class="line">${str_content}</th>
					<th class="line">${str_reg_date}</th>
					<th class="line"></th>
				</tr>
		 	<c:forEach var="FoReDto" items="${articles}">
		 		<tr>
		 			<th class="line">${FoReDto.food_r_id}</th>
					<td class="line">${FoReDto.food_recontent}</td>
					<th class="line">
						<fmt:formatDate value="${FoReDto.food_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
						
					</th>
					<c:if test="${sessionScope.memId == FoReDto.food_r_id }">
						<th class="line">
							<input class="button3" type="button" value="${btn_Reply_Del}" 
							onclick="ReDel('${food_connum}','${FoReDto.food_renum}','${FoReDto.food_r_code}')">	
						</th>
					</c:if>
					<c:if test="${sessionScope.memId != FoReDto.food_r_id }">
						<th class="line"></th>
					</c:if>
				</tr>
			</c:forEach>
		 </c:if>
		</table>
	
	</form>
	</div>
	
	<jsp:include page="../HKK_bottom.jsp" flush="false"/>
</body>






















