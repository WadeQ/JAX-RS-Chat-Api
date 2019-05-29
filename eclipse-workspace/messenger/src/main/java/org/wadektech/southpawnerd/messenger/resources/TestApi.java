package org.wadektech.southpawnerd.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.wadektech.southpawnerd.model.MessageModel;
import org.wadektech.southpawnerd.service.MessageService;



@Path("/messages")
public class TestApi {
	
	MessageService mService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageModel>  getMessages( @QueryParam("year") int year ,
											@QueryParam("start") int start ,
											@QueryParam("size") int size){
		
		if (year > 0) {
			 return mService.getAllMessagesUsingYear(year);
		}
		
		if (start >= 0 && size > 0) {
			return mService.getAllPaginatedList(start, size);
		}
		return mService.getAllMessages();
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel postMessage(MessageModel message) {
		return mService.addMessage(message) ;
	}
	//since we are using the put and we only want to edit an existing message,
	//we will ensure that the id is set to the original messageId and not changed
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel puttMessage(@PathParam("messageId") long id, MessageModel message) {
		//set id to the same long id
		message.setId(id);
		return mService.updateMessage(message) ;
	}
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		mService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel getSingleMessage(@PathParam("messageId") long id) {
		return mService.getMessage(id);
	}
}
 