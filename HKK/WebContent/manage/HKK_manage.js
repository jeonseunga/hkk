function searchid(){
	var id = manage.search.value;
	location.replace("membersearch.do?id="+id);
}

function grantCheck(chk){
    var obj = document.getElementsByName("memcode");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}

var pwerror = "비밀번호를 입력해 주세요";

function pwCheck(){
	if(!manage.pw.value){
		alert(pwerror);
		return false;
	}
}