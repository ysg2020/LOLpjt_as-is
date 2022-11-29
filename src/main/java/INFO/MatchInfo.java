package INFO;

import org.json.JSONArray;

public class MatchInfo {

	String[] MatchId;
	//String test;
	
	public MatchInfo(String MatchId , int gameCnt) {
		// TODO Auto-generated constructor stub
		JSONArray jsonArray = new JSONArray(MatchId); 
		this.MatchId = new String[gameCnt];
		/*
		 * test = (String) jsonArray.get(0); System.out.println(test);
		 */
		
		for(int i=0;i<gameCnt;i++) {
			this.MatchId[i] =  (String) jsonArray.get(i);
		
		}
		
	}

	public String[] getMatchId() {
		return MatchId;
	}

	public void setMatchId(String[] matchId) {
		MatchId = matchId;
	}
	
	
	
}
