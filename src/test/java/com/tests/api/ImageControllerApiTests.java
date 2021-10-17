package com.tests.api;

import com.company.api.CommentControllerApi;
import com.company.api.ImageControllerApi;
import com.company.entity.CommentControllerData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ImageControllerApiTests {

    @Test(description = "Post - Upload file", priority = 1)
    public void postUploadFileTest() throws IOException {

        File file = new File("src/test/resources/ghost.png");

        ImageControllerApi api = new ImageControllerApi();

        int statusCode = api.postUploadFile(file);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get - Image by id", priority = 2)
    public void getImageByIdTest() throws IOException {
        ImageControllerApi api = new ImageControllerApi();
        int statusCode = api.getImageByUserId(108);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get - Image profile", priority = 3)
    public void getImageProfileTest() throws IOException {
        ImageControllerApi api = new ImageControllerApi();
        int statusCode = api.getImageProfile();
        Assert.assertEquals(statusCode, 200);
    }


}
