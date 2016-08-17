<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\form.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\style.css" type="text/css" media="screen"/>
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
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

<div align="center" style="margin-right: 100px;">

	<h3> ��ȭ ���� </h3><br>
	<table border="0" class="style4">
		<tr>
			
			<th width="250">��ȭ����</th>	
						
		</tr>
		<c:forEach var="data" items="${data }">	
			<tr>
						
				<td width="250" align="center">
					<a href="<%=request.getContextPath() %>/Image/read.do?num=${data.num }" style="text-decoration:none; color:black; font-weight: bold">${data.title }</a>
				</td>
				
			</tr>
		</c:forEach>	
		</table>
			
	<a href="<%=request.getContextPath() %>/Image/insert.jsp"><img src='<%=request.getContextPath() %>/data/writeboard.png' width='90' height='35' hspace='2' border='0'></a>
	<%-- 
	<br>
	<c:forEach var="imgView" items="${data }">
	<table border="0" class="style4">
		<tr>
			<th width="150"> ��ȭ���� </th> 
			<td width="500"> ${imgView.img.title }</td>
		</tr>
		<tr>
			<th width="150"> �Խ��� </th> 
			<td width="500"> ${imgView.img.id }</td>
		</tr>
		<tr>
			<th width="150"> ������ </th> 
			<td width="600"> <img src="${imgView.img.path }" width=400 height=500> </td>
		</tr>
		<tr>
			<th width="150"> ���� </th> 
			<td width="600"> ${imgView.img.content } </td>
		</tr>
	</table>
	<table class="style4" id="${imgView.img.num }">
		<tr>
			<td><h3>[���䳻��]</h3></td>
		</tr>
		<tr class="style4">
			<td><b>�ۼ���</b></td>	
			<td><b>����</b></td>				
		</tr>				
		<tr>
			<td id="a">				
				<c:forEach var="imgBoard" items="${imgView.list }">
					${imgBoard.writer }<br>
				</c:forEach>				
			</td>
			<td id="b">				
				<c:forEach var="imgBoard" items="${imgView.list }">
					${imgBoard.content }<br>
				</c:forEach>				
			</td>			
		</tr>			
		<tr>
			<td>	
				<form class="inputbox">
					<input type="text" name="id" placeholder="���̵� �Է��ϼ���" value="${id }">
					<input type="text" name="content" placeholder="������ �Է��ϼ���">					
					<input type="button" value="��۵��" onClick="a(this.form.content.value, this.form.id.value, '${imgView.img.num }')">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<div class="fb-like"
					  data-share="true"
					  data-width="450"
					  data-show-faces="true">
				</div>
			</td>
		</tr> --%>
	<%-- <br>
	
	
	[��ȭ����]${imgView.img.title }<br>
	[�Խ���]${imgView.img.id }<br>
	[������]<br>
	<img src="${imgView.img.path }" width=800 height=500>
		<br>
		
		
		
	<!-- ������  -->
	
	<a href="<%=request.getContextPath()%>/Image/editInsert.do?num=${imgView.img.num }">����</a> || 


<a href = "<%=request.getContextPath()%>/Image/del.do?num=${imgView.img.num }"><img src='<%=request.getContextPath() %>/data/delboard.png' width='90' height='35' hspace='2' border='0'></a>
<br>
	
	
	</td></tr><br><BR><br><br>
	<tr> --%>
	
		
		
		
		
		
		
		
		
		
		<%-- </c:forEach> --%>
		


	
	

	
</div>

</body>
</html>



