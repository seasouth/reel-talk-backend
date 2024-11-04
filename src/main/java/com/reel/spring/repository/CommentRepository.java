package com.reel.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reel.spring.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	Comment findByCommentId(String commentId);
	
	List<Comment> findByThreadId(String threadId);
}
