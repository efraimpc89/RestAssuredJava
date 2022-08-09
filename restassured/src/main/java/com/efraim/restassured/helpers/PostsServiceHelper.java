package com.efraim.restassured.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.efraim.restassured.constants.Endpoints;
import com.efraim.restassured.models.Post;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostsServiceHelper {

	
	public PostsServiceHelper(){
	
		RestAssured.baseURI = Endpoints.BASE_URI;
		//RestAssured.useRelaxedHTTPSValidation(); //use only when executing on local api
		
	}
	
	public List<Post> getAllPostsList(){
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(Endpoints.POSTS_CRUD)
				.andReturn();
		
		Type type = new TypeReference<List<Post>>() {}.getType();
		
		List<Post> postList = response.as(type);
		
		return postList;

	}
	
	public Response getAllPostsResponse(){
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(Endpoints.POSTS_CRUD)
				.andReturn();
		
		return response;

	}
	
	public List<Post> convertResponseToPostList(Response response){
				
		Type type = new TypeReference<List<Post>>() {}.getType();
		
		List<Post> postList = response.as(type);
		
		return postList;

	}
	
	public Response newPost(int userId, String title, String body) {
		
		Post newPost = new Post();
		newPost.setUserId(userId);
		newPost.setTitle(title);
		newPost.setBody(body);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.body(newPost)
				.post(Endpoints.POSTS_CRUD)
				.andReturn();
		
		return response;

	}
	
	public Response deletePost(int postId) {
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.delete(Endpoints.POSTS_CRUD+ "/" + postId)
				.andReturn();
		
		return response;

	}
	
	public Response updatePost(int postId, int userId, String title, String body) {
		
		Post post = new Post();
		post.setUserId(userId);
		post.setTitle(title);
		post.setBody(body);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.body(post)
				.put(Endpoints.POSTS_CRUD + "/" + postId)
				.andReturn();
		
		return response;

	}
	
}
