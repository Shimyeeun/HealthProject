<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<body>

   <span><strong>Comments</strong></span>
   <span id="cCnt"></span>
   <form id="commentForm" name="commentForm" method="post">
      <div style="width:850px; margin: 0 auto">
         <table class="table" style="align: center">
            <tr>
               <td><textarea style="width:100%; height: 80px"
                     id="comment" name="comment" placeholder="댓글을 입력하세요."></textarea>
                  <br>
                  <div align="right">
                     <button class="btn" type="button" onClick="fn_comment('#')">등록</a>
                  </div></td>
            </tr>
         </table>
      </div>
      <input type="hidden" id="b_code" name="b_code"
         value="#" />
   </form>

    <div class="container">
        <div class="commentList" style="width: 800px; margin: 0 auto"></div>
    </div>

<script>

/* 댓글 등록하기(Ajax) */
function fn_comment(code){
    
   var mem_id = 'YOUNGHO';
   var board_idx = '${article.board_idx}';
   var comment = $("#comment").val();
   console.log(comment);
   var allData = { "mem_id": mem_id, "board_idx" : board_idx, "comment" : comment };
    
   $.ajax({
        type:'POST',
        url : "/board/addComment.do",
        data: allData,
        success : function(data){
            if(data=="success")
            {
            	alert("댓글이 입력되었습니다.");
               	getCommentList();
              	$("#comment").val("");
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
}
 
/* 초기 페이지 로딩시 댓글 불러오기 */
$(function(){
    
    getCommentList();
    
});
 
/* 댓글 불러오기 */
function getCommentList(){
   
   var board_idx = '${article.board_idx}';
   var allData = {"board_idx" : board_idx};
   
    $.ajax({
        type:'GET',
        url : "/board/commentList.do",
        dataType : "json",
        data: allData,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(data){
            
            var html = "";
         
            if(data.length > 0 && data[0].data != false){
                   
                for(i=0; i<data.length; i++){
               /*
                   html += '<div class="commentArea" style="width:100%; margin: 0 auto"';
                    html += "<div><table class='table'><h6><strong>"+data[i].mem_id+"</strong></h6>";
                    html += data[i].comment + "<tr><td></td></tr>";
                    html += "</table></div>";
                    html += "</div>";
                    */
                    
                    html += '<div class="commentArea" style="margin-bottom: 15px; width:800px; margin: 0 auto">';
                    html += '<div class="commentInfo'+data[i].comment_idx+'">'+ '<h6><strong>'+data[i].mem_id  + ' (' + data[i].reg_date + ')</strong></h6></div>';
                    html += '<div class="comment_area"><div id="comment_text" class="commentContent'+data[i].comment_idx+'"><p>'+data[i].comment+ '</p></div>';
                    html += '<div id="comment_update"><a class="update" onclick="commentUpdate('+data[i].comment_idx+',\''+data[i].comment+'\');">수정</a>';
                    html += '<a class="delete" onclick="commentDelete('+data[i].comment_idx+');"> 삭제 </a></div>';
                    html += '</div>';
                    
                    
                }
                
            } else {
                
               html += '<div class="commentArea" style="width:800px; margin: 0 auto"';
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
                
            }
            $(".commentList").html(html);
            
        },
        error:function(request,status,error){
            
       }
        
    });
}


//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(comment_idx, content){
    var html ='';
    //console.log("수정할 코멘트 idx: " + comment_idx);
    //console.log("수정할 내용" + content);
    html += '<div class="input-group" style="width: 750px">';
    html += '<input type="text" class="form-control" name="content_'+comment_idx+'" value="'+content+'"/>';
    html += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+comment_idx+');">수정</button> </span>';
    html += '</div>';
    
    $('.commentContent'+comment_idx).html(html);
    
}


//댓글 수정
function commentUpdateProc(comment_idx){
	
    var updateComment = $('[name=content_'+comment_idx+']').val();
	console.log("수정할 comment_idx: " + comment_idx);
	console.log("수정할 content: " + updateComment);
	

	$.ajax({
        type : 'POST',
        url : "/board/updateComment.do",
      //  dataType : "json",
        //contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        data : {'comment' : updateComment, 'comment_idx': comment_idx},
        success : function(data){
        	
        	alert("댓글이 수정되었습니다.");
        	
            if(data == "success") {
            	console.log("data" + data);
            	//$(".commentList").html(html);
            	getCommentList(); //댓글 수정후 목록 출력
            }	
             
        }
    });
}
 
//댓글 삭제 
function commentDelete(comment_idx){
	
	
    $.ajax({
        type : 'POST',
        url : "/board/deleteComment.do",
        data : {'comment_idx' : comment_idx},
        success : function(data){
            if(data == "success"){
            	alert("댓글이 삭제되었습니다.");
            	getCommentList(); //댓글 삭제후 목록 출력 
            }
        }
    });
}

</script>

</body>