package org.wadektech.southpawnerd.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.wadektech.southpawnerd.database.MessageDB;
import org.wadektech.southpawnerd.model.MessageModel;



public class MessageService {
	

	private Map<Long,MessageModel> messages = MessageDB.getMessages();
	//private Map<Long,Profile> profiles = MessageDB.getProfiles();
	
	public MessageService() {
		messages.put(1L, new MessageModel(1 , "We are learning JAX-RS", "Derrick"));
		messages.put(2L, new MessageModel(2 , "We are learning JAX-RS and with Jersey too!", "WadeQ"));
		
	}
 	
	public List<MessageModel> getAllMessages(){
		return new ArrayList<MessageModel>(messages.values());
	}
	
	public MessageModel getMessage(long id) {
		return messages.get(id);
	}
	
	public List<MessageModel> getAllMessagesUsingYear(int year){
		//we create a blank list that we will use when calling our list
		List<MessageModel> messagesPerYear = new ArrayList<>();
		//creating a calendar instance for comparison
		Calendar calender = Calendar.getInstance();
		//iterate over the list of messages and then for each of the messages set our calendar instance
		for(MessageModel message : messages.values()) {
			calender.setTime(message.getCreatedAt());
		//get the year of the calendar instance and check if it corresponds to input
			if (calender.get(Calendar.YEAR) == year) {
				messagesPerYear.add(message);
			}
		}
		 return messagesPerYear ;
	}
	
	public List<MessageModel> getAllPaginatedList(int start, int size){
		//converting message values into a list
		List<MessageModel> newList = new ArrayList<MessageModel>(messages.values()) ;
		//check if start+size is greater than size of our list, if greater return an empty list
		if (start + size > newList.size()) {
			return new ArrayList<>() ;
		} else {
			return newList.subList(start, size + start) ;
		}
	}
	
	public MessageModel addMessage(MessageModel message) {
		message.setId(messages.size() + 1);
	    messages.put(message.getId(), message);
	    return message ;
	}
	
	public MessageModel updateMessage(MessageModel message) {
		if (message.getId() <= 0) {
			return null ;
		} else {
			messages.put(message.getId(), message);
			return message ;
		}
	}
	
	public MessageModel removeMessage(long id) {
		return messages.get(id) ;
	}
}
