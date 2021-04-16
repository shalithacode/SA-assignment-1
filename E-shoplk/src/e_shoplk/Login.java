package e_shoplk;

import java.util.HashMap;

public class Login {

	HashMap<String, String> user = new HashMap<String, String>();

	public Login() {
		user.put("vendor1", "111");
		user.put("vendor2", "222");
		user.put("vendor2", "333");
		
	}
	public boolean isUser(String uId, String password) {
		
		for (String i : user.keySet()) {
			  if (i ==uId  && password== user.get(i)) {
				  return true;
			  }
			}
		return false;
	}
	
}
