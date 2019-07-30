package com.study.px.spring.springtest.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-12-20 11:03
 **/
@Slf4j
public class OkHttpUtil {

    private OkHttpUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder().build();
    }

    public static OkHttpClient getClient(long timeout) {

        OkHttpClient.Builder builder =
                new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS);
//        new OkHttpClient.Builder()
//                .cookieJar(new CookieJar() {
//                    private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
//
//                    @Override
//                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//                        cookieStore.put(url, cookies);
//                        cookieStore.put(HttpUrl.parse("http://192.168.31.231:8080/shiro-2"), cookies);
//                        for(Cookie cookie:cookies){
//                            System.out.println("cookie Name:"+cookie.name());
//                            System.out.println("cookie Path:"+cookie.path());
//                        }
//                    }
//
//                    @Override
//                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
////                        List<Cookie> cookies = cookieStore.get(httpUrl);
//                        List<Cookie> cookies = cookieStore.get(HttpUrl.parse("http://192.168.31.231:8080/shiro-2"));
//                        if(cookies==null){
//                            System.out.println("没加载到cookie");
//                        }
//                        return cookies != null ? cookies : new ArrayList<>();
//                    }
//                });
        return builder.build();
    }

    private static Request getRequest(String url, okhttp3.RequestBody requestBody, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
        builder.addHeader("Connection", "keep-alive");
        if (requestBody != null) {
            builder.post(requestBody);
        }
        return builder.build();
    }

    private static String handleUrl(String url, Map<String, String> urlParams) {
        if (urlParams == null || urlParams.isEmpty()) {
            return url;
        }
        if (url.lastIndexOf("?") == -1) {
            url = url + "?";
        }
        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            String v = entry.getValue();
            if (v.lastIndexOf(";") != -1) {
                v = v.substring(0, v.lastIndexOf(";"));
            }
            url += "&" + entry.getKey() + "=" + v;
        }

        return url;
    }

    public static String requestOfGet(String url, Map<String, String> headers, Map<String, String> urlParams) {
        url = handleUrl(url, urlParams);
        OkHttpClient okHttpClient = getClient(5000);
        Request request = getRequest(url, null, headers);
        return doConnection(okHttpClient, request);
    }

    public static String requestOfPost(String url, Map<String, String> urlParams, Map<String, String> headers) {
        OkHttpClient okHttpClient = getClient(5000);
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(urlParams));
        Request request = getRequest(url, body, headers);
        return doConnection(okHttpClient, request);
    }

    public static String requestOfFormPost(String url, Map<String, String> urlParams, Map<String, String> headers) {
        OkHttpClient okHttpClient = getClient(5000);
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : urlParams.keySet()) {
            builder.addEncoded(key,urlParams.get(key));
        }
        Request request = getRequest(url, builder.build(), headers);
        return doConnection(okHttpClient, request);
    }

    private static String doConnection(OkHttpClient okHttpClient, Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() == 200) {
                Headers headers = response.headers();
                Map<String, List<String>> stringListMap = headers.toMultimap();
                System.out.println(JSON.toJSONString(stringListMap));
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("OkHttpUtil.requestOfPost请求异常：", e);
        }
        return null;
    }


    public static String requestOfPost(String url, Map<String, String> urlParams) {
        OkHttpClient okHttpClient = getClient(5000);
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(urlParams));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return doConnection(okHttpClient, request);
    }

}
