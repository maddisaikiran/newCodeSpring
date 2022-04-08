package com.app.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.model.Comment;
import com.app.demo.respository.CommentRepository;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	TimelineRepository timelineRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		comment.setTimeline(timelineRepository.findById(comment.getTimeline().getTimeId()).get());
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> getCommentsByMessageId(Integer timeId) {
		// TODO Auto-generated method stub
		List<Comment> comments = commentRepository.findCommentsByMessageId(timeId);
		if(comments.size() == 0) {
			throw new ResourceNotFoundException("comment not found");
		}
		return comments;
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(commentId);
	}
	

}
