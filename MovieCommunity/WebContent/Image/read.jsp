<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\form.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\style.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
<script src="<%=request.getContextPath() %>\js\httpRequest" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
<title>영화의 모든 것! 씨네리뷰▦  영화 리뷰</title>
<script type="text/javascript">
	function submitForm(){
		document.f.submit();
	}
	
	function resetForm(){
		document.f.reset();
	}
</script>
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
</script>
<style type="text/css">
		.id{
			font-weight:bold;
			font-size:13px;
		}
	</style>
<script>
function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}
var httpRequest = null;

function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}

function a(content, writer, img_num){
	var params = "content="+content+"&writer="+writer+"&img_num="
	+img_num;	
	sendRequest("<%=request.getContextPath()%>/Image/write.do", params,
				aResult, 'POST');
	}
	function aResult() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var jsonDoc = httpRequest.responseText;
				var comment = eval("(" + jsonDoc + ")");
				/* var listDiv = document.getElementById(comment[0].img_num); */
				var listDiv1 = document.getElementById("a");
				var listDiv2 = document.getElementById("b");
				
				listDiv1.innerHTML = "";
				listDiv2.innerHTML = "";
				for (i = 0; i < comment.length; i++) {
					listDiv1.innerHTML += comment[i].writer + "<br>";					
				}
				
				for (i = 0; i < comment.length; i++) {
					listDiv2.innerHTML += comment[i].content + "<br>";					
				}			

			} else {
				alert("서버 에러 발생: " + httpRequest.status);
			}
		}
	}
</script>
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
	
	<div align="center"><h3> 게시글 내용 </h3>
		<form name="f" action="<%=request.getContextPath() %>/" method="post">
			<table border="0" class="style4">
				<tr>
					<th width="150"> 게시글 번호 </th> 
					<td width="500"> ${img.num }</td>				
				</tr>
				<tr>
					<th width="150"> 작성자 </th> 
					<td width="500"> ${img.id }</td>				
				</tr>
				<tr>
					<th width="150"> 영화제목 </th> 
					<td width="500"> ${img.title }</td>				
				</tr>		
				<tr>
					<th width="150"> 포스터 </th> 
					<td width="500"> <img src="${img.path }" width="300" height="400"></td>		
				</tr>
				<tr>
					<th width="150"> 리뷰 </th> 
					<td width="500"> ${img.content }</td>		
				</tr>				
			</table>			
		</form>			
		<table class="style4">
		<tr>
			<td><h3>[리뷰내용]</h3></td>
		</tr>
		<tr>
			<td><b>작성자</b></td>	
			<td><b>내용</b></td>				
		</tr>				
		<tr>
			<td id="a">				
				<c:forEach var="data" items="${data }">
					${data.writer }<br>
				</c:forEach>				
			</td>
			<td id="b">				
				<c:forEach var="data" items="${data }">
					${data.content }<br>
				</c:forEach>				
			</td>			
		</tr>			
		<tr>
			<td>	
				<form class="inputbox">
					<input type="text" name="id" placeholder="아이디를 입력하세요" value="${id }">
					<input type="text" name="content" placeholder="내용을 입력하세요">					
					<input type="button" value="댓글등록" onClick="a(this.form.content.value, this.form.id.value, '${img.num }')">
				</form>
			</td>
		</tr>
		</table>
	</div>
</body>
</html>