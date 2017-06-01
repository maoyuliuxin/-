package com.lin.studysmartrecom.http;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.lin.studysmartrecom.MyApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Qiangshen on 2017/3/13.
 */

public class HttpMethod {

    private static final long DEFAULT_TIMEOUT = 5;
    private static final String BASE_URL = "";
    private static HttpMethod httpMethod;
    public final HttpService httpService;
    private static final String TAG = "HttpMethod";


    protected HttpMethod() {
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(),
                        new SharedPrefsCookiePersistor(MyApplication.sContext));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public static HttpMethod get() {
        if (httpMethod == null) {
            httpMethod = new HttpMethod();
        }
        return httpMethod;
    }

}
