package com.reel.spring.web.dto;

public class SaveCommentDto {
	String commenter;
	String commentText;
	String threadId;
	String parentId;
	
	public SaveCommentDto(String commenter, String commentText, String threadId, String parentId) {
		this.commenter = commenter;
		this.commentText = commentText;
		this.threadId = threadId;
		this.parentId = parentId;
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
	
	

}
