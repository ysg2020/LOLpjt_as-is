package INFO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MatchInfoDtl {
	

	boolean win; 
	int kills;
	int deaths;
	int assists;
	String championName;
	int totalDamageDealtToChampions;
	int totalDamageTaken;
	
	
	int[] kills2 = new int[10];
	int[] deaths2 = new int[10];
	int[] assists2 = new int[10];
	String[] championName2 = new String [10];
	int[] totalDamageDealtToChampions2 = new int[10];
	int[] totalDamageTaken2 = new int[10];
	String[] summonerName = new String[10];

	
	

	public MatchInfoDtl(String MatchInfoDtl,String nickname) {
		// TODO Auto-generated constructor stubs
		JSONObject jsonobject = new JSONObject(MatchInfoDtl);
		JSONObject info = jsonobject.getJSONObject("info");
		JSONArray participants = info.getJSONArray("participants"); //participants
		System.out.println("info "+info);
		System.out.println("participants "+participants);
		System.out.println("내가 검색한 닉네임 "+nickname);
		String  summonerNameto = nickname.toLowerCase().trim();
		System.out.println("내가 검색한 닉네임 변환 "+summonerNameto);		
		for(int i=0;i<10;i++) {//1게임에 10명이 참여함
			JSONObject participant = participants.getJSONObject(i); //participant
			String  summonerName = participant.getString("summonerName").toLowerCase().replace(" ", ""); //2022-11-27
			System.out.println("닉네임!! : "+ summonerName);
			if(summonerName.equals(summonerNameto)) {//내가 검색한 닉네임일경우
				win=(Boolean) participant.get("win");
				championName=(String) participant.get("championName");
				kills=participant.getInt("kills");
				deaths=participant.getInt("deaths");
				assists=participant.getInt("assists");
				totalDamageDealtToChampions=participant.getInt("totalDamageDealtToChampions");
				totalDamageTaken=participant.getInt("totalDamageTaken");
				System.out.print("win : "+win);
				System.out.print("championName : "+championName);
				System.out.print("kills : "+kills);
				System.out.print("assists : "+assists);
				
			}
		}
		
		
	}
	
	//getAllMatchInfoDtl
	public MatchInfoDtl(String MatchInfoDtl) {
		// TODO Auto-generated constructor stub
		JSONObject jsonobject = new JSONObject(MatchInfoDtl);
		JSONObject info = jsonobject.getJSONObject("info");
		JSONArray participants = info.getJSONArray("participants"); //participants
		
		for(int i=0;i<10;i++) {//1게임에 10명이 참여함
			JSONObject participant = participants.getJSONObject(i); //participant
				kills2[i]=participant.getInt("kills");
				deaths2[i]=participant.getInt("deaths");
				assists2[i]=participant.getInt("assists");
				championName2[i]=(String) participant.get("championName");
				totalDamageDealtToChampions2[i]=participant.getInt("totalDamageDealtToChampions");
				totalDamageTaken2[i]=participant.getInt("totalDamageTaken");
				summonerName[i]=(String) participant.get("summonerName");
		}
		
	}

	public String[] getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String[] summonerName) {
		this.summonerName = summonerName;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public int getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public String[] getChampionName2() {
		return championName2;
	}

	public int[] getKills2() {
		return kills2;
	}

	public void setKills2(int[] kills2) {
		this.kills2 = kills2;
	}

	public int[] getDeaths2() {
		return deaths2;
	}

	public void setDeaths2(int[] deaths2) {
		this.deaths2 = deaths2;
	}

	public int[] getAssists2() {
		return assists2;
	}

	public void setAssists2(int[] assists2) {
		this.assists2 = assists2;
	}

	public void setChampionName2(String[] championName2) {
		this.championName2 = championName2;
	}

	public int[] getTotalDamageDealtToChampions2() {
		return totalDamageDealtToChampions2;
	}

	public void setTotalDamageDealtToChampions2(int[] totalDamageDealtToChampions2) {
		this.totalDamageDealtToChampions2 = totalDamageDealtToChampions2;
	}

	public int[] getTotalDamageTaken2() {
		return totalDamageTaken2;
	}

	public void setTotalDamageTaken2(int[] totalDamageTaken2) {
		this.totalDamageTaken2 = totalDamageTaken2;
	}

	
	
	
	
	

	
	

}
