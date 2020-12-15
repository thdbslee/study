<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>      
<script type="text/javascript" src="/js/notice/notice.js" ></script> 
<script type="text/javascript" src="/js/egovframework/EgovMultiFile.js" ></script>
   <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<!DOCTYPE html>
<html lang="kr">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1800px; margin:auto; padding-top:50px;">
                        <h1 class="mt-4">공지사항</h1>
                       	<h7>${loginvo.ID}접속중입니다.</h7> 
                       	 <input type="hidden" id="NAME" name="NAME" value="${loginvo.NAME}">
                       	 <input type="hidden" id="INX" name="INX" value="${noticevo.INX}">
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                
                            </div>
                            <div class="card-body" >
                            
                             <table class="table table-bordered" id="dataTable" >
                             	<form id="frm" name="frm" method="post" enctype="multipart/form-data">
                                    <div>	
	                                  <tbody>
	                                  		<tr>
	                                  			<th>제목</th> 
	                                  			<td>${noticevo.TITLE}</td>
	                                  		</tr>
	                                  		<tr>
	                                  			<th>작성자</th>
	                                  			<td>${loginvo.NAME}</td>
	                                  		</tr>
	                                  		<tr>
	                                  			<th>내용</th>
	                                  			<td colspan="5">
	                                    			<textarea rows="20" cols="30" style="width:99%;" id="CONTENT" name="CONTENT" readOnly >${noticevo.CONTENT}</textarea>
	                                    		</td>
	                                  		</tr>
	                                  		<tr>
	                                  			<th>첨부파일</th>
	                                  			<td>
	                                  			<c:if test="${noticevo.IMG_1 ne null}">
												<img src="/upload/${noticevo.IMG_1}" style="max-width: 10%; max-height: 10%;">
												</c:if>
												</td>
	                                  		</tr>
	                                  		<tr>
	                                  			<th>작성일</th>
	                                  			<td>${noticevo.INSERT_DATE}</td>
	                                  		</tr>
	                                  </tbody>
	                                  <tfoot>
	                                  		<a class="button" href="/notice.do">목록</a>
	                                  </tfoot>
                                   </div>
                                  </form>
                 				</table>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        
      
    </body>
</html>
<style>

.button {

  background-color: black;

  border: none;

  color: white;

  padding: 5px 3px;

  text-align: center;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;

  margin: 4px 2px;

  cursor: pointer;

}

</style>
<script>
	function fn_add(){
		if(!$("#TITLE").val()){
			alert("제목을 입력하세요");
			return;
		}
		if(!$("#CONTENT").val()){
			alert("내용을 입력하세요");
			return;
		}
		var formData = new FormData($("#frm")[0]);
		$.ajax({
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			type:"POST",
			url:"/noticeInsert_ok.do",      
			data: formData,
			processDate: false,
			async       : false,
			traditional : true,
			processData: false,
			contentType: false,
			success:function(success){
				if(success=="true"){
					alert("공지사항 등록완료.");
					location.href="/notice.do";
				}else{
					alert("등록실패.");	
				}
			},error:function(indx){
				alert("에러");
			}
		});
	}
</script>

