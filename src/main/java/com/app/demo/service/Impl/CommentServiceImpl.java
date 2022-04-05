package com.app.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		 Optional<List<Comment>> commentOptional = Optional.of(commentRepository.findCommentsByMessageId(timeId));
			return commentOptional.isPresent() ? commentOptional.get() : null;
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(commentId);
	}
	

}
