package e_shoplk;

import java.util.HashMap;
import java.util.Map.Entry;

public class Login {

	HashMap<String, String> user = new HashMap<String, String>();

	public Login() {
		user.put("vendor1", "111");
		user.put("vendor2", "222");
		user.put("vendor3", "333");
		
	}
	public boolean isUser(String uId, String password) {
		
		boolean res = false;

		 for(Entry<String, String> m : user.entrySet()){   
		
			 if (uId.equals(m.getKey()) &&  password.equals(m.getValue())) {
				 res = true;
				  break;
			  }
			   }  
		return res;
	}
	
}
