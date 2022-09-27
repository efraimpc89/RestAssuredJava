package com.efraim.restassured.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.efraim.restassured.constants.Endpoints;
import com.efraim.restassured.models.Post;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PostsServiceHelper {

	
	public PostsServiceHelper(){
		RestAssured.baseURI = Endpoints.BASE_URI;
	}
	
	/***
	 * Gets a list of all posts (/posts)
	 * @return List<Post>
	 */
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
	
	/***
	 * Gets a list of all posts (/posts)
	 * @return Response
	 */
	public Response getAllPostsResponse(){
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(Endpoints.POSTS_CRUD)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Gets a Response of a single post by Id (/posts/{id})
	 * @param postId
	 * @return Response
	 */
	public Response getSinglePostResponse(int postId){
	
		String url = String.format(Endpoints.GET_SINGLE_POST, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
		
		return response;
	
	}
	
	/***
	 * Converts a Response object to a Post List
	 * @param response
	 * @return List<Post>
	 */
	public List<Post> convertResponseToPostList(Response response){
				
		Type type = new TypeReference<List<Post>>() {}.getType();
		
		List<Post> postList = response.as(type);
		
		return postList;

	}
	
	/***
	 * Creates a new Post based on the parameters
	 * @param userId
	 * @param title
	 * @param body
	 * @return Response
	 */
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
	
	/***
	 * Deletes a post by Id
	 * @param postId
	 * @return Response
	 */
	public Response deletePost(int postId) {
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.delete(Endpoints.POSTS_CRUD+ "/" + postId)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Updates a post based on the parameters
	 * @param postId
	 * @param userId
	 * @param title
	 * @param body
	 * @return Response
	 */
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
	
	public void getAllPostSchemaValidation(){
		RestAssured.given()
		.contentType(ContentType.JSON)
		.get(Endpoints.POSTS_CRUD)
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("resources/GetAllPostsSchema.json"))
			.statusCode(200);
	}
	
}
