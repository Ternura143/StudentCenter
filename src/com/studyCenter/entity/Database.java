package com.studyCenter.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.studyCenter.entity.building.Building;

import java.io.*;
import java.util.ArrayList;

/**
 * database entity
 */
public class Database implements Serializable {

    private ArrayList<Building> buildings = new ArrayList<Building>();
    private static Database singleton;

    private Database() {
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
            readFromFile();
        }
        return singleton;
    }

    public static void saveToFile() {
        String path = ".\\data\\";
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }

        String jsonString = JSON.toJSONString(Database.getInstance().getBuildings());
        StringtoFile(jsonString, path + "buildings.json");

    }


    public static void readFromFile() {
        String path = ".\\data\\";
        File file = new File(path + "users.json");
        String jsonString = "";

        file = new File(path + "buildings.json");
        if (file.exists()) {
            jsonString = readJson(file);
            singleton.setBuildings(new ArrayList<Building>(JSONArray.parseArray(jsonString, Building.class)));
        }

    }

    public static String readJson(File file) {
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufr = null;
        String line = null;
        String tmp = null;
        try {
            bufr = new BufferedReader(new FileReader(file));
            while ((tmp = bufr.readLine()) != null) {
                if (line == null) line = tmp;
                else line += tmp;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return line;
    }

    public static void StringtoFile(String s, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream outPutStream = null;
        try {
            outPutStream = new FileOutputStream(file);
            byte[] bytes = s.getBytes("UTF-8");
            outPutStream.write(bytes);
            outPutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outPutStream != null)
                    outPutStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
