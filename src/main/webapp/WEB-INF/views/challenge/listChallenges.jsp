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
					
					<p class="text-muted">  누적금액 : ${challenge.total_point }원 &nbsp; 신청자수 :  ${challenge.challenger }명  &nbsp; 시작일 : ${challenge.start_date } &nbsp; 마감일 : ${challenge.end_date } 
					
					</p>	
				<div style="text-align:right; width:100%; padding:0;">
				<button id="chalbtn${challenge.chal_idx }" class="btn" type="button" onclick="javascript:loginCheck(${isLogOn},${challenge.chal_idx })" >도전하기!</button>
				<c:choose>
					<c:when test="${isLogOn==true }">
						<c:forEach var="state" items="${statesList }"
						varStatus="stateNum">
							
							<c:choose>
								<c:when test="${state.mem_id==member.mem_id&&state.chal_idx==challenge.chal_idx}">
									<script>
										function hidebutton(chal_idx){
											var chal_btn="chalbtn"+chal_idx;
											document.getElementById(chal_btn).style.display="none";											
										}
										hidebutton(${challenge.chal_idx});
										</script> 
							  		<label for="challenge" class="btn btn-danger btn-sm "> 이미 도전중인 챌린지 입니다.</label>
								</c:when>
							</c:choose>		
						</c:forEach>	
										
					</c:when>
					
					
    			</c:choose>
				</div>
				
				</div>
			</c:forEach>
		</c:when>
	</c:choose>	
</div>


<script>

function loginCheck(isLogOn,chal_idx){
	
	
	console.log(isLogOn);
	console.log(chal_idx);
	
	if(isLogOn==true){
		showConfirm(chal_idx);
	}
	else{
		alert("로그인 후 이용가능합니다.");
	}
	
}

function showConfirm(chal_idx){
	var mem_id="<c:out value="${member.mem_id}"/>";
	console.log(chal_idx);
	if(confirm("챌린지에 도전하시겠습니까?"))
	{	
		
		location.href="updateChallenge.do?chal_idx="+chal_idx+"&mem_id="+mem_id;
		alert("챌린지 신청이 완료되었습니다.");
		return true;
		
	} 
	else
		return false;
}


</script>