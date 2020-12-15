function fn_onload(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_delete(){
	console.log("INX_>"+$("#INX").val());
	console.log("MENU ->"+$("#MENU").val());
	console.log("ID ->"+$("#ID").val());
	if($("#MENU").val() == 'FREE'){
		console.log("NOTICE");
	}
	if($("#MENU").val() =='QA'){
		console.log("QA");
	}
	if($("#MENU").val() =="LEVEL"){
		console.log("LEVEL");
	}
	
}

$(document).ready(function(){
	try{
		fn_onload();
	}catch(e){
		alert(e.message);
	}
});