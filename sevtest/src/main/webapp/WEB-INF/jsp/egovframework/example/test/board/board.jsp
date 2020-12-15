<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="/layoutMenu.do"></c:import>
     <script type="text/javascript" src="/js/board/board.js" ></script> 
<!DOCTYPE html>
<html>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1800px; margin:auto; padding-top:50px;">
                        <h1 class="mt-4">자유게시판</h1>
                       	<h7>${loginvo.ID}접속중입니다.</h7> 
                       	 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                게시판
                            </div>
                            <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="boardfrm" name="boardfrm">
                                
									<input type="hidden" id="LEVEL" name="LEVEL" value="${loginvo.LEVEL }">
                                	<input type="hidden" id="AUTH_CODE" name="AUTH_CODE" value="${loginvo.AUTH_CODE}">
                                    <table class="table table-bordered" id="dataTable" >
                                    <div>
										                                    
                                    	<a class="button" href="javascript:fn_add();">등록</a>
                                    	<a class="button" href="javascript:fn_edit();">수정</a>
                                    	<a class="button" href="javascript:fn_delete();">삭제</a>
                                    </div>
                                      	<thead>
                                      		<tr>
                                      			<th style="width:10%;"><input type="checkbox" id="all_check" name="all_check"></th>
                                      			<th>title</th>
                                      			<th>id</th>
                                      			<th style="width:8%;">조회수</th>
                                      			<th style="width:100px;">date</th>
                                      		</tr>
                                      	</thead>
                                      		<tbody id="aatbody">
                                      			<c:forEach var="list" items="${list}">
                                      				<tr>
                                      				<td>
                                      				<c:choose>
                                      					<c:when test="${login.AUTH_CODE eq 9 }">
                                      						<input type="checkbox" id="INX_CHK" name="INX_CHK" value="${list.INX}"> 
                                      					</c:when>
                                  						<c:when test="${login.ID eq list.ID}">
                                  							<input type="checkbox" id="INX_CHK" name="INX_CHK" value="${list.INX}"> 
                                  						</c:when>
                                      				</c:choose>
                                      								
                              						</td>
                                      				<td  id="test" name="test" style="cursor: pointer;" onMouseOver="this.style.backgroundColor='#F0F1F3'" onMouseOut="this.style.backgroundColor='#FFFFFF'" onclick="javascript:fn_detail('${list.INX}')">
                                      				${list.TITLE}</td>
                                      				<td>${list.ID}</td>
                                      				<td style="text-align:center">
                                      				<input type="hidden" id="INFO" name="INFO" value="${list.INFO}">${list.INFO}</td>
                                      				<td style="width:100px;">${list.NOTICE_DATE}</td>
                                      				</tr>
                                      			</c:forEach>
                                      		</tbody>
                                      		
                                    </table>          
                                    </form>
                                   
                                </div>
                            </div>
                        </div>-
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
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

