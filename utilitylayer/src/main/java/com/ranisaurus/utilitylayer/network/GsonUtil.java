package com.ranisaurus.utilitylayer.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ranisaurus.utilitylayer.logger.Log4a;
import com.ranisaurus.utilitylayer.reflection.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by MuzammilPeer on 3/13/2015.
 */
public class GsonUtil {
    // shared method for json coversion
    public static JsonObject getJsonObjectFromObject(final Object obj) {

        Gson gson = new Gson();
        String modelString = gson.toJson(obj);
        JsonParser parser = new JsonParser();
        JsonObject model = (JsonObject) parser.parse(modelString);

        return model;
    }

    public static <T> Object getObjectFromJsonObject(final Object data, Class<T> classofT) {

        if (data instanceof JsonObject) {
            JsonObject json = (JsonObject) data;
            Gson gson = new Gson();
            T obj = gson.fromJson(json, classofT);
            return obj;
        }
        return null;
    }

    public static String getStringFromObject(final Object data) {

        if (data != null) {
            Gson gson = new Gson();
            String json = gson.toJson(data);
            return json;
        }
        return "";
    }

    public static <T> Object getObjectFromString(final String data, Class<T> classofT) {

        if (data instanceof String) {
            Gson gson = new Gson();
            T obj = gson.fromJson(data, classofT);
            return obj;
        }
        return "";
    }



    public static String getQueryStringURL(Object model) {
        StringBuilder sb = new StringBuilder();
//        sb.append(url);
        if (model != null) {
            sb.append("?");
            Boolean flag = true;
            for (Method method : ReflectionUtil.findGettersSetters(
                    model.getClass(), true)) {
                try {
                    String returnValue = (String) method.invoke(model, null);
                    if (returnValue != null) {
                        Log4a.e(method.getName(), returnValue);
                        if (flag) {
                            sb.append(method.getName() + "=" + returnValue);
                            flag = false;
                        } else {
                            sb.append("&" + method.getName() + "="
                                    + returnValue);
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    Log4a.e("error occured", e.getMessage());
                }
            }
            Log4a.e("Parcel Bean In completed", "End");
        }
        Log4a.e("Full URL = ", sb.toString());
        return sb.toString();
    }

}