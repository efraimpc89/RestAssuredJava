package com.efraim.restassured.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.efraim.restassured.helpers.PostsServiceHelper;
import com.efraim.restassured.models.Post;

import io.restassured.response.Response;

public class DELETE_Post_Test {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	
	@Test
	public void DeletePostReturns200() {
		Response response = helper.deletePost(1);
	    System.out.println(response.asString());
	    Assert.assertTrue(response.getStatusCode() == 200);
   
	}
	


}
