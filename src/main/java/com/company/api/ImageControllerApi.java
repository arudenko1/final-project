package com.company.api;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class ImageControllerApi extends BaseApi {

    public int postUploadFile(File file) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/image/upload";

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(file, MediaType.parse("png")))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("Authorization", TOKEN)
                .post(requestBody)
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

    public int getImageByUserId(int userId) throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/image/" + userId;

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

    public int getImageProfile() throws IOException {
        String url = "https://freelance.lsrv.in.ua/api/image/profile";

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
