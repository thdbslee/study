function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_cmdelete(INX){
	
}
function fn_add(){
	

	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/comment_ok.do",   
		processData : true,
		data: $("#frm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("등록완료2.");
				location.reload();
			}else{
				alert("등록실패.");	
			}
		}
	});
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});