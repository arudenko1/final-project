package com.tests.api;

import com.company.api.AuthControllerApi;
import com.company.entity.AuthControllerData;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthControllerApiTests {

    Faker faker = new Faker();

    String userName = "Nastya";
    String password = "password1";

    @Test(description = "Post - Sign Up test", priority = 1)
    public void postSignUpTest() throws IOException {
        AuthControllerData data = new AuthControllerData();
        userName = faker.name().name();
        data.setUsername(userName);
        data.setPassword(password);
        data.setConfirmPassword(password);
        AuthControllerApi api = new AuthControllerApi();
        int statusCode = api.postSignUp(data);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Post - Sign In test", priority = 2)
    public void postSignInTest() throws IOException {
        AuthControllerData data = new AuthControllerData();
        data.setUsername(userName);
        data.setPassword(password);
        AuthControllerApi api = new AuthControllerApi();
        int statusCode = api.postSignIn(data);
        Assert.assertEquals(statusCode, 200);
    }
}
