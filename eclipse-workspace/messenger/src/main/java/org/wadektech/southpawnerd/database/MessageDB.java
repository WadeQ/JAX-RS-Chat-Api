package org.wadektech.southpawnerd.database;

import java.util.HashMap;
import java.util.Map;
import org.wadektech.southpawnerd.model.MessageModel;
import org.wadektech.southpawnerd.model.Profile;

public class MessageDB {
	
	private static Map<Long , MessageModel> messages = new HashMap<>();
	private static Map<String , Profile> profiles = new HashMap<>();
	
	
	public static Map<Long , MessageModel> getMessages(){
		return messages ;
	}
   
	public static Map<String , Profile> getProfiles(){
		return profiles ;
	}
}
