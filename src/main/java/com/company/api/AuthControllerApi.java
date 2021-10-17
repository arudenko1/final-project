package com.company.api;

import com.company.entity.AuthControllerData;
import com.google.gson.Gson;

import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AuthControllerApi extends BaseApi {

    @Step("Post - Sign Up")
    public int postSignUp(AuthControllerData data) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/auth/signup";
        Gson gson = new Gson();
        String jsonObject = gson.toJson(data);

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();
        int statusCode = response.code();
        System.out.println(statusCode);
        System.out.println(response.body().string());
        return statusCode;
    }

    @Step("Post - Sign In")
    public int postSignIn(AuthControllerData data) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/auth/signin";
        Gson gson = new Gson();
        String jsonObject = gson.toJson(data);

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();
        int statusCode = response.code();
        String body = response.body().string();
        System.out.println(statusCode);
        System.out.println(body);

        Map respMap = gson.fromJson(body, Map.class);
        BaseApi.TOKEN = (String) respMap.get("token");
        return statusCode;
    }
}
