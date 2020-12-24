package com.infy.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("loginservice")  
public interface LoginService extends RemoteService {

	public boolean validateCredentials(String customerId,String password);
	
	
}
