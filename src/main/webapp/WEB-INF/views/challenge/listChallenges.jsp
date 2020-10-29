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
					
					<p class="text-muted"> 누적금액 :  ${challenge.total_point }원 &nbsp; 신청자수 :  ${challenge.challenger }명  &nbsp; 시작일 : ${challenge.start_date } &nbsp; 마감일 : ${challenge.end_date } 
					
					</p>	
				<div style="text-align:right; width:100%; padding:0;">
    				<button class="btn" type="button" onclick="javascript:showConfirm(${challenge.chal_idx})" >도전하기!</button>
				</div>
				
				</div>
				
				
			</c:forEach>
		</c:when>
	</c:choose>	
</div>

<script>
function showConfirm(chal_idx){
	if(confirm("챌린지에 도전하시겠습니까?"))
	{	
		location.href="updateChallenge.do?chal_idx="+chal_idx;
		alert("챌린지 신청이 완료되었습니다.");
		return true;
		
	} 
	else
		return false;
}
</script>