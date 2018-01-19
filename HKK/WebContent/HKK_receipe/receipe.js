var count = 0;
  
   function addForm(){
         var addedFormDiv = document.getElementById("addedFormDiv");
        
         var str = "";
         str+="<span style='line-height:1%'><br></span><br><input type='file' id='img_"+count+ "' name='image_"+count;
         str+="'><br><span style='line-height:1%'><br></span>" + "<textarea rows='5' cols='80' style='border: 1px solid lightgray; resize:none;' name='content_"+count+"'></textarea><br><span style='line-height:10%'><br></span>";
         str+="<input class = 'button2' type='Button' value='삭제' onclick='delForm()'><br>";
         // 추가할 폼(에 들어갈 HTML)
         
         var addedDiv = document.createElement("div"); // 폼 생성
         addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를 위해)
         addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
         addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽
  
         count++;
         document.writeform.count.value=count;
         // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
   }

   function delForm(){
         var addedFormDiv = document.getElementById("addedFormDiv");
  
         if(count >1){ // 현재 폼이 두개 이상이면
            var addedDiv = document.getElementById("added_"+(--count));
            // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
            addedFormDiv.removeChild(addedDiv); // 폼 삭제 
         }else{ // 마지막 폼만 남아있다면
                    document.baseForm.reset(); // 폼 내용 삭제
         }
   }
   
   var titleerror = "타이틀을 입력해주세요";
   var contenterror = "내용을 입력해주세요";
   var recontenterror = "댓글을 입력해 주세요";
   var deleteerror = "게시물  삭제에 실패하였습니다 \n 나중에 다시 시도하여 주십시오";
   var noiderror = "자기 게시물이 아닙니다 \n 자기 게시물만 삭제할 수 있습니다";
   var writeerror = "글작성에 실패하셨습니다."
   
   function erroralert( msg ){
      alert( msg );
      history.back();
   }
   
   function backalert( msg ){
	   	  var connum = deleteform.connum.value;
	   	  var foodcode = deleteform.foodcode.value;
	      alert( msg );
	      location.replace("receipeView.do?food_connum="+connum+"&food_code="+foodcode);
   }
 
   function writeCheck(){
      if(! writeform.food_title.value){
         alert(titleerror);
         writeform.food_title.focus();
         return false;
      }else if(! writeform.content_0.value){
         alert(contenterror);
         writeform.content_0.focus();
         return false;
      }else if(count>0){
         var content = [];
           var confocus = [];
           for(var i=1; i < count;i++) {
               content[i] = eval("writeform.content_" + i + ".value");
           confocus[i] = eval("writeform.content_" + i + ".focus();");
               if(!content[i]) {
                  alert(contenterror);
                  confocus[i]
                  return false;
               }
            }
      }
   }
   
   function Viewcheck() {
	   if(!ViewForm.r_reply_content.value) {
		   alert(recontenterror);
		   ViewForm.r_reply_content.focus();
           return false;
	   }
   }    

   function ReDel(food_connum,food_renum,food_r_code)
   {        	      
	    if(confirm("댓글을 삭제하시겠습니까?")){
	    	location.href = "HKK_receipeReDelPro.do?food_r_connum="+food_connum+"&food_renum="+food_renum+"&food_r_code="+food_r_code;
	    } 
   }
   
   function scrap(food_connum,image_path,food_title,food_id,food_code)
   {        	      
	    if(confirm("스크랩을 원하시면 확인을 눌러주세요.")){
	    	location.href = "HKK_scrapPro.do?s_connum="+food_connum+"&s_img_path="+image_path+"&s_r_title="+food_title+"&s_r_id="+food_id+"&food_code="+food_code;
	    } 
   }
   
   
   function confirmDelete(food_connum, food_code)
   {
	   if(confirm("글을 삭제하시겠습니까?")){
		   location.href = "receipeDeletePro.do?food_connum="+food_connum+"&food_code="+food_code;
   	       return true;
   	   } else {
   	        return false;
   	   }
   }
   
   
   
   
   
   