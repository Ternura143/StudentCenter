package com.studyCenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {

    public static synchronized String getCode() {
        SimpleDateFormat format = new SimpleDateFormat("YYMMddHHmm"); // 时间字符串产生方式，防止重复
        String uid = format.format(new Date());
        return uid;
    }
}
