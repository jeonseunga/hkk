/**
 * 게시판
 */
var writererror = "작성자를 입력하세요";
var subjecterror = "글제목을 입력하세요";
var contenterror = "글내용을 입력하세요";
var passwderror = "비밀번호를 입력하세요";
var writeerror="글작성에 실패했습니다. DB처리가 되지 않았습니다. 잠시 후 다시 시도하세요"
var noticecheck ="공지사항 글쓰기 권한이 없습니다. 관리자로 로그인하세요"
var repasswderror = "입력하신 비밀번호가 다릅니다. 다시 확인하세요.";
var modifyerror = "글수정에 실패했습니다. 잠시 후 다시 시도하세요";
var deleteerror ="글삭제에 실패 했습니다";
var replyerror = "댓글이 있는 글은 삭제할 수 없습니다";
var deleteerror2 = "글쓴이 계정과 일치 하지 않아 삭제할 수 없습니다";


function erroralert(msg){
	alert(msg);
	history.back();
}

function deletecheck(listnum,memid,pagenum,id){
		if(memid != id){
			alert(deleteerror2);
			return false;
		}else{
			console.log(pagenum);
			location.replace("NoticedeletePro.do?num="+listnum+"&pageNum="+pagenum+"&writer="+id);
		}

}

//글수정
function passwdfocus(){
	passwdform.passwd.focus();
}
function passwdcheck(){
	if(! passwdform.passwd.value){
		alert(passwderror);
		passwdform.passwd.focus();
		return false;
	}
}



function writefocus(){
	
	writeform.writer.focus(); //작성자
}

function modifyfocus(){
	modifyform.subject.focus();
}

function modifycheck(){
	if(! modifyform.subject.value){
		alert(subjecterror);
		modifyform.subject.focus();
		return false;
	} else if (! modifyform.content.value){
		alert(contenterror);
		modifyform.content.focus();
		return false
	} else if(! modifyform.passwd.value){
		alert(passwderror);
		modifyform.passwd.focus();
		return false;
	}
}



//글쓰기
function writecheck(){
	if(! writeform.writer.value){ //작성자가 없다면 에러띄워라 
		alert(writererror)
		writeform.writer.focus();
		return false;
	} else if(! writeform.subject.value){ //제목
		alert(subjecterror)
		writeform.subject.focus();
		return false;
	} else if(! writeform.content.value){ //내용
		alert(contenterror);
		writeform.content.focus();
	} else if(! writeform.passwd.value){ //패스워드
		alert(passwderror);
		writeform.passwd.focus();
		return false;
	}
}
