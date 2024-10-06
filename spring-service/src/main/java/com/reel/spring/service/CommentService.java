package com.reel.spring.service;

import com.reel.spring.model.Comment;
import com.reel.spring.web.dto.SaveCommentDto;

public interface CommentService {
	Comment save(SaveCommentDto commentDto);
}