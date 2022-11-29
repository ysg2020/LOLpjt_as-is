<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ġ �� ����</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
</head>
<body>
		<canvas id="myChart"></canvas>								                                   	
		<canvas id="myChart2"></canvas>	
								<table id ="example-table-1">
								 <thead>
                                        <tr>
                                            <th>�÷����� ���� �г���</th>
                                            <th>�÷����� è�Ǿ�</th>
                                            <th>ų</th>
                                            <th>����</th>
                                            <th>��ý�Ʈ</th>
                                            <th>���ط�</th>
                                            <th>���� ���ط�</th>
                                        </tr>
                                    </thead>
                                  <tbody>

                                 <c:set var="list2" value="${pvpList2}"  /> 

                                 <script type="text/javascript">
                                   	var ctx = document.getElementById('myChart').getContext('2d'); 
                                   	var chart = new Chart(ctx, { // type : 'bar' = ������Ʈ�� �ǹ��մϴ�. 
                                   		type: 'bar', // 
                                   		data: { 
                                   			labels:['${list2.summonerName[0]}','${list2.summonerName[1]}',
                                   				'${list2.summonerName[2]}','${list2.summonerName[3]}','${list2.summonerName[4]}'
                                   				,'${list2.summonerName[5]}','${list2.summonerName[6]}','${list2.summonerName[7]}',
                                   				'${list2.summonerName[8]}','${list2.summonerName[9]}'], 
                                   			datasets: [{ label: '���� ���ط�',
                                   						axis: 'y',
                                   						backgroundColor: 'rgb(255, 99, 132)', 
                                   						borderColor: 'rgb(255, 99, 132)', 
                                   						data: [${list2.totalDamageDealtToChampions2[0]},${list2.totalDamageDealtToChampions2[1]},
                                   							${list2.totalDamageDealtToChampions2[2]},${list2.totalDamageDealtToChampions2[3]},
                                   							${list2.totalDamageDealtToChampions2[4]},${list2.totalDamageDealtToChampions2[5]},
                                   							${list2.totalDamageDealtToChampions2[6]},${list2.totalDamageDealtToChampions2[7]},
                                   							${list2.totalDamageDealtToChampions2[8]},${list2.totalDamageDealtToChampions2[9]}  
                                   							] 
                                   			}] }

                                   	});
                                   	var ctx = document.getElementById('myChart2').getContext('2d'); 
                                   	var chart = new Chart(ctx, { // type : 'bar' = ������Ʈ�� �ǹ��մϴ�. 
                                   		type: 'bar', // 
                                   		data: { 
                                   			labels:['${list2.summonerName[0]}','${list2.summonerName[1]}',
                                   				'${list2.summonerName[2]}','${list2.summonerName[3]}','${list2.summonerName[4]}'
                                   				,'${list2.summonerName[5]}','${list2.summonerName[6]}','${list2.summonerName[7]}',
                                   				'${list2.summonerName[8]}','${list2.summonerName[9]}'], 
                                   			datasets: [{ label: '���� ���ط�',
                                   						axis: 'y',
                                   						backgroundColor: 'rgb(255, 99, 132)', 
                                   						borderColor: 'rgb(255, 99, 132)', 
                                   						data: [${list2.totalDamageTaken2[0]},${list2.totalDamageTaken2[1]},
                                   							${list2.totalDamageTaken2[2]},${list2.totalDamageTaken2[3]},
                                   							${list2.totalDamageTaken2[4]},${list2.totalDamageTaken2[5]},
                                   							${list2.totalDamageTaken2[6]},${list2.totalDamageTaken2[7]},
                                   							${list2.totalDamageTaken2[8]},${list2.totalDamageTaken2[9]}  
                                   							] 
                                   			}] }

                                   	});

                                   	</script>
                                   		<tr>
                                   		<c:forEach var="i" begin="0" end="9"> <!-- 1���� ��ġ���� �ȿ� 10���� ���� -->
										<tr>
                                           <td onClick="popupSubmit()">${list2.summonerName[i]}</td>
                                           <td >${list2.championName2[i]}</td>
                                           <td >${list2.kills2[i]}</td>
                                           <td >${list2.deaths2[i]}</td>
                                           <td >${list2.assists2[i]}</td>
                                           <td >${list2.totalDamageDealtToChampions2[i]}</td>
                                           <td >${list2.totalDamageTaken2[i]}</td>
                                        </tr>
                                        </c:forEach>
                                    	</tr>
                                    </tbody>
								</table>
							                                   	
        <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous">
		</script>								
</body>
</html>
<script type="text/javascript">
 function popupSubmit() {
	 $("#example-table-1 tr").click(function(){ 	

		var tr = $(this);
		var td = tr.children();
		var userNickname = td.eq(0).text();
		
	 opener.parent.location='/lol/search?nickname='+userNickname;
	 self.close();
	 });

}
</script>


