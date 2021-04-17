package e_shoplk;

import java.util.HashMap;
import java.util.Map.Entry;

public class Login {

	HashMap<String, String> user = new HashMap<String, String>();

	private final  static String vendor = "vendor1";
	private final  static String password = "111";
	
	public Login() {
		user.put(vendor, password);
		
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
