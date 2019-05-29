package org.wadektech.southpawnerd.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageModel {
	
	private long id;
	private String message;
	private String author;
	private Date createdAt;
	
	
	public MessageModel() {
		
	}


	public MessageModel(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.createdAt = new Date();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
		
}
