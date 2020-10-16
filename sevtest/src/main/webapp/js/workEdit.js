function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	console.log("11");
	$("#STWORK").datepicker();
}
function fn_edit(){
	/*var a = $("#stwork").val();
	var mm = a.substr(0,2);
	console.log("월"+mm);
	var dd=  a.substr(3,2);
	console.log("일"+dd)
	var yy = a.substr(6,4);
	console.log("년도"+yy);
	var date = yy+"-"+mm+"-"+dd;
	console.log("날짜->"+date);
	$("#stwork").val(date);*/
	
	console.log("edit");
	$.ajax({      
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",  
		url:"/workEdit_ok.do",      
		data: $("#frm").serialize(),
		success:function(data){ 
			if(data=="true") {
				alert("수정하였습니다.");
				opener.location.reload();
				self.close();
			} else {
				alert("수정에 실패하였습니다");
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
})