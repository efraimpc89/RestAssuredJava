package com.efraim.restassured.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.efraim.restassured.helpers.PostsServiceHelper;
import com.efraim.restassured.models.Post;

import io.restassured.response.Response;

public class GET_Post_Test {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	
	@Test
	public void getAllPostsIs200() {
	    Response response = helper.getAllPostsResponse();
	    Assert.assertTrue(response.getStatusCode() == 200);
	       
	}
	
	@Test
	public void getAllPosts_containsData() {
	    List<Post> response = helper.getAllPostsList();
	    
	    Assert.assertTrue(!response.isEmpty());
	       
	}

	@Test
	public void getSinglePostIs200() {
	    Response response = helper.getSinglePostResponse(1);
	    Assert.assertTrue(response.getStatusCode() == 200);
	       
	}
	
	@Test
	public void getNonExistentPostsIsNot200() {
	    Response response = helper.getSinglePostResponse(99999);
	    Assert.assertTrue(response.getStatusCode() != 200);
	       
	}
	
	@Test
	public void getNonExistentPostsIs404() {
	    Response response = helper.getSinglePostResponse(99999);
	    Assert.assertTrue(response.getStatusCode() == 404);
	       
	}
	
	@Test
	public void getPostsSchemaValidation() {
	    helper.getAllPostSchemaValidation();       
	}
}
