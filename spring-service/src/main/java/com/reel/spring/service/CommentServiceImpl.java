package com.reel.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reel.spring.model.Comment;
import com.reel.spring.repository.CommentRepository;
import com.reel.spring.web.dto.SaveCommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}
	
	@Override
	public Comment save(SaveCommentDto commentDto) {
		//System.out.println(commentDto.getParentId());
		Comment comment = new Comment(commentDto.getCommenter(), commentDto.getCommentText(), commentDto.getThreadId(), commentDto.getParentId());
		
		
		System.out.println("Parent ID: " + comment.getParentId());
		
		System.out.println("Comment To String: " + comment.toString());
		
		return commentRepository.save(comment);
	}
	
}
