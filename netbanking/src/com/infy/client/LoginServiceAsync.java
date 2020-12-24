package com.infy.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void validateCredentials(String name, String password, AsyncCallback asyncCallback);
}
