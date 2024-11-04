package com.reel.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reel.spring.model.Comment;
import com.reel.spring.repository.CommentRepository;
import com.reel.spring.service.CommentService;
import com.reel.spring.web.dto.SaveCommentDto;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	CommentService commentService;
	
	// Create Comment rest api
	@PostMapping("/save")
	public Comment saveNewComment(@RequestBody SaveCommentDto commentDto) {
		return commentService.save(commentDto);
	}
	
	// Get comments on thread
	@GetMapping(value = "/thread/{threadId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> getCommentsOnThread(@PathVariable String threadId) {
		System.out.println(threadId);
		return commentRepository.findByThreadId(threadId);
	}
}
