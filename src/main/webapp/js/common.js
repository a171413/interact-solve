$(function(){
	if($('#menu').length){
		$('#menu').on('click', function () {
			if($('.header-nav').hasClass('on')){
				$('.header-nav').removeClass('on');
				$(this).removeClass('on');
			}else{
				$('.header-nav').addClass('on');
				$(this).addClass('on');
			}
		});
	}
});