<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>      
<script type="text/javascript" src="/js/total/totalDetail.js" ></script> 
   <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<!DOCTYPE html>
<html lang="kr">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1800px; margin:auto; padding-top:50px;">
                        <h1 class="mt-4">게시글 상세보기</h1>
                       	<h7>${loginvo.ID}접속중입니다.</h7> 
                       	 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                
                            </div>
                            <div class="card-body" >
                            
                             <table class="table table-bordered" id="dataTable" >
                             	<form id="frm" name="frm" method="post" >
								 <input type="text" id="ID" name="ID" value="${loginvo.ID}">
								 <input type="text" id="MENU" name="MENU" value="${totalvo.MENU}">
								 <input type="text" id="INX" name="INX" value="${totalvo.INX}">                         

                                    <div>	
	                                 <tbody>
	                                 	<tr>
	                                 		<th>제목</th>
	                                 		<td>${totalvo.TITLE}</td>
	                                 	</tr>
	                                 	<tr>
	                                 		<th>게시판이름</th>
	                                		<c:choose>
	                                			<c:when test="${totalvo.MENU eq 'FREE' }">
	                                				<td>자유게시판</td>
	                                			</c:when>
	                                			<c:when test="${totalvo.MENU eq 'Q&A' }">
	                                				<td>Q & A게시판</td>
	                                			</c:when>
	                                			<c:when test="${totalvo.MENU eq 'LEVEL'}">
	                                				<td>등업게시판</td>
	                                			</c:when>
	                                		</c:choose>
	                                 	</tr>
	                                 	<tr>
	                                 		<th>내용</th>
	                                 		<td><textarea rows="8" cols="85" readOnly>${totalvo.CONTENT }</textarea></td>
	                                 	</tr>
	                                 	<tr>
	                                 		<th>작성일</th>
	                                 		<td>${totalvo.DT}</td>
	                                 	</tr>
	                                 </tbody>
	                               
                                  </form>
                 				</table>
                 				  <tfoot>
                 				  	<div>
	                                 	<a class="button" href="javascript:fn_delete()">삭제</a>
	                                 	<a class="button" href="/totwrite.do">목록</a>
	                                 </div>
	                              </tfoot>
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

