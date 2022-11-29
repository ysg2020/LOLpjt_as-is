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
	롤 전적 검색 
</h1>

<P>  The time on the server is ${serverTime}. </P>
  <input id="Nickname" type="text" placeholder="Search for..." aria-label="Search for..." />
  <button type="button" onclick="search_click()">검색</button>

 <table id="example-table-1" >

                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>승패</th>
                                            <th>플레이한 챔피언</th>
                                            <th>킬</th>
                                            <th>데스</th>
                                            <th>어시스트</th>
                                            <th>KDA</th>
                                            <th>피해량</th>
                                            <th>받은 피해량</th>
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
                                    				승
                                    			</c:when>
                                    			<c:otherwise>
                                    				패
                                    			</c:otherwise>
                                    		</c:choose>
                                           </td>
                                           <td >${list.championName}</td>
                                           <td >${list.kills}</td>
                                           <td >${list.deaths}</td>
                                           <td >${list.assists}</td>
                                           <td >
                                       	<c:set var="kda" value="${(list.kills+list.assists)/list.deaths}"/>
                                           	<c:out value="${kda+(1-(kda%1))%1}"/> <!-- 올림 처리 --> 
                                           </td>
                                           <td >${list.totalDamageDealtToChampions}</td>
                                           <td >${list.totalDamageTaken}</td>
                                           <td onClick="fn_layer_popup()" >▼</td>
                                          
                                        </tr>
                             		
                                       </c:forEach> 
                                       
                                    </tbody>
                                </table>

<%-- 								<table>  매치의 10명의 유저정보를 모두 가져오는 테이블
                                    <thead>
                                        <tr>
                                            <th>승패</th>
                                            <th>플레이한 챔피언</th>
                                            <th>킬</th>
                                            <th>데스</th>
                                            <th>어시스트</th>
                                            <th>KDA</th>
                                            <th>피해량</th>
                                            <th>받은 피해량</th>
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

                                    <c:forEach var="list2" items="${pvpList2}" begin="0" end="0" > <!--  begin ,end 추가 (1개의 리스트 = 1개의 매치정보) --> 
                                   		<tr>
                                   		<c:forEach var="i" begin="0" end="9"> <!-- 1개의 매치정보 안에 10명의 유저 -->
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
$(document).ready(function(){  <!-- 로드 될때 검색한 내용을 표시해줌 -->
	console.log("start");
/* 	if(nickname != null){
		$("#Nickname").val() = nickname;
		console.log("start2");
	} */
});
function  search_click() {
	var nickname=$("#Nickname").val();
	var page ="/lol/search?nickname="+nickname;  <!-- 파라미터를 붙여서 컨트롤러가 맵핑 되게함 -->
	
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
	var pop_name ="상세정보";
    var popOption = "width=600, height=450, top=100, left=300,location=no";
    
	window.open(popUrl,pop_name,popOption);

	});
 	
}

//참고 함수
$("#example-table-1 tr").click(function(){ 	

	var str = ""
	//var tdArr = new Array();	// 배열 선언
	
	// 현재 클릭된 Row(<tr>)
	var tr = $(this);
	var td = tr.children();
	
	// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
//	console.log("클릭한 Row의 모든 데이터 : "+tr.text());
	
	// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
/* 	td.each(function(i){
		tdArr.push(td.eq(i).text());
	}); */
	
//	console.log("배열에 담긴 값 : "+tdArr);
	
	// td.eq(index)를 통해 값을 가져올 수도 있다.
	var no = td.eq(0).text();
	var userid = td.eq(1).text();
	var name = td.eq(2).text();
	var email = td.eq(3).text();
	console.log(no);

	
	str +=	" * 클릭된 Row의 td값 = No. : <font color='red'>" + no + "</font>" +
			", 아이디 : <font color='red'>" + userid + "</font>" +
			", 이름 : <font color='red'>" + name + "</font>" +
			", 이메일 : <font color='red'>" + email + "</font>";		
	
	$("#ex1_Result1").html(" * 클릭한 Row의 모든 데이터 = " + tr.text());		
	$("#ex1_Result2").html(str);
	
	
});


</script>
