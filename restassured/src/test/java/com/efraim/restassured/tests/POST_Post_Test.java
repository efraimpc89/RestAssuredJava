package com.efraim.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.efraim.restassured.helpers.PostsServiceHelper;

import io.restassured.response.Response;

public class POST_Post_Test {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	
	@Test
	public void RequestForNewPost() {
	    Response response = helper.newPost(1,"efra", "prueba");
	    Assert.assertTrue(response.getStatusCode() == 201);     
	}
	
	@Test
	public void NoDataNewPostIsNot201() {
	    Response response = helper.newPost(-1,"", "");
	    Assert.assertTrue(response.getStatusCode() == 201);     
	}
	


}
