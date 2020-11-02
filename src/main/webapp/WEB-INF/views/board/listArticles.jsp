<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<div class="content_area">
	<div class="side_area" style="padding-top: 40px">
		<p style="font-size: 15px"><strong>•　자유게시판</strong></p>
		<p style="font-size: 15px"><strong>•　장터게시판</strong></p>
		<p style="font-size: 15px"><strong>•　[회원전용]개인PT게시판</strong></p>
	</div>

	<div class="main_area" style="padding-top: 30px">
		<h1 align="left" style="padding-bottom:10px"">자유 게시판</h1>
		<table class="table table-striped" border="1" style="width: 90%">
			<tr height="10" align="center">
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:choose>
				<c:when test="${articlesList ==null }">
					<tr height="10">
						<td colspan="4">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				<c:when test="${articlesList !=null }">
					<c:forEach var="article" items="${articlesList }">
						<tr align="center">
							<td width="3%">${article.board_idx}</td>
							<td width="7%">${article.mem_id }</td>
							<td align='left' width="35%"><span
								style="padding-right: 30px"></span> <a class='cls1'
								href="${contextPath}/board/viewArticle.do?board_idx=${article.board_idx}">${article.title}</a></td>
							<td width="7%">${article.upload_date}</td>
							<td width="3%">${article.cnt}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<div style="width:90%"><button class="btn" type="button" class="btn btn-sm btn-primary" id="boardWrite" style="float:right; width:90px; height:40px; text-size:15px">글쓰기</button></div>
		
	</div>
</div>
	
<script>
	function fn_articleForm(isLogOn, articleForm, loginForm) {
		if (isLogOn != '' && isLogOn != 'false') {
			location.href = articleForm;
		} else {
			
			location.href = loginForm + '?action=/board/articleForm.do';
		}
	}
</script>
<script>
$(document).on('click', '#boardWrite', function(e) {

	var isLogOn = '${isLogOn}';
	
	console.log(isLogOn);

	if (isLogOn != '' && isLogOn != 'false'){
		location.href = "/board/boardForm.do";
		
	} else{
		alert("로그인 후 작성 가능합니다.");
	}

});
</script>
