package com.github.shy526.github;

import com.github.shy526.factory.OkHttpClientFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GithubHelp {

    private static Request buildReq(String url,String token) {
        return new Request.Builder()
                .url(url)
        .addHeader("Accept", "application/vnd.github+json")
        .addHeader("Host", "api.github.com")
        .addHeader("Authorization", "token " + token)
                .build();
    }
    public static void createOrUpdateFile() {
        OkHttpClient client = OkHttpClientFactory.getInstance().getClient();
        Request request = buildReq("","111");
        try (Response response = client.newCall(request).execute()) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
