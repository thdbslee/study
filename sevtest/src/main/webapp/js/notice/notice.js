function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	console.log("default");
}
function fn_click(INX){
	location.href="/notceDetail.do?INX="+INX;
	//window.open("/notceDetail.do?INX="+INX,'detail');
}

function fn_edit(){
	console.log("edit");
}
function fn_delete(){
  if($("input[name=INX_CHK]:checked").length == 0){
	  alert("삭제할 공지사항 선택하세요SS");
	  return ;
  }
	if(!confirm('선택한 게시물 삭제하시겠습니까 ?')){
		return;
	}
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/noticeDelete.do",   
		processData : true,
		data: $("#frm").serialize(),
		success:function(success){
			if(success=="true"){
				alert("삭제완료.");
				location.reload();
			}else{
				alert("삭제실패.");	
			}
		}
	});
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e).message;
	}
});