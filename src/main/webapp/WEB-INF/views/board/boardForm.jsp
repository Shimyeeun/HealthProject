<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>

<!DOCTYPE html>

<html>


<meta charset="UTF-8">





<body>

	<article>

		<div class="container" role="main">

			<h2>게시글 FORM</h2>

			<form:form name="form" id="form" role="form"  modelAttribute="articleVO" method="post"
				action="/board/saveBoard.do">
				<form:hidden path="board_idx"/>
				<input type="hidden" name="mode"/>
				<div class="mb-3">
					<label for="title">제목</label> <form:input path="title" id="title" class="form-control" placeholder="제목을 입력해 주세요" />
				</div>

				<div class="mb-3">
					<label for="mem_id">작성자</label> <form:input path="mem_id" id="mem_id" class="form-control" placeholder="이름을 입력해 주세요" />
				</div>

				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="content" id="content" class="form-control" rows="5" placeholder="내용을 입력해 주세요" />
				</div>

			</form:form>

			<div>

				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>

		</div>

	</article>


</body>

<script>
	$(document).on('click', '#btnSave', function(e) {
		alert("게시글이 작성되었습니다.");
		e.preventDefault();

		$("#form").submit();

	});

	$(document)
			.on(
					'click',
					'#btnList',
					function(e) {

						e.preventDefault();
						location.href ="/board/listArticles.do";

					});
	
	$(document).ready(function(){

		var mode = '<c:out value="${mode}"/>';

		if ( mode == 'edit'){

			//입력 폼 셋팅

			$("#mem_id").prop('readonly', true);

			$("input:hidden[name='board_idx']").val(<c:out value="${articleVO.board_idx}"/>);

			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');


 
			$("#upload_date").val('<c:out value="${articleVO.upload_date}"/>');


 
			$("#title").val('<c:out value="${articleVO.title}"/>');

			$("#content").val('<c:out value="${articleVO.content}"/>');


		}

	});

</script>

<script src="${pageContext.request.contextPath}/resources/js/ckeditor.js"></script>
</html>
