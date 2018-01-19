/**
 * 
 */

var titleerror = "제목을 입력하세요.";
var TAerror = "내용을 입력하세요."
var taerror = "내용이 입력되지 않았습니다."
var Replyerror = "댓글 내용을 입력하세요."
var writeerror = "글작성에 실패하셨습니다."	
var geerror = "게시물이 존재하지 않습니다.";
var deleteerror = "게시물 삭제에 실패하였습니다. \n 나중에 다시 시도하여 주십시오.";
var RPeerror = "댓글 작성에 실패하였습니다. \n 나중에 다시 시도하여 주십시오."
var ReDelerror = "댓글 삭제에 실패하였습니다. \n 나중에 다시 시도하여 주십시오."

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
                     document.Recomwriteform.count.value=count;
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
           
           function ReComwriteck() {
        	   if(!Recomwriteform.r_title.value) {
        		   alert(titleerror);
        		   Recomwriteform.r_title.focus();
        			return false;
        	   } else if(!Recomwriteform.content_0.value) {
        		   alert(TAerror);
        		   Recomwriteform.content_0.focus();
        			return false;
        	   } else if (count>0) {
        		   var content = [];
        		   var confocus = [];
        		   for(var i=1; i < count;i++) {
        			   content[i] = eval("Recomwriteform.content_" + i + ".value");
        			   confocus[i] = eval("Recomwriteform.content_" + i + ".focus();");
        				if(!content[i]) {
        					alert(taerror);
        					confocus[i]
                 			return false;
        				}
        		   }
        	   }
           }
           
           function ReConCk() {
        	   if(!ReConRewriteform.r_reply_content.value) {
        		   alert(Replyerror);
        		   ReConRewriteform.r_reply_content.focus();
        		   return false;
        	   }
           }
           
           function erroralert(msg) {
        	   alert(msg);
        	   history.back();
           }
           
           function ReconDel(r_connum,pageNum)
           {        	      
        	     if(confirm("게시물을 삭제하시겠습니까?")){
        	         location.href = "RecomdeletePro.do?r_connum="+r_connum+"&pageNum="+pageNum;
        	     } 
           }    
           
           function ReDelCK(pageNum,r_connum,number,renum)
           {        	      
        	     if(confirm("댓글을 삭제하시겠습니까?")){
        	         location.href = "RecomReDelPro.do?r_connum="+r_connum+"&pageNum="+pageNum+"&number="+number+"&renum="+renum;
        	     } 
           }   
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           