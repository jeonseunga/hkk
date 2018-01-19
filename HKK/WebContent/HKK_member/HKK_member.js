var iderror ="아이디를 입력하시기 바랍니다";
var deleteiderror = "아이디가 다릅니다.삭제하실수 없습니다";
var pwerror = "비밀번호를 입력하세요";
var repwerror = "비밀번호가 다릅니다";
var emailerror = "메일주소를 확인하시기 바랍니다";
var emailerror1 = "@를 붙여주시기바랍니다";
var emailcodeerror = "이메일 인증번호를 입력하시기 바랍니다";
var iderrorx = "중복확인을 해주시기 바랍니다";
var inputerror = "회원 가입에 실패했습니다 \n 잠시 후 다시 시도하세요";
var emailnumerror2 = "이메일 인증코드가 틀렸습니다";
var noiderror = "없는 아이디 입니다. 확인해주세요";
var diffpasswderror = "비밀번호가 다릅니다 . 다시입력하시 바랍니다.";
var gendererror = "성별을 체크해주시기 바랍니다.";

/*체크박스 중복체크 제어*/
function oneCheck(chk){
    var obj = document.getElementsByName("gender");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}

function erroralert(msg){
   alert(msg);
   history.back();
}

/*join폼*/
function inputcheck(){
   
   if( ! insertform.id.value ){
      alert( iderror );
      insertform.id.focus();
      return false;
   }else if( !insertform.pw.value ){
      alert( pwerror );
      insertform.pw.focus();
      return false;
   }else if( insertform.pw.value != insertform.repw.value ){
      alert(repwerror);
      insertform.repw.focus();
      return false;
   }else if(!insertform.email.value){
      alert(emailerror);
      insertform.email.focus();
      return false;
   }else if( !insertform.emailcode.value){   
      alert(emailcodeerror);
      insertform.email.focus();
      return false;
   }else if(insertform.checkid.value ==0){
      alert(iderrorx);
      return false;
   }else if( insertform.authnum.value != insertform.emailcode.value ){
      alert( emailnumerror2 );
      insertform.emailcode.focus();
      return false;
   }
   if($('input:checkbox[name="gender"]').is(":checked")){
	   
   }else
	   {
	   alert( gendererror );
	      insertform.emailcode.focus();
	      return false;
	   }
  
  
}
/*아이디 중복체크*/

function confirmid(){
   if( !insertform.id.value ){
      alert(iderror);
      insertform.id.focus();
      return;
   }
   var url = "confirmId.do?id=" + insertform.id.value;
   open(url,"confirmwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200");
}

function confirmfocus(){
   confirmform.id.focus();
}
function confirmcheck(){
   if(!confirmform.id.value){
      alert( iderror);
      confirmform.id.focus();
      return false;
   }
}

function setid(id){
   opener.document.insertform.id.value = id;
   self.close();
   opener.document.insertform.pw.focus();
   opener.document.insertform.checkid.value=1;
}

function inputfocus(){
   insertform.id.focus();
}

function Change(){
   insertform.checkid.value=0;
}

/*이메일 인증*/
function sendemail(){
   if(!insertform.email.value){
      alert(emailerror);
      confirmform.email.focus();
      return false;
   }else if( insertform.email.value.length > 0 && insertform.email.value.indexOf("@") === -1){   
      alert(emailerror1);
      insertform.email.focus();
      return false;
   }else{
      var url = "";
      url = "sendEmail.do?email=" + insertform.email.value;
      open(url,"emailwindow",
            "statusbar=no, scrollbar=no, menubar=no, width=400px, height=200px");
   }   
}

function setAuthNum(){
   opener.document.insertform.authnum.value = sendemailform.authnum.value;
   //이메일 전송창에 히든으로 숨겨놓은 authnum을 부모창에 insertform에 넣어준다. 그런다음 비교가능 
   console.log(sendemailform.authnum.value);
   console.log("111111");
   self.close();
   opener.document.insertform.emailnum.focus();
}