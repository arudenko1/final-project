package com.tests.api;

import com.company.api.UserControllerApi;
import com.company.entity.UserControllerData;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserControllerApiTests {

    Faker faker = new Faker();

    @Test(description = "Post - Update user test")
    public void postUpdateUserTest() throws IOException {
        UserControllerData data = new UserControllerData();
        data.setUsername(faker.name().username());
        data.setName(faker.name().name());
        data.setLastname(faker.name().lastName());
        UserControllerApi api = new UserControllerApi();
        int statusCode = api.postUserUpdate(data);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get User by Id test")
    public void getUserByIdTest() throws IOException {
        UserControllerApi api = new UserControllerApi();
        int statusCode = api.getUserById(1);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get User test")
    public void getUserTest() throws IOException {
        UserControllerApi api = new UserControllerApi();
        int statusCode = api.getUser();
        Assert.assertEquals(statusCode, 200);
    }
}
