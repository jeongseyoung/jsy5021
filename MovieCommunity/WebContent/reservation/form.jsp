<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Movie</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>\css\top.css" type="text/css" media="screen"/>
	<script src="<%=request.getContextPath() %>/js/jquery-1.7.1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>\js\httpRequest" type="text/javascript"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/rolling.js"></script>	
	<script src="<%=request.getContextPath() %>/js/seat.js"></script>
	<script src="<%=request.getContextPath() %>/js/date_picker.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/roll.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/list.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/reservation.css" />	
	<script src="<%=request.getContextPath() %>/js/main.js" type="text/javascript"></script>
	<style type="text/css">
		.id{
			font-weight:bold;
			font-size:13px;"
		}
	</style>	
	<script type="text/javascript">
		function movie(str, str1){		
			document.getElementById("movie").value = str;
			document.getElementById("post").innerHTML = "<img  src=" + '<%=request.getContextPath() %>/data/' + str1 +".jpg  width=100 height=150>";
		}
		
		function theater(str){
			document.getElementById("theater").value = str;
		}
		
		function running(str){
			document.getElementById("running").value = str;
		}
		
		function day(){
			var day = document.getElementById("calendar").value;		
			document.getElementById("reservday").value = day;
		}
		
		function person(str){
			document.getElementById("people").value = str + "��";
			document.getElementById("pay").value = (str * 10000) + "��";
		}
		
		function seat(){
			var seat = ""; 
			var cnt = 0;
			var people = document.getElementById("people").value;
			for(var i=0; i<document.form.seat.length; i++){
				if(document.form.seat[i].checked){
					seat += document.form.seat[i].value + " ";
					cnt++;
				}
			}
			people = people.substring(0,1);
			
			if(people==cnt){				
				document.getElementById("seat").value = seat;
			}
			else{
				alert("���õ� �ο����� ���� �ʽ��ϴ�.");
				document.getElementById("seat").value = "";
			}
		} 
		
		function confirm(){			
			var user = document.getElementById("userid").value;
			var movie = document.getElementById("movie").value;
			var theater = document.getElementById("theater").value;
			var running = document.getElementById("running").value;
			var reservday = document.getElementById("reservday").value;
			var people = document.getElementById("people").value;
			var pay = document.getElementById("pay").value;
			var seat = document.getElementById("seat").value
			
			if(user.length>=1 && movie.length>1 && theater.length>1 && running.length>1 && reservday.length>1 && people.length>1 && pay.length>1){
				alert("������ : " + user + "\n" + "��ȭ : " + movie + "\n" + "���� : " + theater + "\n" + "�Ͻ� : " + reservday + "\n" + "�ð� : " + running + "\n" + "�ο� : " + people + "\n" + "�¼� : " + seat + "\n" + "�����ݾ�: " + pay + "\n\n�Է��Ͻ� ������ �½��ϱ�?");
				document.f.action+="reservation/reserv.do?";
				document.f.submit();
				alert("���Ű� �Ϸ�Ǿ����ϴ�.");
			}else if(user.length<1){
				alert("�α��� �Ͻ� �� �̿��Ͻ� �� �ֽ��ϴ�.");
		    	location.href = "http://localhost:8800/MovieCommunity/member/login.jsp";
			}else{
				alert("���õ��� ���� ���� �����մϴ�.");
			}
		}
	</script>
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
		<h3> ��ȭ���� </h3><br><br>
	</div>	
	<div id="divMovie">			
		<div id="List" style="width:250px;">	
			<div>
				<img src='<%=request.getContextPath() %>/data/movie.png' width='120' height='30'/>
			</div>		
			<ul>
				<li> <a href="javascript: movie('��Ǫ�Ҵ�3','kungfu')"> ��Ǫ�Ҵ�3 </a></li>
				<li> <a href="javascript: movie('�˻����','violent')"> �˻���� </a></li>
				<li> <a href="javascript: movie('��������','melody')"> �������� </a></li>
				<li> <a href="javascript: movie('�´��̳�','gooddino')"> �´��̳� </a></li>
				<li> <a href="javascript: movie('�κ�, �Ҹ�','sori')"> �κ�, �Ҹ� </a></li>
				<li> <a href="javascript: movie('������Ʈ: �������� ���ƿ� ��','revenant')"> ������Ʈ: �������� ���ƿ� �� </a></li>
				<li> <a href="javascript: movie('���Ʈ','bigshort')"> ���Ʈ </a></li>
				<li> <a href="javascript: movie('�׳��� ������','day')"> �׳��� ������ </a></li>
				<li> <a href="javascript: movie('�����ڵ�: �� ��������','original')"> �����ڵ�: �� �������� </a></li>
				<li> <a href="javascript: movie('����','youth')"> ���� </a></li>
			</ul>
		</div>
		
		<div id="List" style="width:200px;">	
			<div>
				<img src='<%=request.getContextPath() %>/data/theater.png' width='120' height='30'/>
			</div>	
			<ul>
				<li> <a href="javascript: theater('CGVõ��')"> CGVõ�� </a></li>
				<li> <a href="javascript: theater('CGVõ����Ÿ��Ʈ')"> CGVõ����Ÿ��Ʈ</a></li>
				<li> <a href="javascript: theater('CGV����')"> CGV���� </a></li>
				<li> <a href="javascript: theater('CGV����')"> CGV���� </a></li>				
				<li> <a href="javascript: theater('�ް��ڽ� õ��')"> �ް��ڽ� õ�� </a></li>
				<li> <a href="javascript: theater('�ް��ڽ� ����')"> �ް��ڽ� ���� </a></li>
				<li> <a href="javascript: theater('�ް��ڽ� ����')"> �ް��ڽ� ���� </a></li>
				<li> <a href="javascript: theater('�Ե��ó׸� �ƻ��͹̳�')"> �Ե��ó׸� �ƻ��͹̳� </a></li>
				<li> <a href="javascript: theater('�Ե��ó׸� ����')"> �Ե��ó׸� ���� </a></li>
				<li> <a href="javascript: theater('�߿츮�ó׸�')"> �߿츮�ó׸� </a></li>
			</ul>
		</div>
		<div id="List" style="width:230px;">
			<div>
				<img src='<%=request.getContextPath() %>/data/day.png' width='120' height='30'/>
			</div>		
			<input type="text" id="calendar" name="target_date" size="8">
			<input type="button" value="�޷º���" onClick="datePicker(event,'target_date')">
			<input type="button" value="Ȯ��" onClick="day()"/>
		</div>
		<div id="List" style="width:200px;">
			<div>
				<img src='<%=request.getContextPath() %>/data/time.png' width='120' height='30'/>
			</div>				
			<ul>
				<li> <a href="javascript: running('1ȸ (08:20 ~ 10:00)')"> 1ȸ (08:20 ~ 10:00) </a></li>
				<li> <a href="javascript: running('2ȸ (08:50 ~ 10:30)')"> 2ȸ (08:50 ~ 10:30) </a></li>
				<li> <a href="javascript: running('3ȸ (09:10 ~ 10:50)')"> 3ȸ (09:10 ~ 10:50) </a></li>
				<li> <a href="javascript: running('4ȸ (09:50 ~ 11:30)')"> 4ȸ (09:50 ~ 11:30) </a></li>
				<li> <a href="javascript: running('5ȸ (10:00 ~ 11:40)')"> 5ȸ (10:00 ~ 11:40) </a></li>
				<li> <a href="javascript: running('6ȸ (10:20 ~ 12:00)')"> 6ȸ (10:20 ~ 12:00) </a></li>
				<li> <a href="javascript: running('7ȸ (11:00 ~ 12:40)')"> 7ȸ (11:00 ~ 12:40) </a></li>
				<li> <a href="javascript: running('8ȸ (11:10 ~ 12:50)')"> 8ȸ (11:10 ~ 12:50) </a></li>
				<li> <a href="javascript: running('9ȸ (12:40 ~ 14:20)')"> 9ȸ (12:40 ~ 14:20) </a></li>
				<li> <a href="javascript: running('10ȸ (15:30 ~ 17:10)')"> 10ȸ (15:30 ~ 17:10) </a></li>
				<li> <a href="javascript: running('11ȸ (18:20 ~ 20:00)')"> 11ȸ (18:20 ~ 20:00) </a></li>
				<li> <a href="javascript: running('12ȸ (21:20 ~ 23:00)')"> 12ȸ (21:20 ~ 23:00) </a></li>
				<li> <a href="javascript: running('13ȸ (24:00 ~ 25:40)')"> 13ȸ (24:00 ~ 25:40) </a></li>
				<li> <a href="javascript: running('14ȸ (24:20 ~ 26:00)')"> 14ȸ (24:20 ~ 26:00) </a></li>
			</ul>
		</div>		
		
		<div id="List" style="width:250px; height:500px;">	
			<div>
				<img src='<%=request.getContextPath() %>/data/seat.png' width='120' height='30'/><br><br>
			</div>	
			<select id="person" onchange="person(this.value)">
				<option value="0">�ο�����</option>
		        <option value="1">1��</option>
		        <option value="2">2��</option>
		        <option value="3">3��</option>
		        <option value="4">4��</option>
		        <option value="5">5��</option>
		        <option value="6">6��</option>
		        <option value="7">7��</option>
		        <option value="8">8��</option>
		        <option value="9">9��</option>		        
    		</select>
 			<br><br><img src='<%=request.getContextPath() %>/data/screen.png' width='220' height='15'/><br>
		    <form name="form">
		    <table border="0">
		        <tr align="center">
		            <td><label><input type="checkbox" name="seat" value="A1"/>A1</label></td>
		            <td><label><input type="checkbox" name="seat" value="A2"/>A2</label></td>
		            <td><label><input type="checkbox" name="seat" value="A3"/>A3</label></td>
		            <td><label><input type="checkbox" name="seat" value="A4"/>A4</label></td>
		            <td><label><input type="checkbox" name="seat" value="A5"/>A5</label></td>
		            <td><label><input type="checkbox" name="seat" value="A6"/>A6</label></td>
		        </tr>
		        <tr align="center">
		            <td><label><input type="checkbox" name="seat" value="B1"/>B1</label></td>
		            <td><label><input type="checkbox" name="seat" value="B2"/>B2</label></td>
		            <td><label><input type="checkbox" name="seat" value="B3"/>B3</label></td>
		            <td><label><input type="checkbox" name="seat" value="B4"/>B4</label></td>
		            <td><label><input type="checkbox" name="seat" value="B5"/>B5</label></td>
		            <td><label><input type="checkbox" name="seat" value="B6"/>B6</label></td>
		            <td><label><input type="checkbox" name="seat" value="B7"/>B7</label></td>
		            <td><label><input type="checkbox" name="seat" value="B8"/>B8</label></td>
		        </tr>
		        <tr align="center">
		            <td><label><input type="checkbox" name="seat" value="C1"/>C1</label></td>
		            <td><label><input type="checkbox" name="seat" value="C2"/>C2</label></td>
		            <td><label><input type="checkbox" name="seat" value="C3"/>C3</label></td>
		            <td><label><input type="checkbox" name="seat" value="C4"/>C4</label></td>
		            <td><label><input type="checkbox" name="seat" value="C5"/>C5</label></td>
		            <td><label><input type="checkbox" name="seat" value="C6"/>C6</label></td>
		            <td><label><input type="checkbox" name="seat" value="C7"/>C7</label></td>
		            <td><label><input type="checkbox" name="seat" value="C8"/>C8</label></td>
		            <td><label><input type="checkbox" name="seat" value="C9"/>C9</label></td>
		            <td><label><input type="checkbox" name="seat" value="C10"/>C10</label></td>
		        </tr>
		        <tr align="center">
		            <td><label><input type="checkbox" name="seat" value="D1"/>D1</label></td>
		            <td><label><input type="checkbox" name="seat" value="D2"/>D2</label></td>
		            <td><label><input type="checkbox" name="seat" value="D3"/>D3</label></td>
		            <td><label><input type="checkbox" name="seat" value="D4"/>D4</label></td>
		            <td><label><input type="checkbox" name="seat" value="D5"/>D5</label></td>
		            <td><label><input type="checkbox" name="seat" value="D6"/>D6</label></td>
		            <td><label><input type="checkbox" name="seat" value="D7"/>D7</label></td>
		            <td><label><input type="checkbox" name="seat" value="D8"/>D8</label></td>
		            <td><label><input type="checkbox" name="seat" value="D9"/>D9</label></td>
		            <td><label><input type="checkbox" name="seat" value="D10"/>D10</label></td>
		        </tr>
		    </table>
		    </form>
		    <input type="button" name="btn" value="Ȯ��" onClick="seat()"/>
		</div>	
	</div>
	
	<div id="result" style="width:300px;">		
		<div>
			<img src='<%=request.getContextPath() %>/data/result.png' width='120' height='30'/><br><br>
		</div>	
		<div id="post"><img  src='<%=request.getContextPath() %>/data/poster.png'  width="100" height="150"></div>
		<form name="f" action="<%=request.getContextPath() %>/" method="post">			
			<input type="text" name="movie" id="movie" size="22" readonly><br>
			������<input type="text" name="userid" id="userid" size="8" readonly value=${id }  ><br>
			����<input type="text" name="theater" id="theater" size="18" readonly><br>
			���Ͻ�<input type="text" name="reservday" id="reservday" size="8" readonly><br>
			�󿵽ð�<input type="text" name="running" id="running" size="15" readonly><br>
			�����ο� <input type="text" name="people" id="people" size="2" readonly><br>
			�¼�<input type="text" name="seat" id="seat" size="25" readonly><br>
			�����ݾ� <input type="text" name="pay" id="pay" size="3" readonly><br>	
		
			<a href="javascript: confirm()"><img src='<%=request.getContextPath() %>/data/reservation.png' width='200' height='50' hspace='10' border='0'></a>
		</form>
	</div>
	
</body>
</html>