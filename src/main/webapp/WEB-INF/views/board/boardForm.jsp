<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>

<html>
<meta charset="UTF-8">
<body>
	<article>
		<div class="container" role="main">
			<h2>게시글 작성</h2>
			<form:form name="form" id="form" role="form"  modelAttribute="articleVO" method="post" enctype="multipart/form-data"
				action="/board/saveBoard.do">
				
				<form:hidden path="board_idx"/>
				<input type="hidden" name="mode"/>
				
				<div class="mb-3">
					<label for="title">제목</label> <form:input path="title" id="title" style="width: 800px" class="form-control" placeholder="제목을 입력해 주세요" />
				</div>

				<div class="mb-3">
					<label for="mem_id">아이디</label> <form:input path="mem_id" id="mem_id"  style="width:800px" class="form-control" type="text" value="${mem_id}" readonly="true"/>
				</div>

				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="content" id="content" class="form-control" rows="5" placeholder="내용을 입력해 주세요" />
						<script>
						
						 var ckeditor_config = {
						   resize_enaleb : false,
						   enterMode : CKEDITOR.ENTER_BR,
						   shiftEnterMode : CKEDITOR.ENTER_P,
						   filebrowserUploadUrl : "/admin/goods/ckUpload"
						 };
						
						
						 CKEDITOR.replace("content", ckeditor_config);
						 
						</script>	
				</div>
				
				<div class="inputArea" style="margin:30px 0">
					 <label for="boardImg" class="btn btn-primary btn-file">이미지</label>
					 <input type="file" id="boardImg" name="file" style="display: none;"/>
					 <div class="select_img"><img src="" /></div>

					 <script>
						  $("#boardImg").change(function(){
						   if(this.files && this.files[0]) {
						    var reader = new FileReader;
						    reader.onload = function(data) {
						     $(".select_img img").attr("src", data.target.result).width(500);        
						    }
						    reader.readAsDataURL(this.files[0]);
						   }
						  });
					 </script>
					 
					 <%=request.getRealPath("/") %>
					 
				</div>
				 
			</form:form>
			<div style="display: flex;">
			<div style="width:40%; box-sizing:border-box; text-align:left">
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
			<div style="flex:1; width:40%; text-align:right; box-sizing:border-box">
				<button type="button" class="btn btn-sm btn-primary" id="btnSave" >저장</button>
			</div>
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
			
			$("#mem_id").val('<c:out value="${boardContent.mem_id}"/>');

			$("input:hidden[name='board_idx']").val(<c:out value="${boardContent.board_idx}"/>);

			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');


 
			$("#upload_date").val('<c:out value="${boardContent.upload_date}"/>');


 
			$("#title").val('<c:out value="${boardContent.title}"/>');

			$("#content").val('<c:out value="${boardContent.content}"/>');


		}

	});

</script>



<script src="${pageContext.request.contextPath}/resources/js/ckeditor.js"></script>
</html>