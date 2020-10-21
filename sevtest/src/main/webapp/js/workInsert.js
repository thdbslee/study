function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	$("#STWORK").datepicker();

}
function fn_add(){
	var a = $("#STWORK").val();
	var mm = a.substr(0,2);
	console.log("월"+mm);
	var dd=  a.substr(3,2);
	console.log("일"+dd)
	var yy = a.substr(6,4);
	console.log("년도"+yy);
	var date = yy+"-"+mm+"-"+dd;
	console.log("날짜->"+date);
	$("#STWORK").val(date);


	if(!$("#NAME").val()){
		alert("이름 입력하세요");
		return;
	}
	if(!$("#PHONE").val()){
		alert("폰번호입력하세요");
		return;
	}
	if(!$("#AGE").val()){
		alert("나이입력하세요");
		return;
	}
	if(!$("#STWORK").val()){
		alert("입사일 or 입사예정일 선택하세요");
		return;
	}
	
	$.ajax({
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		type:"POST",
		url:"/workInsert_ok.do",      
		data: $("#frm").serialize(),
		processData : false,
		success:function(success){
			if(success=="TRUE"){
				alert("등록완료.");
				opener.document.location.reload();
				self.close();
			}else{
				alert("등록실패.");	
			}
		},error:function(indx){
			alert("에러");
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