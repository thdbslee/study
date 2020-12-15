function fn_onload(){
	
	fn_setDefault();
}
function fn_setDefault(){
}
function fn_detail(INX){
	location.href="/total_detail.do?INX="+INX;
}
function fn_search(){
	$("#frm").submit();
}
function fn_delete(){
	
	
}
$(document).ready(function(){
	try{
		fn_onload();
	}catch(e){
		alert(e.message);
	}
});