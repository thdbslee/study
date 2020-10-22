<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>

<html lang="ko">
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/board/boardDetail.js" ></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<title>게시판 상세보기 </title>
<body>
	<div>
		<form id="frm" name="frm">
		<input type="hidden" id="INX" name="INX" value="${boardvo.INX}"> 
			<table class="simple_table">
				<tbody>
					<h4>게시판 상세보기</h4>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" value="${boardvo.TITLE}"></td>
				</tr>	
				<tr> 
					<th>내용</th>
					<td><textarea rows="5" cols="30" name="CONTENT" readOnly>${boardvo.CONTENT}</textarea>
				</tr>
				</tbody>
			</table>
		<h5>댓글</h5>
		<table class="simple_table">
		<input type="text" id="B_INX" name="B_INX" value="${boardvo.INX}">게시물 번호
		<input type="hidden" id="ID" name="ID" value="${sevvo.ID}">
			<tbody>
				<c:forEach var="cmlist" items="${cmlist}">
					<tr>
						<th style="width:20px;">id</th>
						<td style="width:20px;">${cmlist.ID}</td>
						<th style="width:20px;">댓글</th>
						<td>${cmlist.COMMENT}</td>
						<th style="width:10px">
							<a class="button" href="javascript:fn_cmdelete(${cmlist.INX})">삭제</a>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="simple_table">
			<tfoot>
				<tr>
					<th></th>
					<td><textarea rows="3" cols="30" name="COMMENT" id="COMMENT">
					</textarea><a class="button" href="javascript:fn_add();">등록</a>
					</td>		
				</tr>
			</tfoot>
		</table>
		<a href="javascript:self.close();" class="button">닫기</a>
		</form>
	

	
	</div>
</body>

<style>
.simple_table { width: 100%; border: none; border-collapse: separate; border-spacing: 2px;}
.simple_table th { padding: 15px; border: none; border-left: 5px solid #C03; border-bottom: 1px solid #DDD; background: #FCF0F3; font-weight: normal; text-align:center; text-shadow: 0 1px #FFF; vertical-align: middle;}
.simple_table td { padding: 15px; border: none; border-bottom: 1px solid #DDD; text-align: left; vertical-align: baseline;}
table.type07 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border: 1px solid #ccc;
    margin: 20px 10px;
}
table.type07 thead {
    border-right: 1px solid #ccc;
    border-left: 1px solid #ccc;
    background: #e7708d;
}
table.type07 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
}
table.type07 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #fcf1f4;
}
table.type07 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
</style>

