<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<div class="container" style="margin-top:50px;">	
		<ul>
			<li>
				<c:choose>
				<c:when test="${challengesList ==null }">
				<div">
					<p align="center">
							<b><span style="font-size: 9pt;">등록된 챌린지가 없습니다.</span></b>
						</p>
				</div>
			</c:when>
			<c:when test="${challengesList !=null }">
				<c:forEach var="challenge" items="${challengesList }"
					varStatus="challengeNum">
				<div  style="border:1px solid #CCCCCC;  margin-bottom:20px; padding:10px">
					<h4> ${challenge.title }</h4>				
					<p class="text-muted">누적금액:${challenge.total_point } 
					신청자수:${challenge.challenger } 
					시작일:${challenge.start_date } 
					마감일:${challenge.end_date } 
					신청금액:${challenge.target_point }</p>
					<button class="btn" type="button" >도전하기!</button>
						
				</div>
				
					
					
			</c:forEach>
		</c:when>
	</c:choose>
				
			</li>	
		</ul>
</div>



