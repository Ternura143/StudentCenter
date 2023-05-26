package com.studyCenter.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * File operator
 */
public class FileOperator {


    /**
     * read data from file and convert to object
     * @param fileName file name
     * @param c class of object
     * @return object list
     */
    public static List loadData(String fileName, Class<?> c) {
        List ret = new ArrayList<>();
        try {
            String path = "data/" + fileName;
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = in.readLine()) != null) {
                line = "[" + line + "]";
                Object object = GsonUtil.toObj(line, c);
                ret.add(object);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    /**
     * write object to file
     * @param object object to write
     * @param filename file name
     */
    public static void writeData(Object object, String filename) {
        try {
            String fileName = "data/" + filename;
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(GsonUtil.toJson(object));
            out.newLine();

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * write object list to file
     * @param objectList object list to write
     * @param filename file name
     */
    public static void writeData(List objectList, String filename) {
        try {
            String fileName = "data/" + filename;
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
            for (Object object : objectList) {
                out.write(GsonUtil.toJson(object));
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
