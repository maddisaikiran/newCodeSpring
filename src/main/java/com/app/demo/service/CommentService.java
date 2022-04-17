package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Comment;

public interface CommentService {
	
	Comment createComment(Comment comment);
	
	void deleteComment(Integer commentId);
	
	List <Comment> getCommentsByMessageId(Integer timeId);

}
