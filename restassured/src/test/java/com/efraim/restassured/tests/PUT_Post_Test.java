package com.efraim.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.efraim.restassured.helpers.PostsServiceHelper;

import io.restassured.response.Response;

public class PUT_Post_Test {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	
	@Test
	public void RequestForNewPost() {
	    Response response = helper.updatePost(1, 1,"efra", "prueba");
	    Assert.assertTrue(response.getStatusCode() == 200);
  
	}
	

}
