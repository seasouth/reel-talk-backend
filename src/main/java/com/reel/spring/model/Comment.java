package com.reel.spring.model;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "commenter")
	private String commenter;
	
	@Column(name = "commenttext")
	private String commentText;
	
	@Column(name = "threadid")
	private String threadId;
	
	@Column(name = "commentid")
	private String commentId;
	
	@Column(name = "parentid")
	private String parentId;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "numratings")
	private int numRatings;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	public Comment() {
		
	}
	
	public Comment(String commenter, String commentText, String threadId, String parentId) {
		super();
		this.commenter = commenter;
		this.commentText = commentText;
		this.threadId = threadId;
		this.parentId = parentId;
		
		this.commentId = UUID.randomUUID().toString();
		this.rating = 0;
		this.numRatings = 0;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getNumRatings() {
		return numRatings;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public String toString() {
		String thisComment = "ID: " + this.id + ", commenter: " + this.commenter + ", commentText: " + this.commentText + ", threadID: " + this.threadId + ", parentID: " + this.parentId;
		
		System.out.print("Comment is: " + thisComment);
		return thisComment;
		
	}
	
}
