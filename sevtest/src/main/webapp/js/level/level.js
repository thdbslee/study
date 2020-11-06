function fn_onLoad(){
	fn_setDefault();
}
function fn_setDefault(){

}
function fn_add(){

	window.open("/level_insert.do",'insert','width=400px,height=400px;');
}
function fn_edit(){
	
}
function fn_delete(){
	
}
$(document).ready(function(){
	try{
		fn_onLoad();
	}catch(e){
		alert(e.message);
	}
});