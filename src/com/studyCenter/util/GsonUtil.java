package com.studyCenter.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;


/**
 * Gson util
 */
public class GsonUtil {

    /**
     * convert object to json
     * @param object object to convert
     * @return json
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    /**
     * convert json to object
     * @param json json to convert
     * @param c class of object
     * @return object
     */
    public static Object toObj(String json, Class<?> c) {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();
        Gson gson = new Gson();
        Object obj = null;
        for (JsonElement item : jsonArray) {
            obj = gson.fromJson(item, c);
        }
        return obj;
    }

    /**
     * convert json to object list
     * @param js json to convert
     * @param c class of object
     * @return object list
     */
    public static List<Object> toObjList(String js, Class<?> c) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(js).getAsJsonArray();
        Gson gson = new Gson();
        ArrayList<Object> objList = new ArrayList<Object>();
        for (JsonElement item : jsonArray) {
            Object obj = gson.fromJson(item, c);
            objList.add(obj);
        }

        return objList;
    }

}

// please write the junit test case for this class
