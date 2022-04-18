package com.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Comment;
import com.app.demo.respository.CommentRepository;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	TimelineRepository timelineRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment createComment(Comment comment) {
		comment.setTimeline(timelineRepository.findById(comment.getTimeline().getId()).get());
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		commentRepository.deleteById(commentId);
	}

	@Override
	public List<Comment> getCommentsByMessageId(Integer timeId) {
		return commentRepository.findCommentsByMessageId(timeId);
	}

}
