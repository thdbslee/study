<%@ page language="java" contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"		uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>

<html lang="ko">
<head>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="/js/workEdit.js" ></script> 
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
</head>
<div class="intranetTitle">
		<h4>사용자 수정</h4>
</div>
<div>
	<form id="frm" name="frm" method="post">
	<input type="text" id="INX" name="INX" value="${editvo.INX}">
		<table>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type="text" id="NAME" name="NAME" value="${editvo.NAME}"></td>
				</tr>
				<tr>
					<th>직위</th>
					<td><input type="text" id="LEVEL" name="LEVEL" value="${editvo.LEVEL}"></td>
				</tr>
				<tr>
					<th>번호</th>
					<td><input type="text" id="PHONE" name="PHONE" value="${editvo.PHONE}"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" id="AGE" name="AGE" value="${editvo.AGE}"></td>
				</tr>
				<tr>
					<th>입사일//입사예정일</th>
					<td><input type="text" id="STWORK" name="STWORK" value="${editvo.STWORK}" readOnly></td>
				</tr>
			</tbody>
		</table>
	
			<a style="width:100px;cursor:pointer;"  onclick="fn_edit();">수정</a>
			<a style="width:100px;cursor:pointer;"  onclick="self.close;">닫기</a>
			
	
	</form> 
</div>