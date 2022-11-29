package INFO;

import org.json.JSONObject;

public class UserInfo {

	
	String accountId;
	int profileIconId;
	long revisionDate;
	String name;
	String id;
	String puuid;
	int summonerLevel;
	
	
	public UserInfo(String userInfo) {
		// TODO Auto-generated constructor stub
		JSONObject jsonobject = new JSONObject(userInfo);
		this.name= (String) jsonobject.get("name");
		this.summonerLevel= (Integer) jsonobject.get("summonerLevel");
		this.id= (String) jsonobject.get("id");
		this.accountId= (String) jsonobject.get("accountId");
		this.puuid = (String) jsonobject.get("puuid");
		
	}
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	public long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public int getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	
	
	
}
