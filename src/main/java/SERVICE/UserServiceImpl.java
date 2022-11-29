package SERVICE;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements lolUserService{
	
	public void print() {
		System.out.println("LOLUserService");
		
	}

}
