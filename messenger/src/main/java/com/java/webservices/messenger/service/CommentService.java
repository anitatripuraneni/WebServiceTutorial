package com.java.webservices.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.java.webservices.messenger.dao.MessageDao;
import com.java.webservices.messenger.model.Comment;
import com.java.webservices.messenger.model.ErrorMessage;
import com.java.webservices.messenger.model.Message;

public class CommentService {
	private Map<Long, Message> messages = MessageDao.getMessages();
	
	public CommentService(){
		Comment c1 = new Comment(1,"Comment1 for message1","comment1");
		Comment c2 = new Comment(2,"Comment2 for message1","comment2");
		Comment c3 = new Comment(3,"Comment1 for message2","comment1");
		Comment c4 = new Comment(4,"Comment2 for message2","comment2");
		Map<Long,Comment> comment1=new HashMap<>();
		Map<Long,Comment> comment2=new HashMap<>();
		comment1.put(1L, c1);
		comment1.put(2L, c2);
		comment2.put(1L, c3);
		comment2.put(2L, c4);
		messages.put(1L, new Message(1,"Hello world","Anita",comment1));
		messages.put(2L, new Message(2,"Welcome","Sumanth",comment2));
		
	}

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found",404,"URL link");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		Message message=messages.get(messageId);
		if(message == null){
			//throw new WebApplicationException(Status.NOT_FOUND);
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if(comment == null){
			//throw new WebApplicationException(Status.NOT_FOUND);
			throw new WebApplicationException(response);
		}
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId,long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
