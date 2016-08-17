<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �ۼ�</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\form.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\style.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
<script src="<%=request.getContextPath() %>\js\jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript">
	function submitForm(){
		document.f.submit();
	}
	
	function resetForm(){
		document.f.reset();
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
	<div align="center">
	<h3>��ȭ ���� ���</h3>
	<form name="f" action="<%=request.getContextPath() %>/movieInfo/write.do" method="post">		
		<table border="0" class="style4">
			<tr class="inputbox">
				<th width="150"> ��ȭ���� </th>
				<td width="500"> <input type="text" name="title" size="80" placeholder="��ȭ������ �Է��ϼ���"></td>
			</tr>
			<tr class="inputbox">
				<th width="150"> ���� </th>
				<td width="500"> <input type="text" name="director" size="80" placeholder="�����̸��� �Է��ϼ���"></td>
			</tr>
			<tr class="inputbox">
				<th width="150"> ������ </th>
				<td width="500"> <input type="text" name="release_date" size="80" placeholder="�������� �Է��ϼ���"></td>
			</tr>
			<tr class="inputbox">
				<th width="150"> ������ </th>
				<td width="500"> <input type="text" name="video" size="80" placeholder="������ũ�� �Է��ϼ���"></td>
			</tr>
			<tr class="inputbox">
				<th width="150"> ���� </th>
				<td width="500"> <textarea rows="20" cols="82" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript: resetForm()"><img src='<%=request.getContextPath() %>/data/reinput.png' width='80' height='30' hspace='2' border='0'></a> 
					<a href="javascript: submitForm()"><img src='<%=request.getContextPath() %>/data/complete.png' width='80' height='30' hspace='2' border='0'></a> 
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>