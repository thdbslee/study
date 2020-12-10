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
	
}
function fn_delete(){
	
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e).message;
	}
});