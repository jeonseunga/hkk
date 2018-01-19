/* Korean initialisation for the jQuery calendar extension. */
/* Written by DaeKwon Kang (ncrash.dk@gmail.com), Edited by Genie. */
jQuery(function($){
	$.datepicker.regional['ko'] = {
		closeText: '닫기',
		prevText: '이전달',
		nextText: '다음달',
		currentText: '오늘',
		monthNames: ['1월','2월','3월','4월','5월','6월',
		'7월','8월','9월','10월','11월','12월'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월',
		'7월','8월','9월','10월','11월','12월'],
		dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
		dayNamesShort: ['일','월','화','수','목','금','토'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		weekHeader: 'Wk',
		dateFormat: 'mm/dd/yy',
		firstDay: 0,
		isRTL: false,
		showMonthAfterYear: true,
		yearSuffix: '년'};
	$.datepicker.setDefaults($.datepicker.regional['ko']);
	
	$(document).ready(function(){
		//$("#txtDate").datepicker(); 
		$("#txtDate").datepicker({
			showOn: "button", //이미지로 사용 , both : 엘리먼트와 이미지 동시사용
			buttonImage: "images/icon_date.gif", //이미지 주소
			buttonImageOnly: true //이미지만 보이기
		});

		$("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지 버튼 style적용

	});
});
