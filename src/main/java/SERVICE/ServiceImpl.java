package SERVICE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;


import INFO.MatchInfo;
import INFO.MatchInfoDtl;
import INFO.UserInfo;

@Service
public class ServiceImpl implements lolService{
	//���������� ����
	String puuid;
	String[] matchid;
	
	//
	StringBuffer result;
	StringBuilder urlBuilder;
	URL url;
	HttpURLConnection conn;
	int gameCnt = 10; //������ ���� ��ġ ����

	
	public void requestAPI(String RequestURL) {
		try {
		 result = new StringBuffer();
		 urlBuilder = new StringBuilder(RequestURL);
			/* urlBuilder.append("&type=json"); */
		 url = new URL(urlBuilder.toString());
		 conn = (HttpURLConnection) url.openConnection(); // url�� ���� HttpURLConnection Ŭ������ �����Ѵ�.
		 conn.setRequestMethod("GET");
		 BufferedReader rd;
			 if(conn.getResponseCode()>=200 &&conn.getResponseCode()<=300) {
				 rd= new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));    // ��Ʈ������ ��ȯ ������� �޴´�.
			 } else {
				 rd= new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			 }
			 
		 String line;
		 while((line=rd.readLine())!=null) {
			 result.append(line+"\n");
		 }
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public UserInfo getUserInfo (String nickname){
		// TODO Auto-generated method stub
		 requestAPI("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+nickname+"?api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
		 System.out.print("result"+result);
		 UserInfo userInfo = new UserInfo(result.toString());
		 puuid=userInfo.getPuuid();
	 
	 
	 //�׽�Ʈ ��¿�
		/*
		 * String username= (String) userInfo.getName(); int userlevel= (int)
		 * userInfo.getSummonerLevel(); String userid = (String) userInfo.getId();
		 * String accountId = (String) userInfo.getAccountId();
		 * System.out.println(username+"\n"+userlevel);
		 */
		
		
	 return userInfo;

	}

	@Override
	public MatchInfo getMatchInfo(String nickname) {
		// TODO Auto-generated method stub
		
		 getUserInfo(nickname); // puuid�� ���� ���� ����
		 requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+"/ids?start=0&count=20&api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
		 //System.out.println(result);
		 
		 MatchInfo matchInfo = new MatchInfo(result.toString(),gameCnt);
		 matchid  =matchInfo.getMatchId();
		 
		 System.out.println(matchid);
		 System.out.println("--����--");
		 
		 return matchInfo;
			 
			
	}

	@Override
	public List<MatchInfoDtl> getMatchInfoDtl(String nickname) {
		// TODO Auto-generated method stub
		getMatchInfo(nickname);
		List<MatchInfoDtl> pvpList = new ArrayList<MatchInfoDtl>();
		
		
		
		for(int i=0;i<gameCnt;i++) {//��ġ ���� ��ŭ �ݺ�
			requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/"+matchid[i]+"?api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
			System.out.println("���������� "+result);
			
			MatchInfoDtl matchInfoDtl = new MatchInfoDtl(result.toString(),nickname);
			
			pvpList.add(matchInfoDtl);
			
			
			
		}	 
		System.out.println("�� ���� ������ "+pvpList);
		System.out.println("ù���� ���� "+pvpList.get(0).getSummonerName());
		System.out.println("�ι��� ���� "+pvpList.get(1).getSummonerName());
		return pvpList;
	}
	
	//1���� ��ġ�� ������(10���� ���� ����) ��������
	@Override
	public MatchInfoDtl getAllMatchInfoDtl(String nickname,int matchNum) {
		// TODO Auto-generated method stub
		getMatchInfo(nickname);
		//List<MatchInfoDtl> pvpList2 = new ArrayList<MatchInfoDtl>();
		
		//int gameCnt = 20; //������ ���� ��ġ ����
		
		/*
		for(int i=0;i<gameCnt;i++) {//��ġ ���� ��ŭ �ݺ� (��ġ ������ ��� �������� Ŭ���� matchNum�� �´� ������ ���� ������
			requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/"+matchid[i]+"?api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
			//System.out.println(result);
			
			MatchInfoDtl matchInfoDtl2 = new MatchInfoDtl(result.toString());
			
			pvpList2.add(matchInfoDtl2);
			
			
		}	
		*/
		requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/"+matchid[matchNum]+"?api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
		MatchInfoDtl matchInfoDtl2 = new MatchInfoDtl(result.toString());
		//return pvpList2.get(matchNum);
		return matchInfoDtl2;
	}
	
}
