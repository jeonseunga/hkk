var deleteiderror = "본인 글만 삭제 하실 수 있습니다.";
var inserterro = "가입에 실패하셨습니다. 다시시도해 주세요";
var deleteerror = "삭제에 실패하셨습니다. 다시시도해 주세요";
var dateerror="선택된 날짜가 없습니다";
var searchiderror="찾으실 아이디를 입력하세요";
var nosearch = "검색하신 id에 관련된 글이 없습니다";
var nocontent = "해당하는 날짜에 글이 없습니다"


function confirmDelete(t_listnum)
{
	console.log(t_listnum);
	
	 if(confirm("삭제하시겠습니까?")){
	        location.href = "todayHKKdeletePro.do?t_listnum="+t_listnum;
	        return true;
	    } else {
	        return false;
	    }
}

function erroralert( msg ){
	alert( msg );
	history.back();
}

function calender(){
	var url = "HKK_hkkdate.do";
	open(url,"confirmwindow", "statusbar=no, scrollbar=no, menubar=no, width=500, height=500");
}



function selectdate(){
	
	if(!selectDateform.t_date.value){
		alert(dateerror);
		return false;
		
	}
		opener.location.href="todayHKK.do?t_date="+ selectDateform.t_date.value;
		
		self.close();

}



function searchid(){
	if(!searchidform.id.value){
		alert(searchiderror);
		return false;
	}
	location.href='todayHKK.do?t_id=' + searchidform.id.value;
}












