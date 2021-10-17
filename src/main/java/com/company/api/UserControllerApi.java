package com.company.api;

import com.company.entity.UserControllerData;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserControllerApi extends BaseApi {

    @Step("Post - Update user")
    public int postUserUpdate(UserControllerData data) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/user/update";
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
        System.out.println(statusCode);
        String result = response.body().string();
        System.out.println(result);
        return statusCode;
    }

    @Step("Get - User by Id")
    public int getUserById(int userId) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/user/" + userId;
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println(statusCode);
        String result = response.body().string();
        System.out.println(result);
        return statusCode;
    }

    @Step("Get - User")
    public int getUser() throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/user/";
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        int statusCode = response.code();
        System.out.println(statusCode);
        String result = response.body().string();
        System.out.println(result);
        return statusCode;
    }
}
