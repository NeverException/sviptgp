package com.qf.tgp.plamtv.utils;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by 朱雨桐 on 2016/9/12.
 */
public class ModleJsonPaser implements ResponseParser {


    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        Gson gson = new Gson();
        return gson.fromJson(result,resultClass);
    }
}
