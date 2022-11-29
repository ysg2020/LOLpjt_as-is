package SERVICE;

import java.util.ArrayList;
import java.util.List;

import INFO.MatchInfo;
import INFO.MatchInfoDtl;
import INFO.UserInfo;

public interface lolService {
	
	public  UserInfo getUserInfo(String nickname);
	
	public MatchInfo getMatchInfo(String nickname);
	
	public List<MatchInfoDtl> getMatchInfoDtl(String nickname);

	public MatchInfoDtl getAllMatchInfoDtl(String nickname,int matchNum);

}
