package com.efraim.restassured.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

	@JsonProperty("postId")
	private Integer postId;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("body")
	private String body;
	
	@JsonProperty("postId")
	public Integer getPostId() {
	return postId;
	}
	
	@JsonProperty("postId")
	public void setPostId(Integer postId) {
	this.postId = postId;
	}
	
	@JsonProperty("id")
	public Integer getId() {
	return id;
	}
	
	@JsonProperty("id")
	public void setId(Integer id) {
	this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
	return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}
	
	@JsonProperty("email")
	public String getEmail() {
	return email;
	}
	
	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}
	
	@JsonProperty("body")
	public String getBody() {
	return body;
	}
	
	@JsonProperty("body")
	public void setBody(String body) {
	this.body = body;
	}


}