<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\form.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
<style type="text/css">
		.id{
			font-weight:bold;
			font-size:13px;
		}
	</style>
<title>영화 정보</title>
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
	<div align="center">
		<h3> 영화 정보 </h3><br>
	</div>
	
	<div class="tableClass">
		<div align="center" >
		<table border="0" class="style4">
			<tr>
				<th width="80">게시글 번호</th>
				<th width="250">제목</th>	
				<th width="100">감독</th>
				<th width="100">개봉일</th>
			</tr>
			<c:forEach var="b" items="${Movie }">
				<tr>
					<td width="80" align="center">${b.num }</td>				
					<td width="250" align="center">
						<a href="<%=request.getContextPath() %>/movieInfo/movieread.do?num=${b.num }" style="text-decoration:none; color:black; font-weight: bold">${b.title }</a>				
					</td>
					<td width="100" align="center">${b.director }</td>
					<td width="100" align="center">${b.release_date }</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	<div align="right" style="margin-right: 100px;">		
		<a href="<%=request.getContextPath() %>/movieInfo/form.jsp"><img src='<%=request.getContextPath() %>/data/writeboard.png' width='90' height='35' hspace='2' border='0'></a>
	</div>
</body>
</html>