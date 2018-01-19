/**
 * 
 */

var titleerror = "제목을 입력하세요.";
var TAerror = "내용을 입력하세요."
var pwerror = "비밀번호를 입력하세요."
var writeerror = "글작성에 실패하셨습니다."	
var conpweerror = "비밀번호가 같지 않습니다."
var deleteerror = "비밀번호가 같지 않습니다.";
var RPeerror = "댓글 작성에 실패하였습니다. \n 나중에 다시 시도하여 주십시오."
var ReDelerror = "댓글 삭제에 실패하였습니다. \n 나중에 다시 시도하여 주십시오."
	
	function QnAwriteck() {
	   if(!QnAwriteform.q_title.value) {
		   alert(titleerror);
		   QnAwriteform.q_title.focus();
			return false;
	   } else if(!QnAwriteform.q_content.value) {
		   alert(TAerror);
		   QnAwriteform.q_content.focus();
			return false;
	   } else if (!QnAwriteform.q_pw.value) {
		   alert(pwerror);
		   QnAwriteform.q_pw.focus();
			return false;
	   }
	}

	function QnAConCk() {
		if(!QnAConForm.q_pw.value) {
			alert(pwerror);
			QnAConForm.q_pw.focus();
			return false;
		}
	}
	
	function QnADelCk() {
		if(!QnADelForm.q_pw.value) {
			alert(pwerror);
			QnADelForm.q_pw.focus();
			return false;
		}
	}
	
	function erroralert(msg) {
 	   alert(msg);
 	   history.back();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	