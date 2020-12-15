<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:import url="/layoutMenu.do"></c:import>
     <script type="text/javascript" src="/js/total/totalwrite.js" ></script> 
 <link rel="stylesheet" type="text/css" href="css/baseStyle.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" media="all">
<!DOCTYPE html>
<html>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid"
                    style="width:1400px; margin:auto; padding-top:30px;">
                        <h1 class="mt-4">전체게시글</h1>
                       	<h7>${loginvo.ID}접속중입니다.</h7> 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                전체게시글 
                            </div>
                            <table class="searchTable">
										<colgroup>
											<col style="width: 100px;" />
											<col style="width: auto;" />
											<col style="width: 215px;" />
										</colgroup>
										<tr>
											<th class="point">검색</th>
											<td>
												<select name="searchType" id="searchType">
													<option value="1" selected="selected">아이디</option>
												</select>
												<input type="text" name="searchText" id="searchText" value="${vo.searchText}" placeholder="" style="width: 160px;" />
											</td>
											<td>
												<a href="javascript:searchUser()" class="bt btRed" style="width: 80px;">검색</a>
												<a href="/user.do" class="bt btRed" style="width: 80px;">전체보기</a>
											</td>
										</tr>
									</table>
                            <div class="card-body" >
                                <div class="table-responsive" >
                                	<form id="frm" name="frm">
                                		 <input type="hidden" id="ID" name="ID" value="${login.ID}">
                                	 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                		<thead>
                                			<tr>
                                				<th><input type="checkbox" id="all_chk" name="all_chk"></th>
                                				<th>게시판메뉴</th>
                                				<th>아이디</th>
                                				<th>제목</th>
                                				<th>작성날짜</th>
                                		
                                			</tr>
                                		</thead>
                                		<tbody>
                                			<c:forEach var="list" items="${list}">
                                				<tr>
                                				 	<td><input type="checkbox" id="CHK" name="CHK"></td>
                                				 	<c:choose>
	                                				<c:when test="${list.MENU eq 'FREE' }">
	                                				<td onclick="fn_detail('${list.INX}')" style="cursor:pointer;">자유게시판</td>
	                                				</c:when>
	                                				<c:when test="${list.MENU eq 'Q&A' }">
	                                				<td onclick="fn_detail('${list.INX}')" style="cursor:pointer;">Q & A게시판</td>
	                                				</c:when>
	                                				<c:when test="${list.MENU eq 'LEVEL'}">
	                                				<td onclick="fn_detail('${list.INX}')" style="cursor:pointer;">등업게시판</td>
	                                				</c:when>
	                                				</c:choose>
                                				 	<td>${list.ID}</td>
                                				 	<td>${list.TITLE}</td>
                                				 	<td>${list.DT}</td>
                                				</tr>
                                			</c:forEach>
                                		</tbody>
                                    </form>
                                </div>
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

