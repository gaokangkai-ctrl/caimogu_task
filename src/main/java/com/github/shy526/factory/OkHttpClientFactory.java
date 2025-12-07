package com.github.shy526.factory;

import com.github.shy526.interceptor.UserAgentInterceptor;
import okhttp3.OkHttpClient;

public class OkHttpClientFactory {
    private static volatile OkHttpClientFactory instance;
    private final OkHttpClient client;

    private OkHttpClientFactory() {
        this.client = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor()).build();
    }

    public static OkHttpClientFactory getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientFactory.class) {
                if (instance == null) {
                    instance = new OkHttpClientFactory();
                }
            }
        }
        return instance;
    }
    public OkHttpClient getClient() {
        return client;
    }
}
