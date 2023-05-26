package com.studyCenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * generate a unique id
 */
public class IdGenerator {

    /**
     * generate a unique id
     * @return unique id
     */
    public static synchronized String getCode() {
        SimpleDateFormat format = new SimpleDateFormat("YYMMddHHmm");
        String uid = format.format(new Date());
        return uid;
    }
}
