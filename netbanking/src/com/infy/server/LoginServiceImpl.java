package com.infy.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.infy.client.LoginService;

public class LoginServiceImpl extends RemoteServiceServlet  implements LoginService {

	@Override
	public boolean validateCredentials(String customerId, String password) {
		// TODO Auto-generated method stub
		boolean status=false;
		 
				
		if(customerId.equals("admin") && (password.equals("admin")))
			status=true;
		return status;
	}

}
