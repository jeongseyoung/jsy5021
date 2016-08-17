$(document).ready(function() {
	$('.starwars').hide();
	$('.himalayas').hide();
	$('.daeho').hide();
	$('.insideman').hide();	
	
	$(".small").hover(function() {
		$(this).parent().addClass('hover');
		var imgname = $(this).attr('href');		
		$(".large").fadeTo("slow", 0, function() {
			$('.large').attr('src', imgname);			
		}).fadeTo("slow", 1);
		if(imgname == "/MovieCommunity/data/starwars.jpg"){
			$('.starwars').show();
			$('.himalayas').hide();
			$('.daeho').hide();
			$('.insideman').hide();
		}else if(imgname == "/MovieCommunity/data/himalayas.jpg"){
			$('.starwars').hide();
			$('.himalayas').show();
			$('.daeho').hide();
			$('.insideman').hide();
		}else if(imgname == "/MovieCommunity/data/daeho.jpg"){
			$('.starwars').hide();
			$('.himalayas').hide();
			$('.daeho').show();
			$('.insideman').hide();
		}else{
			$('.starwars').hide();
			$('.himalayas').hide();
			$('.daeho').hide();
			$('.insideman').show();
		}
	}, function() {
		$(this).parent().removeClass('hover');
	});
});