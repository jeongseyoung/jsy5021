<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title> Movie </title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
	<script src="<%=request.getContextPath() %>/js/jquery-1.7.1.js" type="text/javascript"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/rolling.js"></script>	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/roll.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/list.css" />	
	<script src="<%=request.getContextPath() %>/js/main.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			  $('.bxslider').bxSlider();
		});		
	</script>	
	<style type="text/css">
		.id{
			font-weight:bold;
			font-size:13px;
		}
	</style>
</head>
<body>	
	<div align="right" style="margin-right: 60px; margin-top: 20px">
		<%String id = (String)session.getAttribute("id");
		%>
		<c:if test="${!empty sessionScope.id }">
			<p class="id"><div class="id">${id }�� ȯ���մϴ�.
			<a href="<%=request.getContextPath() %>/member/editMember.do" ><img src='<%=request.getContextPath() %>/data/editmem.png' width='80' height='30' hspace='10' border='0'></a>
			<a href="<%=request.getContextPath() %>/member/logout.do" ><img src='<%=request.getContextPath() %>/data/logoutmem.png' width='80' height='30' hspace='10' border='0'></a>
			<a href="<%=request.getContextPath() %>/member/del.do" ><img src='<%=request.getContextPath() %>/data/delmem.png' width='80' height='30' hspace='10' border='0'></a>
			<a href="<%=request.getContextPath() %>/reservation/list.do?" ><img src='<%=request.getContextPath() %>/data/mylist.png' width='80' height='30' hspace='10' border='0'></a>
			</div>			
		</c:if>
		<c:if test="${empty sessionScope.id }">
			<a href="<%=request.getContextPath() %>/member/form.do"><img src='<%=request.getContextPath() %>/data/insert.png' width='80' height='30' hspace='2' border='0'></a>
			<a href="<%=request.getContextPath() %>/member/login.jsp"><img src='<%=request.getContextPath() %>/data/loginmem.png' width='80' height='30' hspace='2' border='0'></a>			
		</c:if>
	</div>
	<img src='<%=request.getContextPath() %>/data/logo.png' width='250' height='100' hspace='2' border='0'>
    <div id="container">
   		<ul class="menu">
   			<li><a href="<%=request.getContextPath() %>/member/main.jsp">���� ȭ��</a>
   			<li><a href="<%=request.getContextPath() %>/movieInfo/list.do">��ȭ����</a>   	
   			<li><a href="<%=request.getContextPath() %>/reservation/form.jsp">��ȭ����</a>			
   			<li><a href="<%=request.getContextPath() %>/Image/list.do">��ȭ ����</a>	
       		<li><a href="<%=request.getContextPath() %>/board/list.do?nowPage=${0}">���� �Խ���</a>
       		<li><a href="<%=request.getContextPath() %>/qa/list.do">QnA</a>	       				    			     	
   		</ul>
	</div><br>	
	<div class="home-slider-wrapper" align="center">
		<ul class="bxslider">
		  	<li><img src="<%=request.getContextPath() %>/data/ban0.png" width="700" height="200"/></li>
		   	<li><img src="<%=request.getContextPath() %>/data/ban1.png" width="700" height="200"/></li>
		  	<li><img src="<%=request.getContextPath() %>/data/ban2.png" width="700" height="200"/></li>  
		</ul>
	</div>
	<div class="movie">
		<div class="mtitle" style="margin-left: 40px;">
			<span><b>[�����]</b> ����ϰ� ����� ����!</span>
		</div>
		<div align="center">
			<ul>
				<li>
					<div class="box">							
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=1"><img  src="<%=request.getContextPath() %>/data/frozen.jpg" style="width: 180px;height: 257px" /></a>
						<div class="title">
							�ܿ�ձ�				
						</div>
					</div>
				</li>	
				<li>				
					<div class="box">							
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=2"><img  src="<%=request.getContextPath() %>/data/Tangled.jpg" style="width: 180px;height: 257px" /></a>
						<div class="title">
							��Ǭ��				
						</div>				
					</div>		
				</li>
				<li>
					<div class="box">							
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=3"><img  src="<%=request.getContextPath() %>/data/Ralph.jpg" style="width: 180px;height: 257px" /></a>
						<div class="title">
							�ָԿ� ����				
						</div>				
					</div>			
				</li>
				<li>
					<div class="box">							
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=4"><img  src="<%=request.getContextPath() %>/data/BigHero.jpg" style="width: 180px;height: 257px" /></a>
						<div class="title">
							�� �����				
						</div>				
					</div>
				</li>
				<li>
					<div class="box">							
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=5"><img  src="<%=request.getContextPath() %>/data/Nemo.jpg" style="width: 180px;height: 257px" /></a>
						<div class="title">
							�ϸ� ã�Ƽ� 3D			
						</div>				
					</div>
				</li>			
			</ul>
		</div>
	</div>
	<div class="movie">
		<div class="mtitle" style="margin-left: 40px;">
			<span><b>[���긮]</b> �������� �ִϰ� ������� ��</span>
		</div>
		<div align="center">
			<ul>
				<li>
					<div class="box">							
						<img  src="<%=request.getContextPath() %>/data/SenAndChihiro.jpg" style="width: 180px;height: 257px" />
						<div class="title">
							���� ġ������ ���Ҹ�				
						</div>
					</div>
				</li>	
				<li>				
					<div class="box">							
						<img  src="<%=request.getContextPath() %>/data/Totoro.jpg" style="width: 180px;height: 257px" />
						<div class="title">
							�̿��� �����				
						</div>				
					</div>		
				</li>
				<li>
					<div class="box">							
						<img  src="<%=request.getContextPath() %>/data/Howl.jpg" style="width: 180px;height: 257px" />
						<div class="title">
							�Ͽ��� �����̴� ��			
						</div>				
					</div>			
				</li>
				<li>
					<div class="box">							
						<img  src="<%=request.getContextPath() %>/data/ThroughTime.jpg" style="width: 180px;height: 257px" />
						<div class="title">
							�ð��� �޸��� �ҳ�			
						</div>				
					</div>
				</li>
				<li>
					<div class="box">							
						<img  src="<%=request.getContextPath() %>/data/Summerwars.jpg" style="width: 180px;height: 257px" />
						<div class="title">
							��ӿ���		
						</div>				
					</div>
				</li>			
			</ul>
		</div>
	</div>
</body>
</html>