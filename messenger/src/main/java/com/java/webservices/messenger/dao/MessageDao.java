package com.java.webservices.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import com.java.webservices.messenger.model.Message;
import com.java.webservices.messenger.model.Profile;

public class MessageDao {
	
	private static Map<Long,Message> messages= new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}

}
