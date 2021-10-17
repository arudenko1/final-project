package com.tests.api;

import com.company.api.JobControllerApi;
import com.company.entity.JobControllerData;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobControllerApiTests {

    Faker faker = new Faker();
    int createdJobId;

    @Test(description = "Post - Create job test", priority = 1)
    public void postCreateJobTest() throws IOException {
        JobControllerData requestData = new JobControllerData();
        requestData.setDescription(faker.job().field());
        requestData.setNoOfComments(faker.number().randomDigit());
        requestData.setPrice((int)faker.number().randomNumber(2, true) * 100);
        requestData.setTitle(faker.job().title());
        requestData.setUser(faker.name().name());
        JobControllerApi api = new JobControllerApi();
        int statusCode = api.postCreateJob(requestData);
        Assert.assertEquals(statusCode, 200);

        JobControllerData responseData = api.lastCreatedJob();
        createdJobId = responseData.getId();
    }

    @Test(description = "Get - Job by Id test", priority = 2)
    public void getJobByIdTest() throws IOException {
        JobControllerApi api = new JobControllerApi();
        int statusCode = api.getJobById(createdJobId);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Post - Delete job test", priority = 3)
    public void postDeleteJobTest() throws IOException {
        JobControllerApi api = new JobControllerApi();
        System.out.println("Removing the Job #" + createdJobId);
        int statusCode = api.postDeleteJobById(createdJobId);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get - Jobs test", priority = 4)
    public void getJobsTest() throws IOException {
        JobControllerApi api = new JobControllerApi();
        int statusCode = api.getJobs();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(description = "Get - All Jobs test", priority = 5)
    public void getAllJobsTest() throws IOException {
        JobControllerApi api = new JobControllerApi();
        int statusCode = api.getAllJobs();
        Assert.assertEquals(statusCode, 200);
    }
}
