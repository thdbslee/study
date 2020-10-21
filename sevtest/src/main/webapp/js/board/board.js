function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){
	
}
function fn_add(){
	window.open("/boardInsert.do",'insert','width=600px,height=800px');
}
function fn_detail(INX){
	window.open("/boardDetail.do?INX="+INX,'detail','width=600px,height=800px');
}

$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});