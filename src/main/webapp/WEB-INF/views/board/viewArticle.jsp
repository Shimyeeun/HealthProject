<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%-- 
<c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  />

 --%>
<%
  request.setCharacterEncoding("UTF-8");
%> 

   <meta charset="UTF-8">
   <title>글보기</title>
   <style>
     #tr_file_upload{
       display:none;
     }
     #tr_btn_modify{
       display:none;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
       obj.action="${contextPath}/board/listArticles.do";
       obj.submit();
     }
 
    function fn_enable(obj){
       document.getElementById("i_title").disabled=false;
       document.getElementById("i_content").disabled=false;
       document.getElementById("i_imageFileName").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_file_upload").style.display="block";
       document.getElementById("tr_btn").style.display="none";
    }
    
    function fn_modify_article(obj){
       obj.action="${contextPath}/board/modArticle.do";
       obj.submit();
    }
    
    function fn_remove_article(url,articleNO){
       var form = document.createElement("form");
       form.setAttribute("method", "post");
       form.setAttribute("action", url);
        var articleNOInput = document.createElement("input");
        articleNOInput.setAttribute("type","hidden");
        articleNOInput.setAttribute("name","articleNO");
        articleNOInput.setAttribute("value", articleNO);
       
        form.appendChild(articleNOInput);
        document.body.appendChild(form);
        form.submit();
    
    }
    
    function fn_reply_form(url, parentNO){
       var form = document.createElement("form");
       form.setAttribute("method", "post");
       form.setAttribute("action", url);
        var parentNOInput = document.createElement("input");
        parentNOInput.setAttribute("type","hidden");
        parentNOInput.setAttribute("name","parentNO");
        parentNOInput.setAttribute("value", parentNO);
       
        form.appendChild(parentNOInput);
        document.body.appendChild(form);
       form.submit();
    }
    
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }  
 </script>

   <div class="content_title" style="text-align:left; padding-top:30px; padding-bottom:10px;">
      <h2>${article.title}</h2>
   </div>
   <div style="width: 1000px; margin: 0 auto">
      <div class="writer_info" style=" height:60px; padding-bottom:10px; text-align:left; float:left; width:80%">
      	<div class="profile_area">
      		<div class="profile_info">작성자:${article.mem_id}<br></div>
      		<div class="article_info"><div class="article_date" style="margin: 5px">${article.upload_date}</div></div>
      	</div>
      </div>
      <div class="writer_info" style="float:right; width:20%; height:60px">
      <br>
      	<a class="btn_g" href="/board/modArticle.do" style="font-size:13px;font-weight: 800">수정</a>　<a class="btn_g" href="/board/listArticles.do" style="font-size:13px; font-weight: 800">삭제</a>
      </div>
  </div>   
  
   <div class="cont_upper area_btn_g" style="border-bottom: 1px solid #efefef; width:1000px; margin:0 auto; padding-top: 60px"></div>

  <form role="form" name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data" style="padding-top:20px; margin: 0 auto; width:820px">
  <table  border=0  align="center">
    <td width="80px" align="center" bgcolor="#2E2E2E">
      <p style="color:#FFFFFF">내용</p>
   </td>
   <td>
    <textarea class="form-control" rows="20" cols="60"  name="content"  id="i_content"  disabled />${article.content }</textarea>
   </td>  
  </tr>
</table>   
 </form>
 <div class="cont_upper area_btn_g" style="border-bottom: 1px solid #efefef; width:1000px; margin:0 auto; padding-top:20px"></div>
 <div clas="main_content" style=" margin: 0 auto; width:1300px; align:center; padding-top:20px">
   <div class="writer_info" style=" height:40px; padding-bottom:15px">
      <div class="content_header_item first" style="float:left"><a class="btn_g" href="/board/listArticles.do" style="font-size:13px; font-weight: 800">목록</a></div>      
      <div class="content_header_item two" style="float:right"><a class="btn_g" href="#" style="font-size:13px; font-weight: 800">답글</a></div>      
   </div>
      
</div>

<%@ include file="commentS.jsp" %>
