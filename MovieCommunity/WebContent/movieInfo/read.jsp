<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\form.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
<title>${Movie.title }</title>
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '156952391346150',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  function pstFaceBook(num){
		location.href = "http://localhost:8000/MovieCommunity/movieInfo/movieread.do?num" + ${Movie.num };
		location.protocol = "http:";
		location.host = "localhost:8000";
		location.pathname = "/MovieCommunity/movieInfo/movieread.do";
		location.search = "?num=" + ${Movie.num };		
	    var href = "http://www.facebook.com/sharer.php?u=" +encodeURIComponent(location.href);//+ "&t=" + encodeURIComponent(title);
	    window.open(href, 'facebook', 'toolbar=0,status=0,width=626,height=436');
	    return false;
	}
</script>

<script type="text/javascript">
	function a(x,q){
		/* var n = prompt("password?","0000");	
		var num = q;
		if(pw!=n){
			alert("비밀번호가 틀렸습니다.");
			return;
		} */
		if(x==1){			
			document.f.action+="movieInfo/editForm.do?num=${Movie.num }";
		}else if(x==2){
			alert("정말 삭제하시겠습니까??");
			document.f.method ="post";
			document.f.action+="moviedel.do?num=${Movie.num }";
		}
		document.f.submit();
	}
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
			<p class="id"><div class="id">${id }님 환영합니다.
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
   			<li><a href="<%=request.getContextPath() %>/member/main.jsp">메인 화면</a>
   			<li><a href="<%=request.getContextPath() %>/movieInfo/list.do">영화정보</a>   	
   			<li><a href="<%=request.getContextPath() %>/reservation/form.jsp">영화예매</a>			
   			<li><a href="<%=request.getContextPath() %>/Image/list.do">영화 리뷰</a>	
       		<li><a href="<%=request.getContextPath() %>/board/list.do?nowPage=${0}">자유 게시판</a>
       		<li><a href="<%=request.getContextPath() %>/qa/list.do">QnA</a>	       				    			     	
   		</ul>
	</div><br>	
	<div align="center"><h3> 영화정보 </h3>
	<form name="f" action="<%=request.getContextPath() %>/" method="post">
		<table border="0" class="style4">
				<tr>
				<th width="50"> 영화제목 </th>
				<td width="500"> ${Movie.title }</td>
			</tr>
			<tr>
				<th width="50"> 감독 </th>
				<td width="500"> ${Movie.director }</td>
			</tr>
			<tr>
				<th width="50"> 개봉일 </th>
				<td width="500"> ${Movie.release_date }</td>
			</tr>
			<tr>
				<th width="50"> 동영상 </th>
				<td width="500"> ${Movie.video }</td>
			</tr>
			<tr>
				<th width="50"> 내용 </th>
				<td width="500"> <textarea rows="20" cols="82" name="content"> ${Movie.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript: a(1, ${Movie.num})"><img src='<%=request.getContextPath() %>/data/editboard.png' width='80' height='30' hspace='2' border='0'></a> 
					<a href="javascript: a(2, ${Movie.num})"><img src='<%=request.getContextPath() %>/data/delboard.png' width='80' height='30' hspace='2' border='0'></a> 
				</td>
			</tr>
			<tr>
				<td> <b>[SNS]</b></td>
			</tr>
			<tr>
				<td>
					<!-- <div class="fb-like"
						  data-share="true"
						  data-width="450"
						  data-show-faces="true">
					</div>  -->
					<a href="javascript:pstFaceBook(${Movie.num })"><img src='<%=request.getContextPath() %>/data/fb.png' width='40' height='40' hspace='2' border='0'></a>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>