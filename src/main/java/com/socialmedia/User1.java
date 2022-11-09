package com.socialmedia;

public interface User1 {
	boolean login(String email, String password);
	void signup(Details d);
	void logout();
	void status(String email,String status);
	
}
