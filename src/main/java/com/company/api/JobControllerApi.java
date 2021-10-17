package com.company.api;

import com.company.entity.JobControllerData;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JobControllerApi extends BaseApi {

    @Step("Post - Delete job by Id")
    public int postDeleteJobById(int jobId) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/job/delete/" + jobId;

        RequestBody requestBody = RequestBody.create("".getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Authorization", TOKEN)
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();
        int statusCode = response.code();
        System.out.println(statusCode);
        return statusCode;
    }

    JobControllerData lastCreatedJob;

    public JobControllerData lastCreatedJob() {
        return lastCreatedJob;
    }

    @Step("Post - Create job")
    public int postCreateJob(JobControllerData data) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/job/create";
        Gson gson = new Gson();
        String jsonObject = gson.toJson(data);
        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println("Response code: " + statusCode);
        String result = response.body().string();
        System.out.println("Response body: " + result);
        lastCreatedJob = gson.fromJson(result, JobControllerData.class);
        return statusCode;
    }

    @Step("Get - Job by Id")
    public int getJobById(int jobId) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/job/" + jobId;
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println("Response code: " + statusCode);
        String result = response.body().string();
        System.out.println("Response body: " + result);
        return statusCode;
    }

    @Step("Get - Jobs")
    public int getJobs() throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/job/user/jobs";
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println("Response code: " + statusCode);
        String result = response.body().string();
        System.out.println("Response body: " + result);
        return statusCode;
    }

    @Step("Get - Jobs")
    public int getAllJobs() throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/job/all";
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println("Response code: " + statusCode);
        String result = response.body().string();
        System.out.println("Response body: " + result);
        return statusCode;
    }
}
