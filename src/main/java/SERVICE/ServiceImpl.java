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
	//전역변수로 저장
	String puuid;
	String[] matchid;
	
	//
	StringBuffer result;
	StringBuilder urlBuilder;
	URL url;
	HttpURLConnection conn;
	int gameCnt = 10; //가져올 게임 매치 개수

	
	public void requestAPI(String RequestURL) {
		try {
		 result = new StringBuffer();
		 urlBuilder = new StringBuilder(RequestURL);
			/* urlBuilder.append("&type=json"); */
		 url = new URL(urlBuilder.toString());
		 conn = (HttpURLConnection) url.openConnection(); // url를 통해 HttpURLConnection 클래스를 생성한다.
		 conn.setRequestMethod("GET");
		 BufferedReader rd;
			 if(conn.getResponseCode()>=200 &&conn.getResponseCode()<=300) {
				 rd= new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));    // 스트림으로 반환 결과값을 받는다.
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
	 
	 
	 //테스트 출력용
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
		
		 getUserInfo(nickname); // puuid를 가져 오기 위함
		 requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+"/ids?start=0&count=20&api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
		 //System.out.println(result);
		 
		 MatchInfo matchInfo = new MatchInfo(result.toString(),gameCnt);
		 matchid  =matchInfo.getMatchId();
		 
		 System.out.println(matchid);
		 System.out.println("--구분--");
		 
		 return matchInfo;
			 
			
	}

	@Override
	public List<MatchInfoDtl> getMatchInfoDtl(String nickname) {
		// TODO Auto-generated method stub
		getMatchInfo(nickname);
		List<MatchInfoDtl> pvpList = new ArrayList<MatchInfoDtl>();
		
		
		
		for(int i=0;i<gameCnt;i++) {//매치 개수 만큼 반복
			requestAPI("https://asia.api.riotgames.com/lol/match/v5/matches/"+matchid[i]+"?api_key=RGAPI-f458fbc9-911f-470a-8796-6b71fb38baa8");
			System.out.println("게임전적들 "+result);
			
			MatchInfoDtl matchInfoDtl = new MatchInfoDtl(result.toString(),nickname);
			
			pvpList.add(matchInfoDtl);
			
			
			
		}	 
		System.out.println("총 게임 전적들 "+pvpList);
		System.out.println("첫번쨰 전적 "+pvpList.get(0).getSummonerName());
		System.out.println("두번쨰 전적 "+pvpList.get(1).getSummonerName());
		return pvpList;
	}
	
	//1개의 매치의 상세정보(10명의 유저 정보) 가져오기
	@Override
	public MatchInfoDtl getAllMatchInfoDtl(String nickname,int matchNum) {
		// TODO Auto-generated method stub
		getMatchInfo(nickname);
		//List<MatchInfoDtl> pvpList2 = new ArrayList<MatchInfoDtl>();
		
		//int gameCnt = 20; //가져올 게임 매치 개수
		
		/*
		for(int i=0;i<gameCnt;i++) {//매치 개수 만큼 반복 (매치 정보는 모두 가져온후 클릭한 matchNum에 맞는 정보만 따로 가져옴
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
