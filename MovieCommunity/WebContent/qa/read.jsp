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
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
<title>영화의 모든 것! 씨네리뷰▦  게시글 보기</title>
<script type="text/javascript">
	function a(x,pw,q){
		var n = prompt("password?","0000");	
		var num = q;
		if(pw!=n){
			alert("비밀번호가 틀렸습니다.");
			return;
		}
		if(x==1){			
			document.f.action+="/qa/editForm.do?num=${qas.num }";
		}else if(x==2){
			alert("정말 삭제하시겠습니까??");
			document.f.action+="/qa/qadel.do?num=${qas.num }";
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
	<div align="center"><h3> 게시글 내용 </h3>
	<form name="f" action="<%=request.getContextPath() %>/" method="post">
		<table border="0" class="style4">
			<tr>
				<th width="150"> 게시글 번호 </th> 
				<td width="500"> ${qas.num }</td>				
			</tr>
			<tr>
				<th width="150"> 작성자 </th> 
				<td width="500"> ${qas.writer }</td>				
			</tr>
			<tr>
				<th width="150"> 제목 </th> 
				<td width="500"> ${qas.title }</td>				
			</tr>
			<tr>
				<th width="150"> 작성일 </th> 
				<td width="500"> ${qas.qa_date}</td>		
			</tr>	
			
			<tr class="inputbox">
				<th width="150"> 내용 </th>
				<td width="500"> ${qas.content }</td>
			</tr>
			<tr>
				<td colspan="2" align="center" > 				
					<a href="javascript: a(1, ${qas.pwd}, ${qas.num})"><img src='<%=request.getContextPath() %>/data/editboard.png' width='80' height='30' hspace='2' border='0'></a> 
					<a href="javascript: a(2, ${qas.pwd}, ${qas.num})"><img src='<%=request.getContextPath() %>/data/delboard.png' width='80' height='30' hspace='2' border='0'></a> 
				</td>
			</tr>
		</table>	
		<table border="0" class="style4">
			<tr>
				<th width="50">작성자</th>				
				<th width="400">내용</th>					
				<th width="70">작성일</th>
			</tr>
			<c:forEach var="r" items="${qarep }">
				<tr>					
					<td width="100" align="center" style="font-weight: bold; font-size: 12px;"> ${r.writer }</td>				
									
					<td width="400" align="center" style="font-weight: bold; font-size: 12px;"> ${r.content }</td>				
								
					<td width="150" align="center" style="font-weight: bold; font-size: 12px;"> ${r.qarep_date }</td>				
				</tr>
			</c:forEach>
		</table>
		</form>	
		<form name="r" action="<%=request.getContextPath() %>/qa/writeRep.do?num=${qas.num }" method="post">
			<table border="0" class="style4">
				<tr class="inputbox">										
					<td> <input type="text" name="writer" size=10 value="${id }">
					<input type="text" name="content" size="80" placeholder="내용을 입력하세요"></td>
				</tr>				
				<tr>
					<td colspan="2" align="center">
						<input type="reset" value="취소"/>
						<input type="submit" value="등록"/>					
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>