<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	�� ���� �˻� 
</h1>

<P>  The time on the server is ${serverTime}. </P>
  <input id="Nickname" type="text" placeholder="Search for..." aria-label="Search for..." />
  <button type="button" onclick="search_click()">�˻�</button>

 <table id="example-table-1" >

                                    <thead>
                                        <tr>
                                            <th>��ȣ</th>
                                            <th>����</th>
                                            <th>�÷����� è�Ǿ�</th>
                                            <th>ų</th>
                                            <th>����</th>
                                            <th>��ý�Ʈ</th>
                                            <th>KDA</th>
                                            <th>���ط�</th>
                                            <th>���� ���ط�</th>
                                            <th>+</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="list" items="${pvpList}" varStatus="status">
                                   
                                        <tr <c:set var = "userwin" value = "${list.win}"/>
                                    		<c:choose > 
                                    			<c:when test="${userwin eq 'true'}">
                                    				style="background-color:skyblue";
                                    			</c:when>
                                    			<c:otherwise>
                                    				style="background-color:#FA5858";
                                    			</c:otherwise>
                                    		</c:choose>
                                    	 >
                                    	 <td >
                                    	 ${status.index}
                                    	 </td>
                                           <td >
                                           <c:set var = "userwin2" value = "${list.win}"/>
                                    		<c:choose > 
                                    			<c:when test="${userwin eq 'true'}">
                                    				��
                                    			</c:when>
                                    			<c:otherwise>
                                    				��
                                    			</c:otherwise>
                                    		</c:choose>
                                           </td>
                                           <td >${list.championName}</td>
                                           <td >${list.kills}</td>
                                           <td >${list.deaths}</td>
                                           <td >${list.assists}</td>
                                           <td >
                                       	<c:set var="kda" value="${(list.kills+list.assists)/list.deaths}"/>
                                           	<c:out value="${kda+(1-(kda%1))%1}"/> <!-- �ø� ó�� --> 
                                           </td>
                                           <td >${list.totalDamageDealtToChampions}</td>
                                           <td >${list.totalDamageTaken}</td>
                                           <td onClick="fn_layer_popup()" >��</td>
                                          
                                        </tr>
                             		
                                       </c:forEach> 
                                       
                                    </tbody>
                                </table>

<%-- 								<table>  ��ġ�� 10���� ���������� ��� �������� ���̺�
                                    <thead>
                                        <tr>
                                            <th>����</th>
                                            <th>�÷����� è�Ǿ�</th>
                                            <th>ų</th>
                                            <th>����</th>
                                            <th>��ý�Ʈ</th>
                                            <th>KDA</th>
                                            <th>���ط�</th>
                                            <th>���� ���ط�</th>
                                        </tr>
                                    </thead>
                                  <tbody>
                                    <c:forEach var="list2" items="${pvpList2}" >
                                   		<tr>
                                   		<c:forEach var="i" begin="0" end="9">
										<tr>
										
                                           <td >${list2.championName2[i]}</td>
                                           <td >${list2.kills2[i]}</td>
                                           <td >${list2.deaths2[i]}</td>
                                           <td >${list2.assists2[i]}</td>
                                           <td >${list2.totalDamageDealtToChampions2[i]}</td>
                                           <td >${list2.totalDamageTaken2[i]}</td>
                                        </tr>
                                        </c:forEach>
                                    	</tr>
                                    </c:forEach>
                                    </tbody>
                                </table> --%>
                                
<%--                                 <div id="popup_layer" 
									style="position:absolute;  
									border:double; 
									top:500px;  
									left:500px;  
									width:1000px; 
									height:1000px; 
									z-index:1;  
									visibility:hidden; 
									background-color:white;"> 
								<table>
                                  <tbody>

                                    <c:forEach var="list2" items="${pvpList2}" begin="0" end="0" > <!--  begin ,end �߰� (1���� ����Ʈ = 1���� ��ġ����) --> 
                                   		<tr>
                                   		<c:forEach var="i" begin="0" end="9"> <!-- 1���� ��ġ���� �ȿ� 10���� ���� -->
										<tr>
                                           <td >${list2.championName2[i]}</td>
                                           <td >${list2.kills2[i]}</td>
                                           <td >${list2.deaths2[i]}</td>
                                           <td >${list2.assists2[i]}</td>
                                           <td >${list2.totalDamageDealtToChampions2[i]}</td>
                                           <td >${list2.totalDamageTaken2[i]}</td>
                                        </tr>
                                        </c:forEach>
                                    	</tr>
                                    </c:forEach>
                                    </tbody>
								</table>

								</div> --%>


<input type="button" value="click" onclick="fn_layer_popup()"> 
		<div class="col-lg-12" id="ex1_Result1" ></div> 
		<div class="col-lg-12" id="ex1_Result2" ></div> 

        <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous">
		</script>
</body>
</html>
<script type="text/javascript">
var df =document.myForm;
var matchNum;
$(document).ready(function(){  <!-- �ε� �ɶ� �˻��� ������ ǥ������ -->
	console.log("start");
/* 	if(nickname != null){
		$("#Nickname").val() = nickname;
		console.log("start2");
	} */
});
function  search_click() {
	var nickname=$("#Nickname").val();
	var page ="/lol/search?nickname="+nickname;  <!-- �Ķ���͸� �ٿ��� ��Ʈ�ѷ��� ���� �ǰ��� -->
	
	location.href=page;
	
}
function  fn_layer_popup() {
	$("#example-table-1 tr").click(function(){ 	
/* 	var layer = document.getElementById("popup_layer"); 
	layer.style.visibility="visible"; */
	var nickname=$("#Nickname").val();
	var tr = $(this);
	var td = tr.children();
	var no = parseInt(td.eq(0).text());
	
	console.log(no);
	console.log(typeof(no));
	var popUrl = "/lol/searchDtl?nickname="+nickname+"&matchNum="+no;
	var pop_name ="������";
    var popOption = "width=600, height=450, top=100, left=300,location=no";
    
	window.open(popUrl,pop_name,popOption);

	});
 	
}

//���� �Լ�
$("#example-table-1 tr").click(function(){ 	

	var str = ""
	//var tdArr = new Array();	// �迭 ����
	
	// ���� Ŭ���� Row(<tr>)
	var tr = $(this);
	var td = tr.children();
	
	// tr.text()�� Ŭ���� Row �� tr�� �ִ� ��� ���� �����´�.
//	console.log("Ŭ���� Row�� ��� ������ : "+tr.text());
	
	// �ݺ����� �̿��ؼ� �迭�� ���� ��� ����� �� �� �ִ�.
/* 	td.each(function(i){
		tdArr.push(td.eq(i).text());
	}); */
	
//	console.log("�迭�� ��� �� : "+tdArr);
	
	// td.eq(index)�� ���� ���� ������ ���� �ִ�.
	var no = td.eq(0).text();
	var userid = td.eq(1).text();
	var name = td.eq(2).text();
	var email = td.eq(3).text();
	console.log(no);

	
	str +=	" * Ŭ���� Row�� td�� = No. : <font color='red'>" + no + "</font>" +
			", ���̵� : <font color='red'>" + userid + "</font>" +
			", �̸� : <font color='red'>" + name + "</font>" +
			", �̸��� : <font color='red'>" + email + "</font>";		
	
	$("#ex1_Result1").html(" * Ŭ���� Row�� ��� ������ = " + tr.text());		
	$("#ex1_Result2").html(str);
	
	
});


</script>
