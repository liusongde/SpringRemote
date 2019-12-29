package com.haleywang.putty.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtils {
    private JsonUtils(){}

    public static  <T> T fromJson(String json, Class<T> classOfT, T defaultVal) {
        try {
            return new Gson().fromJson(json, classOfT);
        }catch (Exception e) {
            return defaultVal;
        }

    }

    public static  <T> T fromJson(String json, Class<T> classOfT) {
            return fromJson(json, classOfT, null);
    }

    public static  String toJson(Object object) {
            return new Gson().toJson(object);

    }

    public static boolean validate(String jsonStr) {
        JsonElement jsonElement;
        try {
            jsonElement = new JsonParser().parse(jsonStr);
        } catch (Exception e) {
            return false;
        }
        return jsonElement != null && jsonElement.isJsonObject();
    }


}
