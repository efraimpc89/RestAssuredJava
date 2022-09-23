package com.efraim.restassured.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.efraim.restassured.helpers.CommentsServiceHelper;
import com.efraim.restassured.models.Comment;

import io.restassured.response.Response;

public class GET_Comments_Test {
	
	CommentsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new CommentsServiceHelper();
	}

	
	@Test
	public void getCommentsIs200() {
	    Response response = helper.getCommentsWithPostIdResponse(1);
	    Assert.assertTrue(response.getStatusCode() == 200);
	       
	}
	
	@Test
	public void getComments_containsData() {
	    List<Comment> response = helper.getPostCommentsList(1);
	    Assert.assertTrue(!response.isEmpty());
	       
	}

}
