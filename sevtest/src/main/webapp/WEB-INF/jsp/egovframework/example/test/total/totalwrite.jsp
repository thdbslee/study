<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:import url="/layoutMenu.do"></c:import>
     <script type="text/javascript" src="/js/total/totalwrite.js" ></script> 
 <link rel="stylesheet" type="text/css" href="css/baseStyle.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" media="all">
<!DOCTYPE html>
<html>

	<!-- Right Content Title End //-->	
<div class="intranetContentArea clearFix">
	<div class="icBox clearFix" style="width:1800px; margin:auto; padding-top :50px;">
			<form method="post" id="frm" name="frm" class="clearFix">
				<h1>작성글</h1>
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
								<option value="2" ${vo.searchType eq '2'?'selected':''}>제목</option>
							</select>
							<input type="text" name="searchText" id="searchText" value="${vo.searchText}" placeholder="" style="width: 160px;" />
						</td>
						<td>
							<a href="javascript:fn_search()" class="bt btRed" style="width: 80px;">검색</a>
							<a href="/totwrite.do" class="bt btRed" style="width: 80px;">전체보기</a>
						</td>
					</tr>
				</table>
			

			<table style="margin-top: 40px;">
				<thead>
				<tr>
         		<th>게시판메뉴</th>
         		<th>아이디</th>
         		<th>제목</th>
         		<th>작성날짜</th>
         		</tr>
         		</thead>
				<tbody>
	    			<c:forEach var="list" items="${list}">
	    				<tr>
	    				 
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
			</table>
			</form>


			<div class="btArea3">
				<!-- <a href="javascript:addUser()" class="bottomBtn btGray">사용자 추가</a>
				<a href="javascript:editUser()" class="bottomBtn btGray">사용자 수정</a>
				<a href="javascript:deleteUser()" class="bottomBtn btGray">사용자 삭제</a> -->
			</div>
		</div>
		<!-- icBox End //-->
				
	</div>
</div>     
</html>


