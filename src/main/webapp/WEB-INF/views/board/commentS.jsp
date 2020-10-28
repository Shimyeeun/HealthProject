<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>

	<span><strong>Comments</strong></span>
	<span id="cCnt"></span>
	<form id="commentForm" name="commentForm" method="post">
		<div style="width:1000px; margin: 0 auto">
			<table class="table" style="align: center">
				<tr>
					<td><textarea style="width:100%; height: 100px"
							id="comment" name="comment" placeholder="댓글을 입력하세요."></textarea>
						<br>
						<div align="right">
							<a href='#' onClick="fn_comment('#')"
								class="btn pull-right btn-success">등록</a>
						</div></td>
				</tr>
			</table>
		</div>
		<input type="hidden" id="b_code" name="b_code"
			value="#" />
	</form>
	<c:choose>
		<c:when test="${commentList != null}">
		<div style="width: 800px; margin: 0 auto">
			<c:forEach var="comment" items="${commentList}">
				<table>
				<tr align="center">
					<td width="3%">${comment.comment_idx}</td>
					<td width="7%">${comment.mem_id }</td>
					<td width="7%">${comment.content}</td>
					<td width="3%">${comment.reg_date}</td>
				</tr>
				</table>
			</c:forEach>
			</div>
		</c:when>

		<c:when test="${commentList ==null }">
			<tr height="10">
				<td colspan="4">
					<p align="center">
						<b><span style="font-size: 9pt;">등록된 코멘트가 없습니다.</span></b>
					</p>
				</td>
			</tr>
		</c:when>
	</c:choose>



	<script>
/*
 * 댓글 등록하기(Ajax)
 */
function fn_comment(code){
    
	//comment 가져오기
	var mem_id = 'MK0227';
	var comment_idx = 7;
	console.log(comment_idx);
	var board_idx = '${article.board_idx}';
	var comment = $("#comment").val();
	console.log(comment);
	var allData = { "mem_id": mem_id, "comment_idx": comment_idx, "board_idx" : board_idx, "comment" : comment };
    
	$.ajax({
        type:'POST',
        url : "/board/addComment.do",
        data: allData,
        success : function(data){
            if(data=="success")
            {
               getCommentList();
               $("#comment").val("");
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
}
 
/**
 * 초기 페이지 로딩시 댓글 불러오기
 */
$(function(){
    
    getCommentList();
    
});
 
/**
 * 댓글 불러오기(Ajax)
 */
function getCommentList(){
    
    $.ajax({
        type:'GET',
        url : "<c:url value='/board/commentList.do'/>",
        dataType : "json",
        data:$("#commentForm").serialize(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(data){
            
            var html = "";
            var cCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>"+data[i].writer+"</strong></h6>";
                    html += data[i].comment + "<tr><td></td></tr>";
                    html += "</table></div>";
                    html += "</div>";
                }
                
            } else {
                
                html += "<div>";
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
                
            }
            
            $("#cCnt").html(cCnt);
            $("#commentList").html(html);
            
        },
        error:function(request,status,error){
            
       }
        
    });
}
 
</script>

</body>