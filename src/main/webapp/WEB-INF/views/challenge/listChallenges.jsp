<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<div class="contaniner" style="margin-top:50px">
 	<c:choose>
		<c:when test="${challengesList == null }">
			<div class="container">
				<p align="center">
					<b><span style="font-size: 9pt;">등록된 챌린지가 없습니다.</span></b>
				</p>
			</div>
		</c:when>
		<c:when test="${challengesList !=null }">
			<c:forEach var="challenge" items="${challengesList }"
			varStatus="challengeNum">
								
				<div class="container" style="border:1px solid #CCCCCC;  margin-bottom:20px; padding:10px">
					
					<h4> ${challenge.target_point }원 챌린지 > ${challenge.title } </h4>	
					
					<p class="text-muted"> 누적금액 : ${challenge.total_point } 신청자수 : ${challenge.challenger } 시작일 : ${challenge.start_date } 마감일 : ${challenge.end_date } 
					</p>	
				
				<button class="btn" type="button" onclick="javascript:showConfirm()" >도전하기!</button>
				</div>
				
				
			</c:forEach>
		</c:when>
	</c:choose>	
</div>

<script>
function showConfirm(){
	if(confirm("챌린지에 도전하시겠습니까?"))
	{
		$.ajax({

	           type: "POST",

	           url: "api/notes/{{$note->_id}}",

	           data: data, 

	           contentType: false,

	           success: function(data)

	           {

	                window.location.replace('url');

	           },

	           fail: function(data)

	           {

	                alert('failed');

	           },

	           error: function(data)

	           {

	            if (data.status == 401) {

	                alert('failed.');

	                return;

	            }

	           }

	        });
		alert("챌린지 신청이 완료되었습니다.");
		return true;
	} 
	else
		return false;
}
</script>