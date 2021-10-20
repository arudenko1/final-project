package com.tests.api;

import com.company.api.CommentControllerApi;
import com.company.entity.CommentControllerData;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommentControllerApiTests {

    Faker faker = new Faker();

    @Test(description = "Post - Create comment test")
    public void postCreateCommentTest() throws IOException {
        CommentControllerData data = new CommentControllerData();
        data.setMessage(faker.job().keySkills());
        data.setUsername(faker.name().username());
        CommentControllerApi api = new CommentControllerApi();
        int statusCode = api.postCreateComment(data, 441);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get - All comments test")
    public void getAllCommentsTest() throws IOException {
        CommentControllerApi api = new CommentControllerApi();
        int statusCode = api.getAllComments(441);
        Assert.assertEquals(statusCode, 200);
    }
}
