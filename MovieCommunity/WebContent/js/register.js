$(document).ready(function() {
	$('.blankid').hide();
	
	
	$('.blankpass').hide();
	
	
	
	$('.blankemail').hide();
	
	
	$('.userid').blur(function(){	
		data=$('.userid').val();
		var len=data.length;
		if(len<1){
			$('.blankid').show();
			
		}
		else{
			
			$('.blankid').hide();
				
		}
	});
	
	$('.userpwd').blur(function(){	
		data=$('.userpwd').val();
		var len=data.length;
		if(len<1){
			$('.blankpass').show();
			
		}
		else{
			
			$('.blankpass').hide();
						
		}
	});
	
	
	
	$('.useremail').blur(function(){	
		data=$('.useremail').val();
		var len=data.length;
		if(len<1){
			$('.blankemail').show();
			
		}
		else{
			
			$('.blankemail').hide();
				
			
		}
	});
	
	function validate_email(email){
		var pattern = new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
		return pattern.test(email);
	}
})